package com.example.basics.cryptoticker.data.socket;

import android.util.Log;

import com.example.basics.cryptoticker.AlarmChecker;
import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.data.Parser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class SocketListener extends WebSocketListener{

    public void onOpen(WebSocket webSocket, Response response) {
        webSocket.send("{\n    \"event\": \"message\",\n    \"data\": {\n        \"operation\": \"subscribe\",\n        \"options\": {\n            \"currency\": \"BTCUSD\",\n            \"market\": \"global\"\n        }\n    }\n}");
    }

    public void onMessage(WebSocket webSocket, String text) {
        JsonObject obj = (new JsonParser()).parse(text).getAsJsonObject();
        JsonElement data = obj.get("data");
        if(!"OK".equals(data.toString().substring(1, 3))) {
            JsonObject dataObject = data.getAsJsonObject();
            App.cryptoDatabase.cryptoDao().insertCoin(Parser.getCryptocurrencyFromJsonObject(dataObject));
            AlarmChecker.checkAlarms(App.context);
        }
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Log.wtf("Price ", bytes.hex());
    }

    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(1000, (String)null);
        Log.wtf("Closing ", "" + code + " / " + reason);
    }

    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    }

}