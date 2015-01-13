package me.doapps.igvperu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Bryam on 13/01/2015.
 */
public class Calculator_Activity extends ActionBarActivity{

    private Spinner spnIgv;
    private ArrayList<String> igvs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        spnIgv = (Spinner)findViewById(R.id.spnIgv);
        igvs = new ArrayList<String>();
        igvs.add("18%");
        igvs.add("19%");

        ArrayAdapter<String>dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,igvs);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnIgv.setAdapter(dataAdapter);



    }
}
