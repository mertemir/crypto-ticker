package com.example.basics.cryptoticker.di.components;

import android.app.Application;

import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.di.modules.AppModule;
import com.example.basics.cryptoticker.di.modules.MainActivityModule;
import com.example.basics.cryptoticker.di.modules.ServiceBuilderModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class,
        ServiceBuilderModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }
    void inject(App Application);

}