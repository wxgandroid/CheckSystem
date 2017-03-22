package com.example.windows10.checksystem.fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

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
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.activity.EasyDestroyListActivity;
import com.example.windows10.checksystem.activity.MapviewActivity;
import com.example.windows10.checksystem.adapter.PossibleDestroyListPagerAdapter;
import com.example.windows10.checksystem.bean.ParseCheckResultBean;
import com.example.windows10.checksystem.customview.PointView;
import com.example.windows10.checksystem.databinding.HasProblemFragmentLayoutBinding;
import com.example.windows10.checksystem.databinding.MapInfoWindowLayoutBinding;
import com.example.windows10.checksystem.databinding.ViewPagerLayoutBinding;
import com.example.windows10.checksystem.presenter.HasProblemPresenter;
import com.example.windows10.checksystem.view.HasProblemView;
import com.example.windows10.rx_retrofit_library.CommonUtils;

import java.util.ArrayList;

/**
 * 检测以后汽车有问题的页面
 */
public  class HasProblemFragment extends BaseFragment implements View.OnClickListener, AMapLocationListener, LocationSource, PoiSearch.OnPoiSearchListener, AMap.OnMarkerClickListener, ViewPager.OnPageChangeListener, HasProblemView {

    private HasProblemPresenter mPresenter;
    private HasProblemFragmentLayoutBinding mBinding;
    private AMap aMap;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    public AMapLocationClient mlocationClient = null;
    private UiSettings mMapUiSetting;
    //声明mListener对象，定位监听器
    private OnLocationChangedListener mListener = null;
    private PoiSearch.Query query;
    private PoiSearch poiSearch;
    private double latitude;
    private double longitude;
    private PossibleDestroyListPagerAdapter mPagerAdapter;
    //故障圆点的集合
    private ArrayList<PointView> mPointViews = new ArrayList<>();
    private ArrayList<ParseCheckResultBean> mList = new ArrayList<>();
    private ArrayList<View> mViewDatas = new ArrayList<>();
    //显示推荐的汽修厂
    private boolean firstShowFactory = true;
    private boolean showRecommend = true;
    private boolean locationSuccess = false;


