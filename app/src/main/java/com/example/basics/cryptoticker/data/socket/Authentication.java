package com.example.basics.cryptoticker.data.socket;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

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
}
