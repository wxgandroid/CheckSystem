package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.bean.LingJianDetailsBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityLingjianDetailsBinding;
import com.example.windows10.checksystem.presenter.LingjianDetailsPresenter;
import com.example.windows10.checksystem.view.LingjianDetailsView;

/**
 * 零件的详细信息界面，包括自修指导等功能
 */

public class LingjianDetailsActivity extends BaseActivity implements View.OnClickListener, LingjianDetailsView {

    private ActivityLingjianDetailsBinding mBinding;
    private LingjianDetailsPresenter mPresenter;
    private String lingjianID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lingjian_details);
        mPresenter = new LingjianDetailsPresenter(this);
        mIntent = getIntent();
        lingjianID = mIntent.getStringExtra(Constants.INTENT_KEY_LINGJIAN_ID);
        Log.e("TAG", "lingjianID的值为：" + lingjianID);
        //初始化控件的点击事件
        initListener();
        mPresenter.loadData(lingjianID);

    }

    private void initListener() {
        mBinding.includeZixiu.tvZixiuZhidao.setOnClickListener(this);
        mBinding.includeZixiu.tvLingjianZuoyong.setOnClickListener(this);
        mBinding.includeZixiu.tvTuijianQixiu.setOnClickListener(this);
        mBinding.includeZixiu.tvOtherQixiu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPresenter.onClick(v);
    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(LingjianDetailsActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateUI(LingJianDetailsBean data) {
        LingJianDetailsBean.SparePartsBean bean = data.getSpareParts();
        Glide.with(this).load(Constants.BASE_URL + bean.getPartPicture()).into(mBinding.ivLingjianDetailsPic);
        mBinding.tvLingjianDetailsXinghao.setText(String.format(getString(R.string.lingjian_xinghao), bean.getModel()));
        mBinding.tvLingjianDetailsGuige.setText(String.format(getString(R.string.lingjian_guige), bean.getSpecifications()));
        mBinding.tvLingjianDetailsYuanchangPriceTime.setText(String.format(getString(R.string.yuanchang_price), bean.getPrice(), "12"));
        mBinding.tvLingjianDetailsPinpai.setText(String.format(getString(R.string.lingjian_pinpai_price), bean.getPrice(), "12"));
        mBinding.tvLingjianDetailsWeixiuShichang.setText(String.format(getString(R.string.yuji_gonshi), bean.getBtx1(), "12"));
        mBinding.tvLingjianDetailsShougongfei.setText(String.format(getString(R.string.lingjian_shougongfei), bean.getPrice(), "12"));
    }
}
