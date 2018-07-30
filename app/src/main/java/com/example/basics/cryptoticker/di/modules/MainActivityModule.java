package com.example.basics.cryptoticker.di.modules;

import com.example.basics.cryptoticker.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}