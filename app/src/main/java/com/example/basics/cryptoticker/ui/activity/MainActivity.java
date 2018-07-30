package com.example.basics.cryptoticker.ui.activity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.ui.fragment.AlarmFragment;
import com.example.basics.cryptoticker.ui.fragment.DetailFragment;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector{

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    /**
     * View pager.
     */
    @BindView(R.id.container)
    /* default */ ViewPager viewPager;

    /**
     * The bottom navigation view.
     */
    @BindView(R.id.navigation)
    /* default */ BottomNavigationView bottomNavigationView;

    /**
     * "Now Playing" resource string used for tab title.
     */
    @BindString(R.string.tab_Detail)
    /* default */ String tabTitleDetail;

    /**
     * "Favorites" resource string used for tab title.
     */
    @BindString(R.string.tab_Alarm)
    /* default */ String tabTitleAlarm;

    /**
     * "Settings" resource string used for tab title.
     */
    @BindString(R.string.tab_News)
    /* default */ String tabTitleNews;

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

    // endregion

    // region Private Inner Types

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
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

    // endregion

    // region Public Overrides

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initNavigationView();
    }

    // endregion

    // region Private Methods

    private void initNavigationView() {
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

    // endregion
}