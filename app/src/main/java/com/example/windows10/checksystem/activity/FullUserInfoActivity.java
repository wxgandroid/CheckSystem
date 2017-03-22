package com.example.windows10.checksystem.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.adapter.ChoiceCarIDAdapter;
import com.example.windows10.checksystem.adapter.CommonRecyclerViewAdapter;
import com.example.windows10.checksystem.bean.BrandIdBean;
import com.example.windows10.checksystem.bean.CarModelsBean;
import com.example.windows10.checksystem.databinding.ActivityFullUserInfoBinding;
import com.example.windows10.checksystem.databinding.ChoiceCarsBrandListLayoutBinding;
import com.example.windows10.checksystem.databinding.ChoiceSexLayoutBinding;
import com.example.windows10.checksystem.presenter.FullUserInfoPresenter;
import com.example.windows10.checksystem.view.FullUserInfoView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.view.IOSLoadingDialog;

/**
 * 注册页面（填充数据并进行注册）
 */

public class FullUserInfoActivity extends BaseActivity implements FullUserInfoView, View.OnClickListener {
    public FullUserInfoPresenter mPresenter;
    private ActivityFullUserInfoBinding mBinding;
    private PopupWindow mPopupWindow;
    private View choiceSexView;
    private ChoiceSexLayoutBinding choiceSexBinding;
    private IOSLoadingDialog mIosLoading;
    //用户名
    private String mUserName;
    //用户密码
    private String mUserPassword;
    //用户年龄
    private String mUserAge;
    //用户的性格
    private String mUserCharacters;
    //用户的手机号码
    private String mUserPhoneNum;
    //用户的业余爱好
    private String mUserHobby;
    //用户的当前地址
    private String mUserAddress = "北京";
    //用户的性别
    private int mUserSex;
    //用户的蓝牙
    private String mUserBluetooth = "LY0001";
    //用户的汽车品牌
    private String mUserBrandId = "1";
    //用户的汽车品牌的型号
    private String mUserModelId = "1";
    //用户的汽车年限
    private String mUserCarYears = "10";
    //用户的汽车的颜色
    private String mUserCarColor = "白色";
    //用户的汽车的行驶距离
    private String mUserCarDistance = "2000";
    //用户的车牌号
    private String mUserCarNum = "GB110";
    private String mUserCarColor1;

