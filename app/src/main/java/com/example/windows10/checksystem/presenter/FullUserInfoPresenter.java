package com.example.windows10.checksystem.presenter;

import com.example.windows10.checksystem.bean.BrandIdBean;
import com.example.windows10.checksystem.bean.CarModelsBean;
import com.example.windows10.checksystem.bean.RegistBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.view.FullUserInfoView;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;

import java.util.HashMap;

/**
 * Created by Windows10 on 2017/2/24.
 */
public class FullUserInfoPresenter extends BasePresenter implements RxUtils.LoadingNetDataListener<RegistBean> {

    private FullUserInfoView mView;

    public FullUserInfoPresenter(FullUserInfoView view) {
        mView = view;
    }


    public void choiceSex() {
        mView.showChoiceSexWindow();
    }

    public void choiceBirth() {
        mView.showChoiceBirthWindow();
    }

    public void choiceColor() {
        mView.showChoiceColorWindow();
    }

    //将填写的资料提交到服务器
    public void fullUserInfo(String userName, String password, String age, String character
            , int sex, String phoneNum, String hobby, String address, String bluetooth
            , String brand_id, String models_id, String years, String color
            , String mileage, String carNum) {

        if (CommonUtils.isEmpty(userName)) {
            mView.showToast("用户名不能为空");
            return;
        }
        if (CommonUtils.isEmpty(password)) {
            mView.showToast("密码不能为空");
            return;
        }
        if (CommonUtils.isEmpty(phoneNum)) {
            mView.showToast("电话号码不能为空");
            return;
        }


        //创建一个map，并将参数传入map中
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.USERINFO_NAME, userName);
        params.put(Constants.USERINFO_PASSWORD, password);

        String str = "0";
        switch (age) {
            case "青年":
                str = "1";
                break;
            case "中年":
                str = "2";
                break;
            case "老年":
                str = "3";
                break;
        }

        params.put(Constants.USERINFO_AGE, str);
        params.put(Constants.USERINFO_CHARACTERS, character);
        params.put(Constants.USERINFO_SEX, sex + "");
        params.put(Constants.USERINFO_PHONE, phoneNum);
        params.put(Constants.USERINFO_HOBBY, hobby);
        params.put(Constants.USERINFO_ADDRESS, address);
        params.put(Constants.USERINFO_BLUETOOTH, bluetooth);
        params.put(Constants.USERINFO_BRANDID, brand_id);
        params.put(Constants.USERINFO_MODELSID, models_id);
        params.put(Constants.USERINFO_YEARS, years);
        params.put(Constants.USERINFO_COLOR, color);
        params.put(Constants.USERINFO_MILEAGE, mileage);
        params.put(Constants.USERINFO_CARNUMBER, carNum);

        //进行联网请求
        mView.showLoading();
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_REGIST, params, this, RegistBean.class);
    }

    @Override
    public void onSuccess(RegistBean data) {
        mView.dismissLoading();
        if (data != null) {
            if ("注册成功".equals(data.getMessage().getMsg())) {
                //注册成功,弹出吐司提示
                mView.showToast("注册成功");
                mView.finishPager();
            } else {
                //联网成功，注册失败
                mView.showToast(data.getMessage().getMsg());
            }
        }
    }

    @Override
    public void onError(String msg) {
        mView.dismissLoading();
        mView.showToast("联网错误," + msg);
    }

    @Override
    public void onComplete() {
        mView.dismissLoading();
    }

    public void choiceAge() {
        mView.showChoiceAgeWindow();
    }

    //显示汽车的品牌
    public void showCarBrand() {
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_ALL_MODELS, null, new RxUtils.LoadingNetDataListener<CarModelsBean>() {
            @Override
            public void onSuccess(CarModelsBean data) {
                mView.showChoiceCarBrand(data);
            }

            @Override
            public void onError(String msg) {

            }

            @Override
            public void onComplete() {

            }
        }, CarModelsBean.class);

    }

    //显示车辆型号
    public void showCarId(int modelsID) {

        HashMap<String, String> map = new HashMap<>();
        map.put(Constants.BRAND_ID, modelsID + "");

        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_ALL_BRAND, map, new RxUtils.LoadingNetDataListener<BrandIdBean>() {
            @Override
            public void onSuccess(BrandIdBean data) {
                mView.showchoiceCarId(data);
            }

            @Override
            public void onError(String msg) {

            }

            @Override
            public void onComplete() {

            }
        }, BrandIdBean.class);

    }

}
