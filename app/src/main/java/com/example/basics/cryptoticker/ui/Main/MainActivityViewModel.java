package com.example.basics.cryptoticker.ui.Main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.basics.cryptoticker.data.Repository;

import javax.inject.Inject;

public class MainActivityViewModel extends AndroidViewModel {

    @Inject
    public MainActivityViewModel(@NonNull Repository repository, @NonNull Application application) {
        super(application);
    }

}
