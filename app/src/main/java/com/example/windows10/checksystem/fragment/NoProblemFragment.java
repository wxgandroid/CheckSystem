package com.example.windows10.checksystem.fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.activity.CheckingActivity;
import com.example.windows10.checksystem.activity.DetailsCheckActivity;
import com.example.windows10.checksystem.activity.EasyDestroyListActivity;
import com.example.windows10.checksystem.databinding.CheckingNoProblemLayoutBinding;
import com.example.windows10.checksystem.presenter.NoProblemPresenter;
import com.example.windows10.checksystem.view.CheckView;
import com.example.windows10.rx_retrofit_library.CommonUtils;

/**
 * 初步检测没有发现问题的界面
 */
public class NoProblemFragment extends BaseFragment implements View.OnClickListener, CheckView {

    private CheckingNoProblemLayoutBinding mBinding;
    private NoProblemPresenter mPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.checking_no_problem_layout, container, false);
        mPresenter = new NoProblemPresenter(this, mContext);
        initView();
        return mBinding.getRoot();
    }

    //初始化控件及其监听的方法
    private void initView() {
        mBinding.btnDetailTest.setOnClickListener(this);
        mBinding.btnEasyDestroy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_detail_test:
                CommonUtils.toOtherActivity((Activity) mContext, DetailsCheckActivity.class);
                break;
            case R.id.btn_easy_destroy:
                CommonUtils.toOtherActivity((CheckingActivity) mContext, EasyDestroyListActivity.class);
                break;
        }

    }

    @Override
    public void updateTitle(String msg) {

    }

    @Override
    public void showFragment(BaseFragment fragment) {

    }

    @Override
    public void showList() {

    }

    @Override
    public void updatePager(Object obj) {

    }

    @Override
    public void finishPager() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
