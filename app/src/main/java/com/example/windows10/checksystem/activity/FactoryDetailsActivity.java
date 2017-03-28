package com.example.windows10.checksystem.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.RecommendFactoryBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityFactoryDetailsBinding;
import com.example.windows10.checksystem.presenter.FactoryDetailsPresenter;
import com.example.windows10.checksystem.view.FactoryDetailsView;
import com.example.windows10.rx_retrofit_library.CommonUtils;

public class FactoryDetailsActivity extends BaseActivity implements FactoryDetailsView, View.OnClickListener {

    private ActivityFactoryDetailsBinding mBinding;
    private RecommendFactoryBean.FactoryListBean mBean;
    private FactoryDetailsPresenter mPresenter;
    private String partID;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_factory_details, null);
        mPresenter = new FactoryDetailsPresenter(this);
        mIntent = getIntent();
        partID = mIntent.getStringExtra(Constants.INTENT_PARTS_ID);
        mBean = (RecommendFactoryBean.FactoryListBean) mIntent.getSerializableExtra(Constants.INTENT_FACTORY_INFO);
        latitude = mIntent.getDoubleExtra(Constants.LATTITUDE, -1);
        longitude = mIntent.getDoubleExtra(Constants.LONGITUDE, -1);
        initView();
        updatePagers(mBean);
    }

    private void initView() {
        mBinding.includeFactoryDetails.tvTitleTitle.setText("介绍");
        mBinding.includeFactoryDetails.ivTitleBack.setOnClickListener(this);
        mBinding.btnCankaoPrice.setOnClickListener(this);
        mBinding.tvFactoryDetailsPhone.setOnClickListener(this);
        mBinding.tvFactoryDetailsAddress.setOnClickListener(this);
        if (CommonUtils.isEmpty(partID)) {
            mBinding.btnCankaoPrice.setVisibility(View.GONE);
        } else {
            mBinding.btnCankaoPrice.setVisibility(View.VISIBLE);
        }

    }

    private void updatePagers(RecommendFactoryBean.FactoryListBean bean) {
        mBinding.includeFactoryDetails.tvTitleTitle.setText(getString(R.string.factory_introduce));
        mBinding.tvFactoryDetailsName.setText(String.format(getString(R.string.recommend_factory), bean.getFactoryName()));
        mBinding.tvFactoryDetailsTime.setText(String.format(getString(R.string.service_time), bean.getBtx1()));
        mBinding.rbFactoryDetailsScore.setRating(bean.getLevel());
        mBinding.tvFactoryDetailsIntro.setText(bean.getIntroduce());
        mBinding.tvFactoryDetailsPhone.setText(bean.getPhone());
        mBinding.tvFactoryDetailsAddress.setText(bean.getFactoryAddress());
        Glide.with(this).load(SystemApplication.BASE_PIC_URL + mBean.getPicture()).into(mBinding.ivFactoryPhotos);
    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(FactoryDetailsActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_title_back:
                finishPager();
                break;
            case R.id.btn_cankao_price:
                mPresenter.toGuZhangDetailsActivity(partID);
                break;
            case R.id.tv_factory_details_phone:
                //拨打商家电话
                CommonUtils.callPhone(this, mBean.getPhone());
                break;
            case R.id.tv_factory_details_address:
                //开始进行导航
                if (mIntent == null) {
                    mIntent = new Intent();
                }
                double[] latitudes = new double[2];
                double[] longitudes = new double[2];
                latitudes[0] = latitude;
                latitudes[1] = mBean.getCoordinateX();
                longitudes[0] = longitude;
                longitudes[1] = mBean.getCoordinateY();
                mIntent.putExtra(Constants.INTENT_LATTITUDE, latitudes);
                mIntent.putExtra(Constants.INTENT_LONGITUDE, longitudes);
                CommonUtils.toOtherActivity(this, GuideActivity.class, mIntent);
                break;


        }
    }
}
