package com.example.basics.cryptoticker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.basics.cryptoticker.Repository;
import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;

import javax.inject.Inject;

public class MainActivityViewModel extends AndroidViewModel {

    @Inject
    public MainActivityViewModel(@NonNull Repository repository, @NonNull Application application) {
        super(application);
        repository.getCoin("global","BTC");
    }

}
