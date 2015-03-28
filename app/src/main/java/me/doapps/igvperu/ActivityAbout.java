package me.doapps.igvperu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import me.doapps.utils.UtilFonts;

/**
 * Created by Bryam on 21/01/2015.
 */
public class ActivityAbout extends ActionBarActivity{

    //private TextView txt_1;
    private TextView txt_2;
    //private TextView txt_3;
    private TextView txt_4;

    private Button btn_contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //txt_1 = (TextView) findViewById(R.id.txt_title_about);
        txt_2 = (TextView) findViewById(R.id.txt_about_version);
        //txt_3 = (TextView) findViewById(R.id.txt_about_descrip);
        txt_4 = (TextView) findViewById(R.id.txt_about_desarr1);

        //txt_1.setTypeface(UtilFonts.setLatoBolt(this));
        txt_2.setTypeface(UtilFonts.setLatoReg(this));
        //txt_3.setTypeface(UtilFonts.setLatoLig(this));
        txt_4.setTypeface(UtilFonts.setLatoReg(this));

        /*BUTTON*/
        btn_contacto = (Button) findViewById(R.id.btn_contacto);
        btn_contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recepientEmail = "doapps.me@gmail.com"; // either set to destination email or leave empty
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + recepientEmail));
                startActivity(intent);
            }
        });
    }

}
