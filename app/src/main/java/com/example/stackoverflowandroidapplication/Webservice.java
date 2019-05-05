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
    //get User All Questions
    @GET("/users/{userId}/questions?order=desc&sort=activity&site=stackoverflow")
    void getQuestions(@Path("userId") String userId, Callback<Questions> callback);
    //get User All Questions
    //get Popular tag
    @GET("/2.2/tags")
    Call<StackOverTag.TagItems> getPopulerTags( @Query("order") String order, @Query("sort")String sort, @Query("site") String site);
    @GET("/2.2/questions")//page=5&pagesize=40&order=desc&sort=activity&tagged=java&site=stackoverflow
    Call<Questions> getAllQuestion(@Query("page") String page,@Query("pagesize") String pagesize,@Query("order") String order, @Query("sort")String sort,  @Query("tagged")String tagged,@Query("site") String site);
    @GET("/2.2/questions")
    Call<Questions> getAllHotQuestion(@Query("page") String page,@Query("pagesize") String pagesize,@Query("order") String order, @Query("sort")String sort,  @Query("tagged")String tagged,@Query("site") String site);
    @GET("/2.2/questions")
    Call<Questions> getAllWeekQuestion(@Query("page") String page,@Query("pagesize") String pagesize,@Query("order") String order, @Query("sort")String sort,  @Query("tagged")String tagged,@Query("site") String site);
}
