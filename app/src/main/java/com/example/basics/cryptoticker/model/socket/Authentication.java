package com.example.basics.cryptoticker.model.socket;

import android.util.Log;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import dagger.Module;
import dagger.Provides;

public class Authentication {

    String secretKey = "YjZlY2E1MDBjZWFhNDZjOTkzYjJiMGJjNGExMmE2NDUxOTRlNzA2NTA5NzY0MmNmYTJlMzcxYmJiN2FjOGYxYg";
    String publicKey = "MjBiNzQ2Y2Q1NjVhNDY5Y2E4YzA0M2ZlYTk4MzZmMWQ";

    public String provideSignature() {

        long timestamp = System.currentTimeMillis() / 1000L;
        String payload = timestamp + "." + publicKey;

        Mac sha256_Mac = null;
        try {
            sha256_Mac = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        try {
            sha256_Mac.init(secretKeySpec);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        StringBuffer result = new StringBuffer();
        for (byte byt : sha256_Mac.doFinal(payload.getBytes())) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        String signature = payload + "." + result;

        return signature;
    }

/*
    public static String getTicket() throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String secretKey = "YjZlY2E1MDBjZWFhNDZjOTkzYjJiMGJjNGExMmE2NDUxOTRlNzA2NTA5NzY0MmNmYTJlMzcxYmJiN2FjOGYxYg";
        String publicKey = "MjBiNzQ2Y2Q1NjVhNDY5Y2E4YzA0M2ZlYTk4MzZmMWQ";
        */
/*String signature = getSignature(secretKey, publicKey);*//*


        String url = "https://apiv2.bitcoinaverage.com/websocket/get_ticket";
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Signature", signature);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        bufferedReader.close();

        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.toString());
        new JsonObject();
        JsonObject ticket = je.getAsJsonObject();
        String result = ticket.get("ticket").getAsString();

        return result;
    }
*/

}
