package com.example.windows10.checksystem.fragment;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.bean.UploadBean;
import com.example.windows10.checksystem.databinding.CheckingFragmentLayoutBinding;
import com.example.windows10.checksystem.presenter.CheckingFragmentPresenter;
import com.example.windows10.checksystem.view.CheckingFragmentView;
import com.example.windows10.rx_retrofit_library.RxUtils;

/**
 * 手机端和OBD端进行交互的页面
 */
public class CheckingFragment extends BaseFragment implements RxUtils.LoadingNetDataListener<UploadBean>, CheckingFragmentView {

    public CheckingFragmentLayoutBinding mBinding;
    private CheckingFragmentPresenter mPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.checking_fragment_layout, container, false);
        mPresenter = new CheckingFragmentPresenter(this, mContext);
        mBinding.wvCheckingFragment.setFirstWaveColor(Color.argb(255, 119, 249, 118));
        mBinding.wvCheckingFragment.setSecondWaveColor(Color.argb(255, 59, 222, 129));
        //注册蓝牙搜索的广播
        mPresenter.registReceiver();
        //加载检测的页面，一开始将进行对蓝牙的检测
        mPresenter.loadingChecking();
        return mBinding.getRoot();
    }


    @Override
    public void onSuccess(UploadBean data) {
        Log.e("TAG", "onSuccess" + data.getMessage().getMsg());
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void finishPager() {

    }

    @Override
    public void showToast(String msg) {
        if (mCallback != null) {
            mCallback.showToast(msg);
        }
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void updateProgress(int progress) {
        mBinding.wvCheckingFragment.setWaterProgress(progress);
    }

    @Override
    public void updateTitle(String msg) {
        if (mCallback != null) {
            mCallback.updateTitle(msg);
        }
    }

    @Override
    public void showFragment(BaseFragment fragment) {
        if (mCallback != null) {
            mCallback.showFragment(fragment);
        }
    }

    @Override
    public void showList() {

    }

    @Override
    public void updatePager(Object obj) {

    }


    @Override
    public void updateStatus(String status) {
        mBinding.tvCheckingFragmentStatus.setText(status);
    }

}
