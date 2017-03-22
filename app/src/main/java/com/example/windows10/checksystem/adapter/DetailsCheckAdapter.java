package com.example.windows10.checksystem.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.databinding.DetailsCheckItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DetailsCheckAdapter extends RecyclerView.Adapter<DetailsCheckAdapter.DetailsCheckViewHolder> {

    private Context mContext;
    private List<String> mData;

    public DetailsCheckAdapter(Context context) {
        mContext = context;
        mData = new ArrayList<>();

        mData.add("无法启动");
        mData.add("全车无电");
        mData.add("存在异响");
        mData.add("有焦糊味");
        mData.add("存在异动");


    }

    @Override
    public DetailsCheckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailsCheckViewHolder(LayoutInflater.from(mContext).inflate(R.layout.details_check_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(DetailsCheckViewHolder holder, int position) {
        holder.binding.cbDetailsCheck.setText(mData.get(position));
        if (position % 2 == 0) {
            holder.binding.btnDetailsCheckItemPlay.setVisibility(View.VISIBLE);
        } else {
            holder.binding.btnDetailsCheckItemPlay.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class DetailsCheckViewHolder extends RecyclerView.ViewHolder {

        private final DetailsCheckItemLayoutBinding binding;

        public DetailsCheckViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
