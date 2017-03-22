package com.example.windows10.checksystem.presenter;

import android.content.Context;
import android.util.Log;

import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
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
import com.example.windows10.checksystem.view.MapGuideView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MapPresenter extends BasePresenter implements AMapNaviListener {

    private MapGuideView mView;
    private AMapNavi mAMapNavi;
    List<NaviLatLng> sList = new ArrayList<>();
    List<NaviLatLng> eList = new ArrayList<>();
    List<NaviLatLng> mWayPointList = new ArrayList<>();
    private NaviLatLng start;
    private NaviLatLng end;

    public MapPresenter(MapGuideView view) {
        mView = view;
        mContext = (Context) view;
    }

    public void startGuide(AMapNavi mapNavi,double latitude, double longitude) {
        mAMapNavi = AMapNavi.getInstance(mContext.getApplicationContext());
        mAMapNavi.addAMapNaviListener(this);
        Log.e("TAG", "startGuide" + latitude + "..." + longitude);
        start = new NaviLatLng(latitude, longitude);
        sList.add(start);
        end = new NaviLatLng(latitude + 0.1, longitude - 0.1);
        eList.add(end);

    }

    @Override
    public void onInitNaviFailure() {

    }

    @Override
    public void onInitNaviSuccess() {
        Log.e("TAG", "onInitNaviSuccess");
        int strategy = 0;
        try {
            strategy = mAMapNavi.strategyConvert(true, false, false, false, false);
        } catch (Exception e) {
            Log.e("TAG", "抛出异常了");
            e.printStackTrace();
        }
        boolean b = mAMapNavi.calculateDriveRoute(sList, eList, mWayPointList, strategy);
        if (b) {
            mView.showToast("导航成功");
        } else {
            mView.showToast("导航失败");
        }
        Log.e("TAG", "初始化完成");
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
        Log.e("TAG", "路线规划成功");
        mAMapNavi.startNavi(NaviType.EMULATOR);
//        mAMapNavi.startNavi(NaviType.GPS);
    }

    @Override
    public void onCalculateRouteFailure(int i) {

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
        Log.e("TAG", "路线规划成功");
        mAMapNavi.startNavi(NaviType.EMULATOR);
//        mAMapNavi.startNavi(NaviType.GPS);


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
}
