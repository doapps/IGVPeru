package me.doapps.igvperu.activities;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.viewpagerindicator.TitlePageIndicator;

import me.doapps.igvperu.adapters.TabAdapter;
import me.doapps.igvperu.R;
import me.doapps.igvperu.fragments.HistoryFragment;
import me.doapps.igvperu.fragments.ScheduleFragment;

public class MainContent extends ActionBarActivity implements ViewPager.OnPageChangeListener {

    public ViewPager mPager;
    private TabAdapter mAdapter;
    private TitlePageIndicator mIndicator;
    private static final String root_url = "https://play.google.com/store/apps/details?id=";

    private String push_url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            push_url = extras.getString("push_url");
            Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(push_url));
            startActivity(implicit);
        }

        mAdapter = new TabAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setOnPageChangeListener(this);
        mPager.setAdapter(mAdapter);

        mIndicator = (TitlePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, ActivityAbout.class);
            startActivity(intent);
            return true;
        }


        if (id == R.id.action_share){
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "PERUIgv");
                String sAux = "\nTe invito a descargar esta aplicación:\n\n";
                sAux = sAux + root_url + getPackageName();
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "Compartir"));
            } catch (Exception e) {
                Log.e("error intent share", e.toString());
            }
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onPageScrolled(int i, float v, int i2) {
        Log.e("page scrolled", "i:"+i+", v:"+v+", i2:"+i2);
        /*if(i==1){
            ((HistoryFragment)mAdapter.getItem(i+1)).updateHistory();
        }*/
    }

    @Override
    public void onPageSelected(int i) {
        Log.e("position page", i+"");
        if(i==2){
           ((HistoryFragment)mAdapter.getItem(i)).updateHistory();
        }
        /*switch (i){
            case 0:((HistoryFragment)mAdapter.getItem(i+2)).updateHistory();break;
            case 1:((HistoryFragment)mAdapter.getItem(i+1)).updateHistory();break;
            case 2:((HistoryFragment)mAdapter.getItem(i)).updateHistory();break;
            default:break;
        }*/
        //((HistoryFragment)mAdapter.getItem(i)).updateHistory();

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        Log.e("pageScrollStateChanged",i+"");
    }


}
