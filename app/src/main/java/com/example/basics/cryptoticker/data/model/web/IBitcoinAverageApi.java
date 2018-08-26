package com.example.basics.cryptoticker.data.model.web;

import com.example.basics.cryptoticker.data.model.pojo.CryptoHistory;
import com.example.basics.cryptoticker.data.model.pojo.Cryptocurrency;
import com.example.basics.cryptoticker.data.model.pojo.Ticket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface IBitcoinAverageApi {

    @GET("websocket/get_ticket")
    Call<Ticket> getTicket(@Header("X-Signature") String signature);

    @GET("indices/{symbol_set}/ticker/{crypto}USD")
    Call<Cryptocurrency> getCoinUsd(@Path("symbol_set") String symbol_set, @Path("crypto") String crypto);

    @GET("indices/{symbol_set}/history/{crypto}USD?period=daily&?format=json")
    Call<List<CryptoHistory>> getCoinUsdDaily(@Path("symbol_set") String symbol_set, @Path("crypto") String crypto);

}
