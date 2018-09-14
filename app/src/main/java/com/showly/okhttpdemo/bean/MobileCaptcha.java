package com.showly.okhttpdemo.bean;

/**
 * Created by Administrator on 2018/9/6.
 */

public class MobileCaptcha {

    /**
     * status : 0
     * msg : 该手机获取验证码次数已达上限，请明日再来。
     */

    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
