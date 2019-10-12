package com.example.bmicalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculator extends AppCompatActivity {
    EditText weight, height;
    TextView bmiTv, status;
    Button calc;
    double calculatedBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calc);

        weight = findViewById(R.id.weight_edt);
        height = findViewById(R.id.height_edt);
        calc = findViewById(R.id.button2);
        bmiTv = findViewById(R.id.bmi_tv);
        status = findViewById(R.id.categories_tv);

    }

    public void BMICalc(View view) {
        double weightD = Double.parseDouble(weight.getText().toString());
        double heightD = Double.parseDouble(height.getText().toString()) / 100;

        calculatedBmi = weightD / (heightD * heightD);
        bmiTv.setText("Your bmi is " + calculatedBmi);

        if (calculatedBmi <= 18.5) {
            status.setText("You are underweight");

        } else if (calculatedBmi >= 18.5 && calculatedBmi <= 24.9) {
            status.setText("You are normal weight");

        } else if (calculatedBmi >= 25 && calculatedBmi <= 29.9) {
            status.setText("You are overweight");

        } else {
            status.setText("Obesity");

        }


    }
}
