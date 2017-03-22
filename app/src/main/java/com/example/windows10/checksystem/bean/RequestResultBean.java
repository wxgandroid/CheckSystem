package com.example.windows10.checksystem.bean;

/**
 * Created by Windows10 on 2017/3/14.
 */
public class RequestResultBean {

    /**
     * contentResults : C1102 蓄电池电压低,P0261 喷油嘴电路/短路,0010  蓄电池漂移
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
