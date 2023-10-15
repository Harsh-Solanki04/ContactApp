package com.example.prac_7;
import android.graphics.Bitmap;

import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.Query;

@Entity(tableName = "contacts")
public class myData {
    private String name;
    @PrimaryKey(autoGenerate = true)
    private long phoneNumber;
    @Ignore
    private Bitmap pic;
    public myData(String name,long phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;

    }

    public Bitmap getPic() {
        return pic;
    }

    public void setPic(Bitmap pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
