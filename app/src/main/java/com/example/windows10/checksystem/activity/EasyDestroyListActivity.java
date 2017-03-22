package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.adapter.EasyDestroyListAdapter;
import com.example.windows10.checksystem.bean.EasyDestroyBean;
import com.example.windows10.checksystem.databinding.ActivityEasyDestroyListBinding;
import com.example.windows10.checksystem.presenter.EasyDestroyPresenter;
import com.example.windows10.checksystem.view.EasyDestroyView;

import java.util.List;

public class EasyDestroyListActivity extends BaseActivity implements EasyDestroyView, View.OnClickListener {

    private ActivityEasyDestroyListBinding mBinding;
    private EasyDestroyListAdapter mAdapter;
    private EasyDestroyPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_easy_destroy_list);
        mPresenter = new EasyDestroyPresenter(this);
        initView();
        initRecyclerView();
        //联网进行数据的加载
        mPresenter.loadData();
    }

    //初始化视图的操作
    private void initView() {
        mBinding.includeEasyDestroy.tvTitleTitle.setText("易损零件清单");
        mBinding.includeEasyDestroy.ivTitleBack.setOnClickListener(this);
    }

    //初始化RecyclerView
    private void initRecyclerView() {
        mAdapter = new EasyDestroyListAdapter(this);
        mBinding.rlvEasyDestroyList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.rlvEasyDestroyList.setAdapter(mAdapter);
    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(EasyDestroyListActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateRecyclerView(List<EasyDestroyBean.PartsListBean> partsList) {
        mAdapter.refresh(partsList);
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
