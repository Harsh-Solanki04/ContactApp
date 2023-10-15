package com.example.prac_7;

import android.content.Context;

import androidx.room.Room;

public class contactDBinstance {
    private static contactDatabase database;
    public static contactDatabase getDatabase(Context context){
        if (database==null){
            database= Room.databaseBuilder(context,contactDatabase.class,"app_database").allowMainThreadQueries().build();
        }
        return database;
    }
}
