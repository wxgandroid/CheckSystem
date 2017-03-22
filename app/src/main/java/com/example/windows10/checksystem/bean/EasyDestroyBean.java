package com.example.windows10.checksystem.bean;

import java.util.List;

/**
 * 易损零件清单的bean类
 */
public class EasyDestroyBean {


    /**
     * partsList : [{"brandId":0,"brandName":"","btx1":"","btx2":"","btx3":"","createTime":null,"effect":"","explain":"","id":0,"introduce":"","model":"BMS-1.5A","partPicture":"upload/partPicture/20170228131856-6530272115095174083dr.jpg","partsName":"汽车保险","price":0,"specifications":"BMS-1.5A"},{"brandId":0,"brandName":"","btx1":"","btx2":"","btx3":"","createTime":null,"effect":"","explain":"","id":0,"introduce":"","model":"BMS-2017-01","partPicture":"upload/partPicture/20170228132142-2862510308959186522dr.jpg","partsName":"汽车大灯","price":0,"specifications":"DDS-002"},{"brandId":0,"brandName":"","btx1":"","btx2":"","btx3":"","createTime":null,"effect":"","explain":"","id":0,"introduce":"","model":"w","partPicture":"","partsName":"ww","price":0,"specifications":"wweee333"}]
     * message : {"msg":"查询成功","remark":0,"success":"true","wxMessage":null}
     */

    private MessageBean message;
    private List<PartsListBean> partsList;

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public List<PartsListBean> getPartsList() {
        return partsList;
    }

    public void setPartsList(List<PartsListBean> partsList) {
        this.partsList = partsList;
    }

    public static class MessageBean {
        /**
         * msg : 查询成功
         * remark : 0
         * success : true
         * wxMessage : null
         */

        private String msg;
        private int remark;
        private String success;
        private Object wxMessage;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getRemark() {
            return remark;
        }

        public void setRemark(int remark) {
            this.remark = remark;
        }

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public Object getWxMessage() {
            return wxMessage;
        }

        public void setWxMessage(Object wxMessage) {
            this.wxMessage = wxMessage;
        }
    }

    public static class PartsListBean {
        /**
         * brandId : 0
         * brandName :
         * btx1 :
         * btx2 :
         * btx3 :
         * createTime : null
         * effect :
         * explain :
         * id : 0
         * introduce :
         * model : BMS-1.5A
         * partPicture : upload/partPicture/20170228131856-6530272115095174083dr.jpg
         * partsName : 汽车保险
         * price : 0
         * specifications : BMS-1.5A
         */

        private int brandId;
        private String brandName;
        private String btx1;
        private String btx2;
        private String btx3;
        private Object createTime;
        private String effect;
        private String explain;
        private String id;
        private String introduce;
        private String model;
        private String partPicture;
        private String partsName;
        private int price;
        private String specifications;

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
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

        public String getBtx3() {
            return btx3;
        }

        public void setBtx3(String btx3) {
            this.btx3 = btx3;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getPartPicture() {
            return partPicture;
        }

        public void setPartPicture(String partPicture) {
            this.partPicture = partPicture;
        }

        public String getPartsName() {
            return partsName;
        }

        public void setPartsName(String partsName) {
            this.partsName = partsName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }
    }
}
