package com.example.windows10.checksystem.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.adapter.CommonRecyclerViewAdapter;
import com.example.windows10.checksystem.bean.ShowProblemBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityShowProblemsBinding;
import com.example.windows10.checksystem.databinding.ShowProblemItemLayoutBinding;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

import java.util.HashMap;

public class ShowProblemsActivity extends BaseActivity implements RxUtils.LoadingNetDataListener<ShowProblemBean>, View.OnClickListener {

    private ActivityShowProblemsBinding mBinding;
    private CommonRecyclerViewAdapter<ShowProblemItemLayoutBinding, ShowProblemBean.ProblemListBean> mAdapter;
    private IOSLoadingDialog mIosLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_show_problems);
        mIntent = getIntent();
        mBinding.rlvShowProblem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.btnRecommendFactory.setOnClickListener(this);
        mBinding.btnOtherFactory.setOnClickListener(this);
        mBinding.includeShowProblems.ivTitleBack.setOnClickListener(this);
        mBinding.includeShowProblems.tvTitleTitle.setText("检测结果");
        String subString = mIntent.getStringExtra(Constants.INTENT_SHOW_PROBLEM_SUBSTRING);
        String custom = mIntent.getStringExtra(Constants.INTENT_SHOW_PROBLEM_CUSTOM);
        HashMap<String, String> map = new HashMap<>();
        if (!CommonUtils.isEmpty(subString)) {
            map.put(Constants.ID, subString);
        }
        if (!CommonUtils.isEmpty(custom)) {
            map.put(Constants.PROBLEM_NAME, custom);
        }
        mIosLoading = CommonUtils.showIOSLoadingDialog(this);
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_SHOW_PROBLEM, map, this, ShowProblemBean.class);
    }

    @Override
    public void onSuccess(ShowProblemBean data) {
        dismissLoading();
        mAdapter = new CommonRecyclerViewAdapter<ShowProblemItemLayoutBinding, ShowProblemBean.ProblemListBean>(this, R.layout.show_problem_item_layout) {
            @Override
            public void bindData(ShowProblemItemLayoutBinding binding, int position) {
                binding.tvShowProblem.setText(mData.get(position).getAnalysis());
            }
        };
        mBinding.rlvShowProblem.setAdapter(mAdapter);
        mAdapter.refresh(data.getProblemList());

    }

    private void dismissLoading() {
        if (mIosLoading != null) {
            mIosLoading.dismiss();
        }
    }

    @Override
    public void onError(String msg) {
        dismissLoading();
    }

    @Override
    public void onComplete() {
        dismissLoading();
    }

    @Override
    public void onClick(View v) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        switch (v.getId()) {
            case R.id.iv_title_back:
                finish();
                break;
            case R.id.btn_recommend_factory:
                mIntent.putExtra(Constants.INTENT_SHOW_RECOMMEND, true);
                CommonUtils.toOtherActivity(this, MapviewActivity.class, mIntent);
                finish();
                break;
            case R.id.btn_other_factory:
                mIntent.putExtra(Constants.INTENT_SHOW_RECOMMEND, false);
                CommonUtils.toOtherActivity(this, MapviewActivity.class, mIntent);
                finish();
                break;
        }
    }
}
