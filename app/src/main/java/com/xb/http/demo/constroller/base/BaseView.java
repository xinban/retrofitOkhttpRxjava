package com.xb.http.demo.constroller.base;

/**
 * @author banXin
 * @date 2019/9/9
 * @Description:
 */
public interface BaseView {
    void showLoading(String msg);

    void hindLoading();

    void onComplete();

    void onTokenExpired();
}
