package com.example.windows10.checksystem.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 *
 */
public class PossibleDestroyListPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<View> mData = new ArrayList<>();

    public PossibleDestroyListPagerAdapter(Context context) {
        mContext = context;
    }

    public void refresh(ArrayList<View> list) {

        mData.clear();
        mData.addAll(list);
        Log.e("TAG", "refresh"+mData.size());
        notifyDataSetChanged();

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mData.get(position));
        return mData.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
