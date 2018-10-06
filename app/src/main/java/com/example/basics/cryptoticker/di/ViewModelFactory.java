package com.example.basics.cryptoticker.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.util.ArrayMap;

import com.example.basics.cryptoticker.di.modules.ViewModelSubComponent;
import com.example.basics.cryptoticker.ui.Alarm.AlarmViewModel;
import com.example.basics.cryptoticker.ui.Detail.DetailViewModel;
import com.example.basics.cryptoticker.ui.Main.MainActivityViewModel;
import com.example.basics.cryptoticker.ui.News.NewsViewModel;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {


    private final ArrayMap<Class, Callable<? extends ViewModel>> creators;

    @Inject
    public ViewModelFactory(ViewModelSubComponent viewModelSubComponent) {
        creators = new ArrayMap<>();

        // View models cannot be injected directly because they won't be bound to the owner's
        // view model scope.

        creators.put(DetailViewModel.class, () -> viewModelSubComponent.detailViewModel());
        creators.put(MainActivityViewModel.class, () -> viewModelSubComponent.mainActivityViewModel());
        creators.put(AlarmViewModel.class, () -> viewModelSubComponent.alarmViewModel());
        creators.put(NewsViewModel.class, () -> viewModelSubComponent.newsViewModel());
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Callable<? extends ViewModel> creator = creators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("Unknown model class " + modelClass);
        }
        try {
            return (T) creator.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}