package com.example.stackoverflowandroidapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "TagFirst")
public  class TagFirst {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "qutionTitle")
    private String qutionTitle;

    @ColumnInfo(name = "qutionLink")
    private String qutionLink;
    @NonNull
    @ColumnInfo(name = "isAnswered")
    private Boolean isAnswered;
    @NonNull
    @ColumnInfo(name = "answerCount")
    private String answerCount;
    @NonNull
    @ColumnInfo(name = "typesActivit")
    private String typesActivit;



    public TagFirst(@NonNull String qutionTitle, String qutionLink, @NonNull Boolean isAnswered, @NonNull String answerCount, @NonNull String typesActivit) {
        this.qutionTitle = qutionTitle;
        this.qutionLink = qutionLink;
        this.isAnswered = isAnswered;
        this.answerCount = answerCount;
        this.typesActivit = typesActivit;
    }

    @NonNull
    public String getQutionTitle() {
        return qutionTitle;
    }

    public void setQutionTitle(@NonNull String qutionTitle) {
        this.qutionTitle = qutionTitle;
    }

    public String getQutionLink() {
        return qutionLink;
    }

    public void setQutionLink(String qutionLink) {
        this.qutionLink = qutionLink;
    }

    @NonNull
    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(@NonNull Boolean answered) {
        isAnswered = answered;
    }

    @NonNull
    public String getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(@NonNull String answerCount) {
        this.answerCount = answerCount;
    }

    @NonNull
    public String getTypesActivit() {
        return typesActivit;
    }

    public void setTypesActivit(@NonNull String typesActivit) {
        this.typesActivit = typesActivit;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}