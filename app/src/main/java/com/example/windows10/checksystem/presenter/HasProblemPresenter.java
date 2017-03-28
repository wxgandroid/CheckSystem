package com.example.windows10.checksystem.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.example.windows10.checksystem.activity.CheckingActivity;
import com.example.windows10.checksystem.activity.FactoryDetailsActivity;
import com.example.windows10.checksystem.activity.GuZhangDetailsActivity;
import com.example.windows10.checksystem.activity.GuideActivity;
import com.example.windows10.checksystem.bean.RecommendFactoryBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.customview.PointView;
import com.example.windows10.checksystem.view.HasProblemView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 检测汽车有问题的逻辑页面
 */
public class HasProblemPresenter extends BasePresenter implements RxUtils.LoadingNetDataListener<RecommendFactoryBean> {

    private HasProblemView mView;
    private RecommendFactoryBean mData;

    public HasProblemPresenter(HasProblemView view, Context context) {
        mView = view;
        mContext = context;
    }


    public void changePointsColor(ArrayList<PointView> list, int position) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.size() == 1) {
            list.get(0).setVisibility(View.GONE);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == position) {
                list.get(i).setVisibility(View.VISIBLE);
                list.get(i).setColor(Color.parseColor("#ff0000"));
            } else {
                list.get(i).setVisibility(View.VISIBLE);
                list.get(i).setColor(Color.GRAY);
            }

        }
    }

    //显示推荐汽修厂
    public void showFactory(double latitude, double longitude, boolean isRecommend) {
        HashMap<String, String> map = new HashMap<>();
        map.put(Constants.LATTITUDE, latitude + "");
        map.put(Constants.LONGITUDE, longitude + "");
        if (isRecommend) {
            RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_RECOMMENT_FACTORY, map, this, RecommendFactoryBean.class);
        } else {
            RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_OTHER_FACTORY, map, this, RecommendFactoryBean.class);
        }
    }

    @Override
    public void onSuccess(RecommendFactoryBean data) {
        mData = data;
        double[] atitudes = new double[3];
        double[] longitudes = new double[3];
        List<RecommendFactoryBean.FactoryListBean> factoryList = mData.getFactoryList();
        for (int i = 0; i < factoryList.size(); i++) {
            atitudes[i] = factoryList.get(i).getCoordinateX();
            longitudes[i] = factoryList.get(i).getCoordinateY();
            Log.e("TAG", "获取到的坐标为：" + atitudes[i] + "..." + longitudes[i]);
        }
        mView.showRecommendFactory(atitudes, longitudes);
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onComplete() {

    }

    //给汽修厂打电话
    public void callFactory(int markerPosition) {
        //实际应该根据position从mData里面取出数据
        RecommendFactoryBean.FactoryListBean factoryListBean = mData.getFactoryList().get(markerPosition);
        String num = factoryListBean.getPhone();
        if (CommonUtils.isEmpty(num)) {
            num = "010-68881111";
        }
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
        mContext.startActivity(intent);
    }

    //跳转到对应汽修厂的详细信息的界面
    public void toFactoryDetails(int makerPosition, String partsId, double latitude, double longitude) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.putExtra(Constants.INTENT_PARTS_ID, partsId);
        mIntent.putExtra(Constants.INTENT_FACTORY_INFO, mData.getFactoryList().get(makerPosition));
        mIntent.putExtra(Constants.LATTITUDE, latitude);
        mIntent.putExtra(Constants.LONGITUDE, longitude);
        CommonUtils.toOtherActivity((CheckingActivity) mContext, FactoryDetailsActivity.class, mIntent);
    }

    //跳转到导航页面
    public void toGuideActivity(int makerPosition, double latitude, double longitude) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        RecommendFactoryBean.FactoryListBean factoryListBean = mData.getFactoryList().get(makerPosition);

        double[] latitudes = new double[2];
        double[] longitudes = new double[2];
        latitudes[0] = latitude;
        latitudes[1] = factoryListBean.getCoordinateX();
        longitudes[0] = longitude;
        longitudes[1] = factoryListBean.getCoordinateY();
        mIntent.putExtra(Constants.INTENT_LATTITUDE, latitudes);
        mIntent.putExtra(Constants.INTENT_LONGITUDE, longitudes);
        CommonUtils.toOtherActivity((CheckingActivity) mContext, GuideActivity.class, mIntent);

    }

    //跳转到故障详情页面
    public void toGuZhangActivity(String parterID) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.putExtra(Constants.INTENT_PARTS_ID, parterID);
        CommonUtils.toOtherActivity((CheckingActivity) mContext, GuZhangDetailsActivity.class, mIntent);
    }
}
