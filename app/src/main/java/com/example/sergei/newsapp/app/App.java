package com.example.sergei.newsapp.app;

import android.app.Application;

/**
 * Created by Sergei on 11.08.2017.
 */

public class App extends Application {

    private static AppComponent component;
    public static AppComponent getAppComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = generateAppComponent();
    }

    protected AppComponent generateAppComponent(){
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

}
