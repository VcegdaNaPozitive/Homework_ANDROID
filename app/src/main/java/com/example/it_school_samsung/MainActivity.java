package com.example.it_school_samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.it_school_samsung.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final News[] data = new News[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.listView.setAdapter(new MyNewsAdapter(this, data));

        data[0] = new News("СПАЙК", 10, 10, 10, R.drawable.news1);
        data[1] = new News("ВОРОН", 20, 20, 20, R.drawable.news2);
        data[2] = new News("ЛЕОН", 30, 30, 30, R.drawable.news3);
        data[3] = new News("СЕНДИ", 40, 40, 40, R.drawable.news4);
        data[4] = new News("МЭГ", 50, 50, 50, R.drawable.news5);
        data[5] = new News("АМБЕР", 60, 60, 60, R.drawable.news6);
    }
}