package com.example.stackoverflowandroidapplication;

import android.os.AsyncTask;

class PopulateDbAsync extends AsyncTask< SelectedTags,Void,Void> {
    private final UserDao mDao;
    public PopulateDbAsync(QuestiionDatabase instance) {
        mDao=instance.userDao();

    }

    @Override
    protected Void doInBackground( SelectedTags... selectedTags) {

        SelectedTags selectedTags1 = new  SelectedTags("Hello");
        mDao.insertSelewctedTag(selectedTags1);
        return null;
    }
}
