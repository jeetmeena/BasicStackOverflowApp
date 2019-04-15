package com.example.stackoverflowandroidapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
@Singleton
public class StackUserRepo {

    private final Webservice webservice;
    private final UserDao userDao;
    private final Executor executor;

    @Inject
    public StackUserRepo(Webservice webservice, UserDao userDao, Executor executor) {
        this.webservice = webservice;
        this.userDao = userDao;
        this.executor = executor;
    }


    // Simple in-memory cache. Details omitted for brevity.
    //private UserCache userCache;



}

