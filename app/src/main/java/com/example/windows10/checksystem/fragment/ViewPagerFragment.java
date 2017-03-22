package com.example.windows10.checksystem.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.bean.ParseCheckResultBean;
import com.example.windows10.checksystem.databinding.ViewPagerLayoutBinding;

/**
 * Created by Windows10 on 2017/3/15.
 */
public class ViewPagerFragment extends Fragment {

    private ViewPagerLayoutBinding mBinding;
    private ParseCheckResultBean mBean;

    private ViewPagerFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("TAG", "ViewPagerFragment:OnCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("TAG", "ViewPagerFragment:OnCreateView");
        mBinding = DataBindingUtil.inflate(inflater, R.layout.view_pager_layout, container, false);
        return mBinding.getRoot();
    }

    public static ViewPagerFragment instance() {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        return viewPagerFragment;
    }

    public void loadData(ParseCheckResultBean bean) {
        mBean = bean;

    }
}
