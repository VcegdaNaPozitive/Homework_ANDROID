package com.example.it_school_samsung;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.it_school_samsung.databinding.ActivityCommentBinding;

public class CommentActivity extends AppCompatActivity {

    private ActivityCommentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCommentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupUI();
    }

    private void setupUI() {
        binding.back.setOnClickListener(view -> {
            finish();
        });
    }
}