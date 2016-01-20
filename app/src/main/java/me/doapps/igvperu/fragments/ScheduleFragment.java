package me.doapps.igvperu.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import me.doapps.igvperu.R;
import me.doapps.igvperu.activities.MainActivity;
import me.doapps.igvperu.model.ArrayRucs;
import me.doapps.igvperu.model.OpenHelper;
import me.doapps.igvperu.utils.PreferencesUtil;
import me.doapps.igvperu.utils.UtilFonts;

/**
 * Created by jonathan on 13/01/2015.
 */
public class ScheduleFragment extends Fragment implements View.OnClickListener {

    private final String TAG = ScheduleFragment.class.getSimpleName();
    ScrollView scrollViewResult;
    LinearLayout linearLayoutSearch, linearLayoutLink;
    Button buttonSearchRuc, buttonTryAgain, buttonSaveRuc;
    OpenHelper objSqlite;
    TextView RUC, period01, period02, period03, period04, period05, period06, period07, period08, period09, period10, period11, period12,
            enerp, febrp, marrp,
            abrrp, mayrp, junrp,
            julrp, agorp, seprp,
            octrp, novrp, dicrp,
            textViewLink;
    SimpleDateFormat sdf = new SimpleDateFormat("MM");
    TableRow f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12;
    AutoCompleteTextView autoCompleteTextViewRuc;
    private EditText editTextRucSearch, editTextRucShow;
    private TextView textViewPeriod;
    private TextView textViewRegularDate;
    PreferencesUtil preferencesUtil;

    private String ruc;
    private ArrayRucs historyRucs = new ArrayRucs();

    public static final ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        buttonSearchRuc = (Button) view.findViewById(R.id.button_search_ruc);
        buttonTryAgain = (Button) view.findViewById(R.id.button_try_again);
        buttonSaveRuc = (Button) view.findViewById(R.id.button_save_ruc);

        editTextRucShow = (EditText) view.findViewById(R.id.text_view_search_ruc);
        textViewPeriod = (TextView) view.findViewById(R.id.txt_periodo);
        textViewRegularDate = (TextView) view.findViewById(R.id.txt_fecha_regular);

        f1 = (TableRow) view.findViewById(R.id.rowEne);
        f2 = (TableRow) view.findViewById(R.id.rowFeb);
        f3 = (TableRow) view.findViewById(R.id.rowMar);
        f4 = (TableRow) view.findViewById(R.id.rowAbr);
        f5 = (TableRow) view.findViewById(R.id.rowMay);
        f6 = (TableRow) view.findViewById(R.id.rowJun);
        f7 = (TableRow) view.findViewById(R.id.rowJul);
        f8 = (TableRow) view.findViewById(R.id.rowAgo);
        f9 = (TableRow) view.findViewById(R.id.rowSep);
        f10 = (TableRow) view.findViewById(R.id.rowOct);
        f11 = (TableRow) view.findViewById(R.id.rowNov);
        f12 = (TableRow) view.findViewById(R.id.rowDic);

        period01 = (TextView) view.findViewById(R.id.period01);
        period02 = (TextView) view.findViewById(R.id.period02);
        period03 = (TextView) view.findViewById(R.id.period03);
        period04 = (TextView) view.findViewById(R.id.period04);
        period05 = (TextView) view.findViewById(R.id.period05);
        period06 = (TextView) view.findViewById(R.id.period06);
        period07 = (TextView) view.findViewById(R.id.period07);
        period08 = (TextView) view.findViewById(R.id.period08);
        period09 = (TextView) view.findViewById(R.id.period09);
        period10 = (TextView) view.findViewById(R.id.period10);
        period11 = (TextView) view.findViewById(R.id.period11);
        period12 = (TextView) view.findViewById(R.id.period12);
        enerp = (TextView) view.findViewById(R.id.enerp);
        febrp = (TextView) view.findViewById(R.id.febrp);
        marrp = (TextView) view.findViewById(R.id.marrp);
        abrrp = (TextView) view.findViewById(R.id.abrrp);
        mayrp = (TextView) view.findViewById(R.id.mayrp);
        junrp = (TextView) view.findViewById(R.id.junrp);
        julrp = (TextView) view.findViewById(R.id.julrp);
        agorp = (TextView) view.findViewById(R.id.agorp);
        seprp = (TextView) view.findViewById(R.id.seprp);
        octrp = (TextView) view.findViewById(R.id.octrp);
        novrp = (TextView) view.findViewById(R.id.novrp);
        dicrp = (TextView) view.findViewById(R.id.dicrp);
        scrollViewResult = (ScrollView) view.findViewById(R.id.contentResult);
        linearLayoutSearch = (LinearLayout) view.findViewById(R.id.linear_lauoy_search);
        linearLayoutLink = (LinearLayout) view.findViewById(R.id.linear_layout_link);
        autoCompleteTextViewRuc = (AutoCompleteTextView) view.findViewById(R.id.autocomplete_ruc);
        textViewLink = (TextView) view.findViewById(R.id.text_view_link);
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        preferencesUtil = new PreferencesUtil(getActivity());

        setupParent(getView());

        textViewLink.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        autoCompleteTextViewRuc.setTypeface(UtilFonts.setLightSourceSansPro(getActivity()));
        editTextRucShow.setTypeface(UtilFonts.setLightSourceSansPro(getActivity()));
        textViewPeriod.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        textViewRegularDate.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));

        buttonSearchRuc.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));

        period01.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period02.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period03.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period04.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period05.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period06.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period07.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period08.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period09.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period10.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period11.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        period12.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));

        enerp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        febrp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        marrp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        abrrp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        mayrp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        junrp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        julrp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        agorp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        seprp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        octrp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        novrp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));
        dicrp.setTypeface(UtilFonts.setRegularSourceSansPro(getActivity()));

        buttonTryAgain.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));
        buttonSaveRuc.setTypeface(UtilFonts.setSemiBoldSourceSans(getActivity()));

        historyRucs = preferencesUtil.getHistoryRucs();
        objSqlite = ((MainActivity)getActivity()).objSqlite;

        scrollViewResult.setVisibility(View.GONE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, historyRucs.getRucs());
        autoCompleteTextViewRuc.setAdapter(adapter);

        textViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = getString(R.string.link);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
            }
        });

        autoCompleteTextViewRuc.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == 66){
                    SearchRuc();
                    return true;
                } else {
                    return false;
                }
            }
        });

        buttonTryAgain.setOnClickListener(this);
        buttonSaveRuc.setOnClickListener(this);
        buttonSearchRuc.setOnClickListener(this);
        linearLayoutLink.setOnClickListener(this);
    }

    public String[] Search(String ruc) {
        try {
            String[] show = null;
            if (!ruc.equals(" ")) {
                Object[][] Result = objSqlite.Search("schedule", new String[]{"period", "RegularPayment"}, " lastNumRuc='" + ruc.charAt(10) + "' AND status=1");
                if (Result != null) {
                    period01.setText(Result[0][0].toString());
                    period02.setText(Result[1][0].toString());
                    period03.setText(Result[2][0].toString());
                    period04.setText(Result[3][0].toString());
                    period05.setText(Result[4][0].toString());
                    period06.setText(Result[5][0].toString());
                    period07.setText(Result[6][0].toString());
                    period08.setText(Result[7][0].toString());
                    period09.setText(Result[8][0].toString());
                    period10.setText(Result[9][0].toString());
                    period11.setText(Result[10][0].toString());
                    period12.setText(Result[11][0].toString());

                    enerp.setText(Result[0][1].toString());
                    febrp.setText(Result[1][1].toString());
                    marrp.setText(Result[2][1].toString());
                    abrrp.setText(Result[3][1].toString());
                    mayrp.setText(Result[4][1].toString());
                    junrp.setText(Result[5][1].toString());
                    julrp.setText(Result[6][1].toString());
                    agorp.setText(Result[7][1].toString());
                    seprp.setText(Result[8][1].toString());
                    octrp.setText(Result[9][1].toString());
                    novrp.setText(Result[10][1].toString());
                    dicrp.setText(Result[11][1].toString());
                } else {
                    Toast.makeText(getActivity(), "Not Found!", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getActivity(), "Wrong Format!\nEnter again please!  ", Toast.LENGTH_LONG).show();
            }
            return show;
        } catch (Exception e) {
            Log.e(null, "ERROR Payment_schedule Search: " + e.getMessage());
            return null;
        }
    }

    protected void setupParent(View view) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard();
                    return false;
                }
            });
        }

        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupParent(innerView);
            }
        }
    }

    private void hideSoftKeyboard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_save_ruc:
                Log.e("ruc number", ruc);
                if(objSqlite.existRuc(ruc)<=0){
                    ((MainActivity) getActivity()).showDialog();
                    ((MainActivity) getActivity()).setEditTextRucNumber(ruc);
                }else{
                    Toast.makeText(getActivity(), R.string.ruc_exist, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_search_ruc:
                SearchRuc();
                break;
            case R.id.button_try_again:
                searchAgain();
                break;
            case R.id.linear_layout_link:
                String link = getString(R.string.link);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
                break;
            default:
                Log.e(TAG, "default");
                break;
        }

    }

    public void searchAgain(){
        scrollViewResult.setVisibility(View.GONE);
        linearLayoutSearch.setVisibility(View.VISIBLE);
        linearLayoutLink.setVisibility(View.VISIBLE);
    }

    public void SearchRuc(){
        ruc = autoCompleteTextViewRuc.getText().toString();
        if (ruc.length() == 11) {
            scrollViewResult.setVisibility(View.VISIBLE);
            linearLayoutSearch.setVisibility(View.GONE);
            linearLayoutLink.setVisibility(View.GONE);
            editTextRucShow.setText(ruc);
            autoCompleteTextViewRuc.setText("");
            Search(ruc);
            historyRucs.addRuc(ruc);
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(autoCompleteTextViewRuc.getWindowToken(), 0);
            } catch (Exception e){e.printStackTrace();}
            preferencesUtil.setHistoryRucs(historyRucs);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, historyRucs.getRucs());
            autoCompleteTextViewRuc.setAdapter(adapter);
        } else {
            Toast.makeText(getActivity(), "Formato incorrecto!!", Toast.LENGTH_LONG).show();
        }
    }

}
