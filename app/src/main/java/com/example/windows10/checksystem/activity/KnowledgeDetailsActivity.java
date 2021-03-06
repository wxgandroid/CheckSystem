package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.KnowledgeDetailsBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityKnowledgeDetailsBinding;
import com.example.windows10.checksystem.presenter.KnowledgeDetailsPresenter;
import com.example.windows10.checksystem.view.KnowledgeDetailsView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

public class KnowledgeDetailsActivity extends BaseActivity implements KnowledgeDetailsView, View.OnClickListener {

    private ActivityKnowledgeDetailsBinding mBinding;
    private KnowledgeDetailsPresenter mPresenter;
    private int id;
    private IOSLoadingDialog iosLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_knowledge_details);
        mPresenter = new KnowledgeDetailsPresenter(this);
        initView();
        mIntent = getIntent();
        id = mIntent.getIntExtra(Constants.INTENT_KNOWLEDGE_DETAILS, -1);
        mPresenter.loadData(id);
    }

    private void initView() {
        mBinding.incluleKnowledgeDetails.tvTitleTitle.setText("汽车知识详情");
        mBinding.incluleKnowledgeDetails.ivTitleBack.setOnClickListener(this);

    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(KnowledgeDetailsActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showIOSLoading() {
        iosLoading = CommonUtils.showIOSLoadingDialog(this);
    }

    @Override
    public void dismissIOSLoading() {
        if (iosLoading != null) {
            iosLoading.dismiss();
        }
    }

    @Override
    public void updatePagers(KnowledgeDetailsBean data) {
        mBinding.tvKnowledgeDetails.setText(data.getKnowledgeBase().getKnowledgeName());
        Glide.with(this).load(SystemApplication.getInstance().getBASE_PIC_URL() + data.getKnowledgeBase().getPictureAddress()).into(mBinding.ivKnowledgeDetails);
        String introduce = data.getKnowledgeBase().getIntroduce();
        String[] split = introduce.split(",");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        params.setMargins(10, 10, 10, 10);
        mBinding.llKnowledgeDetailsBottom.removeAllViews();
        for (int i = 0; i < split.length; i++) {
            TextView textView = new TextView(this);
            textView.setText(split[i]);
            textView.setLayoutParams(params);
            textView.setGravity(Gravity.CENTER);
            mBinding.llKnowledgeDetailsBottom.addView(textView);
        }


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
