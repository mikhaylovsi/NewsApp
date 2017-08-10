package com.example.sergei.newsapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.sergei.newsapp.Adapters.NewsAdapter;
import com.example.sergei.newsapp.NewsObjects.PieceOfNews;
import com.example.sergei.newsapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView newsList = (RecyclerView) findViewById(R.id.rv_news);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        newsList.setLayoutManager(linearLayoutManager);

        List<PieceOfNews> news = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            PieceOfNews pieceOfNews = new PieceOfNews();
            pieceOfNews.setAuthor("author" + i);
            pieceOfNews.setSectionName("sectionName" + i);
            pieceOfNews.setWebPublicationDate("webPublicationDate" + i);
            pieceOfNews.setWebTitle("webTitle" + i);

            news.add(pieceOfNews);

        }

        NewsAdapter newsAdapter = new NewsAdapter(news);
        newsList.setAdapter(newsAdapter);



    }
}
