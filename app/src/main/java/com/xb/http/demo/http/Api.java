package com.xb.http.demo.http;

import com.xb.http.demo.http.entity.BaseBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Api {

    String Host = "https://xxxxxxxxxxxxx.com";

    String apiVersion = "/api/v1.8.1";//服务器版本号

    String login = apiVersion + "/app/auth/login";

    /**
     * post
     *
     * @return
     */
    @POST(login)
    Observable<BaseBean> postRequest1(@Body RequestBody pa);

    /**
     * post
     *
     * @return
     */
    @FormUrlEncoded
    @POST(login)
    Observable<BaseBean> postRequest2(@Field("xxxx") String params);

    /**
     * post
     *
     * @return
     */
    @FormUrlEncoded
    @POST("{PATH}")
    Observable<BaseBean> recordCommonVideo(@Path(value = "PATH", encoded = true) String path, @FieldMap Map<String, String> params);

    /**
     * get
     *
     * @return
     */
    @GET(login)
    Observable<BaseBean> getRequest1(@Body RequestBody body);

    /**
     * get
     *
     * @return
     */
    @GET(login)
    Observable<BaseBean> getRequest2(@Query("xxxx") String params);

    @GET("{PATH}")
    Observable<String> loadTrainingTaskDetailInfo(@Path(value = "PATH", encoded = true) String path, @QueryMap Map<String, String> params);


    /**
     * upload
     * @param part
     * @return
     */
    @Multipart
    @POST(apiVersion + "/common/file/add")
    Observable<BaseBean> uploadFile(@Part MultipartBody.Part part);
}
