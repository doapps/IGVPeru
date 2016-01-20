package me.doapps.igvperu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.doapps.igvperu.R;
import me.doapps.igvperu.model.OpenHelper;
import me.doapps.igvperu.utils.FragmentUtil;
import me.doapps.igvperu.utils.UtilFonts;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FrameLayout frameLayoutDialog;
    private boolean openDialog = false, sureOutApp = false;
    private EditText editTextRucNumber, editTextCompanyName;
    private Button buttonAddFavorite;
    public OpenHelper objSqlite;
    public static FragmentUtil fragmentUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objSqlite = new OpenHelper(MainActivity.this, "IGVPeru", null, OpenHelper.BD_VERSION);
        fragmentUtil = new FragmentUtil();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        frameLayoutDialog = (FrameLayout) findViewById(R.id.frame_layout_dialog);
        editTextRucNumber = (EditText) findViewById(R.id.edit_text_ruc_number);
        editTextCompanyName = (EditText) findViewById(R.id.edit_text_company_name);
        buttonAddFavorite = (Button) findViewById(R.id.button_add_favorite);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_transparent);

        editTextRucNumber.setTypeface(UtilFonts.setLightSourceSansPro(MainActivity.this));
        editTextCompanyName.setTypeface(UtilFonts.setLightSourceSansPro(MainActivity.this));
        buttonAddFavorite.setTypeface(UtilFonts.setSemiBoldSourceSans(MainActivity.this));

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        changeTabsFont();

        frameLayoutDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hiddenDialog();
            }
        });

        buttonAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rucNumber = editTextRucNumber.getText().toString();
                String tempCompany = editTextCompanyName.getText().toString();
                if (rucNumber.equals("") && rucNumber.length() == 11) {
                    Toast.makeText(MainActivity.this, "Ingrese un número de RUC válido", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (tempCompany.equals("")) {
                    Toast.makeText(MainActivity.this, "Ingrese una compañía", Toast.LENGTH_SHORT).show();
                    return;
                }

                objSqlite.insertHistory(rucNumber, tempCompany, "10 Abr", 1);
                editTextRucNumber.setText("");
                editTextCompanyName.setText("");
                hiddenDialog();
                fragmentUtil.getScheduleFragment().searchAgain();
                changeTab(2);
                MainActivity.fragmentUtil.getHistoryFragment().updateHistory();
            }
        });

        editTextRucNumber.setNextFocusDownId(R.id.edit_text_company_name);

        editTextCompanyName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.e(TAG, EditorInfo.IME_ACTION_GO + "--->" +keyCode);
                if (keyCode == EditorInfo.IME_ACTION_GO) {
                    String rucNumber = editTextRucNumber.getText().toString();
                    String tempCompany = editTextCompanyName.getText().toString();
                    if (!rucNumber.equals("")) {
                        if(!tempCompany.equals("")){
                            objSqlite.insertHistory(rucNumber, tempCompany, "10 Abr", 1);
                            hiddenDialog();
                            editTextRucNumber.setText("");
                            editTextCompanyName.setText("");
                            hiddenDialog();
                            changeTab(2);
                            MainActivity.fragmentUtil.getHistoryFragment().updateHistory();
                        }else{
                            Toast.makeText(MainActivity.this, "Ingrese una compañía", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Ingrese un número de RUC", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                } else {
                    return false;
                }
            }
        });


    }

    public void changeTab(int index){
        TabLayout.Tab tab = tabLayout.getTabAt(index);
        tab.select();
    }

    public void setEditTextRucNumber(String rucNumber) {
        editTextRucNumber.setText(rucNumber);
    }

    public void showDialog() {
        frameLayoutDialog.setVisibility(View.VISIBLE);
        openDialog = true;
    }

    public void hiddenDialog() {
        frameLayoutDialog.setVisibility(View.GONE);
        openDialog = false;
    }

    @Override
    public void onBackPressed() {
        if (openDialog) {
            frameLayoutDialog.setVisibility(View.GONE);
            openDialog = false;
        } else if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            if (sureOutApp == false) {
                Toast.makeText(MainActivity.this, "Una vez más y saldrá de la aplicación", Toast.LENGTH_SHORT).show();
                sureOutApp = true;
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    private void changeTabsFont() {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(UtilFonts.setSemiBoldSourceSans(MainActivity.this));
                }
            }
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(fragmentUtil.getCalculatorFragment(), "CALCULADORA");
        adapter.addFragment(fragmentUtil.getScheduleFragment(), "CRONOGRAMA");
        adapter.addFragment(fragmentUtil.getHistoryFragment(), "HISTORIAL");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            sureOutApp = false;
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_info:
                startActivity(new Intent(MainActivity.this, ActivityAbout.class));
            break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
