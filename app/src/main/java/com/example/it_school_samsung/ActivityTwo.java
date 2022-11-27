package com.example.it_school_samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.it_school_samsung.databinding.ActivityTwoBinding;

public class ActivityTwo extends AppCompatActivity {

//    private ActivityTwoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
//        binding = ActivityTwoBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
    }
}