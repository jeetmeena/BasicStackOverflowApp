package com.example.stackoverflowandroidapplication;

import com.google.gson.annotations.Expose;

class StackActiveTags {
    private boolean has_synonyms;
    private boolean is_moderator_only;
    private boolean is_required;
    public StackActiveTags(boolean has_synonyms, boolean is_moderator_only, boolean is_required, String count, String name) {
        this.has_synonyms = has_synonyms;
        this.is_moderator_only = is_moderator_only;
        this.is_required = is_required;
        this.count = count;
        this.name = name;
    }

    @Expose
    private String count;

    @Expose
    private String name;

    public boolean isHas_synonyms() {
        return has_synonyms;
    }

    public void setHas_synonyms(boolean has_synonyms) {
        this.has_synonyms = has_synonyms;
    }

    public boolean isIs_moderator_only() {
        return is_moderator_only;
    }

    public void setIs_moderator_only(boolean is_moderator_only) {
        this.is_moderator_only = is_moderator_only;
    }

    public boolean isIs_required() {
        return is_required;
    }

    public void setIs_required(boolean is_required) {
        this.is_required = is_required;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class HotQues {
    }
}
