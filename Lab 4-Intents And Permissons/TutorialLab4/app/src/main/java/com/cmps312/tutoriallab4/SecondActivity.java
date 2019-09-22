package com.cmps312.tutoriallab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void sendEmail(View view) {
        Toast.makeText(this, "I will be able to send", Toast.LENGTH_SHORT).show();
    }
}
