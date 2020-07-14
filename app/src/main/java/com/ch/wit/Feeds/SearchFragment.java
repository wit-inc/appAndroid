package com.ch.wit.Feeds;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ch.wit.R;
import com.google.android.material.navigation.NavigationView;

public class SearchFragment  extends Fragment {

    final NavigationView navigationView;
    public SearchFragment() {
        // Required empty public constructor
        navigationView =null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);


        return view;

    }

}