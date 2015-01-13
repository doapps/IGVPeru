package me.doapps.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
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

        objSqlite = new OpenHelper(getActivity(), "IGVPeru", null, 1);
        Log.e("count table", objSqlite.countTable()+"");

        try {
            String[] show;
            show = Search(" ");
            ArrayAdapter<String> adapter;
            adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, show);
            GridView lv = (GridView) getView().findViewById(R.id.gridViewResultado);
            lv.setAdapter(adapter);
            editTextRuc = (EditText) getView().findViewById(R.id.editTextRuc);
            buttonSearchRuc = (Button) getView().findViewById(R.id.buttonBuscarRuc);
            buttonSearchRuc.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String Ruc = editTextRuc.getText().toString();
                    if (Ruc.length() == 11) {
                        Search(Ruc);
                    } else {
                        Toast.makeText(getActivity(), "Wrong Format!\nEnter again please!  ", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } catch (Exception e) {
            Log.d(null, "ERROR Payment_Schedule onCreate: " + e.getMessage());
        }
    }


    public String[] Search(String ruc) {
        try {
            String[] show = null;
            if (!ruc.equals(" ")) {
                Object[][] Result = objSqlite.Search("schedule", new String[]{"Period", "RegularPayment", "SpecialPayment"}, " lastNumRuc='" + ruc.charAt(10) + "' AND status=1");
                if (Result != null) {
                    Toast.makeText(getActivity(), "i=0 j=0 => " + Result[0][0].toString(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "i=0 j=1 => " + Result[0][1].toString(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "i=0 j=2 => " + Result[0][2].toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Not Found!", Toast.LENGTH_LONG).show();
                }
            } else {
                show = new String[]{"SUNAT", "RUC", "-",
                        "MES", "NORMAL", "BUEN CONTRIBUYENTE",
                        "ENERO", "-", "-", "FEBRERO", "-", "-", "MARZO", "-", "-",
                        "ABRIL", "-", "-", "MAYO", "-", "-", "JUNIO", "-", "-",
                        "JULIO", "-", "-", "AGOSTO", "-", "-", "SEPTIEMBRE", "-", "-",
                        "OCTUBRE", "-", "-", "NOVIEMBRE", "-", "-", "DICIEMBRE", "-", "-"};
            }
            return show;
        } catch (Exception e) {
            Log.d(null, "ERROR Payment_schedule Search: " + e.getMessage());
            return null;
        }
    }
}
