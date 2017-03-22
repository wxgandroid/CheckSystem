package com.example.windows10.rx_retrofit_library;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 用来給指定id的View设置属性的类
 */
public class LayoutQuery {

    private final Activity mActivity;
    private View mView;

    //传入一个activity并给当前的对象中的activity赋值
    public LayoutQuery(Activity activity) {
        mActivity = activity;
    }

    //根据id名给该对象的view赋值
    public LayoutQuery id(int id) {
        mView = mActivity.findViewById(id);
        return this;
    }

    //如果view不为空，并且属于TextView
    public LayoutQuery text(String msg) {
        if (mView != null && mView instanceof TextView && !CommonUtils.isEmpty(msg)) {
            ((TextView) mView).setText(msg);
        }
        return this;
    }

    //如果view为imageView，给imageview设置图片信息
    public LayoutQuery image(int res_id) {
        if (mView != null && mView instanceof ImageView) {
            ((ImageView) mView).setImageResource(res_id);
        }
        return this;
    }

    //如果view不为空，则将view设置为可见的
    public LayoutQuery visible() {
        if (mView != null) {
            mView.setVisibility(View.VISIBLE);
        }
        return this;
    }

    //如果view不为空，则将view设置为不可见的
    public LayoutQuery gone() {
        if (mView != null) {
            mView.setVisibility(View.GONE);
        }
        return this;
    }

    //如果view不为空，则将view设置为占位但是不可见的
    public LayoutQuery inVisible() {
        if (mView != null) {
            mView.setVisibility(View.INVISIBLE);
        }
        return this;
    }

    //当View不为空时，给view设置点击事件
    public LayoutQuery clicked(View.OnClickListener clickListener) {
        if (mView != null && clickListener != null) {
            mView.setOnClickListener(clickListener);
        }
        return this;
    }

    //当View不为空时，设置View的显示状态
    public LayoutQuery visibility(int visible) {
        if (mView != null) {
            mView.setVisibility(visible);
        }
        return this;
    }

}
