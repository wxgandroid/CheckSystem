package com.example.windows10.checksystem.presenter;

import com.example.windows10.checksystem.bean.CheckDetailsAllBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.view.DetailsCheckAllView;
import com.example.windows10.rx_retrofit_library.RxUtils;

/**
 * Created by Windows10 on 2017/3/21.
 */
public class DetailsCheckPresenter extends BasePresenter implements RxUtils.LoadingNetDataListener<CheckDetailsAllBean> {

    private DetailsCheckAllView mView;

    public DetailsCheckPresenter(DetailsCheckAllView view) {
        mView = view;
    }

    //联网进行获取数据的操作
    public void loadData() {
        mView.showIOSLoading();
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_DETAILS_CHECK_ALL, null, this, CheckDetailsAllBean.class);
    }

    @Override
    public void onSuccess(CheckDetailsAllBean data) {
        mView.dismissIOSLoading();
        //联网请求数据成功
        mView.setBean(data);
    }

    @Override
    public void onError(String msg) {
        mView.dismissIOSLoading();
    }

    @Override
    public void onComplete() {
        mView.dismissIOSLoading();
    }

}
