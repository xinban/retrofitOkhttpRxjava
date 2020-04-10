package com.xb.http.demo.http;

import io.reactivex.disposables.Disposable;

/**
 * @author banXin
 * @date 2018/8/20 0020
 * @Description:  {@link #onError(Throwable)} 中的onError()与onMError()会同时执行，监听一个即可
 */
public abstract class ProgressObserver<T> extends MyObserver<T> {

    @Override
    public void onSubscribe(Disposable d) {
        super.onSubscribe(d);
    }

    @Override
    public void onSuccess(T t) {
        super.onSuccess(t);
    }

    @Override
    public void onMError(String e) {
        super.onMError(e);
    }

    @Override
    public void onComplete() {
        super.onComplete();
    }
}
