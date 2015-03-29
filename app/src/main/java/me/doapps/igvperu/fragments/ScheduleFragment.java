package me.doapps.igvperu.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import me.doapps.igvperu.dialogs.FavoriteDialog;
import me.doapps.igvperu.model.ArrayRucs;
import me.doapps.igvperu.model.OpenHelper;
import me.doapps.igvperu.utils.PreferencesUtil;
import me.doapps.igvperu.utils.UtilFonts;

/**
 * Created by jonathan on 13/01/2015.
 */
public class ScheduleFragment extends Fragment implements View.OnClickListener {
    private FloatingActionButton fabFavorite;
    LinearLayout contentResult;
    Button buttonSearchRuc;
    OpenHelper objSqlite;
    TextView RUC, period01, period02, period03, period04, period05, period06, period07, period08, period09, period10, period11, period12,
            enerp, febrp, marrp,
            abrrp, mayrp, junrp,
            julrp, agorp, seprp,
            octrp, novrp, dicrp,
            textViewLink;
    SimpleDateFormat sdf = new SimpleDateFormat("MM");
    TableRow f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12;
    AutoCompleteTextView editTextRuc;
    private TextView txt_cronograma;
    private TextView txt_ruc_buscado;
    private TextView txt_ruc_mostrado;
    private TextView txt_periodo;
    private TextView txt_fecha_regular;
    PreferencesUtil preferencesUtil;

    private String ruc;

    public static final ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        fabFavorite = (FloatingActionButton)view.findViewById(R.id.fabFavorite);
        buttonSearchRuc = (Button) view.findViewById(R.id.buttonSearchRuc);

        txt_cronograma = (TextView) view.findViewById(R.id.txt_cronograma);
        txt_ruc_buscado = (TextView) view.findViewById(R.id.txt_ruc_buscado);
        txt_ruc_mostrado = (TextView) view.findViewById(R.id.textViewSearchRuc);
        txt_periodo = (TextView) view.findViewById(R.id.txt_periodo);
        txt_fecha_regular = (TextView) view.findViewById(R.id.txt_fecha_regular);

        txt_cronograma.setTypeface(UtilFonts.setLatoBolt(getActivity()));
        txt_ruc_buscado.setTypeface(UtilFonts.setLatoReg(getActivity()));
        txt_ruc_mostrado.setTypeface(UtilFonts.setLatoReg(getActivity()));
        txt_periodo.setTypeface(UtilFonts.setLatoReg(getActivity()));
        txt_fecha_regular.setTypeface(UtilFonts.setLatoReg(getActivity()));

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
        f11 = (TableRow) view.findViewById(R.id.rowDic);

        RUC = (TextView) view.findViewById(R.id.textViewSearchRuc);
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
        contentResult = (LinearLayout) view.findViewById(R.id.contentResult);
        editTextRuc = (AutoCompleteTextView) view.findViewById(R.id.editTextRuc);
        textViewLink = (TextView) view.findViewById(R.id.textViewLink);
        return view;
    }

    ArrayRucs historyRucs=new ArrayRucs();;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        preferencesUtil = new PreferencesUtil(getActivity());
        historyRucs = preferencesUtil.getHistoryRucs();
        objSqlite = new OpenHelper(getActivity(), "IGVPeru", null, 3);

        //try {

        contentResult.setVisibility(View.GONE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, historyRucs.getRucs());
        editTextRuc.setAdapter(adapter);

        textViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = getString(R.string.link);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
            }
        });

        fabFavorite.setOnClickListener(this);

        buttonSearchRuc.setOnClickListener(this);

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
        //} catch (Exception e) {
        //    Log.e(null, "ERROR Payment_Schedule onCreate: " + e.getMessage());
        //}
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
                    fabFavorite.setVisibility(View.VISIBLE);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fabFavorite:
                Log.e("ruc number", ruc);
                final FavoriteDialog dialog = new FavoriteDialog(getActivity(), ruc);
                dialog.show();
                dialog.setInterfaceFavorite(new FavoriteDialog.InterfaceFavorite() {
                    @Override
                    public void getFavorite(String tempRuc, String tempCompany) {
                        objSqlite.insertHistory(tempRuc,tempCompany,"10 Abr",1);
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.buttonSearchRuc:
                ruc = editTextRuc.getText().toString();
                if (ruc.length() == 11) {
                    contentResult.setVisibility(View.VISIBLE);
                    RUC.setText(ruc);
                    Search(ruc);
                    historyRucs.addRuc(ruc);
                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(editTextRuc.getWindowToken(), 0);
                    preferencesUtil.setHistoryRucs(historyRucs);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, historyRucs.getRucs());
                    editTextRuc.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "Formato incorrecto!!", Toast.LENGTH_LONG).show();
                    contentResult.setVisibility(View.GONE);
                }
                break;
        }

    }
}
