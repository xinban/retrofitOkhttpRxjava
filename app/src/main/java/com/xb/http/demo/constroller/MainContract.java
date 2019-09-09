package com.xb.http.demo.constroller;

import com.xb.http.demo.http.RequestBody;
import com.xb.http.demo.constroller.base.BaseView;

import okhttp3.MultipartBody;

/**
 * @author banXin
 * @date 2019/9/9
 * @Description:
 */
public interface MainContract {

    interface MainModel {
        void postRequest1(RequestBody body,MainCallback callback);
        void postRequest2(String params,MainCallback callback);

        void getRequest(RequestBody body,MainCallback callback);
        void getRequest2(String params,MainCallback callback);

        void uploadRequest(MultipartBody.Part part, MainCallback callback);
    }

    interface MainView extends BaseView {
        RequestBody getPostRequestBody();
        void postSuccess(String data);

        void postFailed(String msg);
        RequestBody getGostRequestBody();
        void getSuccess(String data);

        void getFailed(String msg);
        MultipartBody.Part getUploadRequestPart();
        void uploadSuccess(String msg);

        void uploadFailed(String msg);
    }

    interface MainPresenter {
        void postRequest();

        void getRequest();

        void uploadRequest();
    }

    interface MainCallback {
        void postSuccess(String data);

        void postFailed(String msg);

        void getSuccess(String data);

        void getFailed(String msg);

        void uploadSuccess(String msg);

        void uploadFailed(String msg);

        void onComplete();
    }
}
