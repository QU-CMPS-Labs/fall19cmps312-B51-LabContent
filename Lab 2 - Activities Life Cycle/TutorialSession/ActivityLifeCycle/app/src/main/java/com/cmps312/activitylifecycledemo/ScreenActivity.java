package com.cmps312.activitylifecycledemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ScreenActivity extends AppCompatActivity {

    TextView displayTv;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        displayTv = findViewById(R.id.display_tv);
    }

    public void increment(View view) {
        number = Integer.parseInt(displayTv.getText().toString());
        number++;

        displayTv.setText(number + "");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        number = savedInstanceState.getInt("number");
        displayTv.setText(number + "");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("number", number);
    }
}





















