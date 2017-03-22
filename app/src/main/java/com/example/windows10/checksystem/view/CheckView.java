package com.example.windows10.checksystem.view;

import com.example.windows10.checksystem.fragment.BaseFragment;

/**
 * Created by Windows10 on 2017/2/27.
 */
public interface CheckView extends BaseView {

    //更新顶部标题栏
    void updateTitle(String msg);

    //显示fragment页面
    void showFragment(BaseFragment fragment);

    //显示下拉菜单
    void showList();

    //更新界面显示的方法
    void updatePager(Object obj);

}
