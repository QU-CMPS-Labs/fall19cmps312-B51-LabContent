package com.cmps312.peoplepower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cmps312.peoplepower.adapters.MyAdapter;
import com.cmps312.peoplepower.httpRequests.UserClient;
import com.cmps312.peoplepower.models.Result;
import com.cmps312.peoplepower.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<User> users;
    MyAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void downloadUser(View view) {

        //Step 1.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UserClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Step 2.

        UserClient client = retrofit.create(UserClient.class);

        Call<Result> call = client.getUsers("10", "json");

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                Result result = response.body();
                ArrayList<User> users = result.getUsers();

                adapter = new MyAdapter(MainActivity.this, users);
                recyclerView.setAdapter(adapter);

                Toast.makeText(MainActivity.this, users.get(0).getPicture().getLarge(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

































