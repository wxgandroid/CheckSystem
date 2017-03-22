package com.example.windows10.checksystem.bean;

import java.io.Serializable;

/**
 * Created by Windows10 on 2017/3/14.
 */
public class ParseCheckResultBean implements Serializable {

    /**
     * id : 保险正常但没电
     * spareParts : {"price":"500.0","manualPrice":"200.0","btx1":"null","btx2":"null"}
     */

    private String id;
    private SparePartsBean spareParts;
    private String partsId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SparePartsBean getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(SparePartsBean spareParts) {
        this.spareParts = spareParts;
    }

    public String getPartsId() {
        return partsId;
    }

    public void setPartsId(String partsId) {
        this.partsId = partsId;
    }

    public static class SparePartsBean implements Serializable{
        /**
         * price : 500.0
         * manualPrice : 200.0
         * btx1 : null
         * btx2 : null
         */

        private String price;
        private String manualPrice;
        private String btx1;
        private String btx2;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getManualPrice() {
            return manualPrice;
        }

        public void setManualPrice(String manualPrice) {
            this.manualPrice = manualPrice;
        }

        public String getBtx1() {
            return btx1;
        }

        public void setBtx1(String btx1) {
            this.btx1 = btx1;
        }

        public String getBtx2() {
            return btx2;
        }

        public void setBtx2(String btx2) {
            this.btx2 = btx2;
        }
    }
}
