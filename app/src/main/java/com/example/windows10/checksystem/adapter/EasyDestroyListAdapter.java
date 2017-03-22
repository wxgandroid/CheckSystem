package com.example.windows10.checksystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.activity.EasyDestroyListActivity;
import com.example.windows10.checksystem.activity.LingjianDetailsActivity;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.bean.EasyDestroyBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.rx_retrofit_library.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 易损零件清单的适配器
 */
public class EasyDestroyListAdapter extends RecyclerView.Adapter<EasyDestroyListAdapter.EasyDestroyViewHolder> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<EasyDestroyBean.PartsListBean> mData;
    private Intent mIntent;

    public EasyDestroyListAdapter(Context context) {
        mData = new ArrayList<>();
        mContext = context;
    }


    @Override
    public EasyDestroyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EasyDestroyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.easy_destroy_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(EasyDestroyViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.ll_easy_destroy_name1.setVisibility(View.VISIBLE);
            holder.ll_easy_destroy_name2.setVisibility(View.GONE);
            holder.tv_easy_destroy_en_name1.setText(mData.get(position).getBrandId() + "");
            holder.tv_easy_destroy_name1.setText(mData.get(position).getPartsName());

        } else {
            holder.ll_easy_destroy_name1.setVisibility(View.GONE);
            holder.ll_easy_destroy_name2.setVisibility(View.VISIBLE);
            holder.tv_easy_destroy_en_name2.setText(mData.get(position).getBrandId() + "");
            holder.tv_easy_destroy_name2.setText(mData.get(position).getPartsName());
        }
        Log.e("TAG", SystemApplication.BASE_PIC_URL + mData.get(position).getPartPicture());
        holder.itemView.setTag(R.id.position_tag, position);
        holder.itemView.setOnClickListener(this);
        Glide.with(mContext).load(SystemApplication.BASE_PIC_URL + mData.get(position).getPartPicture()).into(holder.iv_easy_destroy_pic);

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public void onClick(View v) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.putExtra(Constants.INTENT_KEY_LINGJIAN_ID, mData.get((Integer) v.getTag(R.id.position_tag)).getId());
        CommonUtils.toOtherActivity((EasyDestroyListActivity) mContext, LingjianDetailsActivity.class, mIntent);
    }

    public void refresh(List<EasyDestroyBean.PartsListBean> list) {
        if (mData != null) {
            mData.clear();
        }
        mData.addAll(list);
        notifyDataSetChanged();
    }


    public class EasyDestroyViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_easy_destroy_pic;
        private TextView tv_easy_destroy_name1;
        private TextView tv_easy_destroy_name2;
        private LinearLayout ll_easy_destroy_name1;
        private LinearLayout ll_easy_destroy_name2;
        private TextView tv_easy_destroy_en_name1;
        private TextView tv_easy_destroy_en_name2;

        public EasyDestroyViewHolder(View itemView) {
            super(itemView);
            iv_easy_destroy_pic = (ImageView) itemView.findViewById(R.id.iv_easy_destroy_pic);
            tv_easy_destroy_name1 = (TextView) itemView.findViewById(R.id.tv_easy_destroy_name1);
            tv_easy_destroy_name2 = (TextView) itemView.findViewById(R.id.tv_easy_destroy_name2);
            ll_easy_destroy_name1 = (LinearLayout) itemView.findViewById(R.id.ll_easy_destroy_name1);
            ll_easy_destroy_name2 = (LinearLayout) itemView.findViewById(R.id.ll_easy_destroy_name2);
            tv_easy_destroy_en_name1 = (TextView) itemView.findViewById(R.id.tv_easy_destroy_en_name1);
            tv_easy_destroy_en_name2 = (TextView) itemView.findViewById(R.id.tv_easy_destroy_en_name2);
        }
    }
}
