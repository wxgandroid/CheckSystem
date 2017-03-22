package com.example.windows10.checksystem.view;

/**
 * Created by Windows10 on 2017/2/28.
 */
public interface IPRegistView extends BaseView {

    void updatePagers(String ip, String port);


    void showIOSLoading();

    void dismissIOSLoading();
}
