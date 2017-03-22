package com.example.windows10.checksystem.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 零件详细说明的bean类
 */
public class LingJianDetailsBean {

    /**
     * spareParts : {"brandId":1,"brandName":"","btx1":"1小时","btx2":"汽车保险","btx3":"1","createTime":{"date":28,"day":2,"hours":13,"minutes":19,"month":1,"seconds":37,"time":1488259177000,"timezoneOffset":-480,"year":117},"effect":"保险保护线路发生自燃","explain":"用于宝马系列","explains":"用于宝马系列","guaranteeDate":"6个月","id":4,"introduce":"汽车保险介绍","manualPrice":0,"model":"BMS-1.5A","partName":"","partPicture":"upload/partPicture/20170228131856-6530272115095174083dr.jpg","partsName":14,"price":40,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[{"brandId":1,"brandName":"","btx1":"1小时","btx2":"汽车保险","btx3":"1","createTime":{"date":28,"day":2,"hours":13,"minutes":19,"month":1,"seconds":37,"time":1488259177000,"timezoneOffset":-480,"year":117},"effect":"保险保护线路发生自燃","explain":"用于宝马系列","explains":"用于宝马系列","guaranteeDate":"6个月","id":4,"introduce":"汽车保险介绍","manualPrice":0,"model":"BMS-1.5A","partName":"","partPicture":"upload/partPicture/20170228131856-6530272115095174083dr.jpg","partsName":14,"price":40,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"BMS-1.5A","video":null},{"brandId":2,"brandName":"","btx1":"20分钟","btx2":"更换保险时，请关闭发动机","btx3":"1","createTime":{"date":13,"day":1,"hours":14,"minutes":54,"month":2,"seconds":41,"time":1489388081000,"timezoneOffset":-480,"year":117},"effect":"保护整车线路安全","explain":"保护整车线路安全","explains":"保护整车线路安全","guaranteeDate":"六个月","id":8,"introduce":"全车保险","manualPrice":0,"model":"QCBX-0001-008","partName":"","partPicture":"upload/partPicture/201703131454407221476264689952045dr.jpg","partsName":14,"price":200,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"QCBX-0001","video":null},{"brandId":1,"brandName":"","btx1":"1","btx2":"232","btx3":"1","createTime":{"date":13,"day":1,"hours":17,"minutes":12,"month":2,"seconds":29,"time":1489396349000,"timezoneOffset":-480,"year":117},"effect":"33","explain":"RR","explains":"RR","guaranteeDate":"33","id":9,"introduce":"33","manualPrice":0,"model":"22","partName":"","partPicture":"pictureLoad/20170313/1489395975433950072.jpg","partsName":14,"price":20000,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"22","video":null}],"specifications":"BMS-1.5A","video":{"btx1":"","btx2":"","btx3":"","createTime":{"date":2,"day":4,"hours":15,"minutes":42,"month":2,"seconds":58,"time":1488440578000,"timezoneOffset":-480,"year":117},"id":2,"modelName":"","models":3,"partsId":14,"partsName":"","videoAddress":"upload/project/video/20170302/1488441029301965505.mp4","videoName":"大众汽车保险检修视频"}}
     * message : {"msg":"查询成功","remark":0,"success":"true","wxMessage":null}
     */

    private SparePartsBean spareParts;
    private MessageBean message;

    public SparePartsBean getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(SparePartsBean spareParts) {
        this.spareParts = spareParts;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public static class SparePartsBean implements Serializable{
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
         * partName :
         * partPicture : upload/partPicture/20170228131856-6530272115095174083dr.jpg
         * partsName : 14
         * price : 40
         * spare1 :
         * spare2 :
         * spare3 :
         * spare4 :
         * sparePartsList : [{"brandId":1,"brandName":"","btx1":"1小时","btx2":"汽车保险","btx3":"1","createTime":{"date":28,"day":2,"hours":13,"minutes":19,"month":1,"seconds":37,"time":1488259177000,"timezoneOffset":-480,"year":117},"effect":"保险保护线路发生自燃","explain":"用于宝马系列","explains":"用于宝马系列","guaranteeDate":"6个月","id":4,"introduce":"汽车保险介绍","manualPrice":0,"model":"BMS-1.5A","partName":"","partPicture":"upload/partPicture/20170228131856-6530272115095174083dr.jpg","partsName":14,"price":40,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"BMS-1.5A","video":null},{"brandId":2,"brandName":"","btx1":"20分钟","btx2":"更换保险时，请关闭发动机","btx3":"1","createTime":{"date":13,"day":1,"hours":14,"minutes":54,"month":2,"seconds":41,"time":1489388081000,"timezoneOffset":-480,"year":117},"effect":"保护整车线路安全","explain":"保护整车线路安全","explains":"保护整车线路安全","guaranteeDate":"六个月","id":8,"introduce":"全车保险","manualPrice":0,"model":"QCBX-0001-008","partName":"","partPicture":"upload/partPicture/201703131454407221476264689952045dr.jpg","partsName":14,"price":200,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"QCBX-0001","video":null},{"brandId":1,"brandName":"","btx1":"1","btx2":"232","btx3":"1","createTime":{"date":13,"day":1,"hours":17,"minutes":12,"month":2,"seconds":29,"time":1489396349000,"timezoneOffset":-480,"year":117},"effect":"33","explain":"RR","explains":"RR","guaranteeDate":"33","id":9,"introduce":"33","manualPrice":0,"model":"22","partName":"","partPicture":"pictureLoad/20170313/1489395975433950072.jpg","partsName":14,"price":20000,"spare1":"","spare2":"","spare3":"","spare4":"","sparePartsList":[],"specifications":"22","video":null}]
         * specifications : BMS-1.5A
         * video : {"btx1":"","btx2":"","btx3":"","createTime":{"date":2,"day":4,"hours":15,"minutes":42,"month":2,"seconds":58,"time":1488440578000,"timezoneOffset":-480,"year":117},"id":2,"modelName":"","models":3,"partsId":14,"partsName":"","videoAddress":"upload/project/video/20170302/1488441029301965505.mp4","videoName":"大众汽车保险检修视频"}
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
        private int id;
        private String introduce;
        private double manualPrice;
        private String model;
        private String partName;
        private String partPicture;
        private int partsName;
        private double price;
        private String spare1;
        private String spare2;
        private String spare3;
        private String spare4;
        private String specifications;
        private VideoBean video;
        private List<SparePartsListBean> sparePartsList;

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

        public double getManualPrice() {
            return manualPrice;
        }

        public void setManualPrice(double manualPrice) {
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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
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

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public List<SparePartsListBean> getSparePartsList() {
            return sparePartsList;
        }

        public void setSparePartsList(List<SparePartsListBean> sparePartsList) {
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

        public static class VideoBean implements Serializable{
            /**
             * btx1 :
             * btx2 :
             * btx3 :
             * createTime : {"date":2,"day":4,"hours":15,"minutes":42,"month":2,"seconds":58,"time":1488440578000,"timezoneOffset":-480,"year":117}
             * id : 2
             * modelName :
             * models : 3
             * partsId : 14
             * partsName :
             * videoAddress : upload/project/video/20170302/1488441029301965505.mp4
             * videoName : 大众汽车保险检修视频
             */

            private String btx1;
            private String btx2;
            private String btx3;
            private CreateTimeBeanX createTime;
            private int id;
            private String modelName;
            private int models;
            private int partsId;
            private String partsName;
            private String videoAddress;
            private String videoName;

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

            public CreateTimeBeanX getCreateTime() {
                return createTime;
            }

            public void setCreateTime(CreateTimeBeanX createTime) {
                this.createTime = createTime;
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

            public int getModels() {
                return models;
            }

            public void setModels(int models) {
                this.models = models;
            }

            public int getPartsId() {
                return partsId;
            }

            public void setPartsId(int partsId) {
                this.partsId = partsId;
            }

            public String getPartsName() {
                return partsName;
            }

            public void setPartsName(String partsName) {
                this.partsName = partsName;
            }

            public String getVideoAddress() {
                return videoAddress;
            }

            public void setVideoAddress(String videoAddress) {
                this.videoAddress = videoAddress;
            }

            public String getVideoName() {
                return videoName;
            }

            public void setVideoName(String videoName) {
                this.videoName = videoName;
            }

            public static class CreateTimeBeanX {
                /**
                 * date : 2
                 * day : 4
                 * hours : 15
                 * minutes : 42
                 * month : 2
                 * seconds : 58
                 * time : 1488440578000
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

        public static class SparePartsListBean {
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
             * partName :
             * partPicture : upload/partPicture/20170228131856-6530272115095174083dr.jpg
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
            private CreateTimeBeanXX createTime;
            private String effect;
            private String explain;
            private String explains;
            private String guaranteeDate;
            private int id;
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

            public CreateTimeBeanXX getCreateTime() {
                return createTime;
            }

            public void setCreateTime(CreateTimeBeanXX createTime) {
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

            public static class CreateTimeBeanXX {
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
}
