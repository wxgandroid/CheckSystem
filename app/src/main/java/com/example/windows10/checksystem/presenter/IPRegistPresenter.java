package com.example.windows10.checksystem.presenter;

import android.content.Context;

import com.example.windows10.checksystem.bean.SystemConfigBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.view.IPRegistView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;

/**
 * Created by Windows10 on 2017/2/28.
 */
public class IPRegistPresenter extends BasePresenter implements RxUtils.LoadingNetDataListener<SystemConfigBean> {

    private IPRegistView mView;

    public IPRegistPresenter(IPRegistView view) {
        mView = view;
        mContext = (Context) view;
    }

    public void submitIP(Context context, String ip, String duankou) {
        if (CommonUtils.isEmpty(ip)) {
            mView.showToast("ip地址不能为空");
            return;
        }
        if (CommonUtils.isEmpty(duankou)) {
            mView.showToast("端口号不能为空");
            return;
        }
        Constants.BASE_URL = "http://" + ip + ":" + duankou + "/admin";
        CommonUtils.saveStringExtras(context, Constants.IP_CONFIG, Constants.BASE_URL);
        mView.showIOSLoading();
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_SYSTEM_CONFIG, null, this, SystemConfigBean.class);

    }


    //初始化IP输入框的消息
    public void initIPConfig() {
        String str = Constants.BASE_URL;
        String replace = str.replace("http://", "");
        String ip = replace.substring(0, replace.lastIndexOf(":"));
        int begin = replace.lastIndexOf(":") + 1;
        int end = begin + 4;
        String port = replace.substring(begin, end);
        mView.updatePagers(ip, port);
    }

    @Override
    public void onSuccess(SystemConfigBean data) {
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onComplete() {
        mView.dismissIOSLoading();
        mView.finishPager();
    }
}
