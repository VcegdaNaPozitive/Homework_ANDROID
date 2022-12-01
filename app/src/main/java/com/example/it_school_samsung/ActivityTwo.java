package com.example.it_school_samsung;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.example.it_school_samsung.databinding.ActivityTwoBinding;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener {

    private ActivityTwoBinding binding;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

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
    }

    @Override
    public void onClick(View view) {
        Log.i("TAKE PHOTO", "very well");
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("TAKE PHOTO", "делаем...");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            binding.image.setImageBitmap(imageBitmap);
            Log.i("TAKE PHOTO", "картинка");
        }
    }
}


