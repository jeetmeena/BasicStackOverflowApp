package com.example.stackoverflowandroidapplication;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

class Questions {

    @Expose
    private List<QuestionItems> items = new ArrayList<QuestionItems>();


    // The QuestionItems

    public  List<QuestionItems> getItems() {
        return items;
    }


     // The QuestionItems

    public void setItems(ArrayList<QuestionItems> Items) {
        this.items = Items;
    }

}