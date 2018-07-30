package com.example.basics.cryptoticker.repository.web;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.basics.cryptoticker.repository.data.CryptoHistory;
import com.example.basics.cryptoticker.repository.data.Cryptocurrency;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class BitcoinAverageRepository {

    private final IBitcoinAverageApi bitcoinAverageApi;

    @Inject
    public BitcoinAverageRepository(@NonNull IBitcoinAverageApi bitcoinAverageApi) { this.bitcoinAverageApi = bitcoinAverageApi; }

    @NonNull
    public MutableLiveData<Cryptocurrency> getBitcoinUSD() {
        final MutableLiveData<Cryptocurrency> bitcoin = new MutableLiveData<>();

        bitcoinAverageApi.getBitcoinUsd().enqueue(new Callback<Cryptocurrency>() {
            @Override
            public void onResponse(Call<Cryptocurrency> call, Response<Cryptocurrency> response) {
                bitcoin.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Cryptocurrency> call, Throwable t) {

            }
        });

        return bitcoin;

    }

    @NonNull
    public MutableLiveData<List<CryptoHistory>> getBitcoinUsdDaily() {
        final MutableLiveData<List<CryptoHistory>> bitcoinDaily = new MutableLiveData<>();

        bitcoinAverageApi.getBitcoinUsdDaily().enqueue(new Callback<List<CryptoHistory>>() {
            @Override
            public void onResponse(Call<List<CryptoHistory>> call, Response<List<CryptoHistory>> response) {
                bitcoinDaily.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CryptoHistory>> call, Throwable t) {

            }
        });

        return bitcoinDaily;

    }

}
