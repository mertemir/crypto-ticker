package com.example.basics.cryptoticker.data;

import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;
import com.example.basics.cryptoticker.data.model.Cryptocurrency;
import com.google.gson.JsonObject;

public class Parser {

    public static CryptoEntity getCryptocurrencyFromJsonObject(JsonObject result){

        CryptoEntity cryptocurrency = new CryptoEntity();

        cryptocurrency.setName("Bitcoin");

        cryptocurrency.setAsk(result.get("ask").getAsDouble());
        cryptocurrency.setBid(result.get("bid").getAsDouble());
        cryptocurrency.setLast(result.get("last").getAsDouble());
        cryptocurrency.setHigh(result.get("high").getAsDouble());
        cryptocurrency.setLow(result.get("low").getAsDouble());

        cryptocurrency.setDisplayTimestamp(result.get("display_timestamp").getAsString());

        cryptocurrency.setOpenDay(result.getAsJsonObject("open").get("day").getAsDouble());
        cryptocurrency.setOpenWeek(result.getAsJsonObject("open").get("week").getAsDouble());
        cryptocurrency.setOpenMonth(result.getAsJsonObject("open").get("month").getAsDouble());

        cryptocurrency.setAverageDay(result.getAsJsonObject("averages").get("day").getAsDouble());
        cryptocurrency.setAverageWeek(result.getAsJsonObject("averages").get("week").getAsDouble());
        cryptocurrency.setAverageMonth(result.getAsJsonObject("averages").get("month").getAsDouble());

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

        cryptocurrency.setName("Bitcoin");

        cryptocurrency.setAsk(result.getAsk());
        cryptocurrency.setBid(result.getBid());
        cryptocurrency.setLast(result.getLast());
        cryptocurrency.setHigh(result.getHigh());
        cryptocurrency.setLow(result.getLow());

        cryptocurrency.setDisplayTimestamp(result.getDisplayTimestamp());

        cryptocurrency.setOpenDay(result.getOpen().getDay());
        cryptocurrency.setOpenWeek(result.getOpen().getWeek());
        cryptocurrency.setOpenMonth(result.getOpen().getMonth());

        cryptocurrency.setAverageDay(result.getAverages().getDay());
        cryptocurrency.setAverageWeek(result.getAverages().getWeek());
        cryptocurrency.setAverageMonth(result.getAverages().getMonth());

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
