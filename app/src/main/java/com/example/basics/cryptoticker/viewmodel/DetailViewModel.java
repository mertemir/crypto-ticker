package com.example.basics.cryptoticker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.basics.cryptoticker.model.data.CryptoHistory;
import com.example.basics.cryptoticker.model.data.Cryptocurrency;
import com.example.basics.cryptoticker.model.web.BitcoinAverageRepository;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;


public class DetailViewModel extends AndroidViewModel {

    public static MutableLiveData<String> BitcoinPrice;
    private MutableLiveData<List<CryptoHistory>> currencyHistory;

    @Inject
    public DetailViewModel(@NonNull BitcoinAverageRepository bitcoinAverageRepository, @NonNull Application application) {
        super(application);
        currencyHistory = bitcoinAverageRepository.getBitcoinUsdDaily();
        BitcoinPrice = bitcoinAverageRepository.getBitcoinUSD();
    }

    public MutableLiveData<String> getBitcoinPrice() { return this.BitcoinPrice; }

    public MutableLiveData<List<CryptoHistory>> getDailyCurrency() {
        return this.currencyHistory;
    }

    public void splitCurrencyHistory(List<CryptoHistory> a)
    {

        for(CryptoHistory crypto: a)
        {

            Log.wtf("ANAN", convertStringToTimestamp(crypto.getMinute()).toString());

        }

    }

    public static Timestamp convertStringToTimestamp(String str_date) {
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(str_date);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

            return timestamp;

        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }

}
