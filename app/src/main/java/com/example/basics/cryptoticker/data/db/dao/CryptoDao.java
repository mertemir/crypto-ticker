package com.example.basics.cryptoticker.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;

@Dao
public interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCoin(CryptoEntity c);

    @Query("SELECT * FROM coinTable")
    LiveData<CryptoEntity> getCoin();

    // <-------  Alarm Checker  --------->
    @Query("SELECT * FROM coinTable")
    CryptoEntity getCoinData();

}
