package com.example.windows10.checksystem.bean;

/**
 * Created by Windows10 on 2017/3/22.
 */
public class KnowledgeDetailsBean {

    /**
     * knowledgeBase : {"btx1":"","btx2":"","btx3":"","createTime":{"date":2,"day":4,"hours":13,"minutes":23,"month":2,"seconds":31,"time":1488432211000,"timezoneOffset":-480,"year":117},"id":1,"introduce":"对强光灯的检查维修","knowledgeName":"汽车保险维修大灯","parameterId":7,"parameterName":"","parentTypeId":0,"partsId":14,"partsName":"","pictureAddress":"pictureLoad/20170322/1490148530863709508.jpg","typeName":"","videoAddress":""}
     * message : {"msg":"查询成功","remark":0,"success":"true","wxMessage":null}
     */

    private KnowledgeBaseBean knowledgeBase;
    private MessageBean message;

    public KnowledgeBaseBean getKnowledgeBase() {
        return knowledgeBase;
    }

    public void setKnowledgeBase(KnowledgeBaseBean knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public static class KnowledgeBaseBean {
        /**
         * btx1 :
         * btx2 :
         * btx3 :
         * createTime : {"date":2,"day":4,"hours":13,"minutes":23,"month":2,"seconds":31,"time":1488432211000,"timezoneOffset":-480,"year":117}
         * id : 1
         * introduce : 对强光灯的检查维修
         * knowledgeName : 汽车保险维修大灯
         * parameterId : 7
         * parameterName :
         * parentTypeId : 0
         * partsId : 14
         * partsName :
         * pictureAddress : pictureLoad/20170322/1490148530863709508.jpg
         * typeName :
         * videoAddress :
         */

        private String btx1;
        private String btx2;
        private String btx3;
        private CreateTimeBean createTime;
        private int id;
        private String introduce;
        private String knowledgeName;
        private int parameterId;
        private String parameterName;
        private int parentTypeId;
        private int partsId;
        private String partsName;
        private String pictureAddress;
        private String typeName;
        private String videoAddress;

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

        public String getKnowledgeName() {
            return knowledgeName;
        }

        public void setKnowledgeName(String knowledgeName) {
            this.knowledgeName = knowledgeName;
        }

        public int getParameterId() {
            return parameterId;
        }

        public void setParameterId(int parameterId) {
            this.parameterId = parameterId;
        }

        public String getParameterName() {
            return parameterName;
        }

        public void setParameterName(String parameterName) {
            this.parameterName = parameterName;
        }

        public int getParentTypeId() {
            return parentTypeId;
        }

        public void setParentTypeId(int parentTypeId) {
            this.parentTypeId = parentTypeId;
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

        public String getPictureAddress() {
            return pictureAddress;
        }

        public void setPictureAddress(String pictureAddress) {
            this.pictureAddress = pictureAddress;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getVideoAddress() {
            return videoAddress;
        }

        public void setVideoAddress(String videoAddress) {
            this.videoAddress = videoAddress;
        }

        public static class CreateTimeBean {
            /**
             * date : 2
             * day : 4
             * hours : 13
             * minutes : 23
             * month : 2
             * seconds : 31
             * time : 1488432211000
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
