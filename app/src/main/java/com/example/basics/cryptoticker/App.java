package com.example.basics.cryptoticker;

import android.app.Activity;
import android.app.Application;

import com.example.basics.cryptoticker.di.AppInjector;
import com.example.basics.cryptoticker.di.components.AppComponent;
import com.example.basics.cryptoticker.di.components.DaggerAppComponent;
import com.example.basics.cryptoticker.di.modules.AppModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        AppInjector.init(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
