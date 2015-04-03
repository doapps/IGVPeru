package me.doapps.igvperu.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import me.doapps.igvperu.activities.FavoriteActivity;
import me.doapps.igvperu.activities.MainContent;
import me.doapps.igvperu.adapters.HistoryAdapter;
import me.doapps.igvperu.R;
import me.doapps.igvperu.model.History_DTO;
import me.doapps.igvperu.model.OpenHelper;

/**
 * Created by jonathan on 28/03/2015.
 */
public class HistoryFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView listHistory;
    private ArrayList<History_DTO> history_dtos;
    private OpenHelper objSqlite;

    public static final HistoryFragment newsInstance(){
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        listHistory = (ListView)view.findViewById(R.id.listHistory);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listHistory.setOnItemClickListener(this);
        updateHistory();

    }

    public void updateHistory(){
        objSqlite = new OpenHelper(getActivity(), "IGVPeru", null, 3);
        Cursor cursor = objSqlite.selectHistory();
        history_dtos = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String tempCompany = cursor.getString(1);
                String tempRuc = cursor.getString(0);
                history_dtos.add(new History_DTO(tempCompany, tempRuc, "Mar-15", "22 Abr"));
            } while (cursor.moveToNext());
        }

        listHistory.setAdapter(new HistoryAdapter(history_dtos, getActivity()));
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        History_DTO history_dto = (History_DTO) parent.getAdapter().getItem(position);
        Log.e("ruc selected", history_dto.getRucNumber());
        Intent intent = new Intent(getActivity(), FavoriteActivity.class);
        intent.putExtra("ruc", history_dto.getRucNumber());
        intent.putExtra("razon", history_dto.getCompanyName());
        ((MainContent)getActivity()).startActivity(intent);
    }



}
