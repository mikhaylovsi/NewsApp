package com.example.sergei.newsapp.network;

import com.example.sergei.newsapp.app.App;
import com.example.sergei.newsapp.newsobjects.NewsAnswer;
import com.example.sergei.newsapp.newsobjects.PieceOfNews;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by Sergei on 11.08.2017.
 */

public class NewsLoader {

    @Inject
    NewsApi newsApi;

    public BehaviorSubject<List<PieceOfNews>> newsSubject = BehaviorSubject.<List<PieceOfNews>>create(new ArrayList<PieceOfNews>());

    public NewsLoader() {

        App.getAppComponent().inject(this);

    }


    public void updateData(String searchText, String key){

        newsApi.getData(searchText, key)
                .map(new Func1<NewsAnswer, List<PieceOfNews>>() {
                    @Override
                    public List<PieceOfNews> call(NewsAnswer newsAnswer) {
                        return newsAnswer.getNewsKeeper().getNews();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Action1<List<PieceOfNews>>() {
                    @Override
                    public void call(List<PieceOfNews> news) {
                        newsSubject.onNext(news);
                    }
                });

    }

    public Observable<List<PieceOfNews>> subscribeNews(){

        return newsSubject.asObservable();

    }


}
