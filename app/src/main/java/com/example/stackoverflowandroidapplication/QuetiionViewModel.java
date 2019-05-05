package com.example.stackoverflowandroidapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

public class QuetiionViewModel extends AndroidViewModel {
    private QusestionEntity qusestionEntity;
    private LiveData<QusestionEntity> qusestionEntityLiveData;

     private StackUserRepo userRepo;
     private Webservice webservice;

    private LiveData<List<SelectedTags>> mAllTags;
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

    public QuetiionViewModel(@NonNull Application application ) {
        super(application);
        userRepo=new StackUserRepo(application );
        mAllTags=userRepo.getmAllSelectedTags();
        mAllTagFirstQues=userRepo.getAllTagFirstQues();
        mAllTagFirstYour=userRepo.getAllTagFirstYour();
        mAllTagFirstHot=userRepo.getAllTagFirstHot();
        mAllTagFirstWeek=userRepo.getAllTagFirstWeek();

        mAllTagsecondQues=userRepo.getAllTagsecondQues();
        mAllTagsecondYour=userRepo.getAllTagsecondYour();
        mAllTagsecondHot=userRepo.getAllTagsecondHot();
        mAllTagsecondWeek=userRepo.getAllTagsecondWeek();

        mAllTagThridQues=userRepo.getAllTagThridQues();
        mAllTagThridYour=userRepo.getAllTagThridYour();
        mAllTagThridHot=userRepo.getAllTagThridHot();
        mAllTagThridWeek=userRepo.getAllTagThridWeek();

        mAllTagForthQues=userRepo.getAllTagForthQues();
        mAllTagForthYour=userRepo.getAllTagForthYour();
        mAllTagForthHot=userRepo.getmAllTagForthHot();
        mAllTagForthWeek=userRepo.getAllTagForthWeek();

    }

    // Instructs Dagger 2 to provide the UserRepository parameter.

    LiveData<List<SelectedTags>> getmAllData(){
        return mAllTags;
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

    public void getFirstTagDataAct(String tag){
        userRepo.getFirstTagDataAct(tag);
    }
    public void getFirstTagDataHot(String tag){
        userRepo.getFirstTagDataHot(tag);
    }
    public void getFirstTagDataWeek(String tag){
        userRepo.getFirstTagDataWeek(tag);
    }
    public void getSecondTagDataAct(String tag){
        userRepo.getSecondTagDataAct(tag);
    }
    public void getSecondTagDataHot(String tag){
        userRepo.getSecondTagDataHot(tag);
    }
    public void getSecondTagDataWeek(String tag){
        userRepo.getSecondTagDataWeek(tag);
    }
    public void getThridTagDataAct(String tag){
        userRepo.getThridTagDataAct(tag);
    }
    public void getThridTagDataHot(String tag){
        userRepo.getThridTagDataHot(tag);
    }
    public void getThridTagDataWeek(String tag){
        userRepo.getThridTagDataWeek(tag);
    }
    public void getForthTagDataAct(String tag){
        userRepo.getForthTagDataAct(tag);
    }
    public void getForthTagDataHot(String tag){
        userRepo.getForthTagDataHot(tag);
    }
    public void getForthagDataWeek(String tag){
        userRepo.getForthagDataWeek(tag);
    }


    public void insertAllTags(SelectedTags tags){
       userRepo.insertAllTags(tags);
    }
    public void insertAllTagFirstQues(TagFirst tagFirst){
        userRepo.insertAllTagFirstQues(tagFirst);
    }
    public void insertAllTagsecondQues(TagSecond tagSecond){
        userRepo.insertAllTagsecondQues(tagSecond);
    }
    public void insertgetAllTagThridQues(TagThrid tagThrid){
        userRepo.insertgetAllTagThridQues(tagThrid);
    }
    public void insertAllTagForthQues(TagForth tagForth){
        userRepo.insertAllTagForthQues(tagForth);
    }



    public LiveData<QusestionEntity> getUser() {
        return this.qusestionEntityLiveData;
    }


}
