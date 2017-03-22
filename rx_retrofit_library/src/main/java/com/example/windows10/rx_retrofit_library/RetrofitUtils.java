package com.example.windows10.rx_retrofit_library;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by Windows10 on 2017/2/17.
 */
public class RetrofitUtils {

    static RetrofitUtils instance = new RetrofitUtils();
    public static Retrofit retrofit;
    private NetWork mNetWork;
    private OkHttpClient client;
    //连接的超时时间默认为15s
    private int times = 15;

    //单例模式创建一个对象
    private RetrofitUtils() {

    }

    public static RetrofitUtils getInstance() {
        return instance;
    }

    public Observable<String> get(String baseUrl, String interfaceName, Map<String, String> params) {
        if (CommonUtils.isEmpty(baseUrl)) {
            throw new RuntimeException("baseUrl不能为空");
        }
        String url = CommonUtils.getUrl(baseUrl);
        initNetWork(url);
        if (params == null || params.isEmpty()) {
            Log.e("TAG", "网络请求的连接为：" + url + interfaceName);
            return mNetWork.get(url + interfaceName);
        } else {
            return mNetWork.get(url + interfaceName, params);
        }
    }

    public Observable<String> post(String baseUrl, String interfaceName, Map<String, String> params) {
        if (CommonUtils.isEmpty(baseUrl)) {
            throw new RuntimeException("baseUrl不能为空");
        }
        String url = CommonUtils.getUrl(baseUrl);
        initNetWork(baseUrl);
        Log.e("TAG", "网络请求的链接为：" + url);
        if (params == null || params.isEmpty()) {
            return mNetWork.post(url + interfaceName);
        } else {
            return mNetWork.post(url + interfaceName, params);
        }
    }


    //初始化NetWork
    private void initNetWork(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(getOkHttp(this.times))
                    //添加Rxjava的支持
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //添加FastJson的支持
                    .addConverterFactory(FastJsonConverterFactory.create())
                    //添加字符串的支持
                    .addConverterFactory(StringConverterFactory.create())
                    .build();
        }
        if (mNetWork == null) {
            mNetWork = retrofit.create(NetWork.class);
        }
    }

    private OkHttpClient getOkHttp(int times) {
        if (client == null) {
            client = new OkHttpClient.Builder()
                    //设置断线重连
                    .retryOnConnectionFailure(true)
                    //设置超时时间
                    .connectTimeout(times, TimeUnit.SECONDS)
                    .build();
        }
        return client;
    }

    //设置超时时间
    public void setTimeout(int times) {
        this.times = times;
    }


}
