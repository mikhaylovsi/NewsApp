package com.example.sergei.newsapp.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.example.sergei.newsapp.adapters.NewsAdapter;
import com.example.sergei.newsapp.app.App;
import com.example.sergei.newsapp.network.NewsApi;
import com.example.sergei.newsapp.newsobjects.NewsAnswer;
import com.example.sergei.newsapp.newsobjects.PieceOfNews;
import com.example.sergei.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    NewsApi newsApi;
    RecyclerView newsList;
    List<PieceOfNews> news = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getAppComponent().inject(this);
        newsList = (RecyclerView) findViewById(R.id.rv_news);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        newsList.setLayoutManager(linearLayoutManager);


        newsApi.getData("sport", "test")
                .map(new Func1<NewsAnswer, List<PieceOfNews>>() {
                    @Override
                    public List<PieceOfNews> call(NewsAnswer newsAnswer) {
                        return newsAnswer.getNewsKeeper().getNews();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<PieceOfNews>>() {
                    @Override
                    public void call(List<PieceOfNews> news) {


                        MainActivity.this.news.clear();
                        MainActivity.this.news.addAll(news);
                        updateNews();

                    }
                });


    }


    private void updateNews() {

        NewsAdapter newsAdapter = (NewsAdapter) newsList.getAdapter();
        if(newsAdapter == null){
            newsAdapter = new NewsAdapter(news);
            newsList.setAdapter(newsAdapter);
        }

       newsAdapter.notifyDataSetChanged();


    }
}
