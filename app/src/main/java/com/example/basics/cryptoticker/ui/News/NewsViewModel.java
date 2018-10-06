package com.example.basics.cryptoticker.ui.News;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.basics.cryptoticker.data.Repository;
import com.example.basics.cryptoticker.data.model.News;

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
