package com.example.basics.cryptoticker.ui.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.ui.Alarm.AlarmFragment;
import com.example.basics.cryptoticker.ui.Detail.DetailFragment;
import com.example.basics.cryptoticker.ui.News.NewsFragment;

import butterknife.BindString;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    @BindString(R.string.tab_Detail)
    String tabTitleDetail;

    @BindString(R.string.tab_Alarm)
    String tabTitleAlarm;

    @BindString(R.string.tab_News)
    String tabTitleNews;

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
                return new NewsFragment();
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
