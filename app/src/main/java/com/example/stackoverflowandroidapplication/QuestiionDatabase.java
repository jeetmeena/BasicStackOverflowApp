package com.example.stackoverflowandroidapplication;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
@Database(entities = { QusestionEntity.class }, version = 1)
public abstract class QuestiionDatabase extends RoomDatabase {
    private static final String DB_NAME = "repoDatabase.db";
    private static volatile QuestiionDatabase instance;

    static synchronized QuestiionDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static QuestiionDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                QuestiionDatabase.class,
                DB_NAME).build();
    }

    public abstract UserDao userDao();
    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
