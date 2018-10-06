package com.example.basics.cryptoticker.di.modules;

import com.example.basics.cryptoticker.ui.Alarm.AlarmViewModel;
import com.example.basics.cryptoticker.ui.Detail.DetailViewModel;
import com.example.basics.cryptoticker.ui.Main.MainActivityViewModel;
import com.example.basics.cryptoticker.ui.News.NewsViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }
    DetailViewModel detailViewModel();
    MainActivityViewModel mainActivityViewModel();
    AlarmViewModel alarmViewModel();
    NewsViewModel newsViewModel();
}
