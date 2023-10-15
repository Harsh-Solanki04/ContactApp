package com.example.prac_7;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;

public class MainActivity2 extends AppCompatActivity {
    private static final int REQUEST_CODE=22;
    Button btnPic;
    ImageView imgView;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnPic=findViewById(R.id.btncamera_id);
        imgView=findViewById(R.id.image);
        btnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultLauncher.launch(cameraIntent);
            }
        });
        activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Bundle extras=result.getData().getExtras();
                Uri imgUri;
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                WeakReference<Bitmap> result_1 = new WeakReference<>(Bitmap.createScaledBitmap(imageBitmap, imageBitmap.getWidth(), imageBitmap.getHeight(), false).copy(Bitmap.Config.RGB_565, true));
                Bitmap bm=result_1.get();
                imgUri=saveImg(bm,MainActivity2.this);
                imgView.setImageURI(imgUri);
            }
        });
    }
    private Uri saveImg(Bitmap image, MainActivity2 context) {

        File imagefolder = new File(context.getCacheDir(), "images");

        Uri uri = null;

        try{

            imagefolder.mkdirs();

            File file = new File(imagefolder, "captured_image.jpg");

            FileOutputStream stream = new FileOutputStream(file);

            image.compress(Bitmap.CompressFormat.JPEG, 100, stream);

            stream.flush();

            stream.close();

            uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.allcodingtutorial.camerafull1"+".provider", file);

        }
        catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return uri ;

    }


    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            Bitmap photo=(Bitmap) data.getExtras().get("data");
            imgView.setImageBitmap(photo);
        }
        else{
            Toast.makeText(this,"CANCELLED",Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode,resultCode,data);

        }

    }

     */


}