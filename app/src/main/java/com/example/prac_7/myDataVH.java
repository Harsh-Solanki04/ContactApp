package com.example.prac_7;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myDataVH extends RecyclerView.ViewHolder{
    public TextView cName;
    public TextView cNumber;
    public ImageView cPhoto;


    public myDataVH(@NonNull View itemView) {
        super(itemView);
        cName=itemView.findViewById(R.id.contactName);
        cNumber=itemView.findViewById(R.id.contactPhoneNumber);
        cPhoto=itemView.findViewById(R.id.contactPhoto);
    }
}
