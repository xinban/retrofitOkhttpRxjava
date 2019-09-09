package com.xb.http.demo.constroller.model;

import com.xb.http.demo.constroller.MainContract;
import com.xb.http.demo.http.ProgressObserver;
import com.xb.http.demo.http.RequestBody;
import com.xb.http.demo.http.RetrofitHelper;
import com.xb.http.demo.http.entity.BaseBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * @author banXin
 * @date 2019/9/9
 * @Description:
 */
public class MainModelImp implements MainContract.MainModel {

    @Override
    public void postRequest1(RequestBody body, final MainContract.MainCallback callback) {
        RetrofitHelper
                .createApi()
                .postRequest1(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        super.onSuccess(baseBean);
                        if (callback != null) {
                            callback.postSuccess("");
                        }
                    }

                    @Override
                    public void onMError(String e) {
                        super.onMError(e);
                        if (callback != null) {
                            callback.postFailed(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        if (callback != null) {
                            callback.onComplete();
                        }
                    }
                });
    }

    @Override
    public void postRequest2(String params, final MainContract.MainCallback callback) {
        RetrofitHelper
                .createApi()
                .postRequest2(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        super.onSuccess(baseBean);
                        if (callback != null) {
                            callback.postSuccess("");
                        }
                    }

                    @Override
                    public void onMError(String e) {
                        super.onMError(e);
                        if (callback != null) {
                            callback.postFailed(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        if (callback != null) {
                            callback.onComplete();
                        }
                    }
                });
    }

    @Override
    public void getRequest(RequestBody body, final MainContract.MainCallback callback) {
        RetrofitHelper
                .createApi()
                .getRequest1(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        super.onSuccess(baseBean);
                        if (callback != null) {
                            callback.postSuccess("");
                        }
                    }

                    @Override
                    public void onMError(String e) {
                        super.onMError(e);
                        if (callback != null) {
                            callback.postFailed(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        if (callback != null) {
                            callback.onComplete();
                        }
                    }
                });
    }

    @Override
    public void getRequest2(String params, final MainContract.MainCallback callback) {
        RetrofitHelper
                .createApi()
                .getRequest2(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        super.onSuccess(baseBean);
                        if (callback != null) {
                            callback.postSuccess("");
                        }
                    }

                    @Override
                    public void onMError(String e) {
                        super.onMError(e);
                        if (callback != null) {
                            callback.postFailed(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        if (callback != null) {
                            callback.onComplete();
                        }
                    }
                });
    }

    @Override
    public void uploadRequest(MultipartBody.Part part, MainContract.MainCallback callback) {
        RetrofitHelper
                .createApi()
                .uploadFile(part)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        super.onSuccess(baseBean);
                    }

                    @Override
                    public void onMError(String e) {
                        super.onMError(e);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                });
    }
}
