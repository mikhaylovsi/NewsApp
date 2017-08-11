package com.example.sergei.newsapp.app;

import com.example.sergei.newsapp.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Sergei on 11.08.2017.
 */

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(MainActivity mainActivity);

}
