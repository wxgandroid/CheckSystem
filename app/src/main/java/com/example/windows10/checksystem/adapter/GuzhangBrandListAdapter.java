package com.example.windows10.checksystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.activity.GuZhangDetailsActivity;
import com.example.windows10.checksystem.activity.LingjianDetailsActivity;
import com.example.windows10.checksystem.bean.LingJianDetailsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows10 on 2017/3/17.
 */
public class GuzhangBrandListAdapter extends RecyclerView.Adapter<GuzhangBrandListAdapter.GuzhangBrandViewHolder> {

    private Context mContext;
    private List<LingJianDetailsBean.SparePartsBean.SparePartsListBean> mData;
    private LinearLayout.LayoutParams params;

    public GuzhangBrandListAdapter(Context context) {
        mData = new ArrayList();
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 10, 10, 10);
        mContext = context;
    }

    @Override
    public GuzhangBrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GuzhangBrandViewHolder(new TextView(mContext));
    }

    @Override
    public void onBindViewHolder(GuzhangBrandViewHolder holder, final int position) {
        LingJianDetailsBean.SparePartsBean.SparePartsListBean bean = mData.get(position);
        holder.textView.setText(String.format(mContext.getString(R.string.pinpai_name), bean.getBrandName(), bean.getPrice(), bean.getGuaranteeDate()));
        holder.textView.setGravity(Gravity.CENTER);
        holder.textView.setLayoutParams(params);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mContext instanceof GuZhangDetailsActivity){
                    ((GuZhangDetailsActivity) mContext).updateUI(mData.get(position));
                }else if(mContext instanceof LingjianDetailsActivity){
                    ((LingjianDetailsActivity)mContext).updateUI(mData.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void refresh(List<LingJianDetailsBean.SparePartsBean.SparePartsListBean> list) {
        mData.clear();
        mData.addAll(list);
        notifyDataSetChanged();
    }

    class GuzhangBrandViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public GuzhangBrandViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
