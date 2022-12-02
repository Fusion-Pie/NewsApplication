package com.example.newsapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserDetails.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DatabaseDAO UserDb();
}
