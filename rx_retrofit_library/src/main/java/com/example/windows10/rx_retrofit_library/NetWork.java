package com.example.windows10.rx_retrofit_library;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Windows10 on 2017/2/17.
 */
public interface NetWork {
    @GET
    Observable<String> get(@Url String url);

    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<String> post(@Url String url);

    @POST
    Observable<String> post(@Url String url, @QueryMap Map<String, String> map);

}