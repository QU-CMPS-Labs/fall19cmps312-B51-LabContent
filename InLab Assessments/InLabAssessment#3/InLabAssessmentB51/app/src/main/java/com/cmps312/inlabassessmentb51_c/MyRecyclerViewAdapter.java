package com.cmps312.inlabassessmentb51_c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//TODO implement the recyclerView adapter
class MyRecyclerViewAdapter {

    private Context context;
    private ArrayList<Contact> contacts;

    public MyRecyclerViewAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

}
