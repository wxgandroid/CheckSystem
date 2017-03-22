package com.example.windows10.checksystem.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.windows10.checksystem.activity.CarsKnowledgeActivity;
import com.example.windows10.checksystem.activity.EasyDestroyListActivity;
import com.example.windows10.checksystem.activity.MapviewActivity;
import com.example.windows10.checksystem.view.CheckView;
import com.example.windows10.rx_retrofit_library.CommonUtils;

/**
 * Created by Windows10 on 2017/3/1.
 */
public class NoBluetoothPresenter extends CheckPresenter {


    public NoBluetoothPresenter(CheckView view, Context context) {
        super(view, context);
    }

    //开始检测
    public void check() {
        loadingChecking();
//        Log.e("TAG", "check()");
//        //获取蓝牙适配器
//        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        if (mBluetoothAdapter == null) {
//            mView.showToast("您的手机不支持蓝牙");
//            return;
//        } else if (!mBluetoothAdapter.isEnabled()) {
//            mView.showToast("请打开蓝牙并连接后重试");
//            return;
//        } else {
//            mView.showFragment(BaseFragment.instance(mContext, CheckingFragment.class));
//        }
    }


    //查询附近的汽修厂
    public void checkNearQiXiuChang() {
        CommonUtils.toOtherActivity((Activity) mContext, MapviewActivity.class);
    }

    //本人不在车前
    public void notFront() {

    }

    public void toEasyDestroyActivity() {
        CommonUtils.toOtherActivity((Activity) mContext, EasyDestroyListActivity.class);
    }

    public void toCarsKnowledgeActivity() {
        CommonUtils.toOtherActivity((Activity) mContext, CarsKnowledgeActivity.class);
    }
}
