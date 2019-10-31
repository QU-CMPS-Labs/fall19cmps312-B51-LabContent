package com.cmps312.inlabassessmentb51_c;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerViewAdapter adapter;
    private ArrayList<Contact> contacts;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = new ArrayList<>();

        //TODO : Do not change this code here, just implement addNewContact Method
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewContact();
            }
        });

        //TODO add the recyclerView code here

    }

    //TODO Show the dialog that allows adding new contact then notify the adapter
    private void addNewContact() {
        Toast.makeText(MainActivity.this, "Show the dialog Box that allows adding", Toast.LENGTH_LONG).show();
    }

}
