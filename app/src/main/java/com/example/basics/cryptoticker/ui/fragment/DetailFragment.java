package com.example.basics.cryptoticker.ui.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.data.db.entity.CryptoEntity;
import com.example.basics.cryptoticker.data.model.pojo.CryptoHistory;
import com.example.basics.cryptoticker.di.qualifiers.Injectible;
import com.example.basics.cryptoticker.viewmodel.DetailViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class DetailFragment extends Fragment implements Injectible{

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    String TAG = this.getClass().getName();

    @BindView(R.id.chart)
    LineChart chart;

    @BindView(R.id.price_text)
    TextView priceTV;

    @BindView(R.id.time_text)
    TextView timeTV;

    @BindView(R.id.date_text)
    TextView dateTV;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, root);



        final DetailViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel.class);

        viewModel.getBitcoinUSD().observe(this, cryptocurrency -> {

            setDataToUI(cryptocurrency);

        });

        viewModel.getDailyCurrency().observe(this, cryptoHistories -> {

            Collections.sort(cryptoHistories, new EntryXComparator());
            LineDataSet dataSet = new LineDataSet(cryptoHistories, "Price");
            dataSet.setDrawCircles(false);
            dataSet.setDrawValues(false);

            dataSet.setDrawFilled(true);
            Drawable drawable = ContextCompat.getDrawable(this.getContext(), R.drawable.graph_gradient);
            dataSet.setFillDrawable(drawable);

            LineData data = new LineData(dataSet);

            chart.setData(data);

            chart.getAxisLeft().setDrawLabels(false);
            chart.getAxisRight().setDrawLabels(false);
            chart.getXAxis().setDrawLabels(false);
            chart.getAxisLeft().setDrawGridLines(false);
            chart.getXAxis().setDrawGridLines(false);
            chart.getAxisRight().setDrawGridLines(false);

            XAxis xAxis = chart.getXAxis();
            xAxis.setEnabled(false);

            YAxis yAxis = chart.getAxisLeft();
            yAxis.setEnabled(false);

            YAxis yAxis2 = chart.getAxisRight();
            yAxis2.setEnabled(false);

            chart.setDrawBorders(false);
            chart.setDrawGridBackground(false);

            //no legend
            chart.getLegend().setEnabled(false);
            // no description text
            chart.getDescription().setEnabled(false);

            // enable touch gestures
            chart.setTouchEnabled(false);

            chart.setViewPortOffsets(0f, 0f, 0f, 0f);
            float xMax = chart.getData().getDataSetByIndex(0).getXMax();
            float xMin = 0;
            xAxis.setAxisMaximum(xMax);
            xAxis.setAxisMinimum(xMin);
            chart.invalidate();

        });

        return root;

    }

    private void setDataToUI(CryptoEntity cryptocurrency) {

        if(cryptocurrency != null)
        {
            priceTV.setText("$ " + cryptocurrency.getLast());
            dateTV.setText(cryptocurrency.getDisplayTimestamp().substring(0,10));
            timeTV.setText(cryptocurrency.getDisplayTimestamp().substring(10,19) + " GMT");

            openDayTV.setText("$ " + cryptocurrency.getOpenDay());
            openWeekTV.setText("$ " + cryptocurrency.getOpenWeek());
            openMonthTV.setText("$ " + cryptocurrency.getOpenMonth());

            averageDayTV.setText("$ " + cryptocurrency.getAverageDay());
            averageWeekTV.setText("$ " + cryptocurrency.getAverageWeek());
            averageMonthTV.setText("$ " + cryptocurrency.getAverageMonth());

            askTV.setText("$ " + cryptocurrency.getAsk());
            bidTV.setText("$ " + cryptocurrency.getBid());
            lowTV.setText("$ " + cryptocurrency.getLow());
            highTV.setText("$ " + cryptocurrency.getHigh());

            hourlyChangePriceTV.setText("$ " + cryptocurrency.getChangePriceHour());
            hourlyChangePercentTV.setText(cryptocurrency.getChangePercentHour() + " %");

            dailyChangePriceTV.setText("$ " + cryptocurrency.getChangePriceDay());
            dailyChangePercentTV.setText(cryptocurrency.getChangePercentDay() + " %");

            weeklyChangePriceTV.setText("$ " + cryptocurrency.getChangePriceWeek());
            weeklyChangePercentTV.setText(cryptocurrency.getChangePercentWeek() + " %");

            monthlyChangePriceTV.setText("$ " + cryptocurrency.getChangePriceMonth());
            monthlyChangePercentTV.setText(cryptocurrency.getChangePercentMonth() + " %");

            yearlyChangePriceTV.setText("$ " + cryptocurrency.getChangePriceYear());
            yearlyChangePercentTV.setText(cryptocurrency.getChangePercentYear() + " %");

            changeColors(cryptocurrency);
        }
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
            else
            {
                hourlyChangePercentTV.setTextColor(getResources().getColor(R.color.greenFont));
                hourlyChangePriceTV.setTextColor(getResources().getColor(R.color.greenFont));
            }
        }

        if(!cryptocurrency.getChangePriceDay().isEmpty())
        {
            if(Double.parseDouble(cryptocurrency.getChangePriceDay())<=0)
            {
                dailyChangePercentTV.setTextColor(getResources().getColor(R.color.redFont));
                dailyChangePriceTV.setTextColor(getResources().getColor(R.color.redFont));
            }
            else
            {
                dailyChangePercentTV.setTextColor(getResources().getColor(R.color.greenFont));
                dailyChangePriceTV.setTextColor(getResources().getColor(R.color.greenFont));
            }
        }

        if(!cryptocurrency.getChangePriceWeek().isEmpty())
        {
            if(Double.parseDouble(cryptocurrency.getChangePriceWeek())<=0)
            {
                weeklyChangePercentTV.setTextColor(getResources().getColor(R.color.redFont));
                weeklyChangePriceTV.setTextColor(getResources().getColor(R.color.redFont));
            }
            else
            {
                weeklyChangePercentTV.setTextColor(getResources().getColor(R.color.greenFont));
                weeklyChangePriceTV.setTextColor(getResources().getColor(R.color.greenFont));
            }
        }

        if(!cryptocurrency.getChangePriceMonth().isEmpty())
        {
            if(Double.parseDouble(cryptocurrency.getChangePriceMonth())<=0)
            {
                monthlyChangePercentTV.setTextColor(getResources().getColor(R.color.redFont));
                monthlyChangePriceTV.setTextColor(getResources().getColor(R.color.redFont));
            }
            else
            {
                monthlyChangePercentTV.setTextColor(getResources().getColor(R.color.greenFont));
                monthlyChangePriceTV.setTextColor(getResources().getColor(R.color.greenFont));
            }
        }

        if(!cryptocurrency.getChangePriceYear().isEmpty())
        {
            if(Double.parseDouble(cryptocurrency.getChangePriceYear())<=0)
            {
                yearlyChangePercentTV.setTextColor(getResources().getColor(R.color.redFont));
                yearlyChangePriceTV.setTextColor(getResources().getColor(R.color.redFont));
            }
            else
            {
                yearlyChangePercentTV.setTextColor(getResources().getColor(R.color.greenFont));
                yearlyChangePriceTV.setTextColor(getResources().getColor(R.color.greenFont));
            }
        }
    }
}
