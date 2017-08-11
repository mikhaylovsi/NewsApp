package com.example.sergei.newsapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergei.newsapp.newsobjects.PieceOfNews;
import com.example.sergei.newsapp.R;

import java.util.List;

/**
 * Created by Sergei on 10.08.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<PieceOfNews> news;

    public NewsAdapter(List<PieceOfNews> news){
        this.news = news;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemNews = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);

        return new NewsViewHolder(itemNews);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        PieceOfNews pieceOfNews = news.get(position);

        holder.webTitle.setText(pieceOfNews.getWebTitle());
        holder.sectionName.setText(pieceOfNews.getSectionName());
        holder.author.setText(pieceOfNews.getAuthor());
        holder.webPublicationDate.setText(pieceOfNews.getWebPublicationDate());

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

     static class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView webTitle;
        TextView sectionName;
        TextView author;
        TextView webPublicationDate;


         NewsViewHolder(View itemView) {
            super(itemView);
            webTitle = (TextView)itemView.findViewById(R.id.webTitle);
            sectionName = (TextView)itemView.findViewById(R.id.sectionName);
            author = (TextView)itemView.findViewById(R.id.author);
            webPublicationDate = (TextView)itemView.findViewById(R.id.webPublicationDate);
        }
    }
}
