package com.example.windows10.checksystem.view;

/**
 * Created by Windows10 on 2017/2/23.
 */
public interface MainActivityView extends BaseView {

    void loginSuccess(String userName,String password);

    void loginFailed(String msg);

    //弹出吐司提示用户相关信息
    void showToast(String msg);

    //显示正在加载的动画
    void showLoading();

    //取消正在加载的动画的显示
    void dismissLoadingDialog();
}
