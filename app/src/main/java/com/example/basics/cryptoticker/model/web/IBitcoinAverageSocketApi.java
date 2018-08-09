package com.example.basics.cryptoticker.model.web;

import com.example.basics.cryptoticker.model.data.Ticket;

import org.json.JSONObject;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface IBitcoinAverageSocketApi {

    @GET("get_ticket")
    Call<Ticket> getTicket(@Header("X-Signature") String signature);

}
