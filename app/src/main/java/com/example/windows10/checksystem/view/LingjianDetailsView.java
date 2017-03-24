package com.example.windows10.checksystem.view;

import android.view.View;

import com.example.windows10.checksystem.bean.LingJianDetailsBean;

/**
 * Created by Windows10 on 2017/3/8.
 */
public interface LingjianDetailsView extends BaseView {

    //更新UI的方法
    void updateUI(LingJianDetailsBean.SparePartsBean data);

    void showPinpaiList(View v);

    void setData(LingJianDetailsBean data);
}
