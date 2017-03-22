package com.example.windows10.checksystem.view;

import com.example.windows10.checksystem.bean.BrandIdBean;
import com.example.windows10.checksystem.bean.CarModelsBean;

/**
 * Created by Windows10 on 2017/2/24.
 */
public interface FullUserInfoView extends BaseView{

    void showChoiceSexWindow();

    void showChoiceBirthWindow();

    void showChoiceColorWindow();

    void showLoading();

    void dismissLoading();

    void showToast(String msg);

    void showChoiceAgeWindow();

    void showChoiceCarBrand(CarModelsBean data);

    void showchoiceCarId(BrandIdBean data);
}
