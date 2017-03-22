package com.example.windows10.checksystem.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.windows10.checksystem.activity.FactoryDetailsActivity;
import com.example.windows10.checksystem.activity.GuZhangDetailsActivity;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.view.FactoryDetailsView;
import com.example.windows10.rx_retrofit_library.CommonUtils;

/**
 * Created by Windows10 on 2017/3/15.
 */
public class FactoryDetailsPresenter extends BasePresenter {

    private FactoryDetailsView mView;


    public FactoryDetailsPresenter(FactoryDetailsView view) {
        mView = view;
        mContext = (Context) view;
    }


    public void toGuZhangDetailsActivity(String partID) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.putExtra(Constants.INTENT_PARTS_ID, partID);
        CommonUtils.toOtherActivity((FactoryDetailsActivity) mContext, GuZhangDetailsActivity.class, mIntent);
        mView.finishPager();
    }
}
