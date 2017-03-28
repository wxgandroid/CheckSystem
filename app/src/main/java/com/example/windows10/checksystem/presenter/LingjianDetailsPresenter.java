package com.example.windows10.checksystem.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.activity.LingjianIntroduceActivity;
import com.example.windows10.checksystem.activity.MapviewActivity;
import com.example.windows10.checksystem.activity.VideoPlayerActivity;
import com.example.windows10.checksystem.bean.LingJianDetailsBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.view.LingjianDetailsView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;

import java.util.HashMap;

/**
 * 零件详细页面的逻辑处理
 */
public class LingjianDetailsPresenter extends BasePresenter implements RxUtils.LoadingNetDataListener<LingJianDetailsBean> {

    private LingjianDetailsView mView;
    private HashMap<String, String> mMap;
    private LingJianDetailsBean.SparePartsBean.VideoBean videoBean;
    private LingJianDetailsBean.SparePartsBean parts;
    private boolean clickable = false;

    public LingjianDetailsPresenter(LingjianDetailsView view) {
        mView = view;
        mContext = (Context) view;
    }


    //点击事件处理
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_zixiu_zhidao:
                if (videoBean == null) {
                    Toast.makeText(mContext, "视频信息错误", Toast.LENGTH_SHORT).show();
                    return;
                }

                //点击了自修指导按钮
                if (mIntent == null) {
                    mIntent = new Intent();
                }
                mIntent.putExtra(Constants.INTENT_KEY_VIDEO, videoBean);
                CommonUtils.toOtherActivity((Activity) mContext, VideoPlayerActivity.class, mIntent);
                break;
            case R.id.tv_lingjian_zuoyong:
                //点击了零件作用按钮
                if (mIntent == null) {
                    mIntent = new Intent();
                }
                mIntent.putExtra(Constants.INTENT_PARTS_ID, parts);
                CommonUtils.toOtherActivity((Activity) mContext, LingjianIntroduceActivity.class, mIntent);
                break;
            case R.id.tv_tuijian_qixiu:
                if (mIntent == null) {
                    mIntent = new Intent();
                }
                mIntent.putExtra(Constants.INTENT_SHOW_RECOMMEND, true);
                CommonUtils.toOtherActivity((Activity) mContext, MapviewActivity.class, mIntent);
                break;
            case R.id.tv_other_qixiu:
                //点击了选择其他汽修厂的按钮
                if (mIntent == null) {
                    mIntent = new Intent();
                }
                mIntent.putExtra(Constants.INTENT_SHOW_RECOMMEND, false);
                CommonUtils.toOtherActivity((Activity) mContext, MapviewActivity.class, mIntent);
                break;
            case R.id.tv_lingjian_details_pinpai:
                mView.showPinpaiList(view);
                break;
            case R.id.iv_title_back:
                mView.finishPager();
                break;

        }
    }

    //加载零件的详细数据
    public void loadData(String id) {
        mMap = new HashMap<>();
        mMap.put(Constants.ID, id + "");
        showLoadingDialog();
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_LINGJIAN_DETAILS, mMap, this, LingJianDetailsBean.class);
    }

    @Override
    public void onSuccess(LingJianDetailsBean data) {
        dismissDialog();
        clickable = true;
        mView.setData(data);
        videoBean = data.getSpareParts().getVideo();
        parts = data.getSpareParts();
        Log.e("TAG", "onSuccess()");
    }

    @Override
    public void onError(String msg) {
        dismissDialog();
        mView.showToast(msg);
        Log.e("TAG", "onError()");

    }

    @Override
    public void onComplete() {
        dismissDialog();
        Log.e("TAG", "onComplete");
    }
}
