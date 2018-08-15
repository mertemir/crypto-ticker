package com.example.basics.cryptoticker;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.Intent;

import com.example.basics.cryptoticker.data.db.CryptoDatabase;
import com.example.basics.cryptoticker.di.AppInjector;
import com.example.basics.cryptoticker.data.socket.SocketService;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;

public class App extends Application implements HasActivityInjector, HasServiceInjector {

    // TODO: Find out a way to better implement roomDB
    public static CryptoDatabase cryptoDatabase;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Service> dispatchingServiceInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);

        cryptoDatabase = CryptoDatabase.getInstance(this);

        if(!isServiceRunning("com.example.basics.cryptoticker.model.socket.SocketService"))
        startService(new Intent(this, SocketService.class));


    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() { return dispatchingServiceInjector; }

    private boolean isServiceRunning(String serviceClassName) {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)){
            if(serviceClassName.equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
