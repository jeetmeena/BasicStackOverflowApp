package com.example.stackoverflowandroidapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public  static String PREF_FILE_NAME="signFirst";
    private  ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private TabLayout mTabLayout;
    static QuestionListActivity questionListActivity;
    private QuetiionViewModel quetiionViewModel;
    private NavigationView nav_View;
     YourHashFragment yourHashFragment;
    HotFragment hotFragment;
    WeekFragment weekFragment;
    ScreenSlideAdpter adapter;
    int mTagCount=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav_View=findViewById(R.id.nav_view);

        questionListActivity=this;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        quetiionViewModel= ViewModelProviders.of(this).get(QuetiionViewModel.class);

        if(!readFromPerferences("OpenAppFirstTime","false").equals("True")){
          Intent intent=new Intent(this,LoginActivity.class);
          startActivity(intent);
          finish();
        }
        else {
            quetiionViewModel.getmAllData().observe(this, new Observer<List<SelectedTags>>() {
                @Override
                public void onChanged(@Nullable final List<SelectedTags> tags) {
                    // Update the cached copy of the words in the adapter.
                    // wordListAddpter.setmWords(words);
                    if(tags.size()<2){
                        Intent intent=new Intent(QuestionListActivity.this,UserInterestActivty.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Menu menu=nav_View.getMenu();


                        for (int i=0;i<tags.size();i++){

                            MenuItem menuItem= (MenuItem) menu.add(i,i,Menu.FIRST,tags.get(i).getSelectTags());


                        }
                        if(!readFromPerferences("FirstTimeGetAllQuestion","false").equals("True")){
                            quetiionViewModel.getFirstTagDataAct(tags.get(0).getSelectTags());
                            quetiionViewModel.getFirstTagDataHot(tags.get(0).getSelectTags());
                            quetiionViewModel.getFirstTagDataWeek(tags.get(0).getSelectTags());
                            saveToPerferences("FirstTimeGetAllQuestion","True");
                        }
                    }

                }
            });
        }

        mTabLayout=findViewById(R.id.tabs);
        mViewPager=findViewById(R.id.viewpager);
        mTabLayout.setupWithViewPager(mViewPager);
        mPagerAdapter=new ScreenSlideAdpter(getSupportFragmentManager());

        setViewPager(mViewPager,"tag",1);



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
       List<Fragment> fragments=new ArrayList<>();
        int id = item.getItemId();
        switch (id){
            case 0:
                quetiionViewModel.getFirstTagDataAct(String.valueOf(item.getTitle()));
                quetiionViewModel.getFirstTagDataHot(String.valueOf(item.getTitle()));
                quetiionViewModel.getFirstTagDataWeek(String.valueOf(item.getTitle()));

               // page=5&pagesize=40&order=desc&sort=activity&tagged=java&site=stackoverflow
                mTagCount=1;

                try {
                    yourHashFragment.setObserve(4);
                }catch (Exception e){}
                try {
                    hotFragment.setObserve(4);
                }catch (Exception e){}
                try {
                    weekFragment.setObserve(4);
                }catch (Exception e){}

                Toast.makeText(questionListActivity, ""+String.valueOf(item.getTitle()), Toast.LENGTH_SHORT).show();
                break;
            case 1:

                 quetiionViewModel.getSecondTagDataAct(String.valueOf(item.getTitle()));
                 quetiionViewModel.getSecondTagDataHot(String.valueOf(item.getTitle()));
                 quetiionViewModel.getSecondTagDataWeek(String.valueOf(item.getTitle()));
                mTagCount=2;
                try {
                    yourHashFragment.setObserve(2);
                }catch (Exception e){}
                try {
                    hotFragment.setObserve(2);
                }catch (Exception e){}
                try {
                    weekFragment.setObserve(2);
                }catch (Exception e){}

                Toast.makeText(questionListActivity, ""+String.valueOf(item.getTitle()), Toast.LENGTH_SHORT).show();
                break;
            case 2:
               quetiionViewModel.getThridTagDataAct(String.valueOf(item.getTitle()));
               quetiionViewModel.getThridTagDataHot(String.valueOf(item.getTitle()));
               quetiionViewModel.getThridTagDataWeek(String.valueOf(item.getTitle()));

                mTagCount=2;
             ;
                try {
                    yourHashFragment.setObserve(3);
                }catch (Exception e){}
                try {
                    hotFragment.setObserve(3);
                }catch (Exception e){}
                try {
                    weekFragment.setObserve(3);
                }catch (Exception e){}

                // Toast.makeText(questionListActivity, ""+2, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                quetiionViewModel.getForthTagDataAct(String.valueOf(item.getTitle()));
                quetiionViewModel.getForthTagDataHot(String.valueOf(item.getTitle()));
                quetiionViewModel.getForthagDataWeek(String.valueOf(item.getTitle()));
                mTagCount=4;
                try {
                    yourHashFragment.setObserve(4);
                }catch (Exception e){}
                try {
                    hotFragment.setObserve(4);
                }catch (Exception e){}
                try {
                    weekFragment.setObserve(4);
                }catch (Exception e){}

                //Toast.makeText(questionListActivity, ""+4, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void upFragment(Fragment fragment, String title) {
       // mFragmentList.add(fragment);

    }
    public void setViewPager(ViewPager viewPager,String tag,int tagCount){
         adapter =new ScreenSlideAdpter(getSupportFragmentManager());
       yourHashFragment=  new YourHashFragment(tag,tagCount);
       hotFragment=new HotFragment(tag,tagCount);
       weekFragment=new WeekFragment(tag,tagCount);
       adapter.addFragment(yourHashFragment,"Your#");
       adapter.addFragment(hotFragment,"Hot");
       adapter.addFragment(weekFragment,"Week");
       viewPager.setAdapter(adapter);
    }

    private class ScreenSlideAdpter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ScreenSlideAdpter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int i) {

            return mFragmentList.get(i) ;
        }
        void setUpdataFra(List<Fragment> fragmentList){
            this.mFragmentList=fragmentList;
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return 3;
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
