package me.doapps.igvperu.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import me.doapps.igvperu.R;
import me.doapps.igvperu.utils.UtilFonts;

/**
 * Created by jonathan on 13/01/2015.
 */
public class CalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner spnIgv;
    private ArrayList<String> igvs;
    private EditText pbase;
    private EditText pigv;
    private EditText ptotal;
    private int igv;
    private TextView txt_sub_total;
    private TextView txt_igv;
    private TextView txt_total;

    DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
    DecimalFormat df = new DecimalFormat("0.00", simbolos);

    public static final CalculatorFragment newInstance() {
        return new CalculatorFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*textview*/

        txt_sub_total = (TextView) getView().findViewById(R.id.txt_sub_total);
        txt_igv = (TextView) getView().findViewById(R.id.txt_igv);
        txt_total = (TextView) getView().findViewById(R.id.txt_total);

        txt_sub_total.setTypeface(UtilFonts.setLatoBolt(getActivity()));
        txt_igv.setTypeface(UtilFonts.setLatoBolt(getActivity()));
        txt_total.setTypeface(UtilFonts.setLatoBolt(getActivity()));

        /*spinner*/
        spnIgv = (Spinner) getView().findViewById(R.id.spnIgv);
        igvs = new ArrayList<String>();
        igvs.add("18%");
        igvs.add("19%");

        String[] igvs = new String[]{"18%", "19%"};


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, igvs);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnIgv.setAdapter(dataAdapter);
        spnIgv.setOnItemSelectedListener(this);

        pbase = (EditText) getView().findViewById(R.id.pbase);
        pigv = (EditText) getView().findViewById(R.id.pigv);
        ptotal = (EditText) getView().findViewById(R.id.ptotal);

        /*PRECIO BASE*/
        pbase.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0 && pbase.isFocused()) {
                    try {
                        format(pbase, s.toString());
                        float preciobase = Float.valueOf(pbase.getText().toString());//Float.valueOf(s.toString());
                        float temp_1;
                        float temp_2;
                        int temp_3 = getIgv();
                        temp_1 = preciobase / 100 * temp_3;
                        temp_2 = preciobase + temp_1;
                        pigv.setText(df.format(temp_1));
                        ptotal.setText(df.format(temp_2));
                    } catch (Exception e) {
                        Log.d(null, "string no cast to float " + e.getMessage());
                    }
                } else if (pbase.isFocused()) {
                    pigv.setText("");
                    ptotal.setText("");
                }
            }
        });

        /*PRECIO IGV*/
        pigv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() > 0 && pigv.isFocused()) {
                    try {
                        format(pigv, s.toString());
                        float precioigv = Float.valueOf(s.toString());
                        int temp_3 = getIgv();
                        float temp_1 = precioigv / temp_3 * 100;
                        float temp_2 = precioigv + temp_1;
                        pbase.setText(df.format(temp_1));
                        ptotal.setText(df.format(temp_2));
                    } catch (Exception e) {
                        Log.d(null, "string no cast to float " + e.getMessage());
                    }
                } else if (pigv.isFocused()) {
                    pbase.setText("");
                    ptotal.setText("");
                }
            }
        });

        /*PRECIO TOTAL*/
        ptotal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0 && ptotal.isFocused()) {
                    try {
                        format(ptotal, s.toString());
                        float preciototal = Float.valueOf(s.toString());
                        float temp_1;
                        float temp_2;
                        int temp_3 = getIgv();
                        temp_1 = preciototal * 100 / (temp_3 + 100);
                        temp_2 = preciototal - temp_1;
                        pbase.setText(df.format(temp_1));
                        pigv.setText(df.format(temp_2));
                    } catch (Exception e) {
                        Log.d(null, "string no cast to float");
                    }
                } else if (ptotal.isFocused()) {
                    pbase.setText("");
                    pigv.setText("");
                }
            }
        });
    }

    public void format(EditText et, String textInput) {
        String data = textInput;
        int pos = data.indexOf(".");//start of 0
        if (pos != -1) {
            String Decimal = data.substring(pos + 1, data.length());//start of 1
            if (Decimal.length() > 2) {
                data = data.substring(0, data.length() - 1);
                et.setText(data);
                et.setSelection(data.length());
            }
        }
    }

    public int getIgv() {
        int temp_3;
        switch (igv) {
            case 0:
                temp_3 = 18;
                break;

            case 1:
                temp_3 = 19;
                break;
            default:
                temp_3 = 0;
                break;
        }
        return temp_3;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        igv = position;
        if (position == 0 && pbase.getText().toString().length() > 0) {
            float temp_base = Float.valueOf(pbase.getText().toString());
            float temp_igv = temp_base * 18 / 100;
            float temp_total = temp_base + temp_igv;

            pbase.setText(df.format(temp_base));
            pigv.setText(df.format(temp_igv));
            ptotal.setText(df.format(temp_total));
        }

        if (position == 1 && pbase.getText().toString().length() > 0) {
            float temp_base = Float.valueOf(pbase.getText().toString());
            float temp_igv = temp_base * 19 / 100;
            float temp_total = temp_base + temp_igv;

            pbase.setText(df.format(temp_base));
            pigv.setText(df.format(temp_igv));
            ptotal.setText(df.format(temp_total));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}