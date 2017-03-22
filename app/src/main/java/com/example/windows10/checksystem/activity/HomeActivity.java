package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.adapter.HomeReyclerViewAdapter;
import com.example.windows10.checksystem.databinding.ActivityHomeBinding;
import com.example.windows10.checksystem.presenter.HomePresenter;
import com.example.windows10.checksystem.view.HomeView;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements HomeView {

    private ActivityHomeBinding mBinding;
    private HomeReyclerViewAdapter mAdapter;
    private HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        mPresenter = new HomePresenter(this);
        initReyclcerView();
    }

    //初始化首页
    private void initReyclcerView() {
        mAdapter = new HomeReyclerViewAdapter(this);
        mBinding.rlvHome.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false));
        mBinding.rlvHome.setAdapter(mAdapter);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add("条目" + i);
        }
        mAdapter.refresh(list);
    }

    @Override
    public void onBackPressed() {
        currentTime = System.currentTimeMillis();
        if (currentTime - preTime < 2000) {
            super.onBackPressed();
        } else {
            Toast.makeText(HomeActivity.this, "再次点击退出应用", Toast.LENGTH_SHORT).show();
            preTime = System.currentTimeMillis();
        }
    }
}
