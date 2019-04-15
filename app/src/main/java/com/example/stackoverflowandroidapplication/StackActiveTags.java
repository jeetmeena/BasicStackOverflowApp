package com.example.stackoverflowandroidapplication;

import com.google.gson.annotations.Expose;

class StackActiveTags {
    @Expose
    private String tagCount;

    @Expose
    private String tagName;

    public String getTagCount() {
        return tagCount;
    }

    public void setTagCount(String tagCount) {
        this.tagCount = tagCount;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
