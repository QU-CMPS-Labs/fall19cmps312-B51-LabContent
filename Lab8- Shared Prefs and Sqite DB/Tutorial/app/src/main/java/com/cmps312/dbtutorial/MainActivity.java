package com.cmps312.dbtutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add_btn:
                break;
            case R.id.update_btn:
                break;

            case R.id.delete_btn:
                break;

            case R.id.search_btn:
                break;

            default:
                Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show();

        }
    }
}
