package me.doapps.igvperu.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.doapps.igvperu.fragments.CalculatorFragment;
import me.doapps.igvperu.fragments.HistoryFragment;
import me.doapps.igvperu.fragments.ScheduleFragment;

/**
 * Created by jonathan on 13/01/2015.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private String[] TABS = {"CALCULADORA", "CRONOGRAMA", "HISTORIAL"};

    public TabAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = CalculatorFragment.newInstance();
        switch (position) {
            case 0:
                fragment = CalculatorFragment.newInstance();
                break;
            case 1:
                fragment = ScheduleFragment.newInstance();
                break;
            case 2:
                fragment = HistoryFragment.newsInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TABS[position];
    }
}
