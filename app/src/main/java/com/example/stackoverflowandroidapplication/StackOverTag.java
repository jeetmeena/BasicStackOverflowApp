package com.example.stackoverflowandroidapplication;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class StackOverTag {


    @Expose
    private List<StackActiveTags> items = new ArrayList<StackActiveTags>();

    public  List<StackActiveTags> getItems() {
        return items;
    }

    public void setItems(ArrayList<StackActiveTags> Items) {
        this.items = Items;
    }
}