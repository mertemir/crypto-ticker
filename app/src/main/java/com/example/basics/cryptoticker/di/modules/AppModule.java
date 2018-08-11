package com.example.basics.cryptoticker.di.modules;

import android.arch.lifecycle.ViewModelProvider;
import android.util.Log;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.di.components.ViewModelSubComponent;
import com.example.basics.cryptoticker.model.web.IBitcoinAverageApi;
import com.example.basics.cryptoticker.model.web.IBitcoinAverageSocketApi;
import com.example.basics.cryptoticker.viewmodel.ViewModelFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {

    private static final String API_ENDPOINT = "https://apiv2.bitcoinaverage.com/indices/global/";
    private static final String TICKET_ENDPOINT = "https://apiv2.bitcoinaverage.com/websocket/";


    @Singleton @Provides
    Gson provideGson(){

        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Singleton @Provides
    IBitcoinAverageApi provideIBitcoinAverageApi(Gson gson, OkHttpClient client) {

        final Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IBitcoinAverageApi.class);
    }

    @Singleton @Provides
    IBitcoinAverageSocketApi provideIBitcoinAverageSocketApi(Gson gson, OkHttpClient client){

        final Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(TICKET_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IBitcoinAverageSocketApi.class);
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Singleton @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ViewModelFactory(viewModelSubComponent.build());
    }
}