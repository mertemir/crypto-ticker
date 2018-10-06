package com.example.basics.cryptoticker.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.data.Parser;
import com.example.basics.cryptoticker.data.db.entity.AlarmEntity;
import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;
import com.example.basics.cryptoticker.data.model.CryptoHistory;
import com.example.basics.cryptoticker.data.model.Cryptocurrency;
import com.example.basics.cryptoticker.data.model.News;
import com.example.basics.cryptoticker.data.remote.IBitcoinAverageApi;
import com.example.basics.cryptoticker.data.remote.NewsApi;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class Repository {

    private final IBitcoinAverageApi bitcoinAverageApi;
    private final NewsApi newsApi;

    @Inject
    public Repository(@NonNull IBitcoinAverageApi bitcoinAverageApi, @NonNull NewsApi newsApi) {
        this.bitcoinAverageApi = bitcoinAverageApi;
        this.newsApi = newsApi;
    }

    public LiveData<CryptoEntity> getBitcoinUSD() { return App.cryptoDatabase.cryptoDao().getCoin(); }

    public LiveData<List<AlarmEntity>> getActiveAlarms() { return App.cryptoDatabase.alarmDao().getAlarms(); }


    public void insertAlarm(AlarmEntity alarmEntity) { App.cryptoDatabase.alarmDao().insertAlarm(alarmEntity); }

    private void insertCoinData(CryptoEntity cryptoEntity) { App.cryptoDatabase.cryptoDao().insertCoin(cryptoEntity); }

    public LiveData<List<CryptoHistory>> getBitcoinUsdDaily() {

        final MutableLiveData<List<CryptoHistory>> bitcoinDaily = new MutableLiveData<>();

        bitcoinAverageApi.getCoinUsdDaily("global","BTC").enqueue(new Callback<List<CryptoHistory>>() {

            @Override
            public void onResponse(Call<List<CryptoHistory>> call, Response<List<CryptoHistory>> response) {
                bitcoinDaily.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CryptoHistory>> call, Throwable t) { }
        });
        return bitcoinDaily;
    }

    public void getCoinData(String symbol_set,String coinName){
        bitcoinAverageApi.getCoinUsd(symbol_set,coinName).enqueue(new Callback<Cryptocurrency>() {
            @Override
            public void onResponse(Call<Cryptocurrency> call, Response<Cryptocurrency> response) {
                insertCoinData(Parser.getCryptocurrencyEntityFromCryptocurrency(response.body()));
            }

            @Override
            public void onFailure(Call<Cryptocurrency> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<List<News.Article>> getNewsData(){
        final MutableLiveData<List<News.Article>> news = new MutableLiveData<>();

        newsApi.getNews().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                news.setValue(response.body().articles);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return news;
    }
}
