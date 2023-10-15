package com.example.prac_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the root layout (a LinearLayout)
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        contactsDAO contactsDAO=contactDBinstance.getDatabase(getApplicationContext()).contactsDAO();
        List<myData> dataList= contactsDAO.getAllContacts();
        // Create the button
        Button prevButton = new Button(this);
        prevButton.setText("Previous");

        // Set a click listener for the button
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click, e.g., navigate to another activity
                Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        // Add the button to the root layout
        rootLayout.addView(prevButton);


        // Create the list of contacts dynamically
        // Replace this with your logic to fetch and display contacts
        for (myData data : dataList) {
            LinearLayout contactLayout = new LinearLayout(this);
            contactLayout.setOrientation(LinearLayout.HORIZONTAL);

            // Create TextView for name
            TextView nameTextView = new TextView(this);
            nameTextView.setText(data.getName());
            contactLayout.addView(nameTextView);

            // Create TextView for phone number
            TextView phoneTextView = new TextView(this);
            phoneTextView.setText(String.valueOf(data.getPhoneNumber()));
            contactLayout.addView(phoneTextView);

            // Add the contact layout to the root layout
            rootLayout.addView(contactLayout);
        }

        // Set the root layout as the content view of the activity
        setContentView(rootLayout);
        /*
        //setContentView(R.layout.activity_main4);
        contactsDAO contactsDAO=contactDBinstance.getDatabase(getApplicationContext()).contactsDAO();
        //LinearLayout rootLinearLayout=findViewById(R.id.rootLayout);
        LinearLayout rootLinearLayout=new LinearLayout(this);
        List<myData> dataList=contactsDAO.getAllContacts();
        for (myData data:dataList){
            LinearLayout newLinearLayout=new LinearLayout(this);
            newLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(20,20,20,20);
            TextView textView=new TextView(this);
            textView.setLayoutParams(params);
            textView.setText(String.valueOf(data.getName()));
            newLinearLayout.addView(textView);
            TextView textView1=new TextView(this);
            textView1.setText((int) data.getPhoneNumber());
            newLinearLayout.addView(textView1);
            rootLinearLayout.addView(newLinearLayout);
        }
        Button prev=new Button(this);
        prev.setText("Previous");
       // Button prev=findViewById(R.id.previous);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(i);
            }
        });
        rootLinearLayout.addView(prev);

         */

    }


}