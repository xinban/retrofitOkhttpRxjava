package com.xb.http.demo.http;

import com.xb.http.demo.BuildConfig;

import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author banXin
 * @date 2018/7/11
 * @purpose:
 */
public class RetrofitHelper {

    private static OkHttpClient mOkHttpClient;

    static {
        initOkHttpClient();
    }

    private static Api api;

    public static Api getApi() {
        if (api == null) {
            api = createApi();
        }
        return api;
    }

    /**
     * 根据传入的baseUrl，和api创建retrofit
     */
    public static <T> T createApi(Class<T> clazz, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

    /**
     * 默认
     */
    public static <T> T createApi(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Host)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

    /**
     * 默认
     */
    public static Api createApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Host)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Api.class);
    }

    private static void initOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (mOkHttpClient == null) {

                    //设置Http缓存
                    Cache cache = new Cache(new File(FileHelper.getInstance().getExternalStorePath(), "HttpCache"), 1024 * 1024 * 10);

                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .cache(cache)
                            .addNetworkInterceptor(new RetrofitHelper.CacheInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .addInterceptor(new RetrofitHelper.CommonInterceptor())
                            .addInterceptor(new RetrofitHelper.UserAgentInterceptor());

                    if (!BuildConfig.DEBUG) {//是否允许代理,禁止设置代理
                        builder.proxy(Proxy.NO_PROXY);
                        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY);//打印
                        builder.addInterceptor(logging);
                    }
                    mOkHttpClient = builder.build();
                }
            }
        }
    }

    /**
     * 为OkHttp添加缓存，这里是考虑到服务器不支持缓存时，从而让okhttp支持缓存
     */
    private static class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            // 有网络时 设置缓存超时时间1个小时
            int maxAge = 60 * 60;
            // 无网络时，设置超时为1天
            int maxStale = 60 * 60 * 24;
            Request request = chain.request();
//            if (NetWorkUtils.isConnected()) {
            //有网络时只从网络获取
            request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
//            } else {
//                //无网络时只从缓存中读取
//                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
//            }
            Response response = chain.proceed(request);
//            if (NetWorkUtils.isConnected()) {
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
//            } else {
//                response = response.newBuilder()
//                        .removeHeader("Pragma")
//                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                        .build();
//            }
            return response;
        }
    }

    /**
     * 拦截器使用，修改User-Agent
     */
    private static class UserAgentInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request requestWithUserAgent = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", "Android/1.0")
                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }


    private static class CommonInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request oldRequest = chain.request();
            // 添加新的参数
            HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                    .newBuilder()
                    .scheme(oldRequest.url().scheme())
                    .host(oldRequest.url().host());

            // 新的请求
            Request.Builder builder = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .url(authorizedUrlBuilder.build());


            Request newRequest = builder.build();


            return chain.proceed(newRequest);
        }
    }

}
