package com.example.basics.cryptoticker;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;

import com.example.basics.cryptoticker.data.db.CryptoDatabase;
import com.example.basics.cryptoticker.data.socket.SocketBroadcastReceiver;
import com.example.basics.cryptoticker.di.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;

public class App extends Application implements HasActivityInjector, HasServiceInjector {

    // TODO: Inject DB to needed places
    public static CryptoDatabase cryptoDatabase;

    // TODO: Inject Context to needed places
    public static Context context;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Service> dispatchingServiceInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
        cryptoDatabase = CryptoDatabase.getInstance(this);
        startSocketService();
        context = this;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() { return dispatchingServiceInjector; }

    private void startSocketService(){
        Intent socketIntent= new Intent(this, SocketBroadcastReceiver.class);
        PendingIntent socketAlarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, socketIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        long startTime=System.currentTimeMillis(); //alarm starts immediately
        AlarmManager backupAlarmMgr=(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        backupAlarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP,startTime,AlarmManager.INTERVAL_FIFTEEN_MINUTES,socketAlarmIntent); // alarm will repeat after every 15 minutes
    }
}
