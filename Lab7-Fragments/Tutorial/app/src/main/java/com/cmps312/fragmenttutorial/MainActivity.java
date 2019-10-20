package com.cmps312.fragmenttutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyFragmentTwo fragmentTwo = MyFragmentTwo.newInstance();

        frameLayout = findViewById(R.id.fragment_holder);

        if (frameLayout != null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_holder, fragmentTwo)
                    .addToBackStack(null)
                    .commit();

    }

    public void addFragment(View view) {

        //dynamically adding fragment

        //Step 1. Declare fragment
        MyFragmentTwo fragmentTwo = new MyFragmentTwo();


        //step 2. use transaction to inject the fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_holder, fragmentTwo)
                .addToBackStack(null)
                .commit();
    }

    public void openSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
