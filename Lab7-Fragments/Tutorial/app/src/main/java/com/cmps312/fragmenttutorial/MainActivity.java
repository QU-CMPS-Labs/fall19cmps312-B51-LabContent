package com.cmps312.fragmenttutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
