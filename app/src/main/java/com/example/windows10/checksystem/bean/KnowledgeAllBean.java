package com.example.windows10.checksystem.bean;

import java.util.List;

/**
 * 汽车只是对应的bean类
 */
public class KnowledgeAllBean {

    /**
     * knowledgeBaseList : [{"btx1":"","btx2":"","btx3":"","createTime":{"date":2,"day":4,"hours":13,"minutes":23,"month":2,"seconds":31,"time":1488432211000,"timezoneOffset":-480,"year":117},"id":1,"introduce":"对强光灯的检查维修","knowledgeName":"汽车保险维修大灯","parameterId":7,"parameterName":"","parentTypeId":0,"partsId":14,"partsName":"","pictureAddress":"pictureLoad/20170322/1490148530863709508.jpg","typeName":"","videoAddress":""},{"btx1":"","btx2":"","btx3":"","createTime":{"date":2,"day":4,"hours":13,"minutes":36,"month":2,"seconds":36,"time":1488432996000,"timezoneOffset":-480,"year":117},"id":2,"introduce":"对普通远光灯进行检修","knowledgeName":"汽车大灯检修","parameterId":11,"parameterName":"","parentTypeId":0,"partsId":15,"partsName":"","pictureAddress":"pictureLoad/20170322/1490148785285590666.jpg","typeName":"","videoAddress":""},{"btx1":"","btx2":"","btx3":"","createTime":{"date":2,"day":4,"hours":13,"minutes":37,"month":2,"seconds":32,"time":1488433052000,"timezoneOffset":-480,"year":117},"id":3,"introduce":"对车辆转向灯保险检修","knowledgeName":"大众汽车保险检修","parameterId":9,"parameterName":"","parentTypeId":0,"partsId":18,"partsName":"","pictureAddress":"pictureLoad/20170322/1490148856240619562.gif","typeName":"","videoAddress":""},{"btx1":"","btx2":"","btx3":"","createTime":{"date":20,"day":1,"hours":11,"minutes":12,"month":2,"seconds":1,"time":1489979521000,"timezoneOffset":-480,"year":117},"id":4,"introduce":"更换远光灯保险","knowledgeName":"保险更换","parameterId":7,"parameterName":"","parentTypeId":0,"partsId":14,"partsName":"","pictureAddress":"pictureLoad/20170322/1490148530863709508.jpg","typeName":"","videoAddress":""},{"btx1":"","btx2":"","btx3":"","createTime":{"date":20,"day":1,"hours":13,"minutes":45,"month":2,"seconds":54,"time":1489988754000,"timezoneOffset":-480,"year":117},"id":5,"introduce":"golas  is dream  and deadline","knowledgeName":"my heart will go on","parameterId":12,"parameterName":"","parentTypeId":0,"partsId":16,"partsName":"","pictureAddress":"pictureLoad/20170322/1490148819645353364.jpg","typeName":"","videoAddress":""},{"btx1":"","btx2":"","btx3":"","createTime":{"date":20,"day":1,"hours":16,"minutes":41,"month":2,"seconds":17,"time":1489999277000,"timezoneOffset":-480,"year":117},"id":6,"introduce":"书山有路勤为径","knowledgeName":"学海无涯","parameterId":7,"parameterName":"","parentTypeId":0,"partsId":16,"partsName":"","pictureAddress":"pictureLoad/20170322/1490148819645353364.jpg","typeName":"","videoAddress":""}]
     * message : {"msg":"查询成功","remark":0,"success":"true","wxMessage":null}
     */

    private MessageBean message;
    private List<KnowledgeBaseListBean> knowledgeBaseList;

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public List<KnowledgeBaseListBean> getKnowledgeBaseList() {
        return knowledgeBaseList;
    }

    public void setKnowledgeBaseList(List<KnowledgeBaseListBean> knowledgeBaseList) {
        this.knowledgeBaseList = knowledgeBaseList;
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

    public static class KnowledgeBaseListBean {
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
}
