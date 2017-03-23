package com.example.windows10.checksystem.bean;

import java.util.List;

/**
 * 易损零件清单的bean类
 */
public class EasyDestroyBean {


    /**
     * partsList : [{"brandId":1,"brandName":"","btx1":"1小时","btx2":"汽车保险","btx3":"1","createTime":{"date":28,"day":2,"hours":13,"minutes":19,"month":1,"seconds":37,"time":1488259177000,"timezoneOffset":-480,"year":117},"effect":"保险保护线路发生自燃","explain":"用于宝马系列","explains":"用于宝马系列","guaranteeDate":"6个月","id":4,"introduce":"汽车保险介绍","manualPrice":0,"model":"BMS-1.5A","partName":"汽车保险","partPicture":"pictureLoad/20170313/20170228131856-6530272115095174083dr.jpg","partsName":14,"price":40,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"BMS-1.5A","video":null},{"brandId":2,"brandName":"","btx1":"2小时","btx2":"注意保养","btx3":"1","createTime":{"date":28,"day":2,"hours":13,"minutes":21,"month":1,"seconds":42,"time":1488259302000,"timezoneOffset":-480,"year":117},"effect":"大灯作用","explain":"大灯说明","explains":"大灯说明","guaranteeDate":"12个月","id":5,"introduce":"大灯介绍","manualPrice":0,"model":"BMS-2017-01","partName":"汽车大灯","partPicture":"pictureLoad/20170313/20170228132142-2862510308959186522dr.jpg","partsName":15,"price":500,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"DDS-002","video":null},{"brandId":1,"brandName":"","btx1":"一个小时","btx2":"注意及时保养，不要在人多的时候开启","btx3":"0","createTime":{"date":10,"day":5,"hours":14,"minutes":34,"month":2,"seconds":39,"time":1489127679000,"timezoneOffset":-480,"year":117},"effect":"用于照明","explain":"主光聚大，照射距离远","explains":"主光聚大，照射距离远","guaranteeDate":"","id":6,"introduce":"奥迪专用","manualPrice":0,"model":"AD-0001-002","partName":"汽车大灯","partPicture":"pictureLoad/20170313/201703131050171817952991197028154dr.jpg","partsName":15,"price":2000,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"AD-0001","video":null},{"brandId":1,"brandName":"","btx1":"6个小时","btx2":"注意夏季和冬季，防热和防冷的保养","btx3":"0","createTime":{"date":13,"day":1,"hours":10,"minutes":23,"month":2,"seconds":36,"time":1489371816000,"timezoneOffset":-480,"year":117},"effect":"汽车动力系统","explain":"长春汽车制造厂生成","explains":"长春汽车制造厂生成","guaranteeDate":"12个月","id":7,"introduce":"东方红牌发动机","manualPrice":0,"model":"DFH-201-012-CH","partName":"汽车发动机","partPicture":"pictureLoad/20170313/20170313102336-1316072813190573365dr.jpg","partsName":16,"price":20100,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"DFH-201","video":null},{"brandId":2,"brandName":"","btx1":"20分钟","btx2":"更换保险时，请关闭发动机","btx3":"1","createTime":{"date":13,"day":1,"hours":14,"minutes":54,"month":2,"seconds":41,"time":1489388081000,"timezoneOffset":-480,"year":117},"effect":"保护整车线路安全","explain":"保护整车线路安全","explains":"保护整车线路安全","guaranteeDate":"六个月","id":8,"introduce":"全车保险","manualPrice":80,"model":"QCBX-0001-008","partName":"汽车保险","partPicture":"pictureLoad/20170313/201703131454407221476264689952045dr.jpg","partsName":14,"price":200,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"QCBX-0001","video":null},{"brandId":1,"brandName":"","btx1":"1","btx2":"232","btx3":"1","createTime":{"date":13,"day":1,"hours":17,"minutes":12,"month":2,"seconds":29,"time":1489396349000,"timezoneOffset":-480,"year":117},"effect":"33","explain":"RR","explains":"RR","guaranteeDate":"33","id":9,"introduce":"33","manualPrice":0,"model":"22","partName":"汽车保险","partPicture":"pictureLoad/20170313/1489395975433950072.jpg","partsName":14,"price":20000,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"22","video":null},{"brandId":1,"brandName":"","btx1":"2小时","btx2":"1汽车轮胎","btx3":"1","createTime":{"date":13,"day":1,"hours":17,"minutes":34,"month":2,"seconds":5,"time":1489397645000,"timezoneOffset":-480,"year":117},"effect":"汽车轮胎","explain":"汽车轮胎","explains":"汽车轮胎","guaranteeDate":"12个月","id":10,"introduce":"汽车轮胎","manualPrice":0,"model":"LT-008-001","partName":"汽车轮胎","partPicture":"pictureLoad/20170316/1489645514526791396.jpg","partsName":17,"price":4500,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"LT-008","video":null},{"brandId":2,"brandName":"","btx1":"2个小时","btx2":"方向盘","btx3":"0","createTime":{"date":13,"day":1,"hours":17,"minutes":39,"month":2,"seconds":47,"time":1489397987000,"timezoneOffset":-480,"year":117},"effect":"方向盘","explain":"方向盘","explains":"方向盘","guaranteeDate":"12个月","id":11,"introduce":"方向盘","manualPrice":0,"model":"FXP-0088-001","partName":"方向盘","partPicture":"pictureLoad/20170313/1489397922149975671.jpg","partsName":18,"price":1000,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"FXP-0088","video":null},{"brandId":1,"brandName":"","btx1":"1小时","btx2":"方向盘","btx3":"0","createTime":{"date":16,"day":4,"hours":14,"minutes":41,"month":2,"seconds":39,"time":1489646499000,"timezoneOffset":-480,"year":117},"effect":"2017031602","explain":"2017031603","explains":"2017031603","guaranteeDate":"12个月","id":12,"introduce":"2017031601","manualPrice":0,"model":"FXP-001-008","partName":"方向盘","partPicture":"pictureLoad/20170316/1489646433101789286.jpg","partsName":18,"price":1000,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"FXP-001","video":null},{"brandId":2,"brandName":"","btx1":"3","btx2":"33","btx3":"0","createTime":{"date":16,"day":4,"hours":17,"minutes":56,"month":2,"seconds":33,"time":1489658193000,"timezoneOffset":-480,"year":117},"effect":"","explain":"","explains":"","guaranteeDate":"33","id":13,"introduce":"","manualPrice":80,"model":"BMS-1.5A","partName":"汽车保险","partPicture":"pictureLoad/20170316/1489658191090605173.jpg","partsName":14,"price":55,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"BMS-1.5A","video":null},{"brandId":6,"brandName":"","btx1":"1","btx2":"不可自动拆卸","btx3":"1","createTime":{"date":20,"day":1,"hours":13,"minutes":27,"month":2,"seconds":8,"time":1489987628000,"timezoneOffset":-480,"year":117},"effect":"可以转动转向","explain":"大方向盘","explains":"大方向盘","guaranteeDate":"10","id":14,"introduce":"质量好价格高","manualPrice":0,"model":"H-12","partName":"方向盘","partPicture":"pictureLoad/20170320/1489987544758704723.gif","partsName":18,"price":123,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"88/89","video":null},{"brandId":7,"brandName":"","btx1":"1","btx2":"优惠100美元","btx3":"1","createTime":{"date":20,"day":1,"hours":16,"minutes":31,"month":2,"seconds":22,"time":1489998682000,"timezoneOffset":-480,"year":117},"effect":"载客","explain":"不可过崎岖坎坷的卤","explains":"不可过崎岖坎坷的卤","guaranteeDate":"20","id":15,"introduce":"商务舒适型","manualPrice":0,"model":"HIOIOIO","partName":"汽车发动机","partPicture":"pictureLoad/20170320/1489998611999882132.gif","partsName":16,"price":12313123,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"10/11","video":null}]
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
         * brandId : 1
         * brandName :
         * btx1 : 1小时
         * btx2 : 汽车保险
         * btx3 : 1
         * createTime : {"date":28,"day":2,"hours":13,"minutes":19,"month":1,"seconds":37,"time":1488259177000,"timezoneOffset":-480,"year":117}
         * effect : 保险保护线路发生自燃
         * explain : 用于宝马系列
         * explains : 用于宝马系列
         * guaranteeDate : 6个月
         * id : 4
         * introduce : 汽车保险介绍
         * manualPrice : 0
         * model : BMS-1.5A
         * partName : 汽车保险
         * partPicture : pictureLoad/20170313/20170228131856-6530272115095174083dr.jpg
         * partsName : 14
         * price : 40
         * spare1 :
         * spare2 :
         * spare3 :
         * spare4 :
         * sparePartsList : []
         * specifications : BMS-1.5A
         * video : null
         */

