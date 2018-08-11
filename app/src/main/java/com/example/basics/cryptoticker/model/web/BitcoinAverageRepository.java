package com.example.basics.cryptoticker.model.web;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.model.data.Cryptocurrency;
import com.example.basics.cryptoticker.model.data.CryptoHistory;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class BitcoinAverageRepository {

    private final IBitcoinAverageApi bitcoinAverageApi;
    private final IBitcoinAverageSocketApi bitcoinAverageSocketApi;
    private final OkHttpClient client;

    @Inject
    public BitcoinAverageRepository(@NonNull IBitcoinAverageApi bitcoinAverageApi, @NonNull IBitcoinAverageSocketApi bitcoinAverageSocketApi, OkHttpClient client) {
        this.bitcoinAverageApi = bitcoinAverageApi;
        this.bitcoinAverageSocketApi = bitcoinAverageSocketApi;
        this.client = client;
    }

    public void getBitcoinUSD() {

        bitcoinAverageApi.getBitcoinUsd().enqueue(new Callback<Cryptocurrency>() {
            @Override
            public void onResponse(Call<Cryptocurrency> call, Response<Cryptocurrency> response) {
                App.bitcoinPrice.setValue(String.valueOf(response.body().getLast()));
            }

            @Override
            public void onFailure(Call<Cryptocurrency> call, Throwable t) {

            }
        });
    }

    @NonNull
    public MutableLiveData<List<CryptoHistory>> getBitcoinUsdDaily() {

        final MutableLiveData<List<CryptoHistory>> bitcoinDaily = new MutableLiveData<>();

        bitcoinAverageApi.getBitcoinUsdDaily().enqueue(new Callback<List<CryptoHistory>>() {

            @Override
            public void onResponse(Call<List<CryptoHistory>> call, Response<List<CryptoHistory>> response) { bitcoinDaily.setValue(response.body()); }

            @Override
            public void onFailure(Call<List<CryptoHistory>> call, Throwable t) { }
        });
        return bitcoinDaily;
    }
}
