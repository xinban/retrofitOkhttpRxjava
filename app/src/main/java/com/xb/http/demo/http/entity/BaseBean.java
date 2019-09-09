package com.xb.http.demo.http.entity;

/**
 * @author banXin
 * @date 2019/9/9
 * @Description:
 */
public class BaseBean {

    private  String msg;
    private int code;

    String data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
