package com.example.basics.cryptoticker.ui.Main;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.basics.cryptoticker.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector{

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @BindView(R.id.container)
    ViewPager viewPager;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initNavigationView();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() { return dispatchingAndroidInjector; }

    private void initNavigationView() {
        final SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        final PageChangeListener onPageChangeListener = new PageChangeListener(bottomNavigationView);
        initViewPager(sectionsPagerAdapter, onPageChangeListener);
        initBottomNavigationListener();
    }

    private void initBottomNavigationListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_detail:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_alarm:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_news:
                    viewPager.setCurrentItem(2);
                    return true;
                default:
                    return false;
            }
        });
    }

    private void initViewPager(SectionsPagerAdapter sectionsPagerAdapter, PageChangeListener onPageChangeListener) {
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        viewPager.setCurrentItem(0);
    }
}