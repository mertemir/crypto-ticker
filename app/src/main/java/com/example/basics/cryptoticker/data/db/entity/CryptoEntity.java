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

    private String changePriceHour;
    private String changePriceDay;
    private String changePriceWeek;
    private String changePriceMonth;
    private String changePriceYear;

    public String getChangePriceHour() {
        return changePriceHour;
    }

    public void setChangePriceHour(String changePriceHour) {
        this.changePriceHour = changePriceHour;
    }

    public String getChangePriceDay() {
        return changePriceDay;
    }

    public void setChangePriceDay(String changePriceDay) {
        this.changePriceDay = changePriceDay;
    }

    public String getChangePriceWeek() {
        return changePriceWeek;
    }

    public void setChangePriceWeek(String changePriceWeek) {
        this.changePriceWeek = changePriceWeek;
    }

    public String getChangePriceMonth() {
        return changePriceMonth;
    }

    public void setChangePriceMonth(String changePriceMonth) {
        this.changePriceMonth = changePriceMonth;
    }

    public String getChangePriceYear() {
        return changePriceYear;
    }

    public void setChangePriceYear(String changePriceYear) {
        this.changePriceYear = changePriceYear;
    }

    public String getChangePercentHour() {
        return changePercentHour;
    }

    public void setChangePercentHour(String changePercentHour) {
        this.changePercentHour = changePercentHour;
    }

    public String getChangePercentDay() {
        return changePercentDay;
    }

    public void setChangePercentDay(String changePercentDay) {
        this.changePercentDay = changePercentDay;
    }

    public String getChangePercentWeek() {
        return changePercentWeek;
    }

    public void setChangePercentWeek(String changePercentWeek) {
        this.changePercentWeek = changePercentWeek;
    }

    public String getChangePercentMonth() {
        return changePercentMonth;
    }

    public void setChangePercentMonth(String changePercentMonth) {
        this.changePercentMonth = changePercentMonth;
    }

    public String getChangePercentYear() {
        return changePercentYear;
    }

    public void setChangePercentYear(String changePercentYear) {
        this.changePercentYear = changePercentYear;
    }

    private String changePercentHour;
    private String changePercentDay;
    private String changePercentWeek;
    private String changePercentMonth;
    private String changePercentYear;

    private String volumePercent;
    private Integer timestamp;
    private String displayTimestamp;
    private Boolean success;
    private String time;

}
