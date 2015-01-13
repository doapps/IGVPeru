package me.doapps.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.doapps.fragments.CalculatorFragment;
import me.doapps.fragments.ScheduleFragment;

/**
 * Created by jonathan on 13/01/2015.
 */
public class TabAdapter extends FragmentPagerAdapter {

    public TabAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return CalculatorFragment.newInstance();
        }
        else{
            return ScheduleFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "CALCULADORA";
                break;
            case 1:
                title = "CRONOGRAMA";
                break;
            default:
                title = "CALCULADORA";
                break;
        }
        return title;
    }
}
