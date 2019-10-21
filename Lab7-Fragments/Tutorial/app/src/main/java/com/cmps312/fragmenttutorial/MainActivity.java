package com.cmps312.fragmenttutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MyFragmentTwo.FragmentTwoListner {

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragmentTwo fragmentTwo = MyFragmentTwo.createAndAssignFragment("Hello");

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

        MyFragmentTwo fragmentTwo = MyFragmentTwo.createAndAssignFragment("bla bla bla");

        //step 2. use transaction to inject the fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_holder, fragmentTwo)
                .addToBackStack(null)
                .commit();
    }

    public void openSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


    @Override
    public void SayHello(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
