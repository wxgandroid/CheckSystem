package com.example.windows10.checksystem.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.adapter.CommonRecyclerViewAdapter;
import com.example.windows10.checksystem.bean.CheckDetailsAllBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityDetailsCheckBinding;
import com.example.windows10.checksystem.databinding.DetailsCheckItemLayoutBinding;
import com.example.windows10.checksystem.presenter.DetailsCheckPresenter;
import com.example.windows10.checksystem.view.DetailsCheckAllView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

import java.util.List;

public class DetailsCheckActivity extends BaseActivity implements View.OnClickListener, DetailsCheckAllView {

    private ActivityDetailsCheckBinding mBinding;
    private DetailsCheckPresenter mPresenter;
    private CommonRecyclerViewAdapter<DetailsCheckItemLayoutBinding, CheckDetailsAllBean.ProblemListBean> mAdapter;
    private IOSLoadingDialog mIOSLoading;
    private CheckDetailsAllBean mBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_check);
        mPresenter = new DetailsCheckPresenter(this);
        //初始化视图的操作
        initView();

        mPresenter.loadData();

    }

    //初始化视图的操作
    private void initView() {
        mBinding.includeDetailsCheck.tvTitleTitle.setText("详细检测");
        mBinding.includeDetailsCheck.ivTitleBack.setOnClickListener(this);
        mBinding.btnDetailsCheckSubmit.setOnClickListener(this);
        mBinding.btnDetailsCheckTuijianweixiuchang.setOnClickListener(this);

        mAdapter = new CommonRecyclerViewAdapter<DetailsCheckItemLayoutBinding, CheckDetailsAllBean.ProblemListBean>(this, R.layout.details_check_item_layout) {
            @Override
            public void bindData(DetailsCheckItemLayoutBinding binding, final int position) {
                binding.cbDetailsCheck.setText(mData.get(position).getProblemName());
                if (mData.get(position).getVoiceList() == null || mData.get(position).getVoiceList().size() == 0) {
                    binding.btnDetailsCheckItemPlay.setVisibility(View.GONE);
                } else {
                    binding.btnDetailsCheckItemPlay.setVisibility(View.VISIBLE);
                    binding.btnDetailsCheckItemPlay.setOnClickListener(DetailsCheckActivity.this);
                    binding.btnDetailsCheckItemPlay.setTag(R.id.position_tag, position);
                }
                binding.cbDetailsCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        mData.get(position).setChecked(isChecked);
                    }
                });
            }
        };
        mBinding.rlvDetailsCheck.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.rlvDetailsCheck.setAdapter(mAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_title_back:
                finishPager();
                break;
            case R.id.btn_details_check_submit:
                submitProblem();
                break;
            case R.id.btn_details_check_tuijianweixiuchang:
                toRecommendFactory();
                break;
            case R.id.btn_details_check_item_play:
                //跳转到播放声音异响的页面
                toPlayMusicActivity((Integer) v.getTag(R.id.position_tag));
                break;
        }
    }

    //提交问题到后台
    private void submitProblem() {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        List<CheckDetailsAllBean.ProblemListBean> list = mAdapter.getData();
        StringBuffer buffer = new StringBuffer();
        for (CheckDetailsAllBean.ProblemListBean bean : list) {
            if (bean.isChecked()) {
                buffer.append(bean.getId() + ",");
            }
        }

        if (CommonUtils.isEmpty(buffer.toString()) && CommonUtils.isEmpty(mBinding.etDetailsCheck.getText().toString())) {
            showToast("请至少选择一项或者填入您遇到的问题");
            return;
        }
        String substring = null;
        if (!CommonUtils.isEmpty(buffer.toString())) {
            substring = buffer.toString().substring(0, buffer.toString().length() - 1);
            mIntent.putExtra(Constants.INTENT_SHOW_PROBLEM_SUBSTRING, substring);
        }
        if (!CommonUtils.isEmpty(mBinding.etDetailsCheck.getText().toString())) {
            mIntent.putExtra(Constants.INTENT_SHOW_PROBLEM_CUSTOM, mBinding.etDetailsCheck.getText().toString() + "");
        }
        CommonUtils.toOtherActivity(this, ShowProblemsActivity.class, mIntent);
        finishPager();
    }

    //跳转到推荐汽修厂的页面
    private void toRecommendFactory() {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.putExtra(Constants.INTENT_SHOW_RECOMMEND, true);
        CommonUtils.toOtherActivity(this, MapviewActivity.class, mIntent);
        finishPager();
    }

    //跳转到播放声音异响的页面
    private void toPlayMusicActivity(int position) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.putExtra(Constants.INTENT_DETAILS_CHECK_ALL, mBean.getProblemList().get(position));
        CommonUtils.toOtherActivity(this, MusicePlayActivity.class, mIntent);
    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(DetailsCheckActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updatePagers() {
        mAdapter.refresh(mBean.getProblemList());
    }

    @Override
    public void showIOSLoading() {
        mIOSLoading = CommonUtils.showIOSLoadingDialog(this);
    }

    @Override
    public void dismissIOSLoading() {
        if (mIOSLoading != null && mIOSLoading.isShowing()) {
            mIOSLoading.dismiss();
        }
    }

    @Override
    public void setBean(CheckDetailsAllBean data) {
        mBean = data;
        updatePagers();
    }

}
