package com.example.windows10.checksystem.bean;

import java.util.List;

/**
 * Created by Windows10 on 2017/3/20.
 */
public class CarModelsBean {

    private List<ModelListBean> modelList;

    public List<ModelListBean> getModelList() {
        return modelList;
    }

    public void setModelList(List<ModelListBean> modelList) {
        this.modelList = modelList;
    }

    public static class ModelListBean {
        /**
         * id : 1
         * models : 宝马
         */

        private int id;
        private String models;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getModels() {
            return models;
        }

        public void setModels(String models) {
            this.models = models;
        }
    }
}
