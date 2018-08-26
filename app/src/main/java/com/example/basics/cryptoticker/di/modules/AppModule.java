package com.example.basics.cryptoticker.di.modules;

import android.app.NotificationManager;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.example.basics.cryptoticker.data.model.web.IBitcoinAverageApi;
import com.example.basics.cryptoticker.data.model.web.NewsApi;
import com.example.basics.cryptoticker.data.socket.Authentication;
import com.example.basics.cryptoticker.data.socket.SocketListener;
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

    private static final String BTC_API_ENDPOINT = "https://apiv2.bitcoinaverage.com/";
    private static final String NEWS_API_ENDPOINT = "https://newsapi.org/v2/";

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

    @Provides
    NotificationManager provideNotificationManager(Context context){ return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE); }

    @Singleton @Provides
    IBitcoinAverageApi provideIBitcoinAverageApi(Gson gson, OkHttpClient client) {

        final Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BTC_API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IBitcoinAverageApi.class);
    }

    @Singleton @Provides
    NewsApi provideNewsApi(Gson gson, OkHttpClient client) {

        final Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(NEWS_API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(NewsApi.class);
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