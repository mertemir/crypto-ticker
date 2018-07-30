package com.example.basics.cryptoticker.repository.data;

import java.util.Date;

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
