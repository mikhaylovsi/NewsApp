package com.example.sergei.newsapp.NewsObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergei on 10.08.2017.
 */

public class NewsAnswer {

    @SerializedName("response")
    @Expose
    private News news;


    public void setNews(News news) {
        this.news = news;
    }

    public News getNews() {
        return news;
    }
}
