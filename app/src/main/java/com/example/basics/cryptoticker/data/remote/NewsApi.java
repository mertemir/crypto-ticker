package com.example.basics.cryptoticker.data.remote;

import com.example.basics.cryptoticker.data.model.News;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {

    @GET("top-headlines?sources=crypto-coins-news&apiKey=050858b30f444854972929cf88c3b49d")
    Call<News> getNews();

}
