package com.example.stackoverflowandroidapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "SelectedTags")
public  class SelectedTags {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "Tags")
    private String mSelectTags;

    public SelectedTags(@NonNull String mSelectTags) {
        this.mSelectTags = mSelectTags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getSelectTags() {
        return mSelectTags;
    }

    public void setSelectTags(@NonNull String mSelectTags) {
        this.mSelectTags = mSelectTags;
    }
}