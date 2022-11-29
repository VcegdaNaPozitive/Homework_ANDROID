package com.example.it_school_samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.it_school_samsung.databinding.ActivityTwoBinding;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener {

    private ActivityTwoBinding binding;
    private ImageView photo;
    private static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        binding = ActivityTwoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        String login = intent.getStringExtra("login");
        binding.hello.setText(login);
        binding.camera.setOnClickListener(this);
        photo = binding.photo;
    }

    @Override
    public void onClick(View view) {
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try{
            startActivityForResult(takePhotoIntent, REQUEST_TAKE_PHOTO);
        }catch (ActivityNotFoundException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap thumbnailBitmap = (Bitmap) extras.get("data");
            photo.setImageBitmap(thumbnailBitmap);
        }
    }
}

