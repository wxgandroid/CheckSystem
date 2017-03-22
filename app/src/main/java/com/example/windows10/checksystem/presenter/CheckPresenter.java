package com.example.windows10.checksystem.presenter;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;

import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.ParseCheckResultBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.fragment.BaseFragment;
import com.example.windows10.checksystem.fragment.CheckingFragment;
import com.example.windows10.checksystem.fragment.HasProblemFragment;
import com.example.windows10.checksystem.fragment.NoBlueToothFragment;
import com.example.windows10.checksystem.fragment.NoProblemFragment;
import com.example.windows10.checksystem.view.CheckView;

import java.util.ArrayList;

/**
 *
 */
public class CheckPresenter extends BasePresenter {
    private CheckView mView;
    private BluetoothAdapter bluetoothAdapter;

    public CheckPresenter(CheckView view, Context context) {
        mView = view;
        mContext = context;
        //获取蓝牙的适配器
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public void showFragment(int status) {
        switch (status) {
            case Constants.FRAGMENT_CHECKING:
                mView.updateTitle("检测中");
                loadingChecking();
                break;
            case Constants.FRAGMENT_HASPROBLEM:
                mView.updateTitle("检测结果");
                HasProblemFragment hasProblemFragment = BaseFragment.instance(mContext, HasProblemFragment.class);
                mView.showFragment(hasProblemFragment);
                break;
            case Constants.FRAGMENT_NOBLUETOOTH:
                mView.updateTitle("检测结果");
                NoBlueToothFragment noBlueToothFragment = BaseFragment.instance(mContext, NoBlueToothFragment.class);
                mView.showFragment(noBlueToothFragment);
                break;
            case Constants.FRAGMENT_NOPROBLEM:
                mView.updateTitle("检测结果");
                NoProblemFragment noProblemFragment = BaseFragment.instance(mContext, NoProblemFragment.class);
                mView.showFragment(noProblemFragment);
                break;
        }
    }

    //加载正在检测的信息
    public void loadingChecking() {
        if (bluetoothAdapter == null) {
            //设备不支持蓝牙
            mView.showToast("您的设备暂不支持蓝牙");
            mView.showFragment(BaseFragment.instance(mContext, NoBlueToothFragment.class));
            //不支持蓝牙
            SystemApplication.BLUETOOTH_STATUS = Constants.BLUE_TOOTH_NOT_SUPPORT;

        } else if (!bluetoothAdapter.isEnabled()) {
            //蓝牙未打开
            mView.showToast("请打开蓝牙后重试");
            SystemApplication.BLUETOOTH_STATUS = Constants.BLUE_TOOTH_IS_CLOSED;
            mView.showFragment(BaseFragment.instance(mContext, NoBlueToothFragment.class));
        } else {
            CheckingFragment checkingFragment = BaseFragment.instance(mContext, CheckingFragment.class);
            mView.showFragment(checkingFragment);
        }
    }

    //点击左上角按钮
    public void clickTopLeft(BaseFragment fragment) {
        switch (getPagerType(fragment)) {
            case Constants.FRAGMENT_HASPROBLEM:
                mView.showList();
                break;
            default:
                mView.finishPager();
                break;
        }
    }

    public int getPagerType(BaseFragment fragment) {
        if (fragment instanceof CheckingFragment) {
            return Constants.FRAGMENT_CHECKING;
        } else if (fragment instanceof HasProblemFragment) {
            return Constants.FRAGMENT_HASPROBLEM;
        } else if (fragment instanceof NoProblemFragment) {
            return Constants.FRAGMENT_NOPROBLEM;
        } else {
            return Constants.FRAGMENT_NOBLUETOOTH;
        }
    }

    public void upDataHasProblemView(ArrayList<ParseCheckResultBean> mList) {
        mView.updatePager(mList);
    }


}
