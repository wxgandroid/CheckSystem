package com.example.windows10.checksystem.view;

/**
 * Created by Windows10 on 2017/3/10.
 */
public interface CheckingFragmentView extends CheckView {
    //更新圆形中间的文字状态
    void updateStatus(String status);

    void updateProgress(int progress);
}
