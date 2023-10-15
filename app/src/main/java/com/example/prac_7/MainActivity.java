package com.example.prac_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.PersistableBundle;

public class MainActivity extends AppCompatActivity {
    MainMenu menu=new MainMenu();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            loadMenu();
        }
    }
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistanceState){
        super.onSaveInstanceState(outState,outPersistanceState);
    }
    private void loadMenu(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.fragmentContainer);
        if(fragment==null){
            fragmentManager.beginTransaction().add(R.id.fragmentContainer,menu).commit();
        }
        else {
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer,menu).commit();
        }
    }

}