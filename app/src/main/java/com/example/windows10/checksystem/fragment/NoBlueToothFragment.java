package com.example.windows10.checksystem.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.NoBluetoothLayoutBinding;
import com.example.windows10.checksystem.presenter.NoBluetoothPresenter;
import com.example.windows10.checksystem.view.CheckView;

/**
 *
 */
public class NoBlueToothFragment extends BaseFragment implements View.OnClickListener {

    private NoBluetoothLayoutBinding mBinding;
    private NoBluetoothPresenter mPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.no_bluetooth_layout, container, false);
        loadData();
        return mBinding.getRoot();
    }

    @Override
    public void loadData() {
        mPresenter = new NoBluetoothPresenter((CheckView) mContext, mContext);
        initListener();
    }

    //初始化控件的监听
    private void initListener() {
        updatePagers();
        mBinding.btnCheck.setOnClickListener(this);
        mBinding.btnNearQixiuchang.setOnClickListener(this);
        mBinding.btnNotFront.setOnClickListener(this);
    }

    //更新页面的操作
    private void updatePagers() {
        switch (SystemApplication.BLUETOOTH_STATUS) {
            case Constants.BLUE_TOOTH_NOT_SUPPORT:
                mBinding.tvGuzhangTitle.setText("该设备不支持蓝牙");
                break;
            case Constants.BLUE_TOOTH_CONNECT_FAILED:
                mBinding.tvGuzhangTitle.setText("设备无法连接，请联系汽修厂");
                mBinding.btnCheck.setText("推荐汽修厂");
                mBinding.btnNearQixiuchang.setText("易损零件清单");
                mBinding.btnNotFront.setText("汽车知识");
                break;
            case Constants.BLUE_TOOTH_IS_CLOSED:
                mBinding.tvGuzhangTitle.setText("蓝牙未连接，请连接后重试");
                mBinding.btnCheck.setText("检测");
                mBinding.btnNearQixiuchang.setText("附近汽修厂");
                mBinding.btnNotFront.setText("不在车前");
                break;

        }

    }

    @Override
    public void onClick(View v) {
        if (SystemApplication.BLUETOOTH_STATUS == Constants.BLUE_TOOTH_CONNECT_FAILED) {
            switch (v.getId()) {
                case R.id.btn_check:
                    mPresenter.checkNearQiXiuChang();
                    break;
                case R.id.btn_near_qixiuchang:
                    mPresenter.toEasyDestroyActivity();
                    break;
                case R.id.btn_not_front:
                    mPresenter.toCarsKnowledgeActivity();
                    break;
            }
        } else if (SystemApplication.BLUETOOTH_STATUS == Constants.BLUE_TOOTH_IS_CLOSED) {
            switch (v.getId()) {
                case R.id.btn_check:
                    //点击了检测按钮
                    mPresenter.check();
                    break;
                case R.id.btn_near_qixiuchang:
                    mPresenter.checkNearQiXiuChang();
                    break;
                case R.id.btn_not_front:
                    mPresenter.notFront();
                    break;
            }
        }


    }

}
