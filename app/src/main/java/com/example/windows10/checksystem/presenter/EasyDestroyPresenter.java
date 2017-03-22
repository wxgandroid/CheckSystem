package com.example.windows10.checksystem.presenter;

import android.content.Context;
import android.util.Log;

import com.example.windows10.checksystem.bean.EasyDestroyBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.view.EasyDestroyView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

/**
 * 易损零件清单界面的逻辑
 */
public class EasyDestroyPresenter extends BasePresenter implements RxUtils.LoadingNetDataListener<EasyDestroyBean> {

    private EasyDestroyView mView;
    private IOSLoadingDialog mLoadingDialog;

    public EasyDestroyPresenter(EasyDestroyView view) {
        mView = view;
        mContext = (Context) view;
    }


    //联网加载数据
    public void loadData() {
        //开始联网进行数据的读取，显示一个进度条
        mLoadingDialog = CommonUtils.showIOSLoadingDialog(mContext);
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_EASY_DESTROY, null, this, EasyDestroyBean.class);
    }


    @Override
    public void onSuccess(EasyDestroyBean data) {
        dismissDialog();
        Log.e("TAG", "onSuccess");
        mView.updateRecyclerView(data.getPartsList());
    }

    @Override
    public void onError(String msg) {
        dismissDialog();
        Log.e("TAG", "onError" + msg);
        mView.showToast(msg);
    }

    @Override
    public void onComplete() {
        dismissDialog();
    }

    public void dismissDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

}
