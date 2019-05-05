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

    public static class TagItems {
        ArrayList<StackActiveTags> items;
        boolean   has_more ;
         int   quota_max;
         int   quota_remaining;

        public ArrayList<StackActiveTags> getItems() {
            return items;
        }

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public int getQuota_max() {
            return quota_max;
        }

        public void setQuota_max(int quota_max) {
            this.quota_max = quota_max;
        }

        public int getQuota_remaining() {
            return quota_remaining;
        }

        public void setQuota_remaining(int quota_remaining) {
            this.quota_remaining = quota_remaining;
        }

        public void setItems(ArrayList<StackActiveTags> items) {
            this.items = items;
        }
    }
}