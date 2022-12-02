package com.example.newsapplication;

import android.content.Context;

import androidx.room.Room;

public class DatabaseHelper {
    public MyDatabase initDb(Context context) {
        return Room
                .databaseBuilder(context, MyDatabase.class, "UserDb")
                .build();
    }
}
