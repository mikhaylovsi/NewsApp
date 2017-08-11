package com.example.sergei.newsapp.newsobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergei on 10.08.2017.
 */

public class PieceOfNews {

    @SerializedName("sectionName")
    @Expose
    private String sectionName;

    @SerializedName("webPublicationDate")
    @Expose
    private String webPublicationDate;

    @SerializedName("webTitle")
    @Expose
    private String webTitle;

    @SerializedName("webUrl")
    @Expose
    private String webUrl;

    @SerializedName("author")
    @Expose
    private String author;




    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public void setWebPublicationDate(String webPublicationDate) {
        this.webPublicationDate = webPublicationDate;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
