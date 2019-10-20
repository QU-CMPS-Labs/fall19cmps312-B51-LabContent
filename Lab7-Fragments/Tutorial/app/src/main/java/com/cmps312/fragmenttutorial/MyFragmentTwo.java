package com.cmps312.fragmenttutorial;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragmentTwo extends Fragment {


    public MyFragmentTwo() {
        // Required empty public constructor
    }

    public static MyFragmentTwo newInstance(String message) {

        Bundle args = new Bundle();
        args.putString("message", message);

        MyFragmentTwo fragment = new MyFragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String message = getArguments().getString("message");
        
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

}
