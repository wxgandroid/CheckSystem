package com.example.windows10.checksystem.bean;

/**
 * 系统配置接口的bean类
 */
public class SystemConfigBean {


    /**
     * system : {"audioPath":"http://www.voice.com","btx1":"","btx2":"","btx3":"","createTime":{"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117},"id":1,"inputPath":"http://www.inputpath.com","inspection_frequency":300,"inspection_time":10,"picturePath":"http://www.picture.com","resultPath":"http://www.resultpath.com","updateTime":{"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117},"videoPath":"http://www.video.com"}
     * message : {"msg":"查询成功","remark":0,"success":"true","wxMessage":null}
     */

    private SystemBean system;
    private MessageBean message;

    public SystemBean getSystem() {
        return system;
    }

    public void setSystem(SystemBean system) {
        this.system = system;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public static class SystemBean {
        /**
         * audioPath : http://www.voice.com
         * btx1 :
         * btx2 :
         * btx3 :
         * createTime : {"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117}
         * id : 1
         * inputPath : http://www.inputpath.com
         * inspection_frequency : 300
         * inspection_time : 10
         * picturePath : http://www.picture.com
         * resultPath : http://www.resultpath.com
         * updateTime : {"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117}
         * videoPath : http://www.video.com
         */

        private String audioPath;
        private String btx1;
        private String btx2;
        private String btx3;
        private CreateTimeBean createTime;
        private int id;
        private String inputPath;
        private double inspection_frequency;
        private double inspection_time;
        private String picturePath;
        private String resultPath;
        private UpdateTimeBean updateTime;
        private String videoPath;

        public String getAudioPath() {
            return audioPath;
        }

        public void setAudioPath(String audioPath) {
            this.audioPath = audioPath;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInputPath() {
            return inputPath;
        }

        public void setInputPath(String inputPath) {
            this.inputPath = inputPath;
        }

        public double getInspection_frequency() {
            return inspection_frequency;
        }

        public void setInspection_frequency(double inspection_frequency) {
            this.inspection_frequency = inspection_frequency;
        }

        public double getInspection_time() {
            return inspection_time;
        }

        public void setInspection_time(double inspection_time) {
            this.inspection_time = inspection_time;
        }

        public String getPicturePath() {
            return picturePath;
        }

        public void setPicturePath(String picturePath) {
            this.picturePath = picturePath;
        }

        public String getResultPath() {
            return resultPath;
        }

        public void setResultPath(String resultPath) {
            this.resultPath = resultPath;
        }

        public UpdateTimeBean getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(UpdateTimeBean updateTime) {
            this.updateTime = updateTime;
        }

        public String getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(String videoPath) {
            this.videoPath = videoPath;
        }

        public static class CreateTimeBean {
            /**
             * date : 27
             * day : 1
             * hours : 11
             * minutes : 25
             * month : 1
             * seconds : 27
             * time : 1488165927000
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

        public static class UpdateTimeBean {
            /**
             * date : 27
             * day : 1
             * hours : 11
             * minutes : 25
             * month : 1
             * seconds : 27
             * time : 1488165927000
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
