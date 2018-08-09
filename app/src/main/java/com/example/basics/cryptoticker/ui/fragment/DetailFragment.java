package com.example.basics.cryptoticker.ui.fragment;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.di.Injectible;
import com.example.basics.cryptoticker.ui.activity.MainActivity;
import com.example.basics.cryptoticker.viewmodel.DetailViewModel;
import com.example.basics.cryptoticker.viewmodel.MainActivityViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.w3c.dom.Text;

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

    @BindView(R.id.price_text)
    TextView priceTV;
 //   @BindView(R.id.ask) TextView ask;
 //   @BindView(R.id.last) TextView last;
    @BindView(R.id.chart)LineChart chart;

    private Unbinder unbinder;

    List<Entry> entries = new ArrayList<Entry>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final DetailViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel.class);

        viewModel.getBitcoinPrice().observe(this, price ->{
            Log.wtf("fragment ", price);
            priceTV.setText(price);
        });

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
}
