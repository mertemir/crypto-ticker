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
    IBitcoinAverageApi provideIBitcoinAverageApi(Gson gson) {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IBitcoinAverageApi.class);
    }

    @Singleton @Provides
    IBitcoinAverageSocketApi provideIBitcoinAverageSocketApi(Gson gson){

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TICKET_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IBitcoinAverageSocketApi.class);
    }

    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient().newBuilder().build();
    }

    @Singleton @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ViewModelFactory(viewModelSubComponent.build());
    }
}