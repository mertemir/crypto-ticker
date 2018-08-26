package com.example.basics.cryptoticker.di.modules;

import com.example.basics.cryptoticker.ui.fragment.AlarmFragment;
import com.example.basics.cryptoticker.ui.fragment.DetailFragment;
import com.example.basics.cryptoticker.ui.fragment.NewsFragment;

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
