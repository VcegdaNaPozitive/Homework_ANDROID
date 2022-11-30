package com.example.it_school_samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.it_school_samsung.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String login = binding.editLogin.getText().toString();
        String password = binding.editPassword.getText().toString();
        Log.v("LET'S GO", "START");
        if (login.length() == 0 || password.length() == 0) {
            Toast.makeText(this, "Заполните пустые поля", Toast.LENGTH_SHORT).show();
            Log.e("ERR", "Надо поля заполнить");
        } else if (password.length() < 8) {
            Toast.makeText(this, "Пароль должен быть не менее 8 символов", Toast.LENGTH_SHORT).show();
            Log.e("ERR", "Пароль нормальный нужен");
        } else if (login.equals("rickroll@gmail.com") && !password.equals("RickAstley")) {
            Toast.makeText(this, "Неверный пароль", Toast.LENGTH_SHORT).show();
            Log.e("ERR", "Фигня, пробовать другое надо");
        } else {

            switch (view.getId()) {
                case R.id.button:
                    Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                    intent.putExtra("login", login);
                    startActivity(intent);
                    finish();
                    Log.i("YES", "email: " + login);
                    break;
            }
        }
    }
}