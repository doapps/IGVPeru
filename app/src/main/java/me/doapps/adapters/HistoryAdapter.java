package me.doapps.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import me.doapps.igvperu.R;
import me.doapps.model.History_DTO;

/**
 * Created by jonathan on 28/03/2015.
 */
public class HistoryAdapter extends BaseAdapter {
    private ArrayList<History_DTO> history_dtos;
    private Context context;
    private LayoutInflater inflater;

    public HistoryAdapter(ArrayList<History_DTO> history_dtos, Context context){
        this.history_dtos = history_dtos;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return history_dtos.size();
    }

    @Override
    public Object getItem(int position) {
        return history_dtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        History_DTO history_dto = history_dtos.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_history, parent, false);
            holder = new Holder();

            holder.txtCompany = (TextView) convertView.findViewById(R.id.txtCompany);
            holder.txtRuc = (TextView) convertView.findViewById(R.id.txtRuc);
            holder.txtDate = (TextView) convertView.findViewById(R.id.txtDate);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.txtCompany.setText(history_dto.getCompanyName());
        holder.txtRuc.setText(history_dto.getRucNumber());
        holder.txtDate.setText(history_dto.getDate());

        return convertView;
    }

    /**Holder Class**/
    private static class Holder{
        TextView txtCompany;
        TextView txtRuc;
        TextView txtDate;
    }
}
