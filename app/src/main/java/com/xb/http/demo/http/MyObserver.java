package com.xb.http.demo.http;


import com.xb.http.demo.http.entity.BaseBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class MyObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        BaseBean baseBean = (BaseBean) t;
//        if (baseBean.getCode() == 2001) {
//            onTokenExpired();
//        } else {
        onSuccess(t);
//        }
    }

    @Override
    public void onError(Throwable e) {
        onMError(e.getMessage());
        onComplete();
    }

    @Override
    public void onComplete() {
    }

    public void onSuccess(T t) {
    }

    /**
     * 自定义错误信息，方便后期针对错误集中处理
     *
     * @param e
     */
    public void onMError(String e) {
    }

    /**
     * 信息过期
     */
    public void onTokenExpired() {
    }

}
