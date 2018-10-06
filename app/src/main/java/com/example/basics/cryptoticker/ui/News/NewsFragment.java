package com.example.basics.cryptoticker.ui.News;

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

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.di.qualifiers.Injectible;
import com.example.basics.cryptoticker.ui.News.NewsAdapter;
import com.example.basics.cryptoticker.ui.News.NewsViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewsFragment extends Fragment implements Injectible {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.news_rv)
    RecyclerView newsRV;

    private NewsAdapter mAdapter;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, root);

        initAdapter();

        final NewsViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel.class);

        viewModel.getNews().observe(this, news -> mAdapter.setNewsList(news,getContext()));

        return root;
    }

    private void initAdapter() {
        mAdapter = new NewsAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        newsRV.setLayoutManager(mLayoutManager);
        newsRV.setItemAnimator(new DefaultItemAnimator());
        newsRV.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }
}



