package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.enums.NaviType;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviStaticInfo;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.tbt.NaviStaticInfo;
import com.autonavi.tbt.TrafficFacilityInfo;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityMapBinding;
import com.example.windows10.checksystem.view.MapGuideView;

import java.util.ArrayList;
import java.util.List;

/**
 * 导航的页面
 */

public class GuideActivity extends BaseActivity implements MapGuideView, AMapNaviViewListener, AMapNaviListener, View.OnClickListener {

    private ActivityMapBinding mBinding;
    //声明mListener对象，定位监听器

    private AMapNavi mAMapNavi;

    List<NaviLatLng> sList = new ArrayList<>();
    List<NaviLatLng> eList = new ArrayList<>();
    List<NaviLatLng> mWayPointList = new ArrayList<>();
    private NaviLatLng start;
    private NaviLatLng end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_map);
        mBinding.mapView.onCreate(savedInstanceState);
        mAMapNavi = AMapNavi.getInstance(getApplicationContext());
        mAMapNavi.addAMapNaviListener(this);
        mIntent = getIntent();
        mBinding.includeGuide.tvTitleTitle.setText("导航");
        mBinding.includeGuide.ivTitleBack.setOnClickListener(this);
        mBinding.mapView.setAMapNaviViewListener(this);
        double[] lattitudes = mIntent.getDoubleArrayExtra(Constants.INTENT_LATTITUDE);
        double[] longitudes = mIntent.getDoubleArrayExtra(Constants.INTENT_LONGITUDE);
        //添加起点和终点坐标
        start = new NaviLatLng(lattitudes[0], longitudes[0]);
        sList.add(start);
        end = new NaviLatLng(lattitudes[1], longitudes[1]);
        Log.e("TAG", "导航终点的坐标为：" + lattitudes[1] + ":" + longitudes[1]);
        eList.add(end);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.mapView.onDestroy();
        mAMapNavi.destroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBinding.mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBinding.mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mBinding.mapView.onSaveInstanceState(outState);
    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(GuideActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNaviSetting() {

    }

    @Override
    public void onNaviCancel() {

    }

    @Override
    public boolean onNaviBackClick() {
        return false;
    }

    @Override
    public void onNaviMapMode(int i) {

    }

    @Override
    public void onNaviTurnClick() {

    }

    @Override
    public void onNextRoadClick() {

    }

    @Override
    public void onScanViewButtonClick() {

    }

    @Override
    public void onLockMap(boolean b) {

    }

    @Override
    public void onNaviViewLoaded() {

    }

    @Override
    public void onInitNaviFailure() {
        Log.e("TAG", "onInitNaviFailure");
    }

    @Override
    public void onInitNaviSuccess() {
        Log.e("TAG", "onInitNaviSuccess()");
        int strategy = 0;
        try {
            //再次强调，最后一个参数为true时代表多路径，否则代表单路径
            strategy = mAMapNavi.strategyConvert(true, false, false, false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mAMapNavi.calculateDriveRoute(sList, eList, mWayPointList, strategy);
    }

    @Override
    public void onStartNavi(int i) {

    }

    @Override
    public void onTrafficStatusUpdate() {

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onGetNavigationText(int i, String s) {

    }

    @Override
    public void onEndEmulatorNavi() {

    }

    @Override
    public void onArriveDestination() {

    }

    @Override
    public void onArriveDestination(NaviStaticInfo naviStaticInfo) {

    }

    @Override
    public void onArriveDestination(AMapNaviStaticInfo aMapNaviStaticInfo) {

    }

    @Override
    public void onCalculateRouteSuccess() {
        Log.e("TAG", "onCalculateRouteSuccess()");
        mAMapNavi.startNavi(NaviType.GPS);
    }

    @Override
    public void onCalculateRouteFailure(int i) {
        Toast.makeText(GuideActivity.this, "错误码：" + i + ",请重试", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReCalculateRouteForYaw() {

    }

    @Override
    public void onReCalculateRouteForTrafficJam() {

    }

    @Override
    public void onArrivedWayPoint(int i) {

    }

    @Override
    public void onGpsOpenStatus(boolean b) {

    }

    @Override
    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {

    }

    @Override
    public void onNaviInfoUpdate(NaviInfo naviInfo) {

    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {

    }

    @Override
    public void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {

    }

    @Override
    public void showCross(AMapNaviCross aMapNaviCross) {

    }

    @Override
    public void hideCross() {

    }

    @Override
    public void showLaneInfo(AMapLaneInfo[] aMapLaneInfos, byte[] bytes, byte[] bytes1) {

    }

    @Override
    public void hideLaneInfo() {

    }

    @Override
    public void onCalculateMultipleRoutesSuccess(int[] ints) {
        Log.e("TAG", "onCalculateMultipleRoutesSuccess");
        mAMapNavi.startNavi(NaviType.EMULATOR);
    }

    @Override
    public void notifyParallelRoad(int i) {

    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfos) {

    }

    @Override
    public void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {

    }

    @Override
    public void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_title_back:
                finishPager();
                break;
        }

    }
}
