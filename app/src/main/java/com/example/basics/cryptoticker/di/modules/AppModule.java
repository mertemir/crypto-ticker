package com.example.basics.cryptoticker.di.modules;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.data.db.CryptoDatabase;
import com.example.basics.cryptoticker.data.db.dao.CryptoDao;
import com.example.basics.cryptoticker.data.socket.Authentication;
import com.example.basics.cryptoticker.data.socket.SocketListener;
import com.example.basics.cryptoticker.data.model.IBitcoinAverageApi;
import com.example.basics.cryptoticker.di.qualifiers.ApplicationContext;
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

    private static final String API_ENDPOINT = "https://apiv2.bitcoinaverage.com/";

    @Provides
    Authentication provideAuthentication(){ return new Authentication(); }

    @Provides
    SocketListener provideSocketListener(){return new SocketListener(); }

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

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(){ return new OkHttpClient.Builder().build(); }

    @Singleton @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ViewModelFactory(viewModelSubComponent.build());
    }
}