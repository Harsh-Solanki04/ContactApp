package com.example.prac_7;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.widget.ImageView;
import android.content.Intent;
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private Context context;
    private List<ContactModel> contactList;

    public ContactAdapter(Context context, List<ContactModel> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        ContactModel contact = contactList.get(position);

        holder.contactName.setText(contact.getName());
        holder.contactPhone.setText(contact.getPhone());
        holder.contactEmail.setText(contact.getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,ContactActivity.class);
                i.putExtra("CONTACT", contact);
                context.startActivity(i);
            }
        });
        /*
        if (contact.getPhoto() != null) {
            // Load contact photo from database
            byte[] photo = contact.getPhoto();
            Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
            holder.ivPhoto.setImageBitmap(bitmap);
        } else {
            holder.ivPhoto.setImageResource(R.drawable.ic_launcher_background);
        }

         */
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    static class ContactHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView contactName, contactPhone, contactEmail;

        public ContactHolder(View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.tvName);
            contactPhone = itemView.findViewById(R.id.tvPhone);
            contactEmail = itemView.findViewById(R.id.tvEmail);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
        }
    }
}

