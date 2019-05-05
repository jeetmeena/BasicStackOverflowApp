package com.example.stackoverflowandroidapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Update;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

import java.util.List;


import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSelewctedTag( SelectedTags selectedTags);

    @Query("SELECT * FROM selectedtags")
    LiveData<List< SelectedTags>> getAllSelectedTags();

    @Query("SELECT * FROM QusestionEntity")
    List<QusestionEntity> getAllRepos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFirstQueTag( TagFirst tagFirst);
    @Query("SELECT * FROM TagFirst")
    LiveData<List< TagFirst>> getAllFirstTagQue();
    @Query("SELECT * FROM TagFirst Where typesActivit='activity'  ")
    LiveData<List< TagFirst>> getAllFirstTagYour();
    @Query("SELECT * FROM TagFirst Where typesActivit='hot' ")
    LiveData<List< TagFirst>> getAllFirstTagHot();
    @Query("SELECT * FROM TagFirst Where typesActivit='week' ")
    LiveData<List< TagFirst>> getAllFirstTagWeek();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSecondQueTag(TagSecond tagSecond);
    @Query("SELECT * FROM TagSecond")
    LiveData<List<TagSecond>> getAllSecondTagQue();
    @Query("SELECT * FROM TagSecond Where typesActivit='activity'")
    LiveData<List<TagSecond>> getAllSecondTagYour();
    @Query("SELECT * FROM TagSecond Where typesActivit='hot'")
    LiveData<List<TagSecond>> getAllSecondTagHot();
    @Query("SELECT * FROM TagSecond Where typesActivit='week'")
    LiveData<List<TagSecond>> getAllSecondTagWeek();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertThridQueTag(TagThrid tagThrid);
    @Query("SELECT * FROM TagThrid")
    LiveData<List<TagThrid>> getAllThridTagQue();
    @Query("SELECT * FROM TagThrid Where typesActivit='activity'")
    LiveData<List<TagThrid>> getAllThridTagYour();
    @Query("SELECT * FROM TagThrid Where typesActivit=('hot')")
    LiveData<List<TagThrid>> getAllThridTagHot();
    @Query("SELECT * FROM TagThrid Where typesActivit=('week')")
    LiveData<List<TagThrid>> getAllThridTagWeek();



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertForthtQueTag( TagForth tagForth);
    @Query("SELECT * FROM TagForth")
    LiveData<List< TagForth>> getAllForthTagQue();
    @Query("SELECT * FROM TagForth Where typesActivit='activity'")
    LiveData<List< TagForth>> getAllForthTagYour();
    @Query("SELECT * FROM TagForth Where typesActivit='hot'")
    LiveData<List< TagForth>> getAllForthTagHot();
    @Query("SELECT * FROM TagForth Where typesActivit='week'")
    LiveData<List< TagForth>> getAllForthTagWeek();


    @Insert
    void insert(QusestionEntity... repos);

    @Update
    void update(QusestionEntity... repos);

    @Delete
    void delete(QusestionEntity... repos);

    @Insert(onConflict = REPLACE)
    void save(QusestionEntity body);



    // LiveData<QusestionEntity> load(int userId);

    //boolean hasUser(int i);


}
