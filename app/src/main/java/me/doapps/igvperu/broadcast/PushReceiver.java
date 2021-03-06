package me.doapps.igvperu.broadcast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

import me.doapps.igvperu.activities.MainContent;

/**
 * Created by jonathan on 28/03/2015.
 */
public class PushReceiver extends ParsePushBroadcastReceiver {

    @Override
    protected void onPushOpen(Context context, Intent intent) {
        Log.e("Push", "Clicked");
        Bundle extras = intent.getExtras();
        String message = extras != null ? extras.getString("com.parse.Data") : "";
        Log.e("message", message);
        JSONObject jObject;
        try {
            jObject = new JSONObject(message);
            String temp_data = jObject.getString("alert");
            String push_url = "";
            for (int i = 0; i < temp_data.length(); i++) {
                push_url = push_url + String.valueOf(temp_data.charAt(i));
                if(temp_data.charAt(i) == '$'){
                    push_url = "";
                }
            }

            Intent i = new Intent(context, MainContent.class);
            i.putExtra("push_url", push_url);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
