package com.cmps312.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] names = {"Abdulahi", "Mohamed", "Hassen"};
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {

        TextView tv = findViewById(R.id.textView);
        tv.setText(names[i]);
        i++;
    }
}
