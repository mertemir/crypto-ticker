package com.example.basics.cryptoticker.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.basics.cryptoticker.data.db.entity.AlarmEntity;

import java.util.List;

@Dao
public interface AlarmDao {

    @Insert
    void insertAlarm(AlarmEntity alarmEntity);

    @Delete()
    void deleteAlarm(AlarmEntity alarmEntity);

    @Query("SELECT * FROM alarmTable")
    LiveData<List<AlarmEntity>> getAlarms();

    @Query("SELECT * FROM alarmTable")
    List<AlarmEntity> getAlarmsList();
}
