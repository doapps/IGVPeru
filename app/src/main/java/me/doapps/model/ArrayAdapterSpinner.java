package me.doapps.model;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Johuan on 16/01/2015.
 */
public class ArrayAdapterSpinner<T> extends ArrayAdapter<T>{

    public ArrayAdapterSpinner(Context ctx, T[] objects)
    {
        super(ctx, android.R.layout.simple_spinner_item, objects);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        ((TextView) v).setTextColor(Color.WHITE);
        return v;
    }


    /*
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        font = Typeface.createFromAsset(getAssets(), "gloriahallelujah.ttf");
        ((TextView) v).setTypeface(font);
        return v;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v =super.getDropDownView(position, convertView, parent);
        font = Typeface.createFromAsset(getAssets(), "gloriahallelujah.ttf");
        ((TextView) v).setTypeface(font);
        return v;
    }
    */
}
