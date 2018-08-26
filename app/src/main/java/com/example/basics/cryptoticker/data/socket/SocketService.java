package com.example.basics.cryptoticker.data.socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.basics.cryptoticker.data.model.pojo.Ticket;
import com.example.basics.cryptoticker.data.model.web.IBitcoinAverageApi;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.android.AndroidInjection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class SocketService extends Service {

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    @Inject
    IBitcoinAverageApi bitcoinAverageApi;

    @Inject
    OkHttpClient client;

    @Inject
    SocketListener socketListener;

    @Inject
    Authentication authentication;

    public SocketService() { super(); }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        bitcoinAverageApi.getTicket(authentication.provideSignature()).enqueue(new Callback<Ticket>() {
            @Override
            public void onResponse(Call<Ticket> call, Response<Ticket> response) {

                Request request = (new Request.Builder())
                        .url("wss://apiv2.bitcoinaverage.com/websocket/ticker?ticket=" + response.body().getTicket() + "&public_key=MjBiNzQ2Y2Q1NjVhNDY5Y2E4YzA0M2ZlYTk4MzZmMWQ")
                        .build();

                client.newWebSocket(request, socketListener);

                Log.wtf("Service Service ", "has started.");

            }

            @Override
            public void onFailure(Call<Ticket> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
