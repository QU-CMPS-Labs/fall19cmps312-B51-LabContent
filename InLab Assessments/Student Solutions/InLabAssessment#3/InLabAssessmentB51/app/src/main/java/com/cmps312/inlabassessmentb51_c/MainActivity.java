package com.cmps312.inlabassessmentb51_c;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerViewAdapter adapter;
    private ArrayList<Contact> contacts;
    private RecyclerView recyclerView;
    AlertDialog dialog;
    View myCustomView;
    EditText name, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        myCustomView = getLayoutInflater().inflate(R.layout.dialog_layout, null, false);
        name = myCustomView.findViewById(R.id.name_edt);
        phone = myCustomView.findViewById(R.id.telephone_edt);

        dialog = new AlertDialog.Builder(this).setView(myCustomView).create();

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

        adapter = new MyRecyclerViewAdapter(this, contacts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //step 3. set the adapter and layout manager
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }

    //TODO Show the dialog that allows adding new contact then notify the adapter
    private void addNewContact() {
        dialog.show();
    }

    public void addToContacts(View view) {

        if (name.getText().toString().length() > 0 && phone.getText().toString().length() > 0) {
            contacts.add(new Contact(name.getText().toString(), phone.getText().toString()));
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
        }
        name.setText("");
        phone.setText("");
    }

    public void cancel(View view) {
        dialog.dismiss();
    }
}
