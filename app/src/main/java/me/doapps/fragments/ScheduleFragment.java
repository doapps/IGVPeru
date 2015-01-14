package me.doapps.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import me.doapps.igvperu.R;
import me.doapps.model.OpenHelper;

/**
 * Created by jonathan on 13/01/2015.
 */
public class ScheduleFragment extends Fragment {
    EditText editTextRuc;
    Button buttonSearchRuc;
    OpenHelper objSqlite;
    TextView RUC,period01,period02,period03,period04,period05,period06,period07,period08,period09,period10,period11,period12,
            enerp,enesp,febrp,febsp,marrp,marsp,
             abrrp,abrsp,mayrp,maysp,junrp,junsp,
             julrp,julsp,agorp,agosp,seprp,sepsp,
             octrp,octsp,novrp,novsp,dicrp,dicsp;
    TableRow f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12;

    public static final ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_payment__schedule, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        objSqlite = new OpenHelper(getActivity(), "IGVPeru", null, 3);
        //Log.d("count table", objSqlite.countTable()+"");

        try {

            RUC=(TextView) getView().findViewById(R.id.textViewSearchRuc);
            period01=(TextView) getView().findViewById(R.id.period01);
            period02=(TextView) getView().findViewById(R.id.period02);
            period03=(TextView) getView().findViewById(R.id.period03);
            period04=(TextView) getView().findViewById(R.id.period04);
            period05=(TextView) getView().findViewById(R.id.period05);
            period06=(TextView) getView().findViewById(R.id.period06);
            period07=(TextView) getView().findViewById(R.id.period07);
            period08=(TextView) getView().findViewById(R.id.period08);
            period09=(TextView) getView().findViewById(R.id.period09);
            period10=(TextView) getView().findViewById(R.id.period10);
            period11=(TextView) getView().findViewById(R.id.period11);
            period12=(TextView) getView().findViewById(R.id.period12);
            enerp=(TextView) getView().findViewById(R.id.enerp);
            enesp=(TextView) getView().findViewById(R.id.enesp);
            febrp=(TextView) getView().findViewById(R.id.febrp);
            febsp=(TextView) getView().findViewById(R.id.febsp);
            marrp=(TextView) getView().findViewById(R.id.marrp);
            marsp=(TextView) getView().findViewById(R.id.marsp);
            abrrp=(TextView) getView().findViewById(R.id.abrrp);
            abrsp=(TextView) getView().findViewById(R.id.abrsp);
            mayrp=(TextView) getView().findViewById(R.id.mayrp);
            maysp=(TextView) getView().findViewById(R.id.maysp);
            junrp=(TextView) getView().findViewById(R.id.junrp);
            junsp=(TextView) getView().findViewById(R.id.junsp);
            julrp=(TextView) getView().findViewById(R.id.julrp);
            julsp=(TextView) getView().findViewById(R.id.julsp);
            agorp=(TextView) getView().findViewById(R.id.agorp);
            agosp=(TextView) getView().findViewById(R.id.agosp);
            seprp=(TextView) getView().findViewById(R.id.seprp);
            sepsp=(TextView) getView().findViewById(R.id.sepsp);
            octrp=(TextView) getView().findViewById(R.id.octrp);
            octsp=(TextView) getView().findViewById(R.id.octsp);
            novrp=(TextView) getView().findViewById(R.id.novrp);
            novsp=(TextView) getView().findViewById(R.id.novsp);
            dicrp=(TextView) getView().findViewById(R.id.dicrp);
            dicsp=(TextView) getView().findViewById(R.id.dicsp);

            initSchedule();
            //String[] show;
            //show = Search(" ");
            //ArrayAdapter<String> adapter;
            //adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, show);
            //lv.setAdapter(adapter);
            editTextRuc = (EditText) getView().findViewById(R.id.editTextRuc);
            buttonSearchRuc = (Button) getView().findViewById(R.id.buttonBuscarRuc);
            buttonSearchRuc.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String Ruc = editTextRuc.getText().toString();
                    if (Ruc.length() == 11) {
                        RUC.setText(Ruc);
                        Search(Ruc);
                    } else {
                        Toast.makeText(getActivity(), "Wrong Format!\nEnter again please!  ", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } catch (Exception e) {
            Log.e(null, "ERROR Payment_Schedule onCreate: " + e.getMessage());
        }
    }

    public void initSchedule(){
        String[] periods=objSqlite.getPeriods();
        period01.setText(periods[0]);
        period02.setText(periods[1]);
        period03.setText(periods[2]);
        period04.setText(periods[3]);
        period05.setText(periods[4]);
        period06.setText(periods[5]);
        period07.setText(periods[6]);
        period08.setText(periods[7]);
        period09.setText(periods[8]);
        period10.setText(periods[9]);
        period11.setText(periods[10]);
        period12.setText(periods[11]);
    }

    public String[] Search(String ruc) {
        try {
            String[] show = null;
            if (!ruc.equals(" ")) {
                Object[][] Result = objSqlite.Search("schedule", new String[]{"period","RegularPayment", "SpecialPayment"}, " lastNumRuc='" + ruc.charAt(10) + "' AND status=1");
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
                    enesp.setText(Result[0][2].toString());
                    febrp.setText(Result[1][1].toString());
                    febsp.setText(Result[1][2].toString());
                    marrp.setText(Result[2][1].toString());
                    marsp.setText(Result[2][2].toString());
                    abrrp.setText(Result[3][1].toString());
                    abrsp.setText(Result[3][2].toString());
                    mayrp.setText(Result[4][1].toString());
                    maysp.setText(Result[4][2].toString());
                    junrp.setText(Result[5][1].toString());
                    junsp.setText(Result[5][2].toString());
                    julrp.setText(Result[6][1].toString());
                    julsp.setText(Result[6][2].toString());
                    agorp.setText(Result[7][1].toString());
                    agosp.setText(Result[7][2].toString());
                    seprp.setText(Result[8][1].toString());
                    sepsp.setText(Result[8][2].toString());
                    octrp.setText(Result[9][1].toString());
                    octsp.setText(Result[9][2].toString());
                    novrp.setText(Result[10][1].toString());
                    novsp.setText(Result[10][2].toString());
                    dicrp.setText(Result[11][1].toString());
                    dicsp.setText(Result[11][2].toString());
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
}
