package com.example.stackoverflowandroidapplication;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;

import retrofit2.Call;

public class UserInterestActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interest_activty);
    }
    Webservice webservice=  CanncetionController.getRetrofitInstance("https://api.stackexchange.com").create(Webservice.class);

}
