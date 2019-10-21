package com.example.bmicalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WeightConverter extends AppCompatActivity {
    EditText kg, pound;
    Button convertBtn;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter);

        kg = findViewById(R.id.kg_edt);
        pound = findViewById(R.id.pound_edt);
        convertBtn = findViewById(R.id.convert_btn);

        kg.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    convertBtn.setText("Kg to Pound");
                    pound.setText("");
                }
            }
        });

        pound.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    convertBtn.setText("Pound to kg");
                    kg.setText("");
                }
            }
        });

    }

    public void convertWeight(View view) {

        if (kg.getText().length() >= 1 && convertBtn.getText().toString().equals("Kg to Pound")) {
            double n = Double.parseDouble(kg.getText().toString());
            pound.setText("" + n * 2.2046);
        } else if (pound.getText().length() >= 1 && convertBtn.getText().toString().equals("Pound to kg")) {
            double n = Double.parseDouble(pound.getText().toString());
            kg.setText("" + n / 2.2046);
        }
    }
}
