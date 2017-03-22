package com.example.windows10.checksystem.presenter;

import android.content.Context;

import com.example.windows10.checksystem.bean.LingJianDetailsBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.view.GuZhangView;
import com.example.windows10.rx_retrofit_library.RxUtils;

import java.util.HashMap;

/**
 * Created by Windows10 on 2017/3/16.
 */
public class GuZhangPresenter extends BasePresenter implements RxUtils.LoadingNetDataListener<LingJianDetailsBean> {

    private GuZhangView mView;

    public GuZhangPresenter(GuZhangView view) {
        mView = view;
        mContext = (Context) view;
    }


    //加载数据
    public void loadData(String partID) {
        mView.showIOSLoading();
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.ID, partID);
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_LINGJIAN_DETAILS, params, this, LingJianDetailsBean.class);

    }

    @Override
    public void onSuccess(LingJianDetailsBean data) {
        mView.dismissIOSLoading();
        mView.setData(data);
    }

    @Override
    public void onError(String msg) {
        mView.dismissIOSLoading();
        mView.showToast(msg);
    }

    @Override
    public void onComplete() {

    }
}
