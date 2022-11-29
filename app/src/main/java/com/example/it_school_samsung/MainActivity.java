package com.example.it_school_samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.it_school_samsung.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(this);
        login = binding.editLogin;
        password = binding.editPassword;

    }


    @Override
    public void onClick(View view) {
        if (login.getText().length() == 0 || password.getText().length() == 0) {
            Toast.makeText(this, "Заполните пустые поля", Toast.LENGTH_SHORT).show();
        } else if (password.getText().length() < 8) {
            Toast.makeText(this, "Пароль должен быть не менее 8 символов", Toast.LENGTH_SHORT).show();
        } else if (login.getText().toString().equals("rickroll@gmail.com") && !password.getText().toString().equals("RickAstley")) {
            Toast.makeText(this, "Неверный пароль", Toast.LENGTH_SHORT).show();
        } else {

            switch (view.getId()) {
                case R.id.button:
                    Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                    intent.putExtra("login", binding.editLogin.getText().toString());
                    startActivity(intent);
                    break;
            }
        }
    }

}