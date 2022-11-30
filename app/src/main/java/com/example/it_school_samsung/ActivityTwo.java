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
    }

    @Override
    public void onClick(View view) {
        Log.i("TAKE PHOTO", "very well");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        Log.i("TAKE PHOTO", "делаем...");
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) intent.getExtras().get("data");
            binding.image.setImageBitmap(photo);
            Log.i("TAKE PHOTO", "картинка");
        }
    }
}

