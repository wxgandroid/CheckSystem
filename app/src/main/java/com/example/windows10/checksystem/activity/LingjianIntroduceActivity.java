package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.LingJianDetailsBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityLingjianIntroduceBinding;
import com.example.windows10.checksystem.presenter.LingjianDetailsPresenter;
import com.example.windows10.checksystem.view.LingjianDetailsView;

public class LingjianIntroduceActivity extends BaseActivity implements LingjianDetailsView, View.OnClickListener {
    private LingjianDetailsPresenter mPresenter;
    private ActivityLingjianIntroduceBinding mBinding;
    private LingJianDetailsBean.SparePartsBean mBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lingjian_introduce);
        mPresenter = new LingjianDetailsPresenter(this);
        mIntent = getIntent();
        mBean = (LingJianDetailsBean.SparePartsBean) mIntent.getSerializableExtra(Constants.INTENT_PARTS_ID);
        initView();
    }

    private void initView() {
        mBinding.includeLingjianTopTitle.tvTitleTitle.setText(getString(R.string.lingjian_introduce));
        mBinding.includeZixiu.tvZixiuZhidao.setOnClickListener(this);
        mBinding.includeZixiu.tvLingjianZuoyong.setOnClickListener(this);
        mBinding.includeZixiu.tvTuijianQixiu.setOnClickListener(this);
        mBinding.includeZixiu.tvOtherQixiu.setOnClickListener(this);
        Glide.with(this).load(SystemApplication.BASE_PIC_URL + mBean.getPartPicture()).into(mBinding.ivLingjianImage);
        mBinding.tvLingjianName.setText(mBean.getBrandName());
    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(LingjianIntroduceActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        mPresenter.onClick(v);
    }

    @Override
    public void updateUI(LingJianDetailsBean data) {

    }
}
