package me.doapps.igvperu.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import me.doapps.igvperu.utils.UtilFonts;

/**
 * Created by William_ST on 15/01/16.
 */
public class MySpinnerAdapter extends ArrayAdapter<String> {

    private Context context;

    public MySpinnerAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.context = context;
    }

    // Affects default (closed) state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTypeface(UtilFonts.setSemiBoldSourceSans(context));
        return view;
    }

    // Affects opened state of the spinner
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        view.setTypeface(UtilFonts.setSemiBoldSourceSans(context));
        return view;
    }
}