package com.example.basics.cryptoticker.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "alarmTable")
public class AlarmEntity {

    @PrimaryKey
    @NonNull
    private String date;

    @NonNull
    private double price;

    @NonNull
    private int andHigher;

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public double getPrice() {
        return price;
    }

    public void setPrice(@NonNull double price) {
        this.price = price;
    }

    @NonNull
    public int getAndHigher() {
        return andHigher;
    }

    public void setAndHigher(@NonNull int andHigher) {
        this.andHigher = andHigher;
    }


}
