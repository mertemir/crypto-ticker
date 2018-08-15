package com.example.basics.cryptoticker.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;
import com.example.basics.cryptoticker.data.model.Cryptocurrency;

@Dao
public interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCoin(CryptoEntity c);

    @Query("SELECT * FROM coinTable")
    LiveData<CryptoEntity> getCoin();
}
