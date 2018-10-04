package com.example.basics.cryptoticker.data.remote.socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.basics.cryptoticker.data.model.Ticket;
import com.example.basics.cryptoticker.data.remote.IBitcoinAverageApi;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.android.AndroidInjection;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class SocketService extends Service {

    @Inject
    IBitcoinAverageApi bitcoinAverageApi;

    @Inject
    OkHttpClient client;

    WebSocketClient webSocketClient;

    @Inject
    Authentication authentication;

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    public SocketService() { super(); }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(webSocketClient == null || webSocketClient.isClosed()) {

            bitcoinAverageApi.getTicket(authentication.provideSignature()).enqueue(new Callback<Ticket>() {
                @Override
                public void onResponse(Call<Ticket> call, Response<Ticket> response) {

                    try {
                        webSocketClient = new WebSocketClient(
                                new URI("wss://apiv2.bitcoinaverage.com/websocket/ticker?ticket="
                                        + response.body().getTicket() +
                                        "&public_key=MjBiNzQ2Y2Q1NjVhNDY5Y2E4YzA0M2ZlYTk4MzZmMWQ"));

                                webSocketClient.connect();

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }

                    Log.wtf("Service Service ", "has started.");

                }

                @Override
                public void onFailure(Call<Ticket> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
