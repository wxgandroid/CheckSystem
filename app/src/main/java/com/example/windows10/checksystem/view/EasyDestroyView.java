package com.example.windows10.checksystem.view;

import com.example.windows10.checksystem.bean.EasyDestroyBean;

import java.util.List;

/**
 * Created by Windows10 on 2017/3/13.
 */
public interface EasyDestroyView extends BaseView {

    void updateRecyclerView(List<EasyDestroyBean.PartsListBean> partsList);

}
