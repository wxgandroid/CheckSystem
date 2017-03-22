package com.example.windows10.checksystem.bean;

/**
 * Created by Windows10 on 2017/3/7.
 */
public class LoginBean {


    /**
     * user : {"address":"北京","age":1,"birthday":"1978-12-08","bluetooth":"GB0098","brandNme":"","btx1":"","btx2":"","btx3":"","carColour":"","carNumber":"","cardNo":"132788999999999999","characters":"内向","createBy":0,"createTime":{"date":10,"day":5,"hours":15,"minutes":23,"month":1,"seconds":24,"time":1486711404000,"timezoneOffset":-480,"year":117},"crfId":0,"deleted":0,"hobby":"游泳，爬山","id":1,"loginCount":0,"loginPwd":"111111","loginTime":null,"mileage":0,"modelNme":"","nickName":"李扬","phone":"13688999999","sex":1,"state":0,"system":{"audioPath":"http://www.voice.com","btx1":"","btx2":"","btx3":"","createTime":{"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117},"id":1,"inputPath":"http://www.inputpath.com","inspection_frequency":3,"inspection_time":1,"picturePath":"http://www.picture.com","resultPath":"http://www.resultpath.com","updateTime":{"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117},"videoPath":"http://www.video.com"},"updateBy":0,"updateTime":null,"years":""}
     * faultDetection : {"brandId":1,"brandName":"","btx1":"","btx2":"","btx3":"","createTime":{"date":1,"day":3,"hours":13,"minutes":38,"month":2,"seconds":58,"time":1488346738000,"timezoneOffset":-480,"year":117},"faultName":"010W\n010G\n010H","id":1,"modelName":"","modelsId":2,"updateTime":{"date":1,"day":3,"hours":13,"minutes":38,"month":2,"seconds":58,"time":1488346738000,"timezoneOffset":-480,"year":117}}
     * message : {"msg":"登录成功","remark":0,"success":"true","wxMessage":null}
     */

    private UserBean user;
    private FaultDetectionBean faultDetection;
    private MessageBean message;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public FaultDetectionBean getFaultDetection() {
        return faultDetection;
    }