    private int modelsID = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_full_user_info);
        mPresenter = new FullUserInfoPresenter(this);
        mBinding.includeFullUserinfo.tvTitleTitle.setText(getString(R.string.full_userinfo_title));
        mBinding.includeFullUserinfo.ivTitleList.setVisibility(View.GONE);
        initListener();
    }

    //初始化控件监听
    private void initListener() {
        mBinding.includeFullUserinfo.ivTitleBack.setOnClickListener(this);
        mBinding.tvFullUserinfoSex.setOnClickListener(this);
        mBinding.tvFullUserinfoColor.setOnClickListener(this);
        mBinding.btnFullUserinfo.setOnClickListener(this);
        mBinding.tvFullUserinfoAge.setOnClickListener(this);
        mBinding.tvFullUserinfoCarbrand.setOnClickListener(this);
        mBinding.tvFullUserinfoCarId.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_full_userinfo_sex:
                //选择性别
                dismissPopupwindow();
                mPresenter.choiceSex();
                break;
//            case R.id.tv_full_userinfo_birth:
//                //选择生日
//                mPresenter.choiceBirth();
//                break;
            case R.id.tv_full_userinfo_color:
                //选择颜色
                dismissPopupwindow();
                mPresenter.choiceColor();
                break;
            case R.id.btn_full_userinfo:
                //将个人资料提交到服务器
                dismissPopupwindow();
                initUserInfo();
                mPresenter.fullUserInfo(mUserName, mUserPassword, mUserAge, mUserCharacters,
                        mUserSex, mUserPhoneNum, mUserHobby, mUserAddress, mUserBluetooth,
                        mUserBrandId, mUserModelId, mUserCarYears, mUserCarColor,
                        mUserCarDistance, mUserCarNum);
                break;
            case R.id.tv_choice_sex_male:
                //选择为男性
                mBinding.tvFullUserinfoSex.setText("男");
                dismissPopupwindow();
                break;
            case R.id.tv_choice_sex_female:
                //选择为女性
                mBinding.tvFullUserinfoSex.setText("女");
                dismissPopupwindow();
                break;
            case R.id.fl_choice_sex:
            case R.id.tv_choice_sex_cancel:
            case R.id.btn_choice_birth_cancel:
                //取消popupWindow的显示
                dismissPopupwindow();
                break;
//            case R.id.btn_choice_birth_submit:
//                //选择了出生日期
//                mBinding.tvFullUserinfoBirth.setText(CommonUtils.getBirthDay());
//                mPopupWindow.dismiss();
//                break;
            case R.id.tv_choice_color_black:
                mBinding.tvFullUserinfoColor.setText("黑色");
                dismissPopupwindow();
                break;
            case R.id.tv_choice_color_white:
                mBinding.tvFullUserinfoColor.setText("白色");
                dismissPopupwindow();
                break;
            case R.id.tv_choice_color_red:
                mBinding.tvFullUserinfoColor.setText("红色");
                dismissPopupwindow();
                break;
            case R.id.tv_choice_color_yellow:
                mBinding.tvFullUserinfoColor.setText("黄色");
                dismissPopupwindow();
                break;
            case R.id.tv_choice_color_cancel:
                dismissPopupwindow();
                break;
            case R.id.tv_full_userinfo_age:
                dismissPopupwindow();
                mPresenter.choiceAge();
                break;
            case R.id.tv_choice_young:
                dismissPopupwindow();
                mBinding.tvFullUserinfoAge.setText("青年");
                break;
            case R.id.tv_choice_zhongnian:
                dismissPopupwindow();
                mBinding.tvFullUserinfoAge.setText("中年");
                break;
            case R.id.tv_choice_old:
                dismissPopupwindow();
                mBinding.tvFullUserinfoAge.setText("老年");
                break;
            case R.id.tv_choice_old_cancel:
                dismissPopupwindow();
                break;
            case R.id.iv_title_back:
                dismissPopupwindow();
                finishPager();
                break;
            case R.id.tv_full_userinfo_carbrand:
                //选择了汽车品牌按钮
                dismissPopupwindow();
                mPresenter.showCarBrand();
                break;
            case R.id.tv_full_userinfo_car_id:
                //选择汽车型号
                if (modelsID == -1) {
                    return;
                }
                dismissPopupwindow();
                mPresenter.showCarId(modelsID);
                break;
        }
    }

    //从edittext中取出数据并给变量进行赋值
    private void initUserInfo() {
        mUserName = mBinding.etFullUserinfoName.getText().toString();
        mUserPassword = mBinding.etFullUserinfoPassword.getText().toString();
        mUserAge = mBinding.tvFullUserinfoAge.getText().toString();
        mUserCharacters = mBinding.etFullUserinfoXingge.getText().toString();
        mUserPhoneNum = mBinding.etFullUserinfoPhoneNum.getText().toString();
        mUserHobby = mBinding.etFullUserinfoHobby.getText().toString();
        //用户的地址
        mUserAddress = mBinding.etFullUserinfoAddress.getText().toString();
        mUserSex = "男".equals(mBinding.tvFullUserinfoSex.getText()) ? 1 : 2;
        //用户的蓝牙
        //private String mUserBluetooth;
        //用户的汽车品牌
//        mUserBrandId = mBinding.tvFullUserinfoCarId.getText().toString();
//        //用户的汽车品牌的型号
//        mUserModelId = mBinding.tvFullUserinfoCarbrand.getText().toString();
        //用户的汽车年限
        mUserCarYears = mBinding.etFullUserinfoCarDate.getText().toString();
        //用户的汽车的颜色
        mUserCarColor = mBinding.tvFullUserinfoColor.getText().toString();
        //用户的汽车的行驶距离
        mUserCarDistance = mBinding.etFullUserinfoCarDistance.getText().toString();
        //用户的车牌号
        //private String mUserCarNum;
    }


    //显示选择性别的弹框
    @Override
    public void showChoiceSexWindow() {
        int[] ress = {R.id.tv_choice_sex_male, R.id.tv_choice_sex_female, R.id.tv_choice_sex_cancel, R.id.fl_choice_sex};
        mPopupWindow = CommonUtils.showPopupWindow(this, R.layout.choice_sex_layout, this, ress, 0, 0);
    }

    @Override
    public void showChoiceBirthWindow() {
        View inflate = View.inflate(this, R.layout.choice_birth_layout, null);
        FrameLayout fl_choice_birth = (FrameLayout) inflate.findViewById(R.id.fl_choice_birth);
        fl_choice_birth.addView(CommonUtils.getDatePicker(this));
        int[] ress = {R.id.space_choice_birth, R.id.btn_choice_birth_cancel, R.id.btn_choice_birth_submit};
        mPopupWindow = CommonUtils.showPopupWindow(this, inflate, this, ress, 0, 0);
    }

    @Override
    public void showChoiceColorWindow() {
        int[] ress = {R.id.tv_choice_color_black, R.id.tv_choice_color_red, R.id.tv_choice_color_white, R.id.tv_choice_color_yellow};
        mPopupWindow = CommonUtils.showPopupWindow(this, R.layout.choice_color_layout, this, ress, 0, 0);
    }

    @Override
    public void showLoading() {
        mIosLoading = CommonUtils.showIOSLoadingDialog(this);
    }

    @Override
    public void dismissLoading() {
        mIosLoading.dismiss();
    }

    public void dismissPopupwindow() {
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        }
    }

    @Override
    public void finishPager() {
        finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(FullUserInfoActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showChoiceAgeWindow() {
        int[] ress = {R.id.tv_choice_young, R.id.tv_choice_zhongnian, R.id.tv_choice_old, R.id.tv_choice_old_cancel};
        mPopupWindow = CommonUtils.showPopupWindow(this, R.layout.choice_old_layout, this, ress, 0, 0);
    }

    @Override
    public void showChoiceCarBrand(final CarModelsBean data) {
        mPopupWindow = new PopupWindow();
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        ChoiceCarBrandAdapter adapter = new ChoiceCarBrandAdapter(this, data.getModelList());
        CommonRecyclerViewAdapter<ChoiceCarsBrandListLayoutBinding, CarModelsBean.ModelListBean> adapter
                = new CommonRecyclerViewAdapter<ChoiceCarsBrandListLayoutBinding, CarModelsBean.ModelListBean>(this, R.layout.choice_cars_brand_list_layout) {
            @Override
            public void bindData(ChoiceCarsBrandListLayoutBinding binding, final int position) {
                Log.e("TAG", "bindData");
                binding.tvChoiceCarBrand.setText(mData.get(position).getModels());
                binding.tvChoiceCarBrand.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setCarsBrand(mData.get(position).getModels() + "", mData.get(position).getId());
                    }
                });
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.refresh(data.getModelList());
        mPopupWindow.setContentView(recyclerView);
        mPopupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.showAsDropDown(mBinding.tvFullUserinfoCarbrand);
    }

    @Override
    public void showchoiceCarId(BrandIdBean data) {
        mPopupWindow = new PopupWindow();
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ChoiceCarIDAdapter adapter = new ChoiceCarIDAdapter(this, data.getBrandList());
        recyclerView.setAdapter(adapter);
        mPopupWindow.setContentView(recyclerView);
        mPopupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.showAsDropDown(mBinding.tvFullUserinfoCarId);

    }

    @Override
    public void onBackPressed() {
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
            return;
        }
        super.onBackPressed();
    }

    public void setCarsBrand(String models, int id) {
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
        }
        mBinding.tvFullUserinfoCarbrand.setText(models);
        mBinding.tvFullUserinfoCarId.setText("");
        modelsID = id;
        mUserModelId = id + "";
    }

    public void setCarsID(String models, int id) {
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
        }
        mBinding.tvFullUserinfoCarId.setText(models);
        modelsID = id;
        mUserBrandId = id + "";
    }


}
