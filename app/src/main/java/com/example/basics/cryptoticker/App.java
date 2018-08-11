package com.example.basics.cryptoticker;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;

import com.example.basics.cryptoticker.di.AppInjector;
import com.example.basics.cryptoticker.model.socket.SocketService;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;

public class App extends Application implements HasActivityInjector, HasServiceInjector {

    public static MutableLiveData<String> bitcoinPrice;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Service> dispatchingServiceInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        bitcoinPrice = new MutableLiveData<>();

        AppInjector.init(this);

        if(!isServiceRunning())
        startService(new Intent(this, SocketService.class));

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() { return dispatchingServiceInjector; }

    private boolean isServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)){
            if("com.example.basics.cryptoticker.model.socket.SocketService".equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
