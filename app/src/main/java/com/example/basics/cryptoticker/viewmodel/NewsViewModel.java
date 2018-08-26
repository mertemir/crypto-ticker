package com.example.basics.cryptoticker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.basics.cryptoticker.Repository;
import com.example.basics.cryptoticker.data.model.pojo.News;

import java.util.List;

import javax.inject.Inject;

public class NewsViewModel extends AndroidViewModel{

    private MutableLiveData<List<News.Article>> news;

    @Inject
    public NewsViewModel(@NonNull Repository repository, @NonNull Application application) {
        super(application);
        news = repository.getNewsData();
    }

    public MutableLiveData<List<News.Article>> getNews() { return this.news;}

}
