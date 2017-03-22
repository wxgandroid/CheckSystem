package com.example.windows10.checksystem.bean;

/**
 * Created by Windows10 on 2017/3/14.
 */
public class CheckResultBean {

    /**
     * contentResults : 4 汽车没电,spareParts:{price:40.0,manualPrice:100.0,btx1:1小时,btx2:汽车保险};5 大灯不亮,spareParts:{price:500.0,manualPrice:200.0,btx1:null,btx2:null};6 保险正常但没电,spareParts:{price:500.0,manualPrice:200.0,btx1:null,btx2:null};
     * message : {"msg":"获取结果成功","remark":0,"success":"true","wxMessage":null}
     */

    private String contentResults;
    private MessageBean message;

    public String getContentResults() {
        return contentResults;
    }

    public void setContentResults(String contentResults) {
        this.contentResults = contentResults;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public static class MessageBean {
        /**
         * msg : 获取结果成功
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
