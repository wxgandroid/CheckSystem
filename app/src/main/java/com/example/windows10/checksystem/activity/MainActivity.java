package com.example.windows10.checksystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.presenter.MainPresenter;
import com.example.windows10.checksystem.view.MainActivityView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

/**
 * 登录页面
 */

public class MainActivity extends BaseActivity implements MainActivityView, View.OnClickListener {

    private MainPresenter mPresenter;
    //页面总的布局
    private LinearLayout ll_main;
    //登陆名
    private EditText et_login_name;
    //登陆密码
    private EditText et_login_password;
    //登陆按钮
    private Button btn_login;
    //立即注册按钮
    private TextView tv_now_regist;
    //忘记密码按钮
    private TextView tv_forget_password;
    //设置IP的按钮
    private TextView tv_ip_regist;
    //游客登录的按钮
    private TextView tv_guist_entry;
    private IOSLoadingDialog mIosLoadingDialog;
    private boolean isAotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //程序启动时，初始化系统配置
        mPresenter = new MainPresenter(this);

        mPresenter.initSystemConfig();

        //初始化视图控件
        initView();
        //初始化控件的监听方法
        initListener();
        //读取用户的账户和密码的缓存信息，缓存不为空直接进行登录
//        String userName = CommonUtils.getStringExtras(this, Constants.USERINFO_PHONE);
//        String password = CommonUtils.getStringExtras(this, Constants.USERINFO_PASSWORD);
//        if (!CommonUtils.isEmpty(userName) && !CommonUtils.isEmpty(password)) {
//            //自动登录，将页面设置为不可见
//            mPresenter.login(userName, password);
//            ll_main.setVisibility(View.GONE);
//        } else {
//            //不能自动登录，将页面设置为可见
//        }
        ll_main.setVisibility(View.VISIBLE);

    }


    private void initListener() {
        btn_login.setOnClickListener(this);
        tv_now_regist.setOnClickListener(this);
        tv_forget_password.setOnClickListener(this);
        tv_ip_regist.setOnClickListener(this);
        tv_guist_entry.setOnClickListener(this);
    }

    private void initView() {
        ll_main = (LinearLayout) findViewById(R.id.ll_main);
        et_login_name = (EditText) findViewById(R.id.et_login_name);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_now_regist = (TextView) findViewById(R.id.tv_now_regist);
        tv_forget_password = (TextView) findViewById(R.id.tv_forget_password);
        tv_ip_regist = (TextView) findViewById(R.id.tv_ip_regist);
        tv_guist_entry = (TextView) findViewById(R.id.tv_guist_entry);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mPresenter.login(et_login_name.getText().toString(), et_login_password.getText().toString());
                break;
            case R.id.tv_now_regist:
                et_login_name.setText("");
                et_login_password.setText("");
                mPresenter.regist(this);
                break;
            case R.id.tv_forget_password:
                mPresenter.forgetPassword(this);
                break;
            case R.id.tv_ip_regist:
                mPresenter.ipRegist(this);
                break;
            case R.id.tv_guist_entry:
                //点击了游客登录的按钮
                mPresenter.guiderLogin();
                SystemApplication.USER_ID = -1;
                break;

        }
    }

    //登陆成功
    @Override
    public void loginSuccess(String userName, String password) {
        et_login_name.setText("");
        et_login_password.setText("");
        //将userName和password做缓存
        CommonUtils.saveStringExtras(this, Constants.USERINFO_PHONE, userName);
        CommonUtils.saveStringExtras(this, Constants.USERINFO_PASSWORD, password);
        CommonUtils.toOtherActivity(this, HomeActivity.class);
        finishPager();
    }

    //登陆失败
    @Override
    public void loginFailed(String msg) {
        //登录失败，将页面设置为可见
        ll_main.setVisibility(View.VISIBLE);
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    //显示正在加载的动画
    @Override
    public void showLoading() {
        mIosLoadingDialog = CommonUtils.showIOSLoadingDialog(this);
    }

    @Override
    public void dismissLoadingDialog() {
        if (mIosLoadingDialog != null) {
            mIosLoadingDialog.dismiss();
        }
    }

    @Override
    public void finishPager() {
        finish();
    }

    //当从注册页面返回登录页面以后，自动执行登录的操作
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("TAG", "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Constants.RESULT_REGIST_CODE) {
            mPresenter.login(data.getStringExtra(Constants.USERINFO_NAME), data.getStringExtra(Constants.USERINFO_PASSWORD));
        }
    }

    @Override
    public void onBackPressed() {
        currentTime = System.currentTimeMillis();
        if (currentTime - preTime < 2000) {
            super.onBackPressed();
        } else {
            Toast.makeText(MainActivity.this, "再次点击退出应用", Toast.LENGTH_SHORT).show();
            preTime = System.currentTimeMillis();
        }
    }
}
