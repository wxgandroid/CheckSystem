package com.example.windows10.checksystem.view;

import com.example.windows10.checksystem.bean.KnowledgeDetailsBean;

/**
 * Created by Windows10 on 2017/3/22.
 */
public interface KnowledgeDetailsView extends BaseView {
    void showIOSLoading();

    void dismissIOSLoading();

    void updatePagers(KnowledgeDetailsBean data);
}
