package com.xb.http.demo.http;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xb.http.demo.BaseActivity;
import com.xb.http.demo.R;
import com.xb.http.demo.constroller.MainContract;
import com.xb.http.demo.constroller.presenter.MainPresenterImp;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;

public class MainActivity extends BaseActivity<MainPresenterImp> implements MainContract.MainView {
    private final String TAG = "MainActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getPageLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        presenter = new MainPresenterImp(this);
        textView = findViewById(R.id.content);
    }

    @Override
    protected void initData() {
        super.initData();

    }

    public void Post(View view) {
        presenter.postRequest();
    }

    public void Get(View view) {
        presenter.getRequest();
    }

    public void Upload(View view) {
        presenter.uploadRequest();
    }

    public void Download(View view) {
    }

    @Override
    public RequestBody getPostRequestBody() {
        return null;
    }

    @Override
    public void postSuccess(String data) {

    }

    @Override
    public void postFailed(String msg) {

    }

    @Override
    public RequestBody getGostRequestBody() {
        return null;
    }

    @Override
    public void getSuccess(String data) {

    }

    @Override
    public void getFailed(String msg) {

    }

    @Override
    public MultipartBody.Part getUploadRequestPart() {
        File file = new File("");
        okhttp3.RequestBody requestFile = okhttp3.RequestBody.create(MediaType.parse("multipart/form-data"), file);
        return MultipartBody.Part.createFormData("file", file.getName(), requestFile);
    }

    @Override
    public void uploadSuccess(String msg) {

    }

    @Override
    public void uploadFailed(String msg) {

    }
}
