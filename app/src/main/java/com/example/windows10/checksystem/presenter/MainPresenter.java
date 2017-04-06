package com.example.windows10.checksystem.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.windows10.checksystem.activity.ForgetPasswordActivity;
import com.example.windows10.checksystem.activity.FullUserInfoActivity;
import com.example.windows10.checksystem.activity.HomeActivity;
import com.example.windows10.checksystem.activity.IPRegistActivity;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.LoginBean;
import com.example.windows10.checksystem.bean.SystemConfigBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.view.MainActivityView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;

import java.util.HashMap;

/**
 * 完成首页逻辑的页面
 */
public class MainPresenter extends BasePresenter implements RxUtils.LoadingNetDataListener<LoginBean> {

    private MainActivityView mView;
    private HashMap<String, String> mMap;

    public MainPresenter(MainActivityView view) {
        mView = view;
        mContext = (Context) view;
    }

    //登陆按钮
    public void login(String userName, String password) {
        if (CommonUtils.isEmpty(userName)) {
            mView.showToast("用户名不能为空");
            return;
        }
        if (CommonUtils.isEmpty(password)) {
            mView.showToast("用户密码不能为空");
            return;
        }
        mMap = new HashMap<>();
        mMap.put("phone", userName);
        mMap.put("password", password);
        mView.showLoading();
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_LOGIN, mMap, this, LoginBean.class);
    }


    //点击立即注册按钮，跳转到注册界面
    public void regist(Activity activity) {
        CommonUtils.toOtherActivityForResult(activity, FullUserInfoActivity.class, new Intent(), Constants.TO_REGIST_CODE);
    }

    //点击了忘记密码按钮
    public void forgetPassword(Activity activity) {
        CommonUtils.toOtherActivity(activity, ForgetPasswordActivity.class);
    }

    //点击了ip注册的按钮
    public void ipRegist(Activity activity) {
        CommonUtils.toOtherActivity(activity, IPRegistActivity.class);
    }

    @Override
    public void onSuccess(LoginBean data) {
        mView.dismissLoadingDialog();
        if (data != null) {
            if ("登录成功".equals(data.getMessage().getMsg())) {
                mView.loginSuccess(mMap.get(Constants.USERINFO_PHONE), mMap.get(Constants.USERINFO_PASSWORD));
                //初始化系统的检测项
                String faultName = data.getFaultDetection().getFaultName();
                String[] split = faultName.split(" ");
                SystemApplication.checkCodes = split;
                SystemApplication.USER_ID = data.getUser().getId();
                //将登录成功的用户名密码信息保存，下次启动app时自动进行登录
            } else {
                mView.loginFailed(data.getMessage().getMsg());
            }
        } else {
            //登录失败
            mView.loginFailed("登录失败，请重试");
        }
    }

    @Override
    public void onError(String msg) {
        mView.dismissLoadingDialog();
        mView.loginFailed("联网失败");
    }

    @Override
    public void onComplete() {
        mView.dismissLoadingDialog();
    }

    //游客登录
    public void guiderLogin() {
        CommonUtils.toOtherActivity((Activity) mContext, HomeActivity.class);
        ((Activity) mContext).finish();
    }

    public void initSystemConfig() {
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_SYSTEM_CONFIG, null, new RxUtils.LoadingNetDataListener<SystemConfigBean>() {
            @Override
            public void onSuccess(SystemConfigBean data) {
                SystemApplication.getInstance().setBASE_VIDEO_URL(data.getSystem().getVideoPath());
                SystemApplication.getInstance().setBASE_PIC_URL(data.getSystem().getPicturePath());
                SystemApplication.getInstance().setBASE_AUDIO_URL(data.getSystem().getAudioPath());
                SystemApplication.getInstance().setBASE_VIDEO_URL(data.getSystem().getVideoPath());
                SystemApplication.CHECK_TIMES = data.getSystem().getInspection_time();
                SystemApplication.CHECK_FREQUENTS = data.getSystem().getInspection_frequency();
            }

            @Override
            public void onError(String msg) {
                mView.showToast("初始化系统配置失败，请重启应用" + msg);
            }

            @Override
            public void onComplete() {

            }
        }, SystemConfigBean.class);
    }
}
