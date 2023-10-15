package com.example.prac_7;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface contactsDAO {
    @Insert
    void insert(myData... data);
    @Insert
    void insertMultiple(List<myData> data);
    @Update
    void update(myData... data);
    @Delete
    void delete(myData... data);
    @Query("Select * FROM contacts")
    List<myData> getAllContacts();
    @Query("Select * from contacts where name=:studentName")
    List<myData> getContactByName(String studentName);
}
