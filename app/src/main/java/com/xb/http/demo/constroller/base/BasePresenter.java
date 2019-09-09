package com.xb.http.demo.constroller.base;

/**
 * @author banXin
 * @date 2018/7/12 0012
 * @purpose:
 */
public class BasePresenter<V extends BaseView> implements MPresenter<V> {

    protected V mView;
    /**
     * Presenter与View建立连接
     *
     * @param mView 与此Presenter相对应的View
     */
    @Override
    public void attachView(V mView) {
        this.mView = mView;
    }

    /**
     * Presenter与View连接断开
     */
    @Override
    public void detachView() {
        this.mView = null;
    }

    /**
     * 是否与View建立连接
     *
     * @return
     */
    public boolean isViewAttached() {
        return mView != null;
    }

    /**
     * 获取当前连接的View
     *
     * @return
     */
    public V getmView() {
        return mView;
    }

}
