package com.example.sergei.newsapp.newsobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sergei on 10.08.2017.
 */

public class NewsKeeper {

    @SerializedName("results")
    @Expose
    private List<PieceOfNews> news = null;

    public List<PieceOfNews> getNews() {
        return news;
    }

    public void setNews(List<PieceOfNews> news) {
        this.news = news;
    }

}
