package com.example.basics.cryptoticker.ui.Detail;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.databinding.FragmentDetailBinding;
import com.example.basics.cryptoticker.di.qualifiers.Injectible;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.util.Collections;

import javax.inject.Inject;


public class DetailFragment extends Fragment implements Injectible{

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    String TAG = this.getClass().getName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final DetailViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel.class);

        FragmentDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container, false);
        View view = binding.getRoot();
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        viewModel.getDailyCurrency().observe(this, cryptoHistories -> {

            Collections.sort(cryptoHistories, new EntryXComparator());
            LineDataSet dataSet = new LineDataSet(cryptoHistories, "Price");
            dataSet.setDrawCircles(false);
            dataSet.setDrawValues(false);

            dataSet.setDrawFilled(true);
            Drawable drawable = ContextCompat.getDrawable(this.getContext(), R.drawable.graph_gradient);
            dataSet.setFillDrawable(drawable);

            LineData data = new LineData(dataSet);

            binding.chart.setData(data);

            binding.chart.getAxisLeft().setDrawLabels(false);
            binding.chart.getAxisRight().setDrawLabels(false);
            binding.chart.getXAxis().setDrawLabels(true);
            binding.chart.getAxisLeft().setDrawGridLines(false);
            binding.chart.getXAxis().setDrawGridLines(false);
            binding.chart.getAxisRight().setDrawGridLines(false);

            XAxis xAxis = binding.chart.getXAxis();
            xAxis.setEnabled(false);

            YAxis yAxis = binding.chart.getAxisLeft();
            yAxis.setEnabled(false);

            YAxis yAxis2 = binding.chart.getAxisRight();
            yAxis2.setEnabled(false);

            binding.chart.setDrawBorders(false);
            binding.chart.setDrawGridBackground(false);

            //no legend
            binding.chart.getLegend().setEnabled(false);
            // no description text
            binding.chart.getDescription().setEnabled(false);

            // enable touch gestures
            binding.chart.setTouchEnabled(false);

            binding.chart.setViewPortOffsets(0f, 0f, 0f, 0f);
            float xMax = binding.chart.getData().getDataSetByIndex(0).getXMax();
            float xMin = 0;
            xAxis.setAxisMaximum(xMax);
            xAxis.setAxisMinimum(xMin);
            binding.chart.invalidate();

        });

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(TAG, "onDestroyView");

    }
}
