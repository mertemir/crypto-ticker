package com.example.basics.cryptoticker.ui.Main;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;

import com.example.basics.cryptoticker.R;

public class PageChangeListener implements ViewPager.OnPageChangeListener {

    BottomNavigationView btmNavView;

    public PageChangeListener(BottomNavigationView bottomNavigationView) {
        this.btmNavView = bottomNavigationView;
    }

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

        btmNavView.setSelectedItemId(itemId);
    }

    @Override
    public void onPageScrollStateChanged(final int state) {
        // ignore
    }
}
