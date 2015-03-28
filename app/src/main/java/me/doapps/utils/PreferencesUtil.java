package me.doapps.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import me.doapps.model.ArrayRucs;

/**
 * Created by jonathan on 02/02/2015.
 */
public class PreferencesUtil {
    private static final String PREFERENCE_NAME = "igvperu_preference";
    private int PRIVATE_MODE = 0;
    Gson gson = new Gson();

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public static final String LIST_RUC = "rucs";

    public PreferencesUtil(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void setHistoryRucs(ArrayRucs rucs){
        try {
            String jsonUser = gson.toJson(rucs);
            editor.putString(LIST_RUC, jsonUser);
            editor.commit();
        } catch(Exception e){
            Log.e("Error setHistoyRucs", e.toString());
        }
    }

    public ArrayRucs getHistoryRucs(){
        String json = preferences.getString(LIST_RUC, " ");
        if(json.equals(" ")){
            return new ArrayRucs();
        }else{
            return gson.fromJson(json, ArrayRucs.class);
        }
    }

}
