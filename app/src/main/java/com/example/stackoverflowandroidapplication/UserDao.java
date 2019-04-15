package com.example.stackoverflowandroidapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;
import android.arch.persistence.room.Query;

import java.util.List;


import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Query("SELECT * FROM QusestionEntity")
    List<QusestionEntity> getAllRepos();

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
