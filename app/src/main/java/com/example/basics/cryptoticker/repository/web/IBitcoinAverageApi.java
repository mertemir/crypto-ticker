package com.example.basics.cryptoticker.repository.web;

import com.example.basics.cryptoticker.repository.data.CryptoHistory;
import com.example.basics.cryptoticker.repository.data.Cryptocurrency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IBitcoinAverageApi {

    @GET("ticker/BTCUSD")
    Call<Cryptocurrency> getBitcoinUsd();

    @GET("ticker/XRPUSD")
    Call<Cryptocurrency> getRippleUsd();

    @GET("ticker/LTCUSD")
    Call<Cryptocurrency> getLitecoinUsd();

    @GET("history/BTCUSD?period=daily&?format=json")
    Call<List<CryptoHistory>> getBitcoinUsdDaily();

}
