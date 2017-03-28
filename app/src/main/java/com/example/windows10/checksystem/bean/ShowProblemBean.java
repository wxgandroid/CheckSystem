package com.example.windows10.checksystem.bean;

import com.example.windows10.rx_retrofit_library.bean.BaseBean;

import java.util.List;

/**
 * Created by Windows10 on 2017/3/28.
 */
public class ShowProblemBean extends BaseBean {


    private List<ProblemListBean> problemList;

    public List<ProblemListBean> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<ProblemListBean> problemList) {
        this.problemList = problemList;
    }

    public static class ProblemListBean {
        /**
         * analysis : 首先检查灯泡是否损坏，如果损坏进行更换
         * btx1 : 010A
         * btx2 :
         * btx3 :
         * createTime : {"date":28,"day":2,"hours":16,"minutes":14,"month":1,"seconds":47,"time":1488269687000,"timezoneOffset":-480,"year":117}
         * id : 5
         * partsId : 15
         * partsName :
         * problemName : 大灯不亮
         * voiceList : []
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
        private List<?> voiceList;

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

        public List<?> getVoiceList() {
            return voiceList;
        }

        public void setVoiceList(List<?> voiceList) {
            this.voiceList = voiceList;
        }

        public static class CreateTimeBean {
            /**
             * date : 28
             * day : 2
             * hours : 16
             * minutes : 14
             * month : 1
             * seconds : 47
             * time : 1488269687000
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
