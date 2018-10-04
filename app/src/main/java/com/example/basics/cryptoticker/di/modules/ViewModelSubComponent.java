package com.example.basics.cryptoticker.di.modules;

import com.example.basics.cryptoticker.viewmodel.AlarmViewModel;
import com.example.basics.cryptoticker.viewmodel.DetailViewModel;
import com.example.basics.cryptoticker.viewmodel.MainActivityViewModel;
import com.example.basics.cryptoticker.viewmodel.NewsViewModel;

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
