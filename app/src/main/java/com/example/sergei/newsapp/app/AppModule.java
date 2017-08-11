package com.example.sergei.newsapp.app;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.sergei.newsapp.network.NewsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sergei on 11.08.2017.
 */

@Module
public class AppModule {

    private Context appContext;

    public AppModule(@NonNull Context context){
        appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return appContext;
    }


    @Provides
    @Singleton
    public NewsApi provideNewsApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://content.guardianapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(NewsApi.class);
    }

}
