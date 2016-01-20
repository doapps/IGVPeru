package me.doapps.igvperu.utils;

import me.doapps.igvperu.fragments.CalculatorFragment;
import me.doapps.igvperu.fragments.HistoryFragment;
import me.doapps.igvperu.fragments.ScheduleFragment;

/**
 * Created by William_ST on 18/01/16.
 */
public class FragmentUtil {

    private CalculatorFragment calculatorFragment;
    private ScheduleFragment scheduleFragment;
    private HistoryFragment historyFragment;

    public FragmentUtil() {
        this.calculatorFragment = new CalculatorFragment();
        this.scheduleFragment = new ScheduleFragment();
        this.historyFragment = new HistoryFragment();
    }

    public CalculatorFragment getCalculatorFragment() {
        return calculatorFragment;
    }

    public ScheduleFragment getScheduleFragment() {
        return scheduleFragment;
    }

    public HistoryFragment getHistoryFragment() {
        return historyFragment;
    }
}
