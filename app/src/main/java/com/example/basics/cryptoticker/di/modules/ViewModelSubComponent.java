package com.example.basics.cryptoticker.di.modules;

import com.example.basics.cryptoticker.viewmodel.DetailViewModel;
import com.example.basics.cryptoticker.viewmodel.MainActivityViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }
 //   AlarmViewModel alarmViewModel();
    DetailViewModel detailViewModel();
    MainActivityViewModel mainActivityViewModel();
}
