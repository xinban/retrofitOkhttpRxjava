package com.xb.http.demo.constroller.base;

/**
 * @author banXin
 * @date 2018/7/12 0012
 * @purpose:
 */
public interface MPresenter<V extends BaseView> {

    /**
     * Presenter与View建立连接
     *
     * @param mvpView 与此Presenter相对应的View
     */
    void attachView(V mvpView);

    /**
     * Presenter与View连接断开
     */
    void detachView();

    boolean isViewAttached();
}
