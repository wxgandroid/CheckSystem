package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.databinding.ActivityIpregistBinding;
import com.example.windows10.checksystem.presenter.IPRegistPresenter;
import com.example.windows10.checksystem.view.IPRegistView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

public class IPRegistActivity extends BaseActivity implements View.OnClickListener, IPRegistView {

    IPRegistPresenter mPresenter;
    private ActivityIpregistBinding mBinding;
    private IOSLoadingDialog mIOSLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_ipregist);
        mPresenter = new IPRegistPresenter(this);
        mPresenter.initIPConfig();
        mBinding.btnIpRegist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ip_regist:
                //提交ip地址以及端口号
                mPresenter.submitIP(this, mBinding.etIpRegistIp.getText().toString(), mBinding.etIpRegistDuankou.getText().toString());
                break;
        }

    }

    //显示Toast提示用户信息
    @Override
    public void showToast(String msg) {
        Toast.makeText(IPRegistActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    //结束当前页面
    @Override
    public void finishPager() {
        finish();
    }


    @Override
    public void updatePagers(String ip, String port) {
        mBinding.etIpRegistIp.setText(ip);
        mBinding.etIpRegistDuankou.setText(port);
    }

    @Override
    public void showIOSLoading() {
        mIOSLoading = CommonUtils.showIOSLoadingDialog(this);
    }

    @Override
    public void dismissIOSLoading() {
        if (mIOSLoading != null) {
            mIOSLoading.dismiss();
        }
    }
}
