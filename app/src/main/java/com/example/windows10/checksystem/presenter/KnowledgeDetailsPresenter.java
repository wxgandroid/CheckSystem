package com.example.windows10.checksystem.presenter;

import android.content.Context;

import com.example.windows10.checksystem.bean.KnowledgeDetailsBean;
import com.example.windows10.checksystem.constant.Constants;
import com.example.windows10.checksystem.view.KnowledgeDetailsView;
import com.example.windows10.rx_retrofit_library.RxUtils;

import java.util.HashMap;

/**
 * 指导信息的详细页面
 */
public class KnowledgeDetailsPresenter extends BasePresenter implements RxUtils.LoadingNetDataListener<KnowledgeDetailsBean> {

    private KnowledgeDetailsView mView;

    public KnowledgeDetailsPresenter(KnowledgeDetailsView view) {
        mView = view;
        mContext = (Context) view;
    }


    //加载数据
    public void loadData(int id) {

        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.ID, id + "");
        mView.showIOSLoading();
        RxUtils.getInstance().get(Constants.BASE_URL, Constants.APP_INTERFACE_KNOWLEDGE_ID, params, this, KnowledgeDetailsBean.class);

    }

    @Override
    public void onSuccess(KnowledgeDetailsBean data) {
        mView.dismissIOSLoading();
        mView.updatePagers(data);
    }

    @Override
    public void onError(String msg) {
        mView.dismissIOSLoading();
    }

    @Override
    public void onComplete() {

    }
}
