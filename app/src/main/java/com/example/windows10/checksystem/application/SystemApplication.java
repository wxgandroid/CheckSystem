package com.example.windows10.checksystem.application;

import android.app.Application;
import android.util.Log;

import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.rx_retrofit_library.CommonUtils;

/**
 * Created by Windows10 on 2017/2/23.
 */
public class SystemApplication extends Application {
    //当前用户的id号，当id为-1时证明用户还没有进行登录
    public static int USER_ID = -1;
    //记录当前用户的车辆型号
    public static int USER_BRAND_ID = -1;

    private String BASE_VIDEO_URL;
    private String BASE_PIC_URL;
    private String BASE_AUDIO_URL;
    public static double CHECK_TIMES;
    public static double CHECK_FREQUENTS;
    public static SystemApplication instance;

    public static String[] checkCodes;

    //记录蓝牙打开或者是连接的变量
    public static int BLUETOOTH_STATUS = -1;
    public static int BLUETOOTH_CONNECT_TIMES = 0;


    public static SystemApplication getInstance() {
        return instance;
    }


    public String getBASE_VIDEO_URL() {
        return BASE_VIDEO_URL;
    }

    public void setBASE_VIDEO_URL(String BASE_VIDEO_URL) {
        this.BASE_VIDEO_URL = BASE_VIDEO_URL;
    }

    public String getBASE_PIC_URL() {
        return BASE_PIC_URL;
    }

    public void setBASE_PIC_URL(String BASE_PIC_URL) {
        this.BASE_PIC_URL = BASE_PIC_URL;
    }

    public String getBASE_AUDIO_URL() {
        return BASE_AUDIO_URL;
    }

    public void setBASE_AUDIO_URL(String BASE_AUDIO_URL) {
        this.BASE_AUDIO_URL = BASE_AUDIO_URL;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //初始化IP地址
        initIPConfig();
    }

    //初始化IP地址
    public void initIPConfig() {
        String value = CommonUtils.getStringExtras(this, Constants.IP_CONFIG);
        Log.e("TAG", value);
        if (CommonUtils.isEmpty(value)) {
            Constants.BASE_URL = Constants.DEFAULT_URL + Constants.DEFAULT_IP + ":" + Constants.DEFAULT_PORT + "/admin/";
        } else {
            Constants.BASE_URL = value;
        }
    }


}
