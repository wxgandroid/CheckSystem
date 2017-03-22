package com.example.windows10.checksystem.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.windows10.checksystem.view.CheckView;

/**
 * Created by Windows10 on 2017/2/27.
 */
public class BaseFragment extends Fragment {

    public Context mContext;
    public CheckView mCallback;

    //加载数据
    public void loadData() {

    }

    //根据传入的class类型返回相应的BaseFragment的子类
    public static <T extends BaseFragment> T instance(Context context, Class<T> tClass) {
        T t = null;
        try {
            t = tClass.newInstance();
            t.mContext = context;
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    public void setCallBack(CheckView callBack) {
        mCallback = callBack;
    }

    public void updatePagers(Object obj){

    }
}
