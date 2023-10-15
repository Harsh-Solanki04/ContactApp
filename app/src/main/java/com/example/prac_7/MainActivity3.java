package com.example.prac_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        contactsDAO contactsDAO=contactDBinstance.getDatabase(getApplicationContext()).contactsDAO();
        EditText name=findViewById(R.id.Name);
        EditText number=findViewById(R.id.number);
        Button save=findViewById(R.id.save);
        Button viewAll=findViewById(R.id.allContacts);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1=name.getText().toString();
                String n2=number.getText().toString();
                long n3=Long.parseLong(n2);
                myData data=new myData(n1,n3);
                data.setName(n1);
                data.setPhoneNumber(n3);
                contactsDAO.insert(data);
                Toast toast=Toast.makeText(MainActivity3.this,"A contact is added",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}