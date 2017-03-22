package com.example.windows10.checksystem.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 查询详细检测所有项的bean对象
 */
public class CheckDetailsAllBean {


    /**
     * problemList : [{"analysis":"首先检查汽车保险是否损坏，如果损坏进行更换","btx1":"010C","btx2":"","btx3":"","createTime":{"date":28,"day":2,"hours":16,"minutes":13,"month":1,"seconds":6,"time":1488269586000,"timezoneOffset":-480,"year":117},"id":4,"partsId":14,"partsName":"","problemName":"汽车没电","voiceList":[{"analysis":"线路短路`121313123123","btx1":"","btx2":"","btx3":"","createTime":{"date":1,"day":3,"hours":10,"minutes":15,"month":2,"seconds":18,"time":1488334518000,"timezoneOffset":-480,"year":117},"id":2,"partsId":14,"partsName":"","problemId":4,"problemName":"","voiceAddress":"upload/voice/201703011015183987965157650243522dr.mp3","voiceName":"保险声音"},{"analysis":"保险声音22","btx1":"","btx2":"","btx3":"","createTime":{"date":1,"day":3,"hours":10,"minutes":16,"month":2,"seconds":56,"time":1488334616000,"timezoneOffset":-480,"year":117},"id":3,"partsId":14,"partsName":"","problemId":4,"problemName":"","voiceAddress":"upload/voice/201703011029523219153234350997823dr.mp3","voiceName":"汽车保险22"},{"analysis":"噪音","btx1":"","btx2":"","btx3":"","createTime":{"date":16,"day":4,"hours":17,"minutes":7,"month":2,"seconds":10,"time":1489655230000,"timezoneOffset":-480,"year":117},"id":5,"partsId":14,"partsName":"","problemId":4,"problemName":"","voiceAddress":"video/20170316/1489655220244754282.mp3","voiceName":"检测声音"},{"analysis":"22","btx1":"","btx2":"","btx3":"","createTime":{"date":16,"day":4,"hours":17,"minutes":24,"month":2,"seconds":10,"time":1489656250000,"timezoneOffset":-480,"year":117},"id":8,"partsId":14,"partsName":"","problemId":4,"problemName":"","voiceAddress":"voice/20170316/1489656244495534227.mp3","voiceName":"222"}]},{"analysis":"首先检查灯泡是否损坏，如果损坏进行更换","btx1":"010A","btx2":"","btx3":"","createTime":{"date":28,"day":2,"hours":16,"minutes":14,"month":1,"seconds":47,"time":1488269687000,"timezoneOffset":-480,"year":117},"id":5,"partsId":15,"partsName":"","problemName":"大灯不亮","voiceList":[]},{"analysis":"查看电瓶是否有电","btx1":"010B","btx2":"","btx3":"","createTime":{"date":28,"day":2,"hours":16,"minutes":15,"month":1,"seconds":28,"time":1488269728000,"timezoneOffset":-480,"year":117},"id":6,"partsId":14,"partsName":"","problemName":"保险正常但没电","voiceList":[]},{"analysis":"路途坎坷","btx1":"001","btx2":"","btx3":"","createTime":{"date":17,"day":5,"hours":10,"minutes":34,"month":2,"seconds":23,"time":1489718063000,"timezoneOffset":-480,"year":117},"id":7,"partsId":18,"partsName":"","problemName":"歪了","voiceList":[]},{"analysis":"散热故障，水不易冷却","btx1":"K19090","btx2":"","btx3":"","createTime":{"date":20,"day":1,"hours":13,"minutes":29,"month":2,"seconds":3,"time":1489987743000,"timezoneOffset":-480,"year":117},"id":8,"partsId":16,"partsName":"","problemName":"噪音太大","voiceList":[{"analysis":"马达","btx1":"","btx2":"","btx3":"","createTime":{"date":20,"day":1,"hours":13,"minutes":33,"month":2,"seconds":49,"time":1489988029000,"timezoneOffset":-480,"year":117},"id":9,"partsId":16,"partsName":"","problemId":8,"problemName":"","voiceAddress":"voice/20170320/1489987903645172179.mp3","voiceName":"遇见你，牛奶咖啡"}]},{"analysis":"新手操作不熟练","btx1":"123","btx2":"","btx3":"","createTime":{"date":20,"day":1,"hours":16,"minutes":32,"month":2,"seconds":42,"time":1489998762000,"timezoneOffset":-480,"year":117},"id":9,"partsId":17,"partsName":"","problemName":"磨损","voiceList":[{"analysis":"轮胎亏气","btx1":"","btx2":"","btx3":"","createTime":{"date":20,"day":1,"hours":17,"minutes":45,"month":2,"seconds":12,"time":1490003112000,"timezoneOffset":-480,"year":117},"id":14,"partsId":17,"partsName":"","problemId":9,"problemName":"","voiceAddress":"voice/20170320/1490003081194231283.mp3","voiceName":"轮胎亏气检测"}]}]
     * message : {"msg":"查询成功","remark":0,"success":"true","wxMessage":null}
     */

    private MessageBean message;
    private List<ProblemListBean> problemList;

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public List<ProblemListBean> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<ProblemListBean> problemList) {
        this.problemList = problemList;
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

    public static class ProblemListBean implements Serializable{
        /**
         * analysis : 首先检查汽车保险是否损坏，如果损坏进行更换
         * btx1 : 010C
         * btx2 :
         * btx3 :
         * createTime : {"date":28,"day":2,"hours":16,"minutes":13,"month":1,"seconds":6,"time":1488269586000,"timezoneOffset":-480,"year":117}
         * id : 4
         * partsId : 14
         * partsName :
         * problemName : 汽车没电
         * voiceList : [{"analysis":"线路短路`121313123123","btx1":"","btx2":"","btx3":"","createTime":{"date":1,"day":3,"hours":10,"minutes":15,"month":2,"seconds":18,"time":1488334518000,"timezoneOffset":-480,"year":117},"id":2,"partsId":14,"partsName":"","problemId":4,"problemName":"","voiceAddress":"upload/voice/201703011015183987965157650243522dr.mp3","voiceName":"保险声音"},{"analysis":"保险声音22","btx1":"","btx2":"","btx3":"","createTime":{"date":1,"day":3,"hours":10,"minutes":16,"month":2,"seconds":56,"time":1488334616000,"timezoneOffset":-480,"year":117},"id":3,"partsId":14,"partsName":"","problemId":4,"problemName":"","voiceAddress":"upload/voice/201703011029523219153234350997823dr.mp3","voiceName":"汽车保险22"},{"analysis":"噪音","btx1":"","btx2":"","btx3":"","createTime":{"date":16,"day":4,"hours":17,"minutes":7,"month":2,"seconds":10,"time":1489655230000,"timezoneOffset":-480,"year":117},"id":5,"partsId":14,"partsName":"","problemId":4,"problemName":"","voiceAddress":"video/20170316/1489655220244754282.mp3","voiceName":"检测声音"},{"analysis":"22","btx1":"","btx2":"","btx3":"","createTime":{"date":16,"day":4,"hours":17,"minutes":24,"month":2,"seconds":10,"time":1489656250000,"timezoneOffset":-480,"year":117},"id":8,"partsId":14,"partsName":"","problemId":4,"problemName":"","voiceAddress":"voice/20170316/1489656244495534227.mp3","voiceName":"222"}]
         */

        private String analysis;
        private String btx1;
        private String btx2;
        private String btx3;
        private CreateTimeBean createTime;
        private int id;
        private int partsId;
        private String partsName;
        private String problemName;
        private List<VoiceListBean> voiceList;

        public String getAnalysis() {
            return analysis;
        }

        public void setAnalysis(String analysis) {
            this.analysis = analysis;
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

        public String getProblemName() {
            return problemName;
        }

        public void setProblemName(String problemName) {
            this.problemName = problemName;
        }

        public List<VoiceListBean> getVoiceList() {
            return voiceList;
        }

        public void setVoiceList(List<VoiceListBean> voiceList) {
            this.voiceList = voiceList;
        }

        public static class CreateTimeBean implements Serializable{
            /**
             * date : 28
             * day : 2
             * hours : 16
             * minutes : 13
             * month : 1
             * seconds : 6
             * time : 1488269586000
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

        public static class VoiceListBean implements Serializable{
            /**
             * analysis : 线路短路`121313123123
             * btx1 :
             * btx2 :
             * btx3 :
             * createTime : {"date":1,"day":3,"hours":10,"minutes":15,"month":2,"seconds":18,"time":1488334518000,"timezoneOffset":-480,"year":117}
             * id : 2
             * partsId : 14
             * partsName :
             * problemId : 4
             * problemName :
             * voiceAddress : upload/voice/201703011015183987965157650243522dr.mp3
             * voiceName : 保险声音
             */

            private String analysis;
            private String btx1;
            private String btx2;
            private String btx3;
            private CreateTimeBeanX createTime;
            private int id;
            private int partsId;
            private String partsName;
            private int problemId;
            private String problemName;
            private String voiceAddress;
            private String voiceName;

            public String getAnalysis() {
                return analysis;
            }

            public void setAnalysis(String analysis) {
                this.analysis = analysis;
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

            public int getProblemId() {
                return problemId;
            }

            public void setProblemId(int problemId) {
                this.problemId = problemId;
            }

            public String getProblemName() {
                return problemName;
            }

            public void setProblemName(String problemName) {
                this.problemName = problemName;
            }

            public String getVoiceAddress() {
                return voiceAddress;
            }

            public void setVoiceAddress(String voiceAddress) {
                this.voiceAddress = voiceAddress;
            }

            public String getVoiceName() {
                return voiceName;
            }

            public void setVoiceName(String voiceName) {
                this.voiceName = voiceName;
            }

            public static class CreateTimeBeanX implements Serializable{
                /**
                 * date : 1
                 * day : 3
                 * hours : 10
                 * minutes : 15
                 * month : 2
                 * seconds : 18
                 * time : 1488334518000
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
}
