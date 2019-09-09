package com.xb.http.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.xb.http.demo.constroller.base.BasePresenter;
import com.xb.http.demo.constroller.base.BaseView;

/**
 * @author banXin
 * @date 2019/9/9
 * @Description:
 */
public abstract class BaseActivity<MPresenter extends BasePresenter> extends AppCompatActivity implements BaseView {

    public MPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSystemBarStatus();
        setContentView(getPageLayoutID());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initView();
                initViewListener();
                initData();
            }
        }, 200);
//        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {//主线程空闲时间执行，有个弊端，在手机较卡时会很久后才执行
//            @Override
//            public boolean queueIdle() {
//                initView();
//                initViewListener();
//                initData();
//                return false;
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void mOnResume() {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onBackPressed();
    }

    /**
     * 设置页面布局ID
     *
     * @return
     */
    protected abstract int getPageLayoutID();

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 设置导航栏状态
     */
    protected void initSystemBarStatus() {
    }

    /**
     * 初始化页面控件
     */
    protected void initView() {
    }

    /**
     * 初始化控件监听器
     */
    protected void initViewListener() {
    }

    public void showLoading(String msg) {

    }

    public void hindLoading() {
    }

    /**
     * 信息过期
     */
    public void onTokenExpired() {
    }

    public void onComplete() {
    }

    private void showLoadDialog(String msg) {
    }

    private void hindLoadingDialog() {

    }

}
