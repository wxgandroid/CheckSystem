package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.adapter.GuzhangBrandListAdapter;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.LingJianDetailsBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.ActivityGuZhangDetailsBinding;
import com.example.windows10.checksystem.databinding.GuzhangBrandListLayoutBinding;
import com.example.windows10.checksystem.presenter.GuZhangPresenter;
import com.example.windows10.checksystem.view.GuZhangView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

public class GuZhangDetailsActivity extends BaseActivity implements GuZhangView, View.OnClickListener {

    private ActivityGuZhangDetailsBinding mBinding;
    private String partID;
    private GuZhangPresenter mPresenter;
    private LingJianDetailsBean.SparePartsBean parts;
    private IOSLoadingDialog mIosLoading;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_gu_zhang_details);
        mPresenter = new GuZhangPresenter(this);
        mIntent = getIntent();
        partID = mIntent.getStringExtra(Constants.INTENT_PARTS_ID);
        initView();
        mPresenter.loadData(partID);
    }

    //初始化控件的方法
    private void initView() {
        mBinding.tvGuzhangDetailsPinpai.setOnClickListener(this);
        mBinding.getRoot().setOnClickListener(this);

    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(GuZhangDetailsActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateUI(LingJianDetailsBean.SparePartsBean bean) {
        Log.e("TAG", "图片地址为：" + SystemApplication.BASE_PIC_URL + bean.getPartPicture());
        Glide.with(this).load(SystemApplication.BASE_PIC_URL + bean.getPartPicture()).into(mBinding.ivGuzhangDetailsPic);
        mBinding.tvGuzhangDetailsXinghao.setText(String.format(getString(R.string.lingjian_xinghao), bean.getModel()));
        mBinding.tvGuzhangDetailsGuige.setText(String.format(getString(R.string.lingjian_guige), bean.getSpecifications()));
        mBinding.tvGuzhangDetailsYuanchangPriceTime.setText(String.format(getString(R.string.yuanchang_price), bean.getPrice(), bean.getGuaranteeDate()));
        mBinding.tvGuzhangDetailsPinpai.setText(String.format(getString(R.string.pinpai_name), bean.getBrandName(), bean.getPrice(), bean.getGuaranteeDate()));
        mBinding.tvGuzhangDetailsShougongfei.setText(String.format(getString(R.string.shougongfei), bean.getManualPrice()));
        double totalPrice = bean.getPrice() + bean.getManualPrice();
        mBinding.tvGuzhangDetailsTuijianPrice.setText(String.format(getString(R.string.tuijiancankaojia), totalPrice + ""));
        mBinding.tvGuzhangDetailsPinpaiPrice.setText(String.format(getString(R.string.pinpailingjian), bean.getPrice() + ""));
        mBinding.tvGuzhangDetailsWeixiuShichang.setText(bean.getBtx1());
    }

    public void updateUI(LingJianDetailsBean.SparePartsBean.SparePartsListBean bean) {
        dismissPopupWindow();
        Log.e("TAG", "图片地址为：" + SystemApplication.BASE_PIC_URL + bean.getPartPicture());
        Glide.with(this).load(SystemApplication.BASE_PIC_URL + bean.getPartPicture()).into(mBinding.ivGuzhangDetailsPic);
        mBinding.tvGuzhangDetailsXinghao.setText(String.format(getString(R.string.lingjian_xinghao), bean.getModel()));
        mBinding.tvGuzhangDetailsGuige.setText(String.format(getString(R.string.lingjian_guige), bean.getSpecifications()));
        mBinding.tvGuzhangDetailsYuanchangPriceTime.setText(String.format(getString(R.string.yuanchang_price), bean.getPrice(), bean.getGuaranteeDate()));
        mBinding.tvGuzhangDetailsPinpai.setText(String.format(getString(R.string.pinpai_name), bean.getBrandName(), bean.getPrice(), bean.getGuaranteeDate()));
        mBinding.tvGuzhangDetailsShougongfei.setText(String.format(getString(R.string.shougongfei), bean.getManualPrice()));
        double totalPrice = bean.getPrice() + bean.getManualPrice();
        mBinding.tvGuzhangDetailsTuijianPrice.setText(String.format(getString(R.string.tuijiancankaojia), totalPrice + ""));
        mBinding.tvGuzhangDetailsPinpaiPrice.setText(String.format(getString(R.string.pinpailingjian), bean.getPrice() + ""));
        mBinding.tvGuzhangDetailsWeixiuShichang.setText(bean.getBtx1());
    }

    @Override
    public void showIOSLoading() {
        mIosLoading = CommonUtils.showIOSLoadingDialog(this);
    }

    @Override
    public void dismissIOSLoading() {
        if (mIosLoading != null) {
            mIosLoading.dismiss();
        }
    }

    @Override
    public void setData(LingJianDetailsBean data) {
        parts = data.getSpareParts();
        updateUI(parts);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_guzhang_details_pinpai:
                //点击了品牌，展示下拉菜单
                showPinpaiList(v);
                break;
            default:
                dismissPopupWindow();
                break;
        }
    }


    //显示品牌列表
    private void showPinpaiList(View v) {
        if (popupWindow != null && popupWindow.isShowing()) {
            return;
        }
        popupWindow = new PopupWindow(this);
        View inflate = LayoutInflater.from(this).inflate(R.layout.guzhang_brand_list_layout, null);
        GuzhangBrandListLayoutBinding binding = DataBindingUtil.bind(inflate);
        binding.rlvGuzhangBrandlist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        GuzhangBrandListAdapter adapter = new GuzhangBrandListAdapter(this);
        binding.rlvGuzhangBrandlist.setAdapter(adapter);
        adapter.refresh(parts.getSparePartsList());
        popupWindow.setContentView(inflate);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.showAsDropDown(v);
    }

    public void dismissPopupWindow() {
        if (popupWindow != null && popupWindow.isShowing())
            popupWindow.dismiss();
    }

}
