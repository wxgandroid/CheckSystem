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
import com.example.windows10.checksystem.databinding.ActivityLingjianDetailsBinding;
import com.example.windows10.checksystem.databinding.GuzhangBrandListLayoutBinding;
import com.example.windows10.checksystem.presenter.LingjianDetailsPresenter;
import com.example.windows10.checksystem.view.LingjianDetailsView;

/**
 * 零件的详细信息界面，包括自修指导等功能
 */

public class LingjianDetailsActivity extends BaseActivity implements View.OnClickListener, LingjianDetailsView {

    private ActivityLingjianDetailsBinding mBinding;
    private LingjianDetailsPresenter mPresenter;
    private String lingjianID;
    private PopupWindow popupWindow;
    private LingJianDetailsBean.SparePartsBean parts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lingjian_details);
        mPresenter = new LingjianDetailsPresenter(this);
        mIntent = getIntent();
        lingjianID = mIntent.getStringExtra(Constants.INTENT_KEY_LINGJIAN_ID) + "";
        Log.e("TAG", "lingjianID的值为：" + lingjianID);
        //初始化控件的点击事件
        initListener();
        mPresenter.loadData(lingjianID);

    }

    private void initListener() {
        mBinding.includeZixiu.tvZixiuZhidao.setOnClickListener(this);
        mBinding.includeZixiu.tvLingjianZuoyong.setOnClickListener(this);
        mBinding.includeZixiu.tvTuijianQixiu.setOnClickListener(this);
        mBinding.includeZixiu.tvOtherQixiu.setOnClickListener(this);
        mBinding.tvLingjianDetailsPinpai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPresenter.onClick(v);
    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(LingjianDetailsActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateUI(LingJianDetailsBean.SparePartsBean bean) {
        Glide.with(this).load(SystemApplication.getInstance().getBASE_PIC_URL() + bean.getPartPicture()).into(mBinding.ivLingjianDetailsPic);
        //型号
        mBinding.tvLingjianDetailsXinghao.setText(String.format(getString(R.string.lingjian_xinghao), bean.getModel()));
        //规格
        mBinding.tvLingjianDetailsGuige.setText(String.format(getString(R.string.lingjian_guige), bean.getSpecifications()));
        //原厂价格
        mBinding.tvLingjianDetailsYuanchangPriceTime.setText(String.format(getString(R.string.pinpai_name), bean.getBrandName(), bean.getPrice(), bean.getGuaranteeDate()));
        //品牌价格
        mBinding.tvLingjianDetailsPinpai.setText(String.format(getString(R.string.pinpai_name), bean.getBrandName(), bean.getPrice(), bean.getGuaranteeDate()));
        //维修时长
        mBinding.tvLingjianDetailsWeixiuShichang.setText(String.format(getString(R.string.yuji_gonshi), bean.getBtx1(), bean.getGuaranteeDate()));
        //手工费
        mBinding.tvLingjianDetailsShougongfei.setText(String.format(getString(R.string.lingjian_shougongfei), bean.getPrice()));
    }

    //显示品牌列表
    public void showPinpaiList(View v) {
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

    public void updateUI(LingJianDetailsBean.SparePartsBean.SparePartsListBean bean) {
        dismissPopupWindow();
        Log.e("TAG", "图片地址为：" + SystemApplication.getInstance().getBASE_PIC_URL() + bean.getPartPicture());
        Glide.with(this).load(SystemApplication.getInstance().getBASE_PIC_URL() + bean.getPartPicture()).into(mBinding.ivLingjianDetailsPic);
        //型号
        mBinding.tvLingjianDetailsXinghao.setText(String.format(getString(R.string.lingjian_xinghao), bean.getModel()));
        //规格
        mBinding.tvLingjianDetailsGuige.setText(String.format(getString(R.string.lingjian_guige), bean.getSpecifications()));
        //品牌价格
        mBinding.tvLingjianDetailsPinpai.setText(String.format(getString(R.string.pinpai_name), bean.getBrandName(), bean.getPrice(), bean.getGuaranteeDate()));
        //维修时长
        mBinding.tvLingjianDetailsWeixiuShichang.setText(String.format(getString(R.string.yuji_gonshi), bean.getBtx1(), bean.getGuaranteeDate()));
        //手工费
        mBinding.tvLingjianDetailsShougongfei.setText(String.format(getString(R.string.lingjian_shougongfei), bean.getPrice()));
    }

    public void dismissPopupWindow() {
        if (popupWindow != null && popupWindow.isShowing())
            popupWindow.dismiss();
    }

    @Override
    public void setData(LingJianDetailsBean data) {
        parts = data.getSpareParts();
        updateUI(parts);
    }
}
