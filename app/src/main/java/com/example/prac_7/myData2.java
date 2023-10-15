package com.example.prac_7;

import android.graphics.Bitmap;


public class myData2 {
    private String name;

    private String phoneNumber;
    private Bitmap pic;
    public myData2(String name,String phoneNumber){
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
