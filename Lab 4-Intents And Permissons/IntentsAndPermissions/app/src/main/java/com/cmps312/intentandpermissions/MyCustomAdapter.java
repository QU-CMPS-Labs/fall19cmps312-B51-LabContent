package com.cmps312.intentandpermissions;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {
    public static final String TAG = MyCustomAdapter.class.getSimpleName();
    private Context context;
    private ArrayList<Planet> planets;

    public MyCustomAdapter(Context context, ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView planetImage;
        public TextView planetNameTv;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            planetImage = itemView.findViewById(R.id.planet_img);
            planetNameTv = itemView.findViewById(R.id.planet_name_tv);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.row_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        final String planetName = planets.get(i).getName().toLowerCase();
        Log.d(TAG, "Planet Name : ");

        try {
            InputStream stream = context.getAssets().open(planetName + ".png");
            Drawable drawable = Drawable.createFromStream(stream, planetName);
            myViewHolder.planetImage.setImageDrawable(drawable);
            myViewHolder.planetNameTv.setText(planetName);


        } catch (IOException e) {
            Log.e(TAG, "Something crazy happened: ");
            e.printStackTrace();
        }

        final int position = i;
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlanetFactsActivity.class);
                intent.putExtra("index", position);
                intent.putExtra("Planets", planets);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return planets.size();
    }
}
