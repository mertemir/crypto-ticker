package com.example.basics.cryptoticker.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "coinTable")
public class CryptoEntity {

    @PrimaryKey
    @NonNull
    private String name;

    private Double ask;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getOpenDay() {
        return openDay;
    }

    public void setOpenDay(Double openDay) {
        this.openDay = openDay;
    }

    public Double getOpenWeek() {
        return openWeek;
    }

    public void setOpenWeek(Double openWeek) {
        this.openWeek = openWeek;
    }

    public Double getOpenMonth() {
        return openMonth;
    }

    public void setOpenMonth(Double openMonth) {
        this.openMonth = openMonth;
    }

    public Double getAverageDay() {
        return averageDay;
    }

    public void setAverageDay(Double averageDay) {
        this.averageDay = averageDay;
    }

    public Double getAverageWeek() {
        return averageWeek;
    }

    public void setAverageWeek(Double averageWeek) {
        this.averageWeek = averageWeek;
    }

    public Double getAverageMonth() {
        return averageMonth;
    }

    public void setAverageMonth(Double averageMonth) {
        this.averageMonth = averageMonth;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getVolumePercent() {
        return volumePercent;
    }

    public void setVolumePercent(Double volumePercent) {
        this.volumePercent = volumePercent;
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

    private Double bid;
    private Double last;
    private Double high;
    private Double low;
    private Double openDay;
    private Double openWeek;
    private Double openMonth;
    private Double averageDay;
    private Double averageWeek;
    private Double averageMonth;
    private Double volume;

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

    private Double volumePercent;
    private Integer timestamp;
    private String displayTimestamp;
    private Boolean success;
    private String time;

}
