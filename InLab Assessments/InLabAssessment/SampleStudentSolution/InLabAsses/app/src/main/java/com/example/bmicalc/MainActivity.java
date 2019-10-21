package com.example.bmicalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioGroup calc_btns;
    RadioButton bmi, weight;
    boolean isRadioButtonChecked = false;
    Button open_btn;
    String choice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc_btns = findViewById(R.id.radioGroup);
        bmi = findViewById(R.id.bmi_rbtn);

        calc_btns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bmi_rbtn:
                        choice = "BMI Calculator";
                        break;
                    case R.id.weight_rbtn:
                        choice = "Weight Converter";
                        break;
                }
            }
        });

    }

    public void onOpen(View view) {
        Intent intent;
        if (choice.equals("BMI Calculator")) {
            intent = new Intent(MainActivity.this, BMICalculator.class);
            startActivity(intent);

        } else if (choice.equals("Weight Converter")) {
            intent = new Intent(MainActivity.this, WeightConverter.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please choose one", Toast.LENGTH_SHORT).show();
        }

    }
}

