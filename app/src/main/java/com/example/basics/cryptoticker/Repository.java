package com.example.basics.cryptoticker;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.basics.cryptoticker.data.db.dao.CryptoDao;
import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;
import com.example.basics.cryptoticker.data.model.CryptoHistory;
import com.example.basics.cryptoticker.data.model.Cryptocurrency;
import com.example.basics.cryptoticker.data.model.IBitcoinAverageApi;
import com.example.basics.cryptoticker.data.Parser;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class Repository {

    private final IBitcoinAverageApi bitcoinAverageApi;

    @Inject
    public Repository(@NonNull IBitcoinAverageApi bitcoinAverageApi) {
        this.bitcoinAverageApi = bitcoinAverageApi;
    }

    public LiveData<CryptoEntity> getBitcoinUSD() { return App.cryptoDatabase.cryptoDao().getCoin(); }

    @NonNull
    public MutableLiveData<List<CryptoHistory>> getBitcoinUsdDaily() {

        final MutableLiveData<List<CryptoHistory>> bitcoinDaily = new MutableLiveData<>();

        bitcoinAverageApi.getCoinUsdDaily("global","BTC").enqueue(new Callback<List<CryptoHistory>>() {

            @Override
            public void onResponse(Call<List<CryptoHistory>> call, Response<List<CryptoHistory>> response) { bitcoinDaily.setValue(response.body()); }

            @Override
            public void onFailure(Call<List<CryptoHistory>> call, Throwable t) { }
        });
        return bitcoinDaily;
    }

    public void getCoin(String symbol_set,String coinName){
        bitcoinAverageApi.getCoinUsd(symbol_set,coinName).enqueue(new Callback<Cryptocurrency>() {
            @Override
            public void onResponse(Call<Cryptocurrency> call, Response<Cryptocurrency> response) {
               App.cryptoDatabase.cryptoDao().insertCoin(Parser.getCryptocurrencyEntityFromCryptocurrency(response.body()));
            }

            @Override
            public void onFailure(Call<Cryptocurrency> call, Throwable t) {

            }
        });
    }
}
