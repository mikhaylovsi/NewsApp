package com.example.sergei.newsapp.newsobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergei on 10.08.2017.
 */

public class NewsAnswer {

    @SerializedName("response")
    @Expose
    private NewsKeeper newsKeeper;


    public void setNews(NewsKeeper news) {
        this.newsKeeper = news;
    }

    public NewsKeeper getNewsKeeper() {
        return newsKeeper;
    }
}
