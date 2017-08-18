package com.example.sergei.newsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sergei.newsapp.adapters.NewsAdapter;
import com.example.sergei.newsapp.app.App;
import com.example.sergei.newsapp.network.NewsLoader;
import com.example.sergei.newsapp.newsobjects.PieceOfNews;
import com.example.sergei.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView newsList;
    EditText editText;
    Button searchButton;

    List<PieceOfNews> news = new ArrayList<>();


    @Inject
    NewsLoader newsLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getAppComponent().inject(this);



        newsList = (RecyclerView) findViewById(R.id.rv_news);
        editText = (EditText) findViewById(R.id.searchText);
        searchButton = (Button) findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = editText.getText().toString();
                newsLoader.updateData(searchText, "test");
                editText.clearFocus();
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        newsList.setLayoutManager(linearLayoutManager);

        newsLoader.subscribeNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<PieceOfNews>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<PieceOfNews> news) {
                        MainActivity.this.news.clear();
                        MainActivity.this.news.addAll(news);

                        updateNews();

                        if(news.size() == 0){
                            editText.requestFocus();
                        }
                    }
                });
    }


    @Override
    protected void onResume() {
        super.onResume();

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