    public void setFaultDetection(FaultDetectionBean faultDetection) {
        this.faultDetection = faultDetection;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public static class UserBean {
        /**
         * address : 北京
         * age : 1
         * birthday : 1978-12-08
         * bluetooth : GB0098
         * brandNme :
         * btx1 :
         * btx2 :
         * btx3 :
         * carColour :
         * carNumber :
         * cardNo : 132788999999999999
         * characters : 内向
         * createBy : 0
         * createTime : {"date":10,"day":5,"hours":15,"minutes":23,"month":1,"seconds":24,"time":1486711404000,"timezoneOffset":-480,"year":117}
         * crfId : 0
         * deleted : 0
         * hobby : 游泳，爬山
         * id : 1
         * loginCount : 0
         * loginPwd : 111111
         * loginTime : null
         * mileage : 0
         * modelNme :
         * nickName : 李扬
         * phone : 13688999999
         * sex : 1
         * state : 0
         * system : {"audioPath":"http://www.voice.com","btx1":"","btx2":"","btx3":"","createTime":{"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117},"id":1,"inputPath":"http://www.inputpath.com","inspection_frequency":3,"inspection_time":1,"picturePath":"http://www.picture.com","resultPath":"http://www.resultpath.com","updateTime":{"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117},"videoPath":"http://www.video.com"}
         * updateBy : 0
         * updateTime : null
         * years :
         */

        private String address;
        private int age;
        private String birthday;
        private String bluetooth;
        private String brandNme;
        private String btx1;
        private String btx2;
        private String btx3;
        private String carColour;
        private String carNumber;
        private String cardNo;
        private String characters;
        private int createBy;
        private CreateTimeBean createTime;
        private int crfId;
        private int deleted;
        private String hobby;
        private int id;
        private int loginCount;
        private String loginPwd;
        private Object loginTime;
        private int mileage;
        private String modelNme;
        private String nickName;
        private String phone;
        private int sex;
        private int state;
        private SystemBean system;
        private int updateBy;
        private Object updateTime;
        private String years;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getBluetooth() {
            return bluetooth;
        }

        public void setBluetooth(String bluetooth) {
            this.bluetooth = bluetooth;
        }

        public String getBrandNme() {
            return brandNme;
        }

        public void setBrandNme(String brandNme) {
            this.brandNme = brandNme;
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

        public String getCarColour() {
            return carColour;
        }

        public void setCarColour(String carColour) {
            this.carColour = carColour;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getCharacters() {
            return characters;
        }

        public void setCharacters(String characters) {
            this.characters = characters;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public int getCrfId() {
            return crfId;
        }

        public void setCrfId(int crfId) {
            this.crfId = crfId;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLoginCount() {
            return loginCount;
        }

        public void setLoginCount(int loginCount) {
            this.loginCount = loginCount;
        }

        public String getLoginPwd() {
            return loginPwd;
        }

        public void setLoginPwd(String loginPwd) {
            this.loginPwd = loginPwd;
        }

        public Object getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(Object loginTime) {
            this.loginTime = loginTime;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public String getModelNme() {
            return modelNme;
        }

        public void setModelNme(String modelNme) {
            this.modelNme = modelNme;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public SystemBean getSystem() {
            return system;
        }

        public void setSystem(SystemBean system) {
            this.system = system;
        }

        public int getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(int updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getYears() {
            return years;
        }

        public void setYears(String years) {
            this.years = years;
        }

        public static class CreateTimeBean {
            /**
             * date : 10
             * day : 5
             * hours : 15
             * minutes : 23
             * month : 1
             * seconds : 24
             * time : 1486711404000
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

        public static class SystemBean {
            /**
             * audioPath : http://www.voice.com
             * btx1 :
             * btx2 :
             * btx3 :
             * createTime : {"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117}
             * id : 1
             * inputPath : http://www.inputpath.com
             * inspection_frequency : 3
             * inspection_time : 1
             * picturePath : http://www.picture.com
             * resultPath : http://www.resultpath.com
             * updateTime : {"date":27,"day":1,"hours":11,"minutes":25,"month":1,"seconds":27,"time":1488165927000,"timezoneOffset":-480,"year":117}
             * videoPath : http://www.video.com
             */

            private String audioPath;
            private String btx1;
            private String btx2;
            private String btx3;
            private CreateTimeBeanX createTime;
            private int id;
            private String inputPath;
            private int inspection_frequency;
            private int inspection_time;
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

            public String getInputPath() {
                return inputPath;
            }

            public void setInputPath(String inputPath) {
                this.inputPath = inputPath;
            }

            public int getInspection_frequency() {
                return inspection_frequency;
            }

            public void setInspection_frequency(int inspection_frequency) {
                this.inspection_frequency = inspection_frequency;
            }

            public int getInspection_time() {
                return inspection_time;
            }

            public void setInspection_time(int inspection_time) {
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

            public static class CreateTimeBeanX {
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
    }

    public static class FaultDetectionBean {
        /**
         * brandId : 1
         * brandName :
         * btx1 :
         * btx2 :
         * btx3 :
         * createTime : {"date":1,"day":3,"hours":13,"minutes":38,"month":2,"seconds":58,"time":1488346738000,"timezoneOffset":-480,"year":117}
         * faultName : 010W
         010G
         010H
         * id : 1
         * modelName :
         * modelsId : 2
         * updateTime : {"date":1,"day":3,"hours":13,"minutes":38,"month":2,"seconds":58,"time":1488346738000,"timezoneOffset":-480,"year":117}
         */

        private int brandId;
        private String brandName;
        private String btx1;
        private String btx2;
        private String btx3;
        private CreateTimeBeanXX createTime;
        private String faultName;
        private int id;
        private String modelName;
        private int modelsId;
        private UpdateTimeBeanX updateTime;

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

        public String getFaultName() {
            return faultName;
        }

        public void setFaultName(String faultName) {
            this.faultName = faultName;
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

        public int getModelsId() {
            return modelsId;
        }

        public void setModelsId(int modelsId) {
            this.modelsId = modelsId;
        }

        public UpdateTimeBeanX getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(UpdateTimeBeanX updateTime) {
            this.updateTime = updateTime;
        }

        public static class CreateTimeBeanXX {
            /**
             * date : 1
             * day : 3
             * hours : 13
             * minutes : 38
             * month : 2
             * seconds : 58
             * time : 1488346738000
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

        public static class UpdateTimeBeanX {
            /**
             * date : 1
             * day : 3
             * hours : 13
             * minutes : 38
             * month : 2
             * seconds : 58
             * time : 1488346738000
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
         * msg : 登录成功
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
