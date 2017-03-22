package com.example.windows10.checksystem.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.activity.KnowledgeDetailsActivity;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.KnowledgeAllBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.databinding.CarKnowledgeItemLayoutBinding;
import com.example.windows10.rx_retrofit_library.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 汽车知识界面的adapter
 */
public class CarsKnowledgeAdapter extends RecyclerView.Adapter<CarsKnowledgeAdapter.CarsKnowledgeViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<KnowledgeAllBean.KnowledgeBaseListBean> mData;
    private Intent mIntent;

    public CarsKnowledgeAdapter(Context context) {
        mContext = context;
        mData = new ArrayList<>();
    }


    @Override
    public CarsKnowledgeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CarsKnowledgeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.car_knowledge_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(CarsKnowledgeViewHolder holder, int position) {
        holder.mBinding.tvCarKnowledge.setText(mData.get(position).getKnowledgeName());
        Glide.with(mContext).load(SystemApplication.BASE_PIC_URL + mData.get(position).getPictureAddress())
                .into(holder.mBinding.ivCarKnowledge);
        holder.mBinding.ivCarKnowledge.setTag(R.id.position_tag, position);
        holder.mBinding.ivCarKnowledge.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void refresh(List<KnowledgeAllBean.KnowledgeBaseListBean> list) {
        mData.clear();
        mData.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_car_knowledge:
                int position = (int) v.getTag(R.id.position_tag);
                toKnowledgeDetailsActivity(position);
                break;
        }

    }

    private void toKnowledgeDetailsActivity(int position) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.putExtra(Constants.INTENT_KNOWLEDGE_DETAILS, mData.get(position).getId());
        CommonUtils.toOtherActivity((Activity) mContext, KnowledgeDetailsActivity.class, mIntent);
    }

    class CarsKnowledgeViewHolder extends RecyclerView.ViewHolder {
        private CarKnowledgeItemLayoutBinding mBinding;

        public CarsKnowledgeViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);

        }
    }

}
