package com.xb.http.demo.constroller.base;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author banXin
 * @date 2018/7/12 0012
 * @purpose:
 */
public class BasePresenter<V extends BaseView> implements MPresenter<V> {
    protected WeakReference<V> mWeakreView;
    protected V mView;

    protected V proxyView;

    /**
     * Presenter与View建立连接
     *
     * @param mView 与此Presenter相对应的View
     */
    @Override
    public void attachView(V mView) {
        if (mWeakreView == null) {
            mWeakreView = new WeakReference<V>(mView);
        }
        proxyView = (V) Proxy.newProxyInstance(mView.getClass().getClassLoader(), mView.getClass().getInterfaces(), new MInvocationHandler(mWeakreView.get()));
    }
 
    /**
     * Presenter与View连接断开
     */
    @Override
    public void detachView() {
        if (isViewAttached()) {
            mWeakreView.clear();
            mWeakreView = null;
        }
    }

    /**
     * 是否与View建立连接
     *
     * @return
     */
    public boolean isViewAttached() {
        return mWeakreView != null && mWeakreView.get() != null;
    }

    /**
     * 获取当前连接的View
     *
     * @return
     */
    public V getmView() {
        return proxyView;
    }


    private class MInvocationHandler implements InvocationHandler {
        private BaseView mView;

        public MInvocationHandler(BaseView view) {
            mView = view;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (isViewAttached()) {
                return method.invoke(mView, args);
            }
            return null;
        }
    }

}
