package me.doapps.application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

import me.doapps.igvperu.MainContent;
import me.doapps.igvperu.R;

/**
 * Created by jonathan on 28/03/2015.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, getResources().getString(R.string.application_id), getResources().getString(R.string.client_key));
        PushService.setDefaultPushCallback(this, MainContent.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
