package com.example.basics.cryptoticker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.basics.cryptoticker.Repository;
import com.example.basics.cryptoticker.data.db.entity.AlarmEntity;
import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;

import java.util.List;

import javax.inject.Inject;

public class AlarmViewModel extends AndroidViewModel {

    private final Repository repository;

    @Inject
    public AlarmViewModel(@NonNull Repository repository, @NonNull Application application) {
        super(application);
        this.repository = repository;
    }

    public LiveData<List<AlarmEntity>> getAlarms() { return repository.getActiveAlarms();}

    public LiveData<CryptoEntity> getBitcoinUSD() { return repository.getBitcoinUSD(); }

    public void insertAlarm(AlarmEntity newAlarm){repository.insertAlarm(newAlarm);}
}
