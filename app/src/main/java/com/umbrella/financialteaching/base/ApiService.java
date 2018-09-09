package com.umbrella.financialteaching.base;

import com.umbrella.financialteaching.model.NewsDetail;
import com.umbrella.financialteaching.model.VideoModel;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by chenjun on 18/9/9.
 */

public interface ApiService {
    String HOST = "";
    String API_SERVER_URL = "";

    String HOST_VIDEO = "";
    String URL_VIDEO = "";

    @GET
    Observable<ResponseResult<NewsDetail>> getNewsDetail(@Url String url);

    @GET
    Observable<String> getVideoHtml(@Url String url);

    @GET
    Observable<ResponseResult<VideoModel>> getVideoData(@Url String url);

    @GET
    Observable<ResponseBody> getImage(@Url String url);
}
