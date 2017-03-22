package com.example.windows10.checksystem.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.bean.RecommendFactoryBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityMapviewBinding;
import com.example.windows10.checksystem.databinding.MapInfoWindowLayoutBinding;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapviewActivity extends BaseActivity implements LocationSource, AMap.OnMarkerClickListener, AMapLocationListener, RxUtils.LoadingNetDataListener<RecommendFactoryBean>, View.OnClickListener {

    private ActivityMapviewBinding mBinding;
    private AMap aMap;
    private UiSettings mMapUiSetting;
    private AMapLocationClientOption mLocationOption;
    private OnLocationChangedListener mListener = null;
    public AMapLocationClient mlocationClient = null;
    private double latitude;
    private double longitude;
    //显示推荐的汽修厂
    private boolean firstShowFactory = true;
    private boolean showRecommend = true;
    private boolean locationSuccess = false;
    private RecommendFactoryBean mData;

    //自定义地图的infoWindow的适配器
    private AMap.InfoWindowAdapter infoWindowAdapter;

    //保存点击的标记位置的position
    private int makerPosition = -1;
    //保存地图上标记点的Marker对象的集合
    private ArrayList<Marker> mMarkers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mapview);
        mBinding.mapView.onCreate(savedInstanceState);
        initLocation();
    }

    //初始化当前定位
    private void initLocation() {

        aMap = mBinding.mapView.getMap();
        aMap.setTrafficEnabled(true);
        aMap.setMapType(AMap.MAP_TYPE_NORMAL);
        mMapUiSetting = aMap.getUiSettings();
        //显示当前位置的按钮，并点击可以触发
        aMap.setLocationSource(this);
        mMapUiSetting.setMyLocationButtonEnabled(true);
        aMap.setMyLocationEnabled(true);
        mMapUiSetting.setScaleControlsEnabled(true);//控制比例尺控件是否显示
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
        aMap.setOnMarkerClickListener(this);

        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
    }


    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            //初始化定位
            mlocationClient = new AMapLocationClient(this);
            //初始化定位参数
            mLocationOption = new AMapLocationClientOption();
            //设置定位回调监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();//启动定位
        }

    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (mListener != null && aMapLocation != null) {
            if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(aMapLocation);// 显示系统小蓝点
                latitude = aMapLocation.getLatitude();
                longitude = aMapLocation.getLongitude();
                Log.e("TAG", "当前的坐标为：" + latitude + "..." + longitude);
                locationSuccess = true;
                if (firstShowFactory) {
                    firstShowFactory = false;
                    showFactory(latitude, longitude, showRecommend);
                }
            } else {
                String errText = "定位失败," + aMapLocation.getErrorCode() + ": " + aMapLocation.getErrorInfo();
                Log.e("AmapErr", errText);
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
        showRecommendFactory(atitudes, longitudes);
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onComplete() {

    }

    public void showRecommendFactory(double[] atitudes, double[] longitudes) {
        if (infoWindowAdapter == null) {
            infoWindowAdapter = new AMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    MapInfoWindowLayoutBinding binding = DataBindingUtil.bind(View.inflate(MapviewActivity.this, R.layout.map_info_window_layout, null));
                    Log.e("TAG", "设置点击事件");
                    binding.ivMapGuide.setOnClickListener(MapviewActivity.this);
                    binding.ivMapCall.setOnClickListener(MapviewActivity.this);
                    binding.ivMapInfo.setOnClickListener(MapviewActivity.this);
                    return binding.getRoot();
                }

                @Override
                public View getInfoContents(Marker marker) {
                    return null;
                }
            };

        }
        aMap.setInfoWindowAdapter(infoWindowAdapter);
        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                makerPosition = mMarkers.indexOf(marker);
                if (!marker.isInfoWindowShown()) {
                    marker.showInfoWindow();
                } else {
                    dismissMarker();
                }
                Log.e("TAG", "markerPosition=" + makerPosition);
                return true;
            }
        });
//        atitudes[0] = latitude - 0.01;
//        longitudes[0] = longitude - 0.01;
//        atitudes[1] = latitude - 0.01;
//        longitudes[1] = longitude + 0.01;
//        atitudes[2] = latitude + 0.01;
//        longitudes[2] = longitude + 0.01;
        mMarkers.clear();
        aMap.clear();
        for (int i = 0; i < atitudes.length; i++) {
            LatLng latLng = new LatLng(atitudes[i], longitudes[i]);
            Marker marker = aMap.addMarker(new MarkerOptions().position(latLng).title("汽修厂名称"));
            mMarkers.add(marker);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_switch_tuijian:
                //在地图上显示其他汽修厂
                if (!locationSuccess) {
                    return;
                }
                showRecommend = !showRecommend;
                if (showRecommend) {
                    mBinding.btnSwitchTuijian.setText("其他汽修厂");
                } else {
                    mBinding.btnSwitchTuijian.setText("推荐汽修厂");
                }
                showFactory(latitude, longitude, showRecommend);
                break;

            case R.id.iv_map_guide:
                dismissMarker();
                toGuideActivity(makerPosition, latitude, longitude);
                break;
            case R.id.iv_map_call:
                dismissMarker();
                callFactory(makerPosition);
                break;
            case R.id.iv_map_info:
                dismissMarker();
                toFactoryDetails(makerPosition);
                break;

        }


    }

    public void dismissMarker() {
        if (mMarkers != null) {
            mMarkers.get(makerPosition).hideInfoWindow();
        }
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
    protected void onDestroy() {
        super.onDestroy();
        mBinding.mapView.onDestroy();
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
        CommonUtils.toOtherActivity(this, GuideActivity.class, mIntent);

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
        startActivity(intent);
    }

    //跳转到对应汽修厂的详细信息的界面
    public void toFactoryDetails(int makerPosition) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.putExtra(Constants.INTENT_FACTORY_INFO, mData.getFactoryList().get(makerPosition));
        CommonUtils.toOtherActivity(this, FactoryDetailsActivity.class, mIntent);
    }

}
