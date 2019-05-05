package com.example.stackoverflowandroidapplication;

import android.content.Context;
import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;





/**
 * Created by Manish on 31/10/2015.
 */
public class CanncetionController{

    /**
     * Customization
     */

    private static final OkHttpClient httpClient = new OkHttpClient();


    //private static final RestAdapter userInfoAdapter = commonBuilder.setEndpoint(Consts.mainURL).build();

    //private static final RestAdapter userIdAdapter = commonBuilder.setEndpoint(Consts.mainURL2).build();

    /**
     * Web service definitions
     */
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(String  url) {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Webservice interfaz = retrofit.create(Webservice.class);
        }
        return retrofit;
    }

}
