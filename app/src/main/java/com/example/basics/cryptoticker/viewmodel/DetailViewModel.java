package com.example.basics.cryptoticker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.example.basics.cryptoticker.Repository;
import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;
import com.example.basics.cryptoticker.data.model.CryptoHistory;
import com.github.mikephil.charting.data.Entry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.inject.Inject;


public class DetailViewModel extends AndroidViewModel {

    private final LiveData<List<Entry>> currencyHistory;
    LiveData<CryptoEntity> bitcoin;
    final List<Entry> entries= new ArrayList<>();

    @Inject
    public DetailViewModel(@NonNull Repository repository, @NonNull Application application) {
        super(application);
        currencyHistory = Transformations.map(repository.getBitcoinUsdDaily(), this::convertToEntry);
        repository.getCoinData("global", "BTC");
        this.bitcoin = repository.getBitcoinUSD();
    }

    public LiveData<CryptoEntity> getBitcoin() { return bitcoin; }

    public LiveData<List<Entry>> getDailyCurrency() { return currencyHistory; }

    private List<Entry> convertToEntry(List<CryptoHistory> currencyHistory)
    {
        String now = Calendar.getInstance(TimeZone.getTimeZone("gmt")).toString();

            for (CryptoHistory c : currencyHistory) {
                if(c.getMinute().substring(8,10).equals(now.substring(198,200)))
                {
                    if (c.getMinute().substring(14, 16).equals("00") || c.getMinute().substring(14, 16).equals("30")) {
                        String time = c.getMinute().substring(11, 16);
                        float timeFloat = Float.parseFloat(time.replace(":", "."));
                        float resultTo100 = convertTo100(timeFloat);
                        entries.add(new Entry(resultTo100, (float) c.getAverage()));
                    }
                }
            }

        return entries;
    }

    private float convertTo100(float input)
    {
        String input_string = Float.toString(input);
        BigDecimal inputBD = new BigDecimal(input_string);
        String hhStr = input_string.split("\\.")[0];
        BigDecimal output = new BigDecimal(Float.toString(Integer.parseInt(hhStr)));
        output = output.add((inputBD.subtract(output).divide(BigDecimal.valueOf(60), 10, BigDecimal.ROUND_HALF_EVEN)).multiply(BigDecimal.valueOf(100)));

        return Float.parseFloat(output.toString());
    }
}