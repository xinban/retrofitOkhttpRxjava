package com.xb.http.demo.http;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * @author banXin
 * @date 2019/9/5
 * @Description: 请求参数
 */

public class RequestBody {

    private HashMap<String, Object> content = new HashMap<>();


    public RequestBody() {
    }

    public void put(String key, Object value) {
        content.put(key, value);
    }


    @Override
    public String toString() {
        return new Gson().toJson(content);
    }

    public static RequestBody create(String key, Object value) {
        RequestBody body = new RequestBody();
        body.put(key, value);
        return body;
    }

}
