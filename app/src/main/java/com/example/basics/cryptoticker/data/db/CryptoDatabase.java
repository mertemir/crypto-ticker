package com.example.basics.cryptoticker.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.basics.cryptoticker.data.db.dao.CryptoDao;
import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;

@Database(entities = {CryptoEntity.class}, version = 1)
public abstract class CryptoDatabase extends RoomDatabase {

    private static CryptoDatabase sInstance;

    public static final String DATABASE_NAME = "crypto-db";

    public abstract CryptoDao cryptoDao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static CryptoDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (CryptoDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext());
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static CryptoDatabase buildDatabase(final Context appContext){
        return Room.databaseBuilder(appContext, CryptoDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
    }

    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }

}
