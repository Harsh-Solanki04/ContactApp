package com.example.prac_7;
import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {myData.class},version = 1)
public abstract class contactDatabase extends RoomDatabase{
    public abstract contactsDAO contactsDAO();
}
