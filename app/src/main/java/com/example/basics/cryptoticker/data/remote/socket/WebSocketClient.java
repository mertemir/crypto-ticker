package com.example.basics.cryptoticker.data.remote.socket;

import com.example.basics.cryptoticker.AlarmChecker;
import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.data.Parser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebSocketClient extends org.java_websocket.client.WebSocketClient {

    public WebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        send("{\n    \"event\": \"message\",\n    \"data\": {\n        \"operation\": \"subscribe\",\n        \"options\": {\n            \"currency\": \"BTCUSD\",\n            \"market\": \"global\"\n        }\n    }\n}");
    }

    @Override
    public void onMessage(String message) {
        JsonObject obj = (new JsonParser()).parse(message).getAsJsonObject();
        JsonElement data = obj.get("data");
        if(!"OK".equals(data.toString().substring(1, 3))) {
            JsonObject dataObject = data.getAsJsonObject();
            App.cryptoDatabase.cryptoDao().insertCoin(Parser.getCryptocurrencyFromJsonObject(dataObject));
            AlarmChecker.checkAlarms(App.context);
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println( "closed connection" );
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}
