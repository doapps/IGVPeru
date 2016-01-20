package me.doapps.igvperu.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import me.doapps.igvperu.R;
import me.doapps.igvperu.model.ArrayRucs;
import me.doapps.igvperu.model.OpenHelper;
import me.doapps.igvperu.utils.PreferencesUtil;
import me.doapps.igvperu.utils.UtilFonts;

/**
 * Created by mili on 03/04/2015.
 */
public class FavoriteActivity extends AppCompatActivity {
    private Button buttonSearchRuc;
    private TextView txt_ruc_mostrado;
    private TextView txt_periodo;
    private TextView txt_fecha_regular;

    private TableRow f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12;
    private TextView period01, period02, period03, period04, period05, period06, period07, period08, period09, period10, period11, period12, enerp, febrp, marrp, abrrp, mayrp, junrp, julrp, agorp, seprp, octrp, novrp, dicrp;
    private AutoCompleteTextView editTextRuc;
    private TextView textViewLink;

    private ArrayRucs historyRucs = new ArrayRucs();
    private PreferencesUtil preferencesUtil;
    private OpenHelper objSqlite;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM");

    private String ruc;
    private String razon;
    private LinearLayout linearLayoutSearch, linearLayoutLink;
    private ScrollView scrollViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_schedule);
        objSqlite = new OpenHelper(this, "IGVPeru", null, OpenHelper.BD_VERSION);

        ruc = getIntent().getExtras().getString("ruc");
        razon = getIntent().getExtras().getString("razon");
        Log.e("llego ruc", ruc);
        linearLayoutSearch = (LinearLayout) findViewById(R.id.linear_lauoy_search);
        linearLayoutLink = (LinearLayout) findViewById(R.id.linear_layout_link);
        scrollViewResult = (ScrollView) findViewById(R.id.contentResult);

        buttonSearchRuc = (Button) findViewById(R.id.button_search_ruc);
        txt_ruc_mostrado = (TextView) findViewById(R.id.text_view_search_ruc);
        txt_periodo = (TextView) findViewById(R.id.txt_periodo);
        txt_fecha_regular = (TextView) findViewById(R.id.txt_fecha_regular);
        txt_ruc_mostrado.setTypeface(UtilFonts.setLightSourceSansPro(this));
        txt_periodo.setTypeface(UtilFonts.setSemiBoldSourceSans(this));
        txt_fecha_regular.setTypeface(UtilFonts.setSemiBoldSourceSans(this));

        f1 = (TableRow) findViewById(R.id.rowEne);
        f2 = (TableRow) findViewById(R.id.rowFeb);
        f3 = (TableRow) findViewById(R.id.rowMar);
        f4 = (TableRow) findViewById(R.id.rowAbr);
        f5 = (TableRow) findViewById(R.id.rowMay);
        f6 = (TableRow) findViewById(R.id.rowJun);
        f7 = (TableRow) findViewById(R.id.rowJul);
        f8 = (TableRow) findViewById(R.id.rowAgo);
        f9 = (TableRow) findViewById(R.id.rowSep);
        f10 = (TableRow) findViewById(R.id.rowOct);
        f11 = (TableRow) findViewById(R.id.rowNov);
        f12 = (TableRow) findViewById(R.id.rowDic);

        period01 = (TextView) findViewById(R.id.period01);
        period02 = (TextView) findViewById(R.id.period02);
        period03 = (TextView) findViewById(R.id.period03);
        period04 = (TextView) findViewById(R.id.period04);
        period05 = (TextView) findViewById(R.id.period05);
        period06 = (TextView) findViewById(R.id.period06);
        period07 = (TextView) findViewById(R.id.period07);
        period08 = (TextView) findViewById(R.id.period08);
        period09 = (TextView) findViewById(R.id.period09);
        period10 = (TextView) findViewById(R.id.period10);
        period11 = (TextView) findViewById(R.id.period11);
        period12 = (TextView) findViewById(R.id.period12);
        enerp = (TextView) findViewById(R.id.enerp);
        febrp = (TextView) findViewById(R.id.febrp);
        marrp = (TextView) findViewById(R.id.marrp);
        abrrp = (TextView) findViewById(R.id.abrrp);
        mayrp = (TextView) findViewById(R.id.mayrp);
        junrp = (TextView) findViewById(R.id.junrp);
        julrp = (TextView) findViewById(R.id.julrp);
        agorp = (TextView) findViewById(R.id.agorp);
        seprp = (TextView) findViewById(R.id.seprp);
        octrp = (TextView) findViewById(R.id.octrp);
        novrp = (TextView) findViewById(R.id.novrp);
        dicrp = (TextView) findViewById(R.id.dicrp);
//        contentResult = (LinearLayout) findViewById(R.id.contentResult);
        editTextRuc = (AutoCompleteTextView) findViewById(R.id.autocomplete_ruc);
        textViewLink = (TextView) findViewById(R.id.text_view_link);

        editTextRuc.setEnabled(false);
        editTextRuc.setTextColor(getResources().getColor(R.color.white));
        preferencesUtil = new PreferencesUtil(this);
        historyRucs = preferencesUtil.getHistoryRucs();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, historyRucs.getRucs());
        editTextRuc.setAdapter(adapter);

        textViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = getString(R.string.link);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
            }
        });


        buttonSearchRuc.setVisibility(View.GONE);



        editTextRuc.setText(ruc);
        Search(ruc);
        historyRucs.addRuc(ruc);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editTextRuc.getWindowToken(), 0);
        preferencesUtil.setHistoryRucs(historyRucs);
        ArrayAdapter<String> adapter_ = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, historyRucs.getRucs());
        editTextRuc.setAdapter(adapter_);
        ((Toolbar) findViewById(R.id.toolbar)).setVisibility(View.VISIBLE);
        linearLayoutSearch.setVisibility(View.GONE);
        scrollViewResult.setVisibility(View.VISIBLE);
        linearLayoutLink.setVisibility(View.GONE);
        ((LinearLayout) findViewById(R.id.linear_layout_options)).setVisibility(View.GONE);
        ((LinearLayout) findViewById(R.id.linear_layout_temp)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.text_view_search_ruc)).setText(ruc);
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
                    Toast.makeText(this, "Not Found!", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Wrong Format!\nEnter again please!  ", Toast.LENGTH_LONG).show();
            }
            return show;
        } catch (Exception e) {
            Log.e(null, "ERROR Payment_schedule Search: " + e.getMessage());
            return null;
        }
    }

}
