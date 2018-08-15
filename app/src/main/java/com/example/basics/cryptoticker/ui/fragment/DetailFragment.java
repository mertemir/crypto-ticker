package com.example.basics.cryptoticker.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;
import com.example.basics.cryptoticker.di.qualifiers.Injectible;
import com.example.basics.cryptoticker.viewmodel.DetailViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class DetailFragment extends Fragment implements Injectible{

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    String TAG = this.getClass().getName();

    @BindView(R.id.chart)LineChart chart;

    @BindView(R.id.price_text)
    TextView priceTV;

    @BindView(R.id.time_text)
    TextView timeTV;

    @BindView(R.id.openDay_text)
    TextView openDayTV;

    @BindView(R.id.openWeek_text)
    TextView openWeekTV;

    @BindView(R.id.openMonth_text)
    TextView openMonthTV;

    @BindView(R.id.averageDay_text)
    TextView averageDayTV;

    @BindView(R.id.averageWeek_text)
    TextView averageWeekTV;

    @BindView(R.id.averageMonth_text)
    TextView averageMonthTV;

    @BindView(R.id.ask_text)
    TextView askTV;

    @BindView(R.id.bid_text)
    TextView bidTV;

    @BindView(R.id.low_text)
    TextView lowTV;

    @BindView(R.id.high_text)
    TextView highTV;

    @BindView(R.id.hourlyChangePrice_text)
    TextView hourlyChangePriceTV;

    @BindView(R.id.hourlyChangePercent_text)
    TextView hourlyChangePercentTV;

    @BindView(R.id.dailyChangePrice_text)
    TextView dailyChangePriceTV;

    @BindView(R.id.dailyChangePercent_text)
    TextView dailyChangePercentTV;

    @BindView(R.id.weeklyChangePrice_text)
    TextView weeklyChangePriceTV;

    @BindView(R.id.weeklyChangePercent_text)
    TextView weeklyChangePercentTV;

    @BindView(R.id.monthlyChangePrice_text)
    TextView monthlyChangePriceTV;

    @BindView(R.id.monthlyChangePercent_text)
    TextView monthlyChangePercentTV;

    @BindView(R.id.yearlyChangePrice_text)
    TextView yearlyChangePriceTV;

    @BindView(R.id.yearlyChangePercent_text)
    TextView yearlyChangePercentTV;

    private Unbinder unbinder;

    List<Entry> entries = new ArrayList<Entry>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final DetailViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel.class);

       viewModel.getBitcoinUSD().observe(this, cryptocurrency -> {

            priceTV.setText(String.valueOf(cryptocurrency.getLast()));
            timeTV.setText(cryptocurrency.getDisplayTimestamp());

            openDayTV.setText(String.valueOf(cryptocurrency.getOpenDay()));
            openWeekTV.setText(String.valueOf(cryptocurrency.getOpenWeek()));
            openMonthTV.setText(String.valueOf(cryptocurrency.getOpenMonth()));

            averageDayTV.setText(String.valueOf(cryptocurrency.getAverageDay()));
            averageWeekTV.setText(String.valueOf(cryptocurrency.getAverageWeek()));
            averageMonthTV.setText(String.valueOf(cryptocurrency.getAverageMonth()));

            askTV.setText(String.valueOf(cryptocurrency.getAsk()));
            bidTV.setText(String.valueOf(cryptocurrency.getBid()));
            lowTV.setText(String.valueOf(cryptocurrency.getLow()));
            highTV.setText(String.valueOf(cryptocurrency.getHigh()));

            hourlyChangePriceTV.setText(String.valueOf(cryptocurrency.getChangePriceHour()));
            hourlyChangePercentTV.setText(String.valueOf(cryptocurrency.getChangePercentHour()));

            dailyChangePriceTV.setText(String.valueOf(cryptocurrency.getChangePriceDay()));
            dailyChangePercentTV.setText(String.valueOf(cryptocurrency.getChangePercentDay()));

            weeklyChangePriceTV.setText(String.valueOf(cryptocurrency.getChangePriceWeek()));
            weeklyChangePercentTV.setText(String.valueOf(cryptocurrency.getChangePercentWeek()));

            monthlyChangePriceTV.setText(String.valueOf(cryptocurrency.getChangePriceMonth()));
            monthlyChangePercentTV.setText(String.valueOf(cryptocurrency.getChangePercentMonth()));

            yearlyChangePriceTV.setText(String.valueOf(cryptocurrency.getChangePriceYear()));
            yearlyChangePercentTV.setText(String.valueOf(cryptocurrency.getChangePercentYear()));

            changeColors(cryptocurrency);

        });

     /*   App.bitcoinPrice.observe(this, price ->{
            Log.wtf("fragment ", price);
            priceTV.setText(price);
        });*/

/*        viewModel.getCurrency().observe(this, cryptocurrency -> {

            Log.wtf("TİCKET: ", cryptocurrency);

            *//*askValue = (int) cryptocurrency.getAsk();
            lastValue=(int) cryptocurrency.getLast();*//*

        });*/

        entries.add(new Entry(1, 1));
        entries.add(new Entry(2, 5));
        entries.add(new Entry(3, 2));
        entries.add(new Entry(4, 9));

        LineDataSet dataSet = new LineDataSet(entries, "Label");

        LineData lineData = new LineData(dataSet);

        chart.setData(lineData);

        chart.invalidate(); // refresh

        viewModel.getDailyCurrency().observe(this, cryptoHistories -> {



        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, root);

        Log.d(TAG, "onCreateView");



        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(TAG, "onDestroyView");

        unbinder.unbind();
    }


    private void changeColors(CryptoEntity cryptocurrency) {
        if(!cryptocurrency.getChangePriceHour().isEmpty())
        {
            if(Double.parseDouble(cryptocurrency.getChangePriceHour())<=0)
            {
                hourlyChangePercentTV.setTextColor(getResources().getColor(R.color.redFont));
                hourlyChangePriceTV.setTextColor(getResources().getColor(R.color.redFont));
            }
        }

        if(!cryptocurrency.getChangePriceDay().isEmpty())
        {
            if(Double.parseDouble(cryptocurrency.getChangePriceDay())<=0)
            {
                dailyChangePercentTV.setTextColor(getResources().getColor(R.color.redFont));
                dailyChangePriceTV.setTextColor(getResources().getColor(R.color.redFont));
            }
        }

        if(!cryptocurrency.getChangePriceWeek().isEmpty())
        {
            if(Double.parseDouble(cryptocurrency.getChangePriceWeek())<=0)
            {
                weeklyChangePercentTV.setTextColor(getResources().getColor(R.color.redFont));
                weeklyChangePriceTV.setTextColor(getResources().getColor(R.color.redFont));
            }
        }

        if(!cryptocurrency.getChangePriceMonth().isEmpty())
        {
            if(Double.parseDouble(cryptocurrency.getChangePriceMonth())<=0)
            {
                monthlyChangePercentTV.setTextColor(getResources().getColor(R.color.redFont));
                monthlyChangePriceTV.setTextColor(getResources().getColor(R.color.redFont));
            }
        }

        if(!cryptocurrency.getChangePriceYear().isEmpty())
        {
            if(Double.parseDouble(cryptocurrency.getChangePriceYear())<=0)
            {
                yearlyChangePercentTV.setTextColor(getResources().getColor(R.color.redFont));
                yearlyChangePriceTV.setTextColor(getResources().getColor(R.color.redFont));
            }
        }

    }
}
