package com.example.stackoverflowandroidapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class StackUserRepo {

   // private final Webservice webservice;
    private final UserDao userDao;
    private Webservice webService;
    private LiveData<List< SelectedTags>> mAllSelectedTags;
      private LiveData<List<TagFirst>> mAllTagFirstQues;
    private LiveData<List<TagFirst>> mAllTagFirstYour;
    private LiveData<List<TagFirst>> mAllTagFirstHot;
    private LiveData<List<TagFirst>> mAllTagFirstWeek;
      private LiveData<List<TagSecond>> mAllTagsecondQues;
    private LiveData<List<TagSecond>> mAllTagsecondYour;
    private LiveData<List<TagSecond>> mAllTagsecondHot;
    private LiveData<List<TagSecond>> mAllTagsecondWeek;
      private LiveData<List< TagThrid>> mAllTagThridQues;
    private LiveData<List< TagThrid>> mAllTagThridYour;
    private LiveData<List< TagThrid>> mAllTagThridHot;
    private LiveData<List< TagThrid>> mAllTagThridWeek;
      private LiveData<List<TagForth>> mAllTagForthQues;
    private LiveData<List<TagForth>> mAllTagForthYour;
    private LiveData<List<TagForth>> mAllTagForthHot;
    private LiveData<List<TagForth>> mAllTagForthWeek;
    List<QuestionItems> questionItems1;
    List<QuestionItems> questionItems2;
    List<QuestionItems> questionItems3;
    public StackUserRepo(Application application ){
        QuestiionDatabase dataBase=QuestiionDatabase.getDataBase(application);
        userDao=dataBase.userDao();
         setConncetion();

        mAllSelectedTags=userDao.getAllSelectedTags();

        mAllTagFirstQues=userDao.getAllFirstTagQue();
        mAllTagFirstYour=userDao.getAllFirstTagYour();
        mAllTagFirstHot=userDao.getAllFirstTagHot();
        mAllTagFirstWeek=userDao.getAllFirstTagWeek();

        mAllTagsecondQues=userDao.getAllSecondTagQue();
        mAllTagsecondYour=userDao.getAllSecondTagYour();
        mAllTagsecondHot=userDao.getAllSecondTagHot();
        mAllTagsecondWeek=userDao.getAllSecondTagWeek();

        mAllTagThridQues=userDao.getAllThridTagQue();
        mAllTagThridYour=userDao.getAllThridTagYour();
        mAllTagThridHot=userDao.getAllThridTagHot();
        mAllTagThridWeek=userDao.getAllThridTagWeek();

        mAllTagForthQues=userDao.getAllForthTagQue();
        mAllTagForthYour=userDao.getAllForthTagYour();
        mAllTagForthHot=userDao.getAllForthTagHot();
        mAllTagForthWeek=userDao.getAllForthTagWeek();



    }
      LiveData<List< SelectedTags>> getmAllSelectedTags(){
          return mAllSelectedTags;
      }
      LiveData<List<TagFirst>> getAllTagFirstQues(){return mAllTagFirstQues;}
    LiveData<List<TagFirst>> getAllTagFirstYour(){return mAllTagFirstYour;}
    LiveData<List<TagFirst>> getAllTagFirstHot(){return mAllTagFirstHot;}
    LiveData<List<TagFirst>> getAllTagFirstWeek(){return mAllTagFirstWeek;}
      LiveData<List<TagSecond>> getAllTagsecondQues(){return mAllTagsecondQues;}
    LiveData<List<TagSecond>> getAllTagsecondYour(){return mAllTagsecondYour;}
    LiveData<List<TagSecond>> getAllTagsecondHot(){return mAllTagsecondHot;}

    LiveData<List<TagSecond>> getAllTagsecondWeek(){return mAllTagsecondWeek;}

    LiveData<List< TagThrid>> getAllTagThridQues(){return mAllTagThridQues;}
    LiveData<List< TagThrid>> getAllTagThridYour(){return mAllTagThridYour;}

    LiveData<List< TagThrid>> getAllTagThridHot(){return mAllTagThridHot;}
    LiveData<List< TagThrid>> getAllTagThridWeek(){return mAllTagThridWeek;}

    LiveData<List<TagForth>> getAllTagForthQues(){return mAllTagForthQues;}
    LiveData<List<TagForth>> getAllTagForthYour(){return mAllTagForthYour;}

    LiveData<List<TagForth>> getmAllTagForthHot(){return mAllTagForthHot;}
    LiveData<List<TagForth>> getAllTagForthWeek(){return mAllTagForthWeek;}


    public void insertAllTags( SelectedTags selectedTags){
          new insertAsyncTask(userDao).execute(selectedTags);
      }
      public void insertAllTagFirstQues(TagFirst tagFirst){
          new insertAsyncFirst(userDao).execute(tagFirst);
      }
      public void insertAllTagsecondQues(TagSecond tagSecond){
          new insertAsyncSecond(userDao).execute(tagSecond);
      }
      public void insertgetAllTagThridQues( TagThrid tagThrid){
          new insertAsyncThrid(userDao).execute(tagThrid);
      }
      public void insertAllTagForthQues( TagForth tagForth){
          new insertAsyncForth(userDao).execute(tagForth);
      }

      private class insertAsyncTask extends AsyncTask< SelectedTags,Void,Void> {
          private UserDao mAsyncTaskDao;
          public insertAsyncTask(UserDao mUserDao) {
              this.mAsyncTaskDao=mUserDao;
          }


          @Override
          protected Void doInBackground(SelectedTags... words) {
              mAsyncTaskDao.insertSelewctedTag(words[0]);
              return null;
          }
      }

      private class insertAsyncFirst extends AsyncTask< TagFirst,Void,Void> {
          private UserDao mAsyncTaskDao;
          public insertAsyncFirst(UserDao userDao) {
              mAsyncTaskDao=userDao;
          }

          @Override
          protected Void doInBackground( TagFirst... tagFirsts) {
              mAsyncTaskDao.insertFirstQueTag(tagFirsts[0]);
              return null;
          }
      }


      private class insertAsyncSecond extends AsyncTask<TagSecond,Void,Void> {
          private UserDao mAsyncTaskDao;
          public insertAsyncSecond(UserDao userDao) {
              mAsyncTaskDao=userDao;
          }

          @Override
          protected Void doInBackground(TagSecond... tagSeconds) {
              mAsyncTaskDao.insertSecondQueTag(tagSeconds[0]);
              return null;
          }
      }
      private class insertAsyncThrid extends AsyncTask< TagThrid,Void,Void> {
          private UserDao mAsyncTaskDao;
          public insertAsyncThrid(UserDao userDao) {
              mAsyncTaskDao=userDao;
          }

          @Override
          protected Void doInBackground( TagThrid... tagThrids) {
              mAsyncTaskDao.insertThridQueTag(tagThrids[0]);
              return null;
          }
      }
      private class insertAsyncForth extends AsyncTask<TagForth,Void,Void> {
          private UserDao mAsyncTaskDao;
          public insertAsyncForth(UserDao userDao) {
              mAsyncTaskDao=userDao;
          }

          @Override
          protected Void doInBackground(TagForth... tagForths) {
              mAsyncTaskDao.insertForthtQueTag(tagForths[0]);
              return null;
          }
      }

      // Simple in-memory cache. Details omitted for brevity.
    //private UserCache userCache;

    private void setConncetion() {
        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webService = retrofit.create(Webservice.class);
    }
    public void getFirstTagDataAct(String tt){ Call<Questions> cal01= (Call<Questions>) webService.getAllQuestion("4","40","desc","activity",tt,"stackoverflow");
        cal01.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagFirst tagFirst=new TagFirst(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"activity");

                    insertAllTagFirstQues(tagFirst);
                   // Log.e("Tag","Activit"+tagFirst);
                }
                Log.e("Tag","Activit");
                //
                //Toast.makeText(questionListActivity, ""+questionItems1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });}
    public void getFirstTagDataHot(String tt){

        Call<Questions> call1= (Call<Questions>) webService.getAllHotQuestion("1","40","desc","hot", tt,"stackoverflow");
        call1.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagFirst tagFirst=new TagFirst(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"hot");

                    insertAllTagFirstQues(tagFirst);
                   // Log.e("Tag","hot"+tagFirst);
                }
                Log.e("Tag","hot" );

                // Toast.makeText(questionListActivity, ""+questionItems, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }
    public void getFirstTagDataWeek(String tt){

        Call<Questions> cal21= (Call<Questions>) webService.getAllWeekQuestion("1","40","desc","week",tt,"stackoverflow");
        cal21.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagFirst tagFirst=new TagFirst(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"week");

                    insertAllTagFirstQues(tagFirst);
                    //Log.e("Tag","week"+tagFirst);

                }
                Log.e("Tag","week" );

                // Toast.makeText(questionListActivity, ""+questionItems, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }

    public void getSecondTagDataAct(String tt){
        Call<Questions> cal02= (Call<Questions>) webService.getAllQuestion("4","40","desc","activity",tt,"stackoverflow");
        cal02.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagSecond tagSecond=new TagSecond(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"activity");

                    insertAllTagsecondQues(tagSecond);
                }
                Log.e("Tag","Activit");
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }
    public void getSecondTagDataHot(String tt){
        Call<Questions> call2= (Call<Questions>) webService.getAllHotQuestion("1","40","desc","hot",tt,"stackoverflow");
        call2.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagSecond tagSecond=new TagSecond(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"hot");

                    insertAllTagsecondQues(tagSecond);
                }
                // Toast.makeText(questionListActivity, ""+questionItems, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }
    public void getSecondTagDataWeek(String tt){

        Call<Questions> cal22= (Call<Questions>) webService.getAllWeekQuestion("1","40","desc","week",tt,"stackoverflow");
        cal22.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagSecond tagSecond=new TagSecond(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"week");

                    insertAllTagsecondQues(tagSecond);
                }
                // Toast.makeText(questionListActivity, ""+questionItems, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });

    }

    public void getThridTagDataAct(String tt){
        Call<Questions> cal03= (Call<Questions>) webService.getAllQuestion("4","40","desc","activity",tt,"stackoverflow");
        cal03.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagThrid tagThrid=new TagThrid(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"activity");

                    insertgetAllTagThridQues(tagThrid);
                }
                Log.e("Tag","Activit");
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }
    public void getThridTagDataHot(String tt){


        Call<Questions> call3= (Call<Questions>) webService.getAllHotQuestion("1","40","desc","hot",tt,"stackoverflow");
        call3.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagThrid tagThrid=new TagThrid(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"hot");

                    insertgetAllTagThridQues(tagThrid);
                }


            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }
    public void getThridTagDataWeek(String tt){
        Call<Questions> cal23= (Call<Questions>) webService.getAllWeekQuestion("1","40","desc","week",tt,"stackoverflow");
        cal23.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagThrid tagThrid=new TagThrid(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"week");

                    insertgetAllTagThridQues(tagThrid);
                }


            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }

    public void getForthTagDataAct(String tt){
        Call<Questions> cal04= (Call<Questions>) webService.getAllQuestion("4","40","desc","activity" ,tt,"stackoverflow");
        cal04.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagForth tagForth=new TagForth(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"activity");
                         insertAllTagForthQues(tagForth);
                 }
                Log.e("Tag","Activit");

                //Toast.makeText(questionListActivity, ""+questionItems, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }
    public void getForthTagDataHot(String tt){
        Call<Questions> call4= (Call<Questions>) webService.getAllHotQuestion("1","40","desc","hot",tt,"stackoverflow");
        call4.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagForth tagForth=new TagForth(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"hot");
                    insertAllTagForthQues(tagForth);
                }
               // Toast.makeText(questionListActivity, ""+questionItems, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }
    public void getForthagDataWeek(String tt){
        Call<Questions> cal24= (Call<Questions>) webService.getAllWeekQuestion("1","40","desc","week",tt,"stackoverflow");
        cal24.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Questions  questions=response.body();
                List<QuestionItems>  questionItems1=questions.getItems();
                //ArrayList<QuestionItems>=questionItems1.
                for(int i=0;i<questionItems1.size();i++){
                    TagForth tagForth=new TagForth(questionItems1.get(i).getTitle(),questionItems1.get(i).getLink(),questionItems1.get(i).getIs_answered(),questionItems1.get(i).getAnswer_count()
                            ,"week");
                    insertAllTagForthQues(tagForth);
                }
                //Toast.makeText(questionListActivity, ""+questionItems, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }



}

