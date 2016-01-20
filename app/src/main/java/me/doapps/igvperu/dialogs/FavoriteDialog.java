package me.doapps.igvperu.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import me.doapps.igvperu.R;

/**
 * Created by jonathan on 28/03/2015.
 */
public class FavoriteDialog extends AlertDialog {

    private Context context;
    private InterfaceFavorite interfaceFavorite;
    private String ruc;

    public FavoriteDialog(Context context, String ruc) {
        super(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        this.context = context;
        this.ruc = ruc;
        initDialog();
    }

    protected FavoriteDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initDialog();
    }

    private void initDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.dialog_favorite, null);
        setView(view);

//        final EditText txtCompanyName = (EditText) view.findViewById(R.id.txtCompanyName);
//        final EditText txtRucNumber = (EditText) view.findViewById(R.id.txtRucNumber);
//        Button btnAddFavorite = (Button)view.findViewById(R.id.btnAddFavorite);
        
//        txtRucNumber.setText(ruc);

//        btnAddFavorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                interfaceFavorite.getFavorite(txtRucNumber.getText().toString(), txtCompanyName.getText().toString());
//            }
//        });



    }

    public interface InterfaceFavorite{
        void getFavorite(String ruc, String company);
    }
    public void setInterfaceFavorite(InterfaceFavorite interfaceFavorite){
        this.interfaceFavorite = interfaceFavorite;
    }
}
