package com.example.basics.cryptoticker.ui.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.data.db.entity.AlarmEntity;
import com.example.basics.cryptoticker.di.qualifiers.Injectible;
import com.example.basics.cryptoticker.ui.AlarmAdapter;
import com.example.basics.cryptoticker.viewmodel.AlarmViewModel;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class AlarmFragment extends Fragment implements Injectible{

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.alarm_RecyclerView)
    RecyclerView alarmRV;

    @BindView(R.id.alarm_add_button)
    Button alarmAddBTN;

    @BindView(R.id.alarm_price_editText)
    EditText alarmPriceET;

    private AlarmAdapter mAdapter;

    private Unbinder unbinder;

    private Double bitcoinPrice = 0.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_alarm, container, false);
        unbinder = ButterKnife.bind(this, root);

        mAdapter = new AlarmAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        alarmRV.setLayoutManager(mLayoutManager);
        alarmRV.setItemAnimator(new DefaultItemAnimator());
        alarmRV.setAdapter(mAdapter);

        final AlarmViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(AlarmViewModel.class);
        viewModel.getAlarms().observe(this, alarms -> mAdapter.setAlarmList(alarms));

        viewModel.getBitcoinUSD().observe(this, cryptoEntity -> {
            if(cryptoEntity != null)
                bitcoinPrice = Double.parseDouble(cryptoEntity.getLast());
        });

        alarmAddBTN.setOnClickListener(v -> {
            if(!alarmPriceET.getText().toString().matches("") && bitcoinPrice != null)
            {
                String time = Calendar.getInstance().getTime().toString();

                AlarmEntity newAlarm = new AlarmEntity();
                newAlarm.setDate(time.substring(4,20) + time.substring(30,34));
                newAlarm.setPrice(Double.parseDouble(alarmPriceET.getText().toString()));

                if(bitcoinPrice > Double.parseDouble(alarmPriceET.getText().toString()))
                    newAlarm.setAndHigher(0);
                else if(bitcoinPrice < Double.parseDouble(alarmPriceET.getText().toString()))
                    newAlarm.setAndHigher(1);

                viewModel.insertAlarm(newAlarm);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }
}
