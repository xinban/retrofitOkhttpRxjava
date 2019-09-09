package com.xb.http.demo.http;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * @author banXin
 * @date 2019/9/5
 * @Description: 请求参数
 */

public class RequestBody1 {

    private HashMap<String, Object> header = new HashMap<>();
    private HashMap<String, Object> content = new HashMap<>();


    public RequestBody1() {
    }

    public void put(String key, Object value) {
        content.put(key, value);
    }

    public void header(String key, Object value) {
        header.put(key, value);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static RequestBody1 create(String key, Object value) {
        RequestBody1 body = new RequestBody1();
        body.put(key, value);
        return body;
    }

}
