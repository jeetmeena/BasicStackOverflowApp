package com.example.stackoverflowandroidapplication;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

class QuestionItems {

    @Expose
    private List<String> tags = new ArrayList<String>();

    @Expose
    private boolean is_answered;

    @Expose
    private String view_count;

    @Expose
    private String answer_count;

    @Expose
    private  String score;

    @Expose
    private  String creation_date;

    @Expose
    private String link;

    @Expose
    private String title;



    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }



    public String getLink() {
        return link;
    }


    public void setLink(String link) {
        this.link = link;
    }



    public String getCreateDate() {
        return creation_date;
    }


    public void setCreateDate(String creation_date) {
        this.creation_date = creation_date;
    }



    public String getScore() {
        return score;
    }


    public void setScore(String score) {
        this.score = score;
    }


    public String getAnswer_count() {
        return answer_count;
    }


    public void setAnswer_count(String answer_count) {
        this.answer_count = answer_count;
    }


    public String getView_count() {
        return view_count;
    }


    public void setView_count(String view_count) {
        this.view_count = view_count;
    }


    public boolean getIs_answered() {
        return is_answered;
    }


    public void setIs_answered(boolean is_answered) {
        this.is_answered = is_answered;
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> Items) {
        this.tags = Items;
    }
}
