package com.example.basics.cryptoticker.ui.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.ui.fragment.AlarmFragment;
import com.example.basics.cryptoticker.ui.fragment.DetailFragment;
import com.example.basics.cryptoticker.viewmodel.MainActivityViewModel;

import javax.inject.Inject;

import butterknife.BindString;
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

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @BindView(R.id.drawer_list)
    ListView listView;

    @BindString(R.string.tab_Detail)
    String tabTitleDetail;

    @BindString(R.string.tab_Alarm)
    String tabTitleAlarm;

    @BindString(R.string.tab_News)
    String tabTitleNews;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initNavigationView();
    }

    /**
     * Listener used to change the selected item in the bottom navigation view when the page is switched.
     */
    private final OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
            // ignore
        }

        @Override
        public void onPageSelected(final int position) {
            final int itemId;
            switch (position) {
                case 0:
                    itemId = R.id.navigation_detail;
                    break;
                case 1:
                    itemId = R.id.navigation_alarm;
                    break;
                case 2:
                    itemId = R.id.navigation_news;
                    break;
                default:
                    return;
            }

            bottomNavigationView.setSelectedItemId(itemId);
        }

        @Override
        public void onPageScrollStateChanged(final int state) {
            // ignore
        }
    };

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    private class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        SectionsPagerAdapter(final FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(final int position) {
            switch (position) {
                case 0:
                    return new DetailFragment();
                case 1:
                    return new AlarmFragment();
                case 2:
                    return new AlarmFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(final int position) {
            switch (position) {
                case 0:
                    return tabTitleDetail;
                case 1:
                    return tabTitleAlarm;
                case 2:
                    return tabTitleNews;
                default:
                    return null;
            }
        }
    }


    private void initNavigationView() {

        final MainActivityViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel.class);
    //    viewModel.connectSocket();
        viewModel.populateDrawerList(listView);

        setSupportActionBar(toolbar);
        mNavigationView.setItemIconTintList(null);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,  mDrawerLayout, toolbar,
                R.string.OPEN, R.string.CLOSED
        );

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle.syncState();

        final SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        viewPager.setCurrentItem(0);
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
}