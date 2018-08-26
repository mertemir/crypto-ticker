package com.example.basics.cryptoticker.data.model.pojo;

public class CryptoHistory {

    private String time;
    private double average;

    public String getMinute() { return time; }

    public void setMinute(String time) {
        this.time = time;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
