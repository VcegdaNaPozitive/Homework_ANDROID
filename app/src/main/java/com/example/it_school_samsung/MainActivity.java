package com.example.it_school_samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private TextView textViewX;
    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        editTextC = findViewById(R.id.edit_text_c);
        textViewX = findViewById(R.id.text_view_x);
    }


    private int getIntValue(EditText editText) {
        return Integer.parseInt(editText.getText().toString());
    }


    public void click(View view) {
        int a = getIntValue(editTextA);
        int b = getIntValue(editTextB);
        int c = getIntValue(editTextC);
        if (a == 0) {
            Toast.makeText(this, "а не может быть равно 0", Toast.LENGTH_SHORT).show();
        } else {
            int D = b * b - 4 * a * c;
            double x = 0;
            if (D > 0) {
                double x1 = 0, x2 = 0;
                x1 = (-b - Math.sqrt(D)) / (2 * a);
                x2 = (-b + Math.sqrt(D)) / (2 * a);
                textViewX.setText("x1 = " + (String.format("%.2f", x1)) + "; x2 = " + (String.format("%.2f", x2)) + ".");
            } else if (D == 0) {
                x = -b / (2 * a);
                textViewX.setText("x = " + (String.format("%.2f", x)) + ".");

            } else {
                textViewX.setText("уравнение не имеет решений.");
            }
        }
    }
}