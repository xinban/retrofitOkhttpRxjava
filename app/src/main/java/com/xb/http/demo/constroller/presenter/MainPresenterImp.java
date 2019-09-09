package com.xb.http.demo.constroller.presenter;

import com.xb.http.demo.constroller.MainContract;
import com.xb.http.demo.constroller.base.BasePresenter;
import com.xb.http.demo.constroller.model.MainModelImp;

/**
 * @author banXin
 * @date 2019/9/9
 * @Description:
 */
public class MainPresenterImp extends BasePresenter<MainContract.MainView> implements MainContract.MainPresenter {

    private MainContract.MainModel model;

    public MainPresenterImp(MainContract.MainView mainView) {
        mView = mainView;
        model = new MainModelImp();
    }

    @Override
    public void postRequest() {
        if (isViewAttached()) {
            model.postRequest1(mView.getPostRequestBody(), callback);
        }
    }

    @Override
    public void getRequest() {
        if (isViewAttached()) {
            model.getRequest(mView.getGostRequestBody(), callback);
        }
    }

    @Override
    public void uploadRequest() {
        if (isViewAttached()) {
            model.uploadRequest(mView.getUploadRequestPart(), callback);
        }
    }

    @Override
    public void detachView() {
        super.detachView();
        if (callback != null) {
            callback = null;
        }
    }

    private MainContract.MainCallback callback = new MainContract.MainCallback() {
        @Override
        public void postSuccess(String data) {

        }

        @Override
        public void postFailed(String msg) {

        }

        @Override
        public void getSuccess(String data) {

        }

        @Override
        public void getFailed(String msg) {

        }

        @Override
        public void uploadSuccess(String msg) {

        }

        @Override
        public void uploadFailed(String msg) {

        }

        @Override
        public void onComplete() {

        }
    };
}
