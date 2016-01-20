package me.doapps.igvperu.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import me.doapps.igvperu.utils.UtilFonts;
import me.doapps.igvperu.R;

/**
 * Created by Bryam on 21/01/2015.
 */
public class ActivityAbout extends AppCompatActivity {

    private final static String TAG = ActivityAbout.class.getSimpleName();
    private Button buttonContact;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_back);
        buttonContact = (Button) findViewById(R.id.button_contact);

        ((TextView) findViewById(R.id.text_view_text1)).setTypeface(UtilFonts.setSemiBoldSourceSans(ActivityAbout.this));
        buttonContact.setTypeface(UtilFonts.setSemiBoldSourceSans(ActivityAbout.this));

        /*BUTTON*/
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recepientEmail = "doapps.me@gmail.com"; // either set to destination email or leave empty
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + recepientEmail));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_share:
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                    String sAux = "\n" + getString(R.string.share_text) + ":\n\n";
                    sAux = sAux + getString(R.string.share_url) + getPackageName();
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, getString(R.string.share_share)));
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
