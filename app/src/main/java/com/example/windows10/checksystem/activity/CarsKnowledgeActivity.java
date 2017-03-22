package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.adapter.CarsKnowledgeAdapter;
import com.example.windows10.checksystem.bean.KnowledgeAllBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityCarsKnowledgeBinding;
import com.example.windows10.rx_retrofit_library.RxUtils;

public class CarsKnowledgeActivity extends BaseActivity implements View.OnClickListener, RxUtils.LoadingNetDataListener<KnowledgeAllBean> {

    private ActivityCarsKnowledgeBinding mBinding;
    private CarsKnowledgeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_cars_knowledge);
        initView();
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_KNOWLEDGE_ALL, null, this, KnowledgeAllBean.class);
    }

    private void initView() {
        mAdapter = new CarsKnowledgeAdapter(this);
        mBinding.includeCarsKnowledge.ivTitleBack.setOnClickListener(this);
        mBinding.includeCarsKnowledge.tvTitleTitle.setText(getString(R.string.cars_knowledge));
        mBinding.includeCarsKnowledge.ivTitleList.setOnClickListener(this);
        mBinding.rlvCarsKnowledge.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.rlvCarsKnowledge.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSuccess(KnowledgeAllBean data) {
        mAdapter.refresh(data.getKnowledgeBaseList());
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onComplete() {

    }
}
