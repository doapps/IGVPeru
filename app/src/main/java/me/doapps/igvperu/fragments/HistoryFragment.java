package me.doapps.igvperu.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import me.doapps.igvperu.activities.MainActivity;
import me.doapps.igvperu.adapters.HistoryAdapter;
import me.doapps.igvperu.R;
import me.doapps.igvperu.model.History_DTO;
import me.doapps.igvperu.model.OpenHelper;
import me.doapps.igvperu.utils.UtilFonts;

/**
 * Created by jonathan on 28/03/2015.
 */
public class HistoryFragment extends Fragment {

    private final static String TAG = HistoryFragment.class.getSimpleName();
    private RecyclerView listHistory;
    private ArrayList<History_DTO> history_dtos;
    private OpenHelper objSqlite;
    private FrameLayout frameLayout;
    public History_DTO temp;
    private RecyclerView.LayoutManager mLayoutManager;

    public static final HistoryFragment newsInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        listHistory = (RecyclerView) view.findViewById(R.id.listHistory);
        frameLayout = (FrameLayout) view.findViewById(R.id.frame_layout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        listHistory.setOnItemClickListener(this);
        updateHistory();

    }

    public void refreshHistory() {
        updateHistory();
    }

    public void updateHistory() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        objSqlite = ((MainActivity) getActivity()).objSqlite;
        Cursor cursor = objSqlite.selectHistory();
        history_dtos = new ArrayList<>();

        while (cursor.moveToNext()) {
            String tempCompany = cursor.getString(2);
            String tempRuc = cursor.getString(1);
            String id = cursor.getString(0);
            history_dtos.add(new History_DTO(id, tempCompany, tempRuc, "Mar-15", "22 Abr"));
        }

        final HistoryAdapter historyAdapter = new HistoryAdapter(history_dtos, getActivity());
        historyAdapter.setInterfaceDelete(new HistoryAdapter.InterfaceDelete() {
                                              @Override
                                              public void Success(final History_DTO history_dto) {
                                                  Snackbar snackbar = Snackbar
                                                          .make(frameLayout, "Favorito Eliminado", Snackbar.LENGTH_LONG)
                                                          .setDuration(Snackbar.LENGTH_LONG)
                                                          .setAction("DESHACER", new View.OnClickListener() {
                                                              @Override
                                                              public void onClick(View view) {
                                                                  ((MainActivity) getActivity()).objSqlite.updateHistory(history_dto.getId(), "1");
                                                                  historyAdapter.addHistory(history_dto);
                                                              }
                                                          });

                                                  snackbar.show();
                                                  View view = snackbar.getView();
                                                  TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_action);
                                                  tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
                                                  tv.setTypeface(UtilFonts.setBoldSourceSansPro(getActivity()));
                                              }
                                          }

        );
        listHistory.setAdapter(historyAdapter);
        listHistory.setLayoutManager(mLayoutManager);
    }

}
