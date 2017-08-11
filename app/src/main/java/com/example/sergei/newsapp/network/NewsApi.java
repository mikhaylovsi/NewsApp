package com.example.sergei.newsapp.network;


import com.example.sergei.newsapp.newsobjects.NewsAnswer;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Sergei on 11.08.2017.
 */

public interface NewsApi {

    @GET("search")
    Observable<NewsAnswer> getData(@Query("q") String resourceName, @Query("api-key") String key);

}
