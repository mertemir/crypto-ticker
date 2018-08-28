package com.example.basics.cryptoticker.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "coinTable")
public class CryptoEntity {

    @PrimaryKey
    @NonNull
    private String name;

    private String ask;

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getOpenDay() {
        return openDay;
    }

    public void setOpenDay(String openDay) {
        this.openDay = openDay;
    }

    public String getOpenWeek() {
        return openWeek;
    }

    public void setOpenWeek(String openWeek) {
        this.openWeek = openWeek;
    }

    public String getOpenMonth() {
        return openMonth;
    }

    public void setOpenMonth(String openMonth) {
        this.openMonth = openMonth;
    }

    public String getAverageDay() {
        return averageDay;
    }

    public void setAverageDay(String averageDay) {
        this.averageDay = averageDay;
    }

    public String getAverageWeek() {
        return averageWeek;
    }

    public void setAverageWeek(String averageWeek) {
        this.averageWeek = averageWeek;
    }

    public String getAverageMonth() {
        return averageMonth;
    }

    public void setAverageMonth(String averageMonth) {
        this.averageMonth = averageMonth;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getVolumePercent() {
        return volumePercent;
    }

    public void setVolumePercent(String volumePercent) {
        this.volumePercent = volumePercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getDisplayTimestamp() {
        return displayTimestamp;
    }

    public void setDisplayTimestamp(String displayTimestamp) {
        this.displayTimestamp = displayTimestamp;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String bid;
    private String last;
    private String high;
    private String low;
    private String openDay;
    private String openWeek;
    private String openMonth;
    private String averageDay;
    private String averageWeek;
    private String averageMonth;
    private String volume;

    private Double changePriceHour;
    private Double changePriceDay;
    private Double changePriceWeek;
    private Double changePriceMonth;
    private Double changePriceYear;

    public Double getChangePriceHour() {
        return changePriceHour;
    }

    public void setChangePriceHour(Double changePriceHour) {
        this.changePriceHour = changePriceHour;
    }

    public Double getChangePriceDay() {
        return changePriceDay;
    }

    public void setChangePriceDay(Double changePriceDay) {
        this.changePriceDay = changePriceDay;
    }

    public Double getChangePriceWeek() {
        return changePriceWeek;
    }

    public void setChangePriceWeek(Double changePriceWeek) {
        this.changePriceWeek = changePriceWeek;
    }

    public Double getChangePriceMonth() {
        return changePriceMonth;
    }

    public void setChangePriceMonth(Double changePriceMonth) {
        this.changePriceMonth = changePriceMonth;
    }

    public Double getChangePriceYear() {
        return changePriceYear;
    }

    public void setChangePriceYear(Double changePriceYear) {
        this.changePriceYear = changePriceYear;
    }

    public Double getChangePercentHour() {
        return changePercentHour;
    }

    public void setChangePercentHour(Double changePercentHour) {
        this.changePercentHour = changePercentHour;
    }

    public Double getChangePercentDay() {
        return changePercentDay;
    }

    public void setChangePercentDay(Double changePercentDay) {
        this.changePercentDay = changePercentDay;
    }

    public Double getChangePercentWeek() {
        return changePercentWeek;
    }

    public void setChangePercentWeek(Double changePercentWeek) {
        this.changePercentWeek = changePercentWeek;
    }

    public Double getChangePercentMonth() {
        return changePercentMonth;
    }

    public void setChangePercentMonth(Double changePercentMonth) {
        this.changePercentMonth = changePercentMonth;
    }

    public Double getChangePercentYear() {
        return changePercentYear;
    }

    public void setChangePercentYear(Double changePercentYear) {
        this.changePercentYear = changePercentYear;
    }

    private Double changePercentHour;
    private Double changePercentDay;
    private Double changePercentWeek;
    private Double changePercentMonth;
    private Double changePercentYear;

    private String volumePercent;
    private Integer timestamp;
    private String displayTimestamp;
    private Boolean success;
    private String time;

}
