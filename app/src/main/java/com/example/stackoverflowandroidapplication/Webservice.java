package com.example.stackoverflowandroidapplication;

import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Webservice {
    Executor getUser(int userId);
    //get UserId
    @GET("/me")
    Call<StackUserInfo> getUserId(@Query("site") String site, @Query("key") String apikey, @Query("access_token") String access_token, Callback<StackUserInfo> callback);
    //get UserInformation
    @GET("/users/{userId}?order=desc&sort=reputation&site=stackoverflow")
    void getUserInfo(@Path("userId") String userId, Callback<StackUserInfo> callback);
    //get User All Questions
    @GET("/users/{userId}/questions?order=desc&sort=activity&site=stackoverflow")
    void getQuestions(@Path("userId") String userId, Callback<Questions> callback);
    //get User All Questions
    //get User Active Tags
    @GET("/users/{userId}/tags?page=1&pagesize=20&order=desc&sort=popular&site=stackoverflow")
    void getActiveTags(@Path("userId") String userId, Callback<StackActiveTags> cb);
}
