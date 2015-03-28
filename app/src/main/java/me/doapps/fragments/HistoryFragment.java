package me.doapps.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import me.doapps.adapters.HistoryAdapter;
import me.doapps.igvperu.R;
import me.doapps.model.History_DTO;

/**
 * Created by jonathan on 28/03/2015.
 */
public class HistoryFragment extends Fragment {
    private ListView listHistory;
    private ArrayList<History_DTO> history_dtos;

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

        history_dtos = new ArrayList<>();
        history_dtos.add(new History_DTO("DoApps SAC", "323627362736", "Mar-15", "22 Abr"));
        history_dtos.add(new History_DTO("DoApps SAC", "323627362736", "Mar-15", "22 Abr"));
        history_dtos.add(new History_DTO("DoApps SAC", "323627362736", "Mar-15", "22 Abr"));
        history_dtos.add(new History_DTO("DoApps SAC", "323627362736", "Mar-15", "22 Abr"));
        history_dtos.add(new History_DTO("DoApps SAC", "323627362736", "Mar-15", "22 Abr"));
        history_dtos.add(new History_DTO("DoApps SAC", "323627362736", "Mar-15", "22 Abr"));
        history_dtos.add(new History_DTO("DoApps SAC", "323627362736", "Mar-15", "22 Abr"));
        history_dtos.add(new History_DTO("DoApps SAC", "323627362736", "Mar-15", "22 Abr"));
        history_dtos.add(new History_DTO("DoApps SAC", "323627362736", "Mar-15", "22 Abr"));

        listHistory.setAdapter(new HistoryAdapter(history_dtos, getActivity()));

    }
}
