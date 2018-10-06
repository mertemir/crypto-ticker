package com.example.basics.cryptoticker.di.modules;

import com.example.basics.cryptoticker.ui.Alarm.AlarmFragment;
import com.example.basics.cryptoticker.ui.Detail.DetailFragment;
import com.example.basics.cryptoticker.ui.News.NewsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract AlarmFragment contributeAlarmFragment();

    @ContributesAndroidInjector
    abstract DetailFragment contributeDetailFragment();

    @ContributesAndroidInjector
    abstract NewsFragment contributeNewsFragment();
}
