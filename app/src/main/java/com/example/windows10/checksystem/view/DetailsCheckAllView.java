package com.example.windows10.checksystem.view;

import com.example.windows10.checksystem.bean.CheckDetailsAllBean;

/**
 * Created by Windows10 on 2017/3/21.
 */
public interface DetailsCheckAllView extends BaseView {
    //更新页面的方法
    void updatePagers();

    //显示正在加载的进度条
    void showIOSLoading();

    //取消显示正在加载的进度条
    void dismissIOSLoading();

    //设置获取的bean对象
    void setBean(CheckDetailsAllBean data);
}
