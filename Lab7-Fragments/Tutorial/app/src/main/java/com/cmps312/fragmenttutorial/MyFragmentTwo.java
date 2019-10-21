package com.cmps312.fragmenttutorial;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragmentTwo extends Fragment {

    FragmentTwoListner listner;

    public MyFragmentTwo() {
        // Required empty public constructor
    }

    public interface FragmentTwoListner {
        void SayHello(String message);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listner = (FragmentTwoListner) context;
    }

    public static MyFragmentTwo createAndAssignFragment(String message) {

        MyFragmentTwo fragmentTwo = new MyFragmentTwo();
        Bundle bundle = new Bundle();
        bundle.putString("message", "Hello how are you.");


        fragmentTwo.setArguments(bundle);

        return fragmentTwo;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String message = getArguments().getString("message");


        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        TextView tv = rootView.findViewById(R.id.fragment_two_tv);

        tv.setText(message);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.SayHello("This is from the child");
            }
        });

        return rootView;
    }

}
