package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.bean.ParseCheckResultBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityCheckingBinding;
import com.example.windows10.checksystem.fragment.BaseFragment;
import com.example.windows10.checksystem.fragment.CheckingFragment;
import com.example.windows10.checksystem.fragment.HasProblemFragment;
import com.example.windows10.checksystem.fragment.NoBlueToothFragment;
import com.example.windows10.checksystem.fragment.NoProblemFragment;
import com.example.windows10.checksystem.presenter.CheckPresenter;
import com.example.windows10.checksystem.view.CheckView;
import com.example.windows10.rx_retrofit_library.RxUtils;

import java.util.ArrayList;

/**
 * 检测车辆健康状态的页面
 */
public class CheckingActivity extends BaseActivity implements CheckView, View.OnClickListener {

    private CheckPresenter mPresenter;
    private ActivityCheckingBinding mBinding;
    private ArrayList<BaseFragment> fragmentList;
    //正在检测的页面
    private CheckingFragment checkingFragment;
    //检测完成以后没有问题的页面
    private NoProblemFragment noProblemFragment;
    //检测完成以后有问题的页面
    private HasProblemFragment hasProblemFragment;
    //检测完成以后蓝牙没有连接的页面
    private NoBlueToothFragment noBlueToothFragment;
    private FragmentManager fragmentManager;

    private BaseFragment mFragment;

    private ArrayList<ParseCheckResultBean> resultBeens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_checking);
        mPresenter = new CheckPresenter(this, this);
        fragmentList = new ArrayList<>(10);
        fragmentManager = getSupportFragmentManager();
        mBinding.test1.setOnClickListener(this);
        mBinding.test2.setOnClickListener(this);
        mBinding.test3.setOnClickListener(this);
        mBinding.test4.setOnClickListener(this);
        mBinding.includeCheckingTop.ivTitleBack.setOnClickListener(this);
        //显示正在检测的页面
        mPresenter.showFragment(Constants.FRAGMENT_NOPROBLEM);
//        mPresenter.showFragment(Constants.FRAGMENT_CHECKING);
    }


    //更新顶部标题栏的状态
    @Override
    public void updateTitle(String msg) {
        mBinding.includeCheckingTop.tvTitleTitle.setText(msg);
    }

    //显示页面
    @Override
    public void showFragment(BaseFragment baseFragment) {
        mFragment = baseFragment;
        mFragment.setCallBack(this);
        RxUtils.getInstance().doInBackground(new RxUtils.BackgroundExcutors() {
            @Override
            public void doPrepare() {
                fragmentManager.beginTransaction().replace(R.id.fl_home, mFragment).commit();
            }

            @Override
            public void doOnNext(Object value) {

            }

            @Override
            public void doComplete() {
                mFragment.updatePagers(resultBeens);
            }

            @Override
            public void onError() {

            }
        });


    }

    @Override
    public void showList() {

    }

    @Override
    public void updatePager(Object obj) {
        mFragment.updatePagers(obj);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_title_back:
                finishPager();
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(CheckingActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    public void setResultBeens(ArrayList<ParseCheckResultBean> list) {
        resultBeens.clear();
        resultBeens.addAll(list);
    }

}