    //自定义地图的infoWindow的适配器
    private AMap.InfoWindowAdapter infoWindowAdapter;
    //保存地图上标记点的Marker对象的集合
    private ArrayList<Marker> mMarkers = new ArrayList<>();
    //保存点击的标记位置的position
    private int makerPosition = -1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.has_problem_fragment_layout, container, false);
        mPresenter = new HasProblemPresenter(this, getContext());
        mBinding.mvHasProblem.onCreate(savedInstanceState);
        initLocation();
        loadData();
        return mBinding.getRoot();
    }

    //初始化当前定位
    private void initLocation() {

        aMap = mBinding.mvHasProblem.getMap();
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
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        query = new PoiSearch.Query("肯德基", "");
        query.setPageSize(10);

    }


    @Override
    public void loadData() {
        mBinding.btnEasyDestroy.setOnClickListener(this);
        mBinding.btnFactoryDetails.setOnClickListener(this);
        mBinding.btnFactoryOther.setOnClickListener(this);
        initViewPager();
    }

    //初始化可能损坏的零件列表
    private void initViewPager() {
        mPointViews = new ArrayList<>();
        mPagerAdapter = new PossibleDestroyListPagerAdapter(mContext);
        mBinding.vpDestroyList.setAdapter(mPagerAdapter);
        mViewDatas = new ArrayList<>();
        initViewDatas();
        mBinding.vpDestroyList.addOnPageChangeListener(this);
    }

    private void initViewDatas() {
        mViewDatas.clear();
        mPointViews.clear();
        for (int i = 0; i < mList.size(); i++) {
            ViewPagerLayoutBinding binding = DataBindingUtil.bind(View.inflate(mContext, R.layout.view_pager_layout, null));
            String price1 = mList.get(i).getSpareParts().getPrice();
            String price2 = mList.get(i).getSpareParts().getManualPrice();
            String totalPrice = Double.parseDouble(price1) + Double.parseDouble(price2) + "";
            binding.tvDestroyResult.setText(mList.get(i).getId());
            binding.tvChangePrice.setText(String.format(getString(R.string.change_price), totalPrice+""));
            binding.tvPinpaiPrice.setText(String.format(getString(R.string.pinpai_price), price1));
            binding.tvShougongPrice.setText(String.format(getString(R.string.shougongfei), price2));
            binding.tvYongshi.setText(String.format(getString(R.string.yujiyongshi), mList.get(i).getSpareParts().getBtx1()));
            binding.tvBaoxiu.setText(String.format(getString(R.string.baoxiu), mList.get(i).getSpareParts().getBtx2()));
            mViewDatas.add(binding.getRoot());
            //添加小圆点
            PointView pointView = new PointView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.leftMargin = 10;
            pointView.setLayoutParams(params);
            mBinding.llDestroyPoints.addView(pointView);
            mPointViews.add(pointView);
        }
        //默认第一个小圆点为红色
        mPresenter.changePointsColor(mPointViews, 0);
        mPagerAdapter.refresh(mViewDatas);
    }

    @Override
    public void onClick(View v) {
        Log.e("TAG", "onClick");
        switch (v.getId()) {
            case R.id.btn_easy_destroy:
                //易损零件清单
                CommonUtils.toOtherActivity(getActivity(), EasyDestroyListActivity.class);
                break;
            case R.id.btn_factory_details:
                mPresenter.toGuZhangActivity(mList.get(mBinding.vpDestroyList.getCurrentItem()).getPartsId());
                break;
            case R.id.btn_factory_other:
                CommonUtils.toOtherActivity((Activity) mContext, MapviewActivity.class);
                break;
            case R.id.iv_map_guide:
                dismissMarker();
                mPresenter.toGuideActivity(makerPosition, latitude, longitude);
                break;
            case R.id.iv_map_call:
                dismissMarker();
                mPresenter.callFactory(makerPosition);
                break;
            case R.id.iv_map_info:
                dismissMarker();
                mPresenter.toFactoryDetails(makerPosition);
                break;

        }
    }

    private void doSearch() {
        poiSearch = new PoiSearch(mContext, query);
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(latitude,
                longitude), 1000));//设置周边搜索的中心点以及半径
        poiSearch.searchPOIAsyn();
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
                    mPresenter.showFactory(latitude, longitude, showRecommend);
                }
            } else {
                String errText = "定位失败," + aMapLocation.getErrorCode() + ": " + aMapLocation.getErrorInfo();
                Log.e("AmapErr", errText);
            }
        }
    }


    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            //初始化定位
            mlocationClient = new AMapLocationClient(mContext);
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
    public void onDestroy() {
        super.onDestroy();
        if (null != mlocationClient) {
            mlocationClient.stopLocation();//停止定位
            mlocationClient.onDestroy();
        }
        mBinding.mvHasProblem.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        mBinding.mvHasProblem.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mBinding.mvHasProblem.onPause();
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {

    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mPresenter.changePointsColor(mPointViews, position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void finishPager() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public void dismissMarker() {
        if (mMarkers != null) {
            mMarkers.get(makerPosition).hideInfoWindow();
        }
    }

    //更新页面
    @Override
    public void updatePagers(Object obj) {
        mList = (ArrayList<ParseCheckResultBean>) obj;
        initViewDatas();
        mPagerAdapter.refresh(mViewDatas);
    }

    //在地图上显示推荐的汽修厂
    @Override
    public void showRecommendFactory(double[] atitudes, double[] longitudes) {
        if (infoWindowAdapter == null) {
            infoWindowAdapter = new AMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    MapInfoWindowLayoutBinding binding = DataBindingUtil.bind(View.inflate(mContext, R.layout.map_info_window_layout, null));
                    Log.e("TAG", "设置点击事件");
                    binding.ivMapGuide.setOnClickListener(HasProblemFragment.this);
                    binding.ivMapCall.setOnClickListener(HasProblemFragment.this);
                    binding.ivMapInfo.setOnClickListener(HasProblemFragment.this);
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
}
