package com.example.stackoverflowandroidapplication;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class StackUserInfo {
    @Expose
    private List<Items> items = new ArrayList<Items>();

    /**
     *
     * @return
     * The Items
     */
    public  List<Items> getItems() {
        return items;
    }

    /**
     *
     * @param Items
     * The Items
     */
    public void setItems(ArrayList<Items> Items) {
        this.items = Items;
    }



}
