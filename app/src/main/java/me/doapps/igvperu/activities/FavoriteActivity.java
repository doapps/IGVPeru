package me.doapps.igvperu.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.shamanland.fab.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.doapps.igvperu.R;
import me.doapps.igvperu.model.ArrayRucs;
import me.doapps.igvperu.model.OpenHelper;
import me.doapps.igvperu.utils.PreferencesUtil;
import me.doapps.igvperu.utils.UtilFonts;

/**
 * Created by mili on 03/04/2015.
 */
public class FavoriteActivity extends ActionBarActivity {
    private Button buttonSearchRuc;
    private TextView txt_cronograma;
    private TextView txt_ruc_buscado;
    private TextView txt_ruc_mostrado;
    private TextView txt_periodo;
    private TextView txt_fecha_regular;

    private TableRow f1;
    private TableRow f2;
    private TableRow f3;
    private TableRow f4;
    private TableRow f5;
    private TableRow f6;
    private TableRow f7;
    private TableRow f8;
    private TableRow f9;
    private TableRow f10;
    private TableRow f11;
    private TableRow f12;

    private TextView RUC;
    private TextView period01;
    private TextView period02;
    private TextView period03;
    private TextView period04;
    private TextView period05;
    private TextView period06;
    private TextView period07;
    private TextView period08;
    private TextView period09;
    private TextView period10;
    private TextView period11;
    private TextView period12;

    private TextView enerp;
    private TextView febrp;
    private TextView marrp;
    private TextView abrrp;
    private TextView mayrp;
    private TextView junrp;
    private TextView julrp;
    private TextView agorp;
    private TextView seprp;
    private TextView octrp;
    private TextView novrp;
    private TextView dicrp;
    private LinearLayout contentResult;
    private AutoCompleteTextView editTextRuc;
    private TextView textViewLink;

    private ArrayRucs historyRucs = new ArrayRucs();
    private PreferencesUtil preferencesUtil;
    private OpenHelper objSqlite;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM");

    private String ruc;
    private String razon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_schedule);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ruc = getIntent().getExtras().getString("ruc");
        razon = getIntent().getExtras().getString("razon");
        Log.e("llego ruc", ruc);

        getSupportActionBar().setTitle(razon);

        buttonSearchRuc = (Button) findViewById(R.id.buttonSearchRuc);
        txt_cronograma = (TextView) findViewById(R.id.txt_cronograma);
        txt_ruc_buscado = (TextView) findViewById(R.id.txt_ruc_buscado);

        txt_ruc_mostrado = (TextView) findViewById(R.id.textViewSearchRuc);
        txt_periodo = (TextView) findViewById(R.id.txt_periodo);
        txt_fecha_regular = (TextView) findViewById(R.id.txt_fecha_regular);

        txt_cronograma.setTypeface(UtilFonts.setLatoBolt(this));
        txt_ruc_buscado.setTypeface(UtilFonts.setLatoReg(this));
        txt_ruc_mostrado.setTypeface(UtilFonts.setLatoReg(this));
        txt_periodo.setTypeface(UtilFonts.setLatoReg(this));
        txt_fecha_regular.setTypeface(UtilFonts.setLatoReg(this));

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

        RUC = (TextView) findViewById(R.id.textViewSearchRuc);
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
        contentResult = (LinearLayout) findViewById(R.id.contentResult);
        editTextRuc = (AutoCompleteTextView) findViewById(R.id.editTextRuc);
        textViewLink = (TextView) findViewById(R.id.textViewLink);

        preferencesUtil = new PreferencesUtil(this);
        historyRucs = preferencesUtil.getHistoryRucs();
        objSqlite = new OpenHelper(this, "IGVPeru", null, 4);

        //try {

        contentResult.setVisibility(View.GONE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, historyRucs.getRucs());
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

        String month = sdf.format(new Date());

        if (month.equals("01")) {
            f1.setBackgroundColor(getResources().getColor(R.color.red_800));
        } else {
            if (month.equals("02")) {
                f2.setBackgroundColor(getResources().getColor(R.color.red_800));
            } else {
                if (month.equals("03")) {
                    f3.setBackgroundColor(getResources().getColor(R.color.red_800));
                } else {
                    if (month.equals("04")) {
                        f4.setBackgroundColor(getResources().getColor(R.color.red_800));
                    } else {
                        if (month.equals("05")) {
                            f5.setBackgroundColor(getResources().getColor(R.color.red_800));
                        } else {
                            if (month.equals("06")) {
                                f6.setBackgroundColor(getResources().getColor(R.color.red_800));
                            } else {
                                if (month.equals("07")) {
                                    f7.setBackgroundColor(getResources().getColor(R.color.red_800));
                                } else {
                                    if (month.equals("08")) {
                                        f8.setBackgroundColor(getResources().getColor(R.color.red_800));
                                    } else {
                                        if (month.equals("09")) {
                                            f9.setBackgroundColor(getResources().getColor(R.color.red_800));
                                        } else {
                                            if (month.equals("10")) {
                                                f10.setBackgroundColor(getResources().getColor(R.color.red_800));
                                            } else {
                                                if (month.equals("11")) {
                                                    f11.setBackgroundColor(getResources().getColor(R.color.red_800));
                                                } else {
                                                    if (month.equals("12")) {
                                                        f12.setBackgroundColor(getResources().getColor(R.color.red_800));
                                                    } else {
                                                        Log.e(null, "ERROR: Schedule focus");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        contentResult.setVisibility(View.VISIBLE);
        RUC.setText(ruc);
        editTextRuc.setText(ruc);
        Search(ruc);
        historyRucs.addRuc(ruc);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editTextRuc.getWindowToken(), 0);
        preferencesUtil.setHistoryRucs(historyRucs);
        ArrayAdapter<String> adapter_ = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, historyRucs.getRucs());
        editTextRuc.setAdapter(adapter_);
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
                    period01.setTextColor(Color.WHITE);
                    period02.setTextColor(Color.WHITE);
                    period03.setTextColor(Color.WHITE);
                    period04.setTextColor(Color.WHITE);
                    period05.setTextColor(Color.WHITE);
                    period06.setTextColor(Color.WHITE);
                    period07.setTextColor(Color.WHITE);
                    period08.setTextColor(Color.WHITE);
                    period09.setTextColor(Color.WHITE);
                    period10.setTextColor(Color.WHITE);
                    period11.setTextColor(Color.WHITE);
                    period12.setTextColor(Color.WHITE);

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

                    enerp.setTextColor(Color.WHITE);
                    febrp.setTextColor(Color.WHITE);
                    marrp.setTextColor(Color.WHITE);
                    abrrp.setTextColor(Color.WHITE);
                    mayrp.setTextColor(Color.WHITE);
                    junrp.setTextColor(Color.WHITE);
                    julrp.setTextColor(Color.WHITE);
                    agorp.setTextColor(Color.WHITE);
                    seprp.setTextColor(Color.WHITE);
                    octrp.setTextColor(Color.WHITE);
                    novrp.setTextColor(Color.WHITE);
                    dicrp.setTextColor(Color.WHITE);
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
