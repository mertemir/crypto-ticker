package com.example.basics.cryptoticker.model.web;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.basics.cryptoticker.model.data.Cryptocurrency;
import com.example.basics.cryptoticker.model.data.Ticket;
import com.example.basics.cryptoticker.model.socket.Authentication;
import com.example.basics.cryptoticker.model.data.CryptoHistory;
import com.example.basics.cryptoticker.model.socket.SocketConnection;
import com.example.basics.cryptoticker.model.socket.SocketListener;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class BitcoinAverageRepository {


    private final IBitcoinAverageApi bitcoinAverageApi;
    private final IBitcoinAverageSocketApi bitcoinAverageSocketApi;
    private final OkHttpClient client;
    SocketListener socketListener = new SocketListener();

    @Inject
    public BitcoinAverageRepository(@NonNull IBitcoinAverageApi bitcoinAverageApi, @NonNull IBitcoinAverageSocketApi bitcoinAverageSocketApi, OkHttpClient client) {
        this.bitcoinAverageApi = bitcoinAverageApi;
        this.bitcoinAverageSocketApi = bitcoinAverageSocketApi;
        this.client = client;
    }

    public MutableLiveData<String> getBitcoinUSD() {
        final MutableLiveData<String> bitcoin = new MutableLiveData<>();

        bitcoinAverageApi.getBitcoinUsd().enqueue(new Callback<Cryptocurrency>() {
            @Override
            public void onResponse(Call<Cryptocurrency> call, Response<Cryptocurrency> response) {
                bitcoin.setValue(String.valueOf(response.body().getLast()));
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
            public void onResponse(Call<List<CryptoHistory>> call, Response<List<CryptoHistory>> response) { bitcoinDaily.setValue(response.body()); }

            @Override
            public void onFailure(Call<List<CryptoHistory>> call, Throwable t) { }
        });
        return bitcoinDaily;
    }

    @NonNull
    public void connectSocket() {

        Authentication authentication = new Authentication();

        Thread thread = new Thread(() -> {

            bitcoinAverageSocketApi.getTicket(authentication.provideSignature()).enqueue(new Callback<Ticket>() {
                @Override
                public void onResponse(Call<Ticket> call, Response<Ticket> response) {

                    Request request = (new Request.Builder())
                            .url("wss://apiv2.bitcoinaverage.com/websocket/ticker?ticket=" + response.body().getTicket() + "&public_key=MjBiNzQ2Y2Q1NjVhNDY5Y2E4YzA0M2ZlYTk4MzZmMWQ")
                            .build();

                    client.newWebSocket(request, socketListener);
                    client.dispatcher().executorService().shutdown();

                }

                @Override
                public void onFailure(Call<Ticket> call, Throwable t) {

                }
            });
        });
        thread.start();
    }
}
