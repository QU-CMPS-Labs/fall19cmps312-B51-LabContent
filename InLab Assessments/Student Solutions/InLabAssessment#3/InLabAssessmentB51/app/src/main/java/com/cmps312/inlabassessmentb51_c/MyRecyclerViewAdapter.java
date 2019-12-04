package com.cmps312.inlabassessmentb51_c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//TODO implement the recyclerView adapter
class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>  {

    Context context;
    ArrayList<Contact> contacts;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView phone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
            phone = itemView.findViewById(R.id.telephone_tv);
        }
    }

    public MyRecyclerViewAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View convertView = LayoutInflater.from(context)
                .inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        //add the data to the views
        holder.name.setText(contacts.get(position).getName());
        holder.phone.setText(contacts.get(position).getTelephoneNumber());


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }



}
