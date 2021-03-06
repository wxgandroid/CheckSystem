package com.example.windows10.checksystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.activity.FullUserInfoActivity;
import com.example.windows10.checksystem.bean.BrandIdBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择车辆品牌的适配器
 */
public class ChoiceCarIDAdapter extends RecyclerView.Adapter<ChoiceCarIDAdapter.ChoiceCarBrandViewHolder> {

    private Context mContext;
    private List<BrandIdBean.BrandListBean> mData;

    public ChoiceCarIDAdapter(Context context, List<BrandIdBean.BrandListBean> list) {
        mContext = context;
        mData = new ArrayList();
        if (list != null) {
            mData.clear();
            mData.addAll(list);
        }
    }

    @Override
    public ChoiceCarBrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChoiceCarBrandViewHolder(LayoutInflater.from(mContext).inflate(R.layout.choice_cars_brand_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ChoiceCarBrandViewHolder holder, final int position) {
        holder.textView.setText(mData.get(position).getBrandName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FullUserInfoActivity) mContext).setCarsID(mData.get(position).getBrandName(), mData.get(position).getModelsId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class ChoiceCarBrandViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ChoiceCarBrandViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_choice_car_brand);
        }
    }


}
