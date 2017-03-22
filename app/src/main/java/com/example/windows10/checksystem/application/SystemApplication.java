package com.example.windows10.checksystem.application;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.example.windows10.checksystem.bean.SystemConfigBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.rx_retrofit_library.CommonUtils;
import com.example.windows10.rx_retrofit_library.RxUtils;

/**
 * Created by Windows10 on 2017/2/23.
 */
public class SystemApplication extends Application implements RxUtils.LoadingNetDataListener<SystemConfigBean> {
    //当前用户的id号，当id为-1时证明用户还没有进行登录
    public static int USER_ID = -1;
    //记录当前用户的车辆型号
    public static int USER_BRAND_ID = -1;

    public static String BASE_VIDEO_URL;
    public static String BASE_PIC_URL;
    public static String BASE_AUDIO_URL;
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

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //初始化IP地址
        initIPConfig();
        //程序启动时，初始化系统配置
        initSystemConfig();
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

    //请求系统配置的接口
    private void initSystemConfig() {
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_SYSTEM_CONFIG, null, this, SystemConfigBean.class);
    }

    @Override
    public void onSuccess(SystemConfigBean data) {
        BASE_VIDEO_URL = data.getSystem().getVideoPath();
        BASE_AUDIO_URL = data.getSystem().getAudioPath();
        BASE_PIC_URL = data.getSystem().getPicturePath();
        CHECK_TIMES = data.getSystem().getInspection_time();
        CHECK_FREQUENTS = data.getSystem().getInspection_frequency();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(SystemApplication.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete() {
    }


}
