package com.example.prac_7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myDataAdapter extends RecyclerView.Adapter<myDataVH> {
    ArrayList<myData2> data;
    public myDataAdapter(ArrayList<myData2> data){
        this.data=data;
    }
    @NonNull
    @Override
    public myDataVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.list_item_layout,parent,false);
        //myDataVH myDataVHolder=new myDataVH(view);
        return new myDataVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myDataVH holder, int position) {
        myData2 singleData=data.get(position);
        holder.cName.setText(singleData.getName());
        holder.cNumber.setText(singleData.getPhoneNumber());
       // holder.cPhoto.setImageURI(singleData.getPhotoUri());   //hold for photo or button
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
