package com.example.windows10.checksystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.windows10.checksystem.R;
import com.example.windows10.checksystem.activity.CheckingActivity;
import com.example.windows10.checksystem.activity.HomeActivity;
import com.example.windows10.checksystem.application.SystemApplication;
import com.example.windows10.checksystem.databinding.HomeRecyclerviewItemLayoutBinding;
import com.example.windows10.rx_retrofit_library.CommonUtils;

import java.util.ArrayList;

/**
 * Created by Windows10 on 2017/2/27.
 */
public class HomeReyclerViewAdapter extends RecyclerView.Adapter<HomeReyclerViewAdapter.HomeRecyclerViewHolder> {

    private Context mContext;
    private ArrayList<String> mData;
    private Intent mIntent;

    public HomeReyclerViewAdapter(Context context) {
        mData = new ArrayList<>();
        mContext = context;
        mIntent = new Intent();
    }


    @Override
    public HomeRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeRecyclerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_recyclerview_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeRecyclerViewHolder holder, final int position) {

        setIconBackground(holder.mBinding, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    if (SystemApplication.USER_ID != -1) {
                        CommonUtils.toOtherActivity((HomeActivity) mContext, CheckingActivity.class);
                    } else {
                        Toast.makeText(mContext, "请先登录,再进行此操作", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(mContext, "功能尚未开放，敬请期待", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setIconBackground(HomeRecyclerviewItemLayoutBinding binding, int position) {
        switch (position) {
            case 0:

                binding.rlHome.setBackgroundColor(Color.argb(200, 255, 103, 108));
                binding.ivHoeRlvItem.setImageResource(R.drawable.home_check_logo);
                binding.tvHomeRlvItem.setText("检测");
                break;
            case 1:
                binding.rlHome.setBackgroundColor(Color.argb(200, 87, 143, 255));
                binding.ivHoeRlvItem.setImageResource(R.drawable.home_hotel_logo);
                binding.tvHomeRlvItem.setText("住宿");
                break;
            case 2:
                binding.rlHome.setBackgroundColor(Color.argb(200, 204, 102, 255));
                binding.ivHoeRlvItem.setImageResource(R.drawable.home_drive_logo);
                binding.tvHomeRlvItem.setText("车游");
                break;
            case 3:
                binding.rlHome.setBackgroundColor(Color.argb(200, 255, 191, 67));
                binding.ivHoeRlvItem.setImageResource(R.drawable.home_market_logo);
                binding.tvHomeRlvItem.setText("餐饮");
                break;
            case 4:
                binding.rlHome.setBackgroundColor(Color.argb(200, 116, 221, 227));
                binding.ivHoeRlvItem.setImageResource(R.drawable.home_check_logo);
                binding.tvHomeRlvItem.setText("互动");
                break;
            case 5:
                binding.rlHome.setBackgroundColor(Color.argb(200, 255, 126, 162));
                binding.ivHoeRlvItem.setImageResource(R.drawable.home_check_logo);
                binding.tvHomeRlvItem.setText("组队");
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void refresh(ArrayList<String> list) {
        mData.clear();
        mData.addAll(list);
        notifyDataSetChanged();
    }


    class HomeRecyclerViewHolder extends RecyclerView.ViewHolder {
        private HomeRecyclerviewItemLayoutBinding mBinding;

        public HomeRecyclerViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }
    }
}
