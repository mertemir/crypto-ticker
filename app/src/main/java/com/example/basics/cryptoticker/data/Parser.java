package com.example.basics.cryptoticker.data;

import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;
import com.example.basics.cryptoticker.data.model.Cryptocurrency;
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

        cryptocurrency.setChangePercentHour(result.getAsJsonObject("changes").getAsJsonObject("percent").get("hour").getAsDouble());
        cryptocurrency.setChangePercentDay(result.getAsJsonObject("changes").getAsJsonObject("percent").get("day").getAsDouble());
        cryptocurrency.setChangePercentWeek(result.getAsJsonObject("changes").getAsJsonObject("percent").get("week").getAsDouble());
        cryptocurrency.setChangePercentMonth(result.getAsJsonObject("changes").getAsJsonObject("percent").get("month").getAsDouble());
        cryptocurrency.setChangePercentYear(result.getAsJsonObject("changes").getAsJsonObject("percent").get("year").getAsDouble());

        cryptocurrency.setChangePriceHour(result.getAsJsonObject("changes").getAsJsonObject("price").get("hour").getAsDouble());
        cryptocurrency.setChangePriceDay(result.getAsJsonObject("changes").getAsJsonObject("price").get("day").getAsDouble());
        cryptocurrency.setChangePriceWeek(result.getAsJsonObject("changes").getAsJsonObject("price").get("week").getAsDouble());
        cryptocurrency.setChangePriceMonth(result.getAsJsonObject("changes").getAsJsonObject("price").get("month").getAsDouble());
        cryptocurrency.setChangePriceYear(result.getAsJsonObject("changes").getAsJsonObject("price").get("year").getAsDouble());

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

        cryptocurrency.setChangePercentHour(result.getChanges().getPercent().getHour());
        cryptocurrency.setChangePercentDay(result.getChanges().getPercent().getDay());
        cryptocurrency.setChangePercentWeek(result.getChanges().getPercent().getWeek());
        cryptocurrency.setChangePercentMonth(result.getChanges().getPercent().getMonth());
        cryptocurrency.setChangePercentYear(result.getChanges().getPercent().getYear());

        cryptocurrency.setChangePriceHour(result.getChanges().getPrice().getHour());
        cryptocurrency.setChangePriceDay(result.getChanges().getPrice().getDay());
        cryptocurrency.setChangePriceWeek(result.getChanges().getPrice().getWeek());
        cryptocurrency.setChangePriceMonth(result.getChanges().getPrice().getMonth());
        cryptocurrency.setChangePriceYear(result.getChanges().getPrice().getYear());

        return cryptocurrency;
    }
}
