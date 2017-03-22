package com.example.windows10.checksystem.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用的RecyclerView的适配器
 */
public abstract class CommonRecyclerViewAdapter<T extends ViewDataBinding, V extends Object> extends RecyclerView.Adapter<CommonRecyclerViewAdapter.CommonRecyclerViewHolder> {

    private Context mContext;
    //条目布局的id号
    private int resId;
    //适配器中数据的集合
    public List<V> mData;

    public CommonRecyclerViewAdapter(Context context, int resId) {
        mContext = context;
        this.resId = resId;
        mData = new ArrayList<>();
    }


    @Override
    public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommonRecyclerViewHolder<T>(LayoutInflater.from(mContext).inflate(resId, parent, false));
    }

    @Override
    public void onBindViewHolder(CommonRecyclerViewHolder holder, int position) {
        T mBinding = (T) holder.mBinding;
        bindData(mBinding, position);
    }

    //绑定数据的方法
    public abstract void bindData(T binding, int position);

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    //刷新适配器中的数据
    public void refresh(List<V> list) {
        if (mData != null) {
            mData.clear();
        }
        mData.addAll(list);
        notifyDataSetChanged();
    }


    public class CommonRecyclerViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
        public T mBinding;

        public <T> CommonRecyclerViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }
    }
}
