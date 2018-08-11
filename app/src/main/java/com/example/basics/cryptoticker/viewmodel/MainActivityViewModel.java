package com.example.basics.cryptoticker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.model.ListItem;
import com.example.basics.cryptoticker.model.web.BitcoinAverageRepository;
import com.example.basics.cryptoticker.ui.DrawerListAdapter;
import com.example.basics.cryptoticker.ui.activity.MainActivity;


import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivityViewModel extends AndroidViewModel {

    private final BitcoinAverageRepository bitcoinAverageRepository;

    ListItem btc, dash, eth, ltc, xmr, xrp, zec;

    ArrayList<ListItem> listItems = new ArrayList<>();

    DrawerListAdapter adapter;

    @Inject
    public MainActivityViewModel(@NonNull BitcoinAverageRepository bitcoinAverageRepository, @NonNull Application application) {
        super(application);
        this.bitcoinAverageRepository = bitcoinAverageRepository;
        bitcoinAverageRepository.getBitcoinUSD();

        btc = new ListItem("Bitcoin", App.bitcoinPrice.getValue(), R.drawable.btc);
        dash = new ListItem("Dash", App.bitcoinPrice.getValue(), R.drawable.dash);
        eth = new ListItem("Etherium", App.bitcoinPrice.getValue(), R.drawable.eth);
        ltc = new ListItem("Litecoin", App.bitcoinPrice.getValue(), R.drawable.ltc);
        xmr = new ListItem("Monero",App.bitcoinPrice.getValue(), R.drawable.xmr);
        xrp = new ListItem("Ripple",App.bitcoinPrice.getValue(), R.drawable.xrp);
        zec = new ListItem("Zcash",App.bitcoinPrice.getValue(), R.drawable.zec);

        listItems.add(btc);
        listItems.add(dash);
        listItems.add(eth);
        listItems.add(ltc);
        listItems.add(xmr);
        listItems.add(xrp);
        listItems.add(zec);

        adapter = new DrawerListAdapter(getApplication().getApplicationContext(), listItems);

    }
/*

    public void connectSocket() { bitcoinAverageRepository.connectSocket(); }
*/

    public void populateDrawerList(ListView listView){
        listView.setAdapter(adapter);
    }



}