        private int brandId;
        private String brandName;
        private String btx1;
        private String btx2;
        private String btx3;
        private CreateTimeBean createTime;
        private String effect;
        private String explain;
        private String explains;
        private String guaranteeDate;
        private String id;
        private String introduce;
        private int manualPrice;
        private String model;
        private String partName;
        private String partPicture;
        private int partsName;
        private int price;
        private String spare1;
        private String spare2;
        private String spare3;
        private String spare4;
        private String specifications;
        private Object video;
        private List<?> sparePartsList;

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

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
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

        public String getExplains() {
            return explains;
        }

        public void setExplains(String explains) {
            this.explains = explains;
        }

        public String getGuaranteeDate() {
            return guaranteeDate;
        }

        public void setGuaranteeDate(String guaranteeDate) {
            this.guaranteeDate = guaranteeDate;
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

        public int getManualPrice() {
            return manualPrice;
        }

        public void setManualPrice(int manualPrice) {
            this.manualPrice = manualPrice;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getPartName() {
            return partName;
        }

        public void setPartName(String partName) {
            this.partName = partName;
        }

        public String getPartPicture() {
            return partPicture;
        }

        public void setPartPicture(String partPicture) {
            this.partPicture = partPicture;
        }

        public int getPartsName() {
            return partsName;
        }

        public void setPartsName(int partsName) {
            this.partsName = partsName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getSpare1() {
            return spare1;
        }

        public void setSpare1(String spare1) {
            this.spare1 = spare1;
        }

        public String getSpare2() {
            return spare2;
        }

        public void setSpare2(String spare2) {
            this.spare2 = spare2;
        }

        public String getSpare3() {
            return spare3;
        }

        public void setSpare3(String spare3) {
            this.spare3 = spare3;
        }

        public String getSpare4() {
            return spare4;
        }

        public void setSpare4(String spare4) {
            this.spare4 = spare4;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }

        public Object getVideo() {
            return video;
        }

        public void setVideo(Object video) {
            this.video = video;
        }

        public List<?> getSparePartsList() {
            return sparePartsList;
        }

        public void setSparePartsList(List<?> sparePartsList) {
            this.sparePartsList = sparePartsList;
        }

        public static class CreateTimeBean {
            /**
             * date : 28
             * day : 2
             * hours : 13
             * minutes : 19
             * month : 1
             * seconds : 37
             * time : 1488259177000
             * timezoneOffset : -480
             * year : 117
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}
