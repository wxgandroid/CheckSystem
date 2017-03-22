package com.example.windows10.checksystem.bean;

import java.util.List;

/**
 * Created by Windows10 on 2017/3/20.
 */
public class BrandIdBean {


    private List<BrandListBean> brandList;

    public List<BrandListBean> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandListBean> brandList) {
        this.brandList = brandList;
    }

    public static class BrandListBean {
        /**
         * brandName : SD9900
         * id : 2
         * modelName :
         * modelsId : 1
         */

        private String brandName;
        private int id;
        private String modelName;
        private int modelsId;

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public int getModelsId() {
            return modelsId;
        }

        public void setModelsId(int modelsId) {
            this.modelsId = modelsId;
        }
    }
}
