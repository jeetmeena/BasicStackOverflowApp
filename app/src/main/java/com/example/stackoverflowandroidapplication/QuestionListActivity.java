package com.example.stackoverflowandroidapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuestionListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public  static String PREF_FILE_NAME="signFirst";
    private  ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private TabLayout mTabLayout;
    static QuestionListActivity questionListActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        questionListActivity=this;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if(readFromPerferences("OpenAppFirstTime","True").equals("True")){
          Intent intent=new Intent(this,LoginActivity.class);
          startActivity(intent);
        }

        mTabLayout=findViewById(R.id.tabs);
        mViewPager=findViewById(R.id.viewpager);
        mTabLayout.setupWithViewPager(mViewPager);
        mPagerAdapter=new ScreenSlideAdpter(getSupportFragmentManager());

        setViewPager(mViewPager);
    }

    public static QuestionListActivity getQuestionListActivity() {
        return questionListActivity;
    }

    public void saveToPerferences(String perferencesName, String perferencesValue){
        SharedPreferences sharedPreferences =this.getSharedPreferences(PREF_FILE_NAME,this.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString(perferencesName,perferencesValue);
        editor.apply();
        Toast toast1 = Toast.makeText(this, "hii Test", Toast.LENGTH_SHORT);
        toast1.show();

    }

    public String readFromPerferences(String perferencesName, String defaultValue) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(PREF_FILE_NAME, this.MODE_PRIVATE);
        return sharedPreferences.getString(perferencesName,defaultValue);
    }     @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void setViewPager(ViewPager viewPager){
        ScreenSlideAdpter adapter =new ScreenSlideAdpter(getSupportFragmentManager());
        adapter.addFragment(new YourHashFragment(),"Your#");
        adapter.addFragment(new HotFragment(),"Hot");
        adapter.addFragment(new WeekFragment(),"Week");
        viewPager.setAdapter(adapter);
    }

    private class ScreenSlideAdpter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ScreenSlideAdpter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }
}
