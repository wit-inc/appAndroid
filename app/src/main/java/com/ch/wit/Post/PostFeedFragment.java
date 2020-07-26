package com.ch.wit.Post;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ch.wit.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class PostFeedFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_post_feed, parent, false);
        Button postFeedBV =view.findViewById(R.id.postFeedBV);
        postFeedBV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setActivated(!v.isActivated());

            }
        });
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}
