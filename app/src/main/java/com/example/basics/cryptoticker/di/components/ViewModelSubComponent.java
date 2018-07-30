package com.example.basics.cryptoticker.di.components;

import com.example.basics.cryptoticker.viewmodel.AlarmViewModel;
import com.example.basics.cryptoticker.viewmodel.DetailViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }
 //   AlarmViewModel alarmViewModel();
    DetailViewModel detailViewModel();
}
