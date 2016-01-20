package me.doapps.igvperu.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.doapps.igvperu.R;
import me.doapps.igvperu.activities.FavoriteActivity;
import me.doapps.igvperu.activities.MainActivity;
import me.doapps.igvperu.fragments.ScheduleFragment;
import me.doapps.igvperu.model.History_DTO;
import me.doapps.igvperu.utils.UtilFonts;

/**
 * Created by jonathan on 28/03/2015.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.CardsViewHolder> {

    static Context context;
    private InterfaceDelete interfaceDelete;
    private static List<History_DTO> history_dtos;
    private final String TAG = HistoryAdapter.class.getSimpleName();

    public HistoryAdapter(List<History_DTO> history_dtos, Context context) {
        this.history_dtos = history_dtos;
        this.context = context;
    }

    @Override
    public HistoryAdapter.CardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new CardsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardsViewHolder holder, final int position) {
        try {
            holder.txtCompany.setTypeface(UtilFonts.setSemiBoldSourceSans(context));
            holder.txtRuc.setTypeface(UtilFonts.setLightSourceSansPro(context));

            holder.txtCompany.setText(history_dtos.get(position).getCompanyName());
            holder.txtRuc.setText(history_dtos.get(position).getRucNumber());
            holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) context).objSqlite.updateHistory(history_dtos.get(position).getId(), "0");
                    interfaceDelete.Success(history_dtos.get(position));
                    history_dtos.remove(position);
                    notifyDataSetChanged();
                }
            });
            holder.frameLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) context).changeTab(1);
                    ScheduleFragment.autoCompleteTextViewRuc.setText(history_dtos.get(position).getRucNumber());
                    ScheduleFragment.buttonSearchRuc.performClick();

//                    Intent intent = new Intent(context, FavoriteActivity.class);
//                    intent.putExtra("ruc", history_dtos.get(position).getRucNumber());
//                    intent.putExtra("razon", history_dtos.get(position).getCompanyName());
//                    context.startActivity(intent);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "onBindViewHolder"+ e.toString());
        }
    }

    @Override
    public int getItemCount() {
        try {
            return history_dtos.size();
        } catch (Exception e){
            Log.e(TAG, e.toString());
            return 0;
        }
    }

    public void addHistory(History_DTO history_dto){
        history_dtos.add(history_dto);
        notifyDataSetChanged();
    }

    public static class CardsViewHolder extends RecyclerView.ViewHolder {

        public TextView txtCompany, txtRuc;
        public ImageView imageViewDelete;
        public FrameLayout frameLayoutItem;

        public CardsViewHolder(View v) {
            super(v);

            txtCompany = (TextView) v.findViewById(R.id.txtCompany);
            txtRuc = (TextView) v.findViewById(R.id.txtRuc);
            imageViewDelete = (ImageView) v.findViewById(R.id.image_view_delete);
            frameLayoutItem = (FrameLayout) v.findViewById(R.id.frame_layout_item);

        }
    }

    public interface InterfaceDelete{
        void Success(History_DTO history_dto);
    }

    public void setInterfaceDelete(InterfaceDelete interfaceDelete){
        this.interfaceDelete = interfaceDelete;
    }
}





        /*extends BaseAdapter {
    private ArrayList<History_DTO> history_dtos;
    private Context context;
    private LayoutInflater inflater;
    private InterfaceDelete interfaceDelete;

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

    public void addHistory(History_DTO history_dto){
        history_dtos.add(history_dto);
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        final History_DTO history_dto = history_dtos.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_history, parent, false);
            holder = new Holder();


            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.txtCompany.setText(history_dto.getCompanyName());
        holder.txtRuc.setText(history_dto.getRucNumber());
        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).objSqlite.updateHistory(history_dtos.get(position).getId(), "0");
                history_dtos.remove(position);
                notifyDataSetChanged();
                interfaceDelete.Success(history_dto);
            }
        });

        return convertView;
    }



    private static class Holder{
        TextView txtCompany;
        TextView txtRuc;
        ImageView imageViewDelete;
    }
}
*/