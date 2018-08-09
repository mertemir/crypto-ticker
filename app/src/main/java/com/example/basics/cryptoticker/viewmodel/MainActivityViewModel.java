package com.example.basics.cryptoticker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import com.example.basics.cryptoticker.model.web.BitcoinAverageRepository;


import javax.inject.Inject;

public class MainActivityViewModel extends AndroidViewModel {

    private final BitcoinAverageRepository bitcoinAverageRepository;

    @Inject
    public MainActivityViewModel(@NonNull BitcoinAverageRepository bitcoinAverageRepository, @NonNull Application application) {
        super(application);
        this.bitcoinAverageRepository = bitcoinAverageRepository;

    }

    public void connectSocket() { bitcoinAverageRepository.connectSocket(); }

}
