package com.example.windows10.checksystem.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

/**
 * Created by Windows10 on 2017/2/23.
 */
public class BasePresenter {
    public IOSLoadingDialog mLoadingDialog;
    public Context mContext;
    public Intent mIntent;


    public void showLoadingDialog(){
        if(mContext!= null){
            mLoadingDialog = CommonUtils.showIOSLoadingDialog(mContext);
        }
    }

    public void dismissDialog(){
        if(mLoadingDialog!= null && mLoadingDialog.isShowing()){
            mLoadingDialog.dismiss();
        }
    }
}
