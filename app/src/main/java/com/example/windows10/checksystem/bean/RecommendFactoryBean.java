package com.example.windows10.checksystem.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Windows10 on 2017/3/15.
 */
public class RecommendFactoryBean {

    private List<FactoryListBean> factoryList;

    public List<FactoryListBean> getFactoryList() {
        return factoryList;
    }

    public void setFactoryList(List<FactoryListBean> factoryList) {
        this.factoryList = factoryList;
    }

    public static class FactoryListBean implements Serializable {
        /**
         * btx1 :
         * btx2 :
         * btx3 :
         * city :
         * city1 :
         * coordinateX : 34
         * coordinateY : 109
         * createTime : null
         * factoryAddress :
         * factoryName :
         * goodRepair :
         * id : 0
         * introduce :
         * latitude : 0
         * level : 0
         * linkman :
         * location :
         * longitude : 0
         * phone :
         * picture :
         * province :
         * province1 :
         * recommend : 0
         * store_area :
         * store_area1 :
         */

        private String btx1;
        private String btx2;
        private String btx3;
        private String city;
        private String city1;
        private double coordinateX;
        private double coordinateY;
        private Object createTime;
        private String factoryAddress;
        private String factoryName;
        private String goodRepair;
        private int id;
        private String introduce;
        private int latitude;
        private int level;
        private String linkman;
        private String location;
        private int longitude;
        private String phone;
        private String picture;
        private String province;
        private String province1;
        private int recommend;
        private String store_area;
        private String store_area1;

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

        public String getBtx3() {
            return btx3;
        }

        public void setBtx3(String btx3) {
            this.btx3 = btx3;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity1() {
            return city1;
        }

        public void setCity1(String city1) {
            this.city1 = city1;
        }

        public double getCoordinateX() {
            return coordinateX;
        }

        public void setCoordinateX(double coordinateX) {
            this.coordinateX = coordinateX;
        }

        public double getCoordinateY() {
            return coordinateY;
        }

        public void setCoordinateY(double coordinateY) {
            this.coordinateY = coordinateY;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public String getFactoryAddress() {
            return factoryAddress;
        }

        public void setFactoryAddress(String factoryAddress) {
            this.factoryAddress = factoryAddress;
        }

        public String getFactoryName() {
            return factoryName;
        }

        public void setFactoryName(String factoryName) {
            this.factoryName = factoryName;
        }

        public String getGoodRepair() {
            return goodRepair;
        }

        public void setGoodRepair(String goodRepair) {
            this.goodRepair = goodRepair;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getLinkman() {
            return linkman;
        }

        public void setLinkman(String linkman) {
            this.linkman = linkman;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getProvince1() {
            return province1;
        }

        public void setProvince1(String province1) {
            this.province1 = province1;
        }

        public int getRecommend() {
            return recommend;
        }

        public void setRecommend(int recommend) {
            this.recommend = recommend;
        }

        public String getStore_area() {
            return store_area;
        }

        public void setStore_area(String store_area) {
            this.store_area = store_area;
        }

        public String getStore_area1() {
            return store_area1;
        }

        public void setStore_area1(String store_area1) {
            this.store_area1 = store_area1;
        }
    }
}
