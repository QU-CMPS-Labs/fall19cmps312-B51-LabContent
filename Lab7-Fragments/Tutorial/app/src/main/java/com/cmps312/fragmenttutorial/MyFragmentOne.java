package com.cmps312.fragmenttutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragmentOne extends Fragment {

    //Rule 1. they should have empty constructor
    public MyFragmentOne() {
    }

    //Next thing is to generate the view


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        TextView tv = rootView.findViewById(R.id.fragment_one_tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "I got clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
