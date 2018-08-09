package com.example.basics.cryptoticker.model.socket;

import com.example.basics.cryptoticker.model.data.Ticket;
import com.example.basics.cryptoticker.model.web.BitcoinAverageRepository;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class SocketConnection {

/*    private Ticket ticket;
    private SocketListener mSocketListener;
    private WebSocket mWebSocket;
    private OkHttpClient client;
    c

    public WebSocket connectSocket() {

        ticket = BitcoinAverageRepository.
        this.mSocketListener = new SocketListener();
        this.client = new OkHttpClient();

   Thread thread = new Thread(() -> {

               Request request = (new Request.Builder())
                       .url("wss://apiv2.bitcoinaverage.com/websocket/ticker?ticket=" + ticket.getTicket() + "&public_key=MjBiNzQ2Y2Q1NjVhNDY5Y2E4YzA0M2ZlYTk4MzZmMWQ")
                       .build();


               mWebSocket = client.newWebSocket(request, mSocketListener);
               client.dispatcher().executorService().shutdown();

   });

        thread.start();

        return mWebSocket;

    }*/

}
