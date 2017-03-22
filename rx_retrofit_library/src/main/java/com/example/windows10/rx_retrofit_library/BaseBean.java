package com.example.windows10.rx_retrofit_library;

/**
 * Created by Windows10 on 2017/2/17.
 */
public class BaseBean {

    /**
     * success : false
     * msg : 追溯码错误，请确认追溯码是否正确!
     */

    private boolean success;
    private String msg;

    public void test() {
        RxUtils instance = RxUtils.getInstance();
        instance.get("", "", null, new RxUtils.LoadingNetDataListener<BaseBean>() {
            @Override
            public void onSuccess(BaseBean data) {
//                http://118.178.226.90:80/newLand/anzhuo/getzsm.do?
            }

            @Override
            public void onError(String msg) {

            }

            @Override
            public void onComplete() {

            }
        }, BaseBean.class);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
