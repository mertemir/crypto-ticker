package com.example.basics.cryptoticker.di.modules;

import com.example.basics.cryptoticker.data.socket.SocketListener;
import com.example.basics.cryptoticker.data.socket.SocketService;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ServiceBuilderModule {
    @ContributesAndroidInjector
    abstract SocketService contributeSocketService();
}
