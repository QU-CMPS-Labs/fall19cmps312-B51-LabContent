package com.cmps312.tutoriallab4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    int currentNumber;
    TextView numberTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        numberTv = findViewById(R.id.number_tv);


    }

    @Override
    protected void onNewIntent(Intent intent) {
        currentNumber = intent.getIntExtra("currentNumber", 0);
        numberTv.setText(currentNumber + "");
        super.onNewIntent(intent);
    }

    public void sendEmail(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"abdulahi@qu.edu.qa", "aya156789@qu.edu.qa"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "First Email Using Intents");
        intent.putExtra(Intent.EXTRA_TEXT, "This is the body of the email you want to send");
        intent.setData(Uri.parse("mailto:"));

        startActivity(Intent.createChooser(intent, "Choose the email client"));
        // setType message/rfc822


    }

    public void loadNextInteger(View view) {

        currentNumber = Integer.parseInt(numberTv.getText().toString());
        currentNumber++;

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("currentNumber", currentNumber);
        startActivity(intent);
    }
}
