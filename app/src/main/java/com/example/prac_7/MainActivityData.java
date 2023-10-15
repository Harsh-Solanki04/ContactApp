package com.example.prac_7;

import android.os.Bundle;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainActivityData extends ViewModel {
    ArrayList<myData2> contactData;
    private MutableLiveData<Bundle> currentGameState;
    public MainActivityData(){
        currentGameState=new MediatorLiveData<Bundle>();
        currentGameState.setValue(null);
        contactData=new ArrayList<myData2>();
    }
    public ArrayList<myData2> getmyData(){
        return contactData;
    }
    public void setmyData(ArrayList<myData2> contactData){
        this.contactData=contactData;
    }

    public MutableLiveData<Bundle> getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(Bundle value) {
        currentGameState.setValue(value);
    }
}
