package com.example.windows10.checksystem.view;

import com.example.windows10.checksystem.bean.LingJianDetailsBean;

/**
 * Created by Windows10 on 2017/3/16.
 */
public interface GuZhangView extends BaseView {

    void updateUI(LingJianDetailsBean.SparePartsBean bean);

    void showIOSLoading();

    void dismissIOSLoading();

    void setData(LingJianDetailsBean data);
}
