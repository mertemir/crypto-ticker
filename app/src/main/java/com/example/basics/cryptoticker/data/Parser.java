package com.example.basics.cryptoticker.data;

import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;
import com.example.basics.cryptoticker.data.model.pojo.Cryptocurrency;
import com.google.gson.JsonObject;

public class Parser {

    public static CryptoEntity getCryptocurrencyFromJsonObject(JsonObject result){

        CryptoEntity cryptocurrency = new CryptoEntity();

        cryptocurrency.setName("bitcoin");

        cryptocurrency.setAsk(result.get("ask").getAsString());
        cryptocurrency.setBid(result.get("bid").getAsString());
        cryptocurrency.setLast(result.get("last").getAsString());
        cryptocurrency.setHigh(result.get("high").getAsString());
        cryptocurrency.setLow(result.get("low").getAsString());

        cryptocurrency.setDisplayTimestamp(result.get("display_timestamp").getAsString());

        cryptocurrency.setOpenDay(result.getAsJsonObject("open").get("day").getAsString());
        cryptocurrency.setOpenWeek(result.getAsJsonObject("open").get("week").getAsString());
        cryptocurrency.setOpenMonth(result.getAsJsonObject("open").get("month").getAsString());

        cryptocurrency.setAverageDay(result.getAsJsonObject("averages").get("day").getAsString());
        cryptocurrency.setAverageWeek(result.getAsJsonObject("averages").get("week").getAsString());
        cryptocurrency.setAverageMonth(result.getAsJsonObject("averages").get("month").getAsString());

        cryptocurrency.setChangePercentHour(result.getAsJsonObject("changes").getAsJsonObject("percent").get("hour").getAsString());
        cryptocurrency.setChangePercentDay(result.getAsJsonObject("changes").getAsJsonObject("percent").get("day").getAsString());
        cryptocurrency.setChangePercentWeek(result.getAsJsonObject("changes").getAsJsonObject("percent").get("week").getAsString());
        cryptocurrency.setChangePercentMonth(result.getAsJsonObject("changes").getAsJsonObject("percent").get("month").getAsString());
        cryptocurrency.setChangePercentYear(result.getAsJsonObject("changes").getAsJsonObject("percent").get("year").getAsString());

        cryptocurrency.setChangePriceHour(result.getAsJsonObject("changes").getAsJsonObject("price").get("hour").getAsString());
        cryptocurrency.setChangePriceDay(result.getAsJsonObject("changes").getAsJsonObject("price").get("day").getAsString());
        cryptocurrency.setChangePriceWeek(result.getAsJsonObject("changes").getAsJsonObject("price").get("week").getAsString());
        cryptocurrency.setChangePriceMonth(result.getAsJsonObject("changes").getAsJsonObject("price").get("month").getAsString());
        cryptocurrency.setChangePriceYear(result.getAsJsonObject("changes").getAsJsonObject("price").get("year").getAsString());

        return cryptocurrency;
    }

    public static CryptoEntity getCryptocurrencyEntityFromCryptocurrency(Cryptocurrency result){

        CryptoEntity cryptocurrency = new CryptoEntity();

        cryptocurrency.setName("bitcoin");

        cryptocurrency.setAsk(result.getAsk().toString());
        cryptocurrency.setBid(result.getBid().toString());
        cryptocurrency.setLast(result.getLast().toString());
        cryptocurrency.setHigh(result.getHigh().toString());
        cryptocurrency.setLow(result.getLow().toString());

        cryptocurrency.setDisplayTimestamp(result.getDisplayTimestamp());

        cryptocurrency.setOpenDay(result.getOpen().getDay().toString());
        cryptocurrency.setOpenWeek(result.getOpen().getWeek().toString());
        cryptocurrency.setOpenMonth(result.getOpen().getMonth().toString());

        cryptocurrency.setAverageDay(result.getAverages().getDay().toString());
        cryptocurrency.setAverageWeek(result.getAverages().getWeek().toString());
        cryptocurrency.setAverageMonth(result.getAverages().getMonth().toString());

        cryptocurrency.setChangePercentHour(result.getChanges().getPercent().getHour().toString());
        cryptocurrency.setChangePercentDay(result.getChanges().getPercent().getDay().toString());
        cryptocurrency.setChangePercentWeek(result.getChanges().getPercent().getWeek().toString());
        cryptocurrency.setChangePercentMonth(result.getChanges().getPercent().getMonth().toString());
        cryptocurrency.setChangePercentYear(result.getChanges().getPercent().getYear().toString());

        cryptocurrency.setChangePriceHour(result.getChanges().getPrice().getHour().toString());
        cryptocurrency.setChangePriceDay(result.getChanges().getPrice().getDay().toString());
        cryptocurrency.setChangePriceWeek(result.getChanges().getPrice().getWeek().toString());
        cryptocurrency.setChangePriceMonth(result.getChanges().getPrice().getMonth().toString());
        cryptocurrency.setChangePriceYear(result.getChanges().getPrice().getYear().toString());

        return cryptocurrency;
    }
}
