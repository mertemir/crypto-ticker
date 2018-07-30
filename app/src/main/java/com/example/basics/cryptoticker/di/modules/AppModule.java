package com.example.basics.cryptoticker.di.modules;

import android.arch.lifecycle.ViewModelProvider;

import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.di.components.ViewModelSubComponent;
import com.example.basics.cryptoticker.repository.web.IBitcoinAverageApi;
import com.example.basics.cryptoticker.viewmodel.ViewModelFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {

    private static final String API_ENDPOINT = "https://apiv2.bitcoinaverage.com/indices/global/";

    @Singleton @Provides
    IBitcoinAverageApi provideIBitcoinAverageApi() {

        final Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IBitcoinAverageApi.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ViewModelFactory(viewModelSubComponent.build());
    }


}
