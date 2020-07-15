package com.ch.wit.Profile;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ch.wit.Feeds.DetailedFeedActivity;
import com.ch.wit.Feeds.PostItemAdapter;
import com.ch.wit.R;

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        if (parent != null) {
            parent.removeAllViews();
        }
        View view =  inflater.inflate(R.layout.fragment_profile, parent, false);

        Button addFriendBV = view.findViewById(R.id.addFriendBV);
        addFriendBV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                Toast.makeText(getContext(), button.getText().toString(), Toast.LENGTH_SHORT).show();
                if(button.getText().toString().equals("Add friend")){
                    button.setText("Requested");
                }
                if(button.getText().toString().equals("Requested")){
                    button.setText("Friend");
                    button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_tick, 0, 0, 0);
                }

            }


        });

        ArrayList<Integer> postData = new ArrayList<>();
        postData.add(1);
        postData.add(2);
        postData.add(1);
        postData.add(2);

        RecyclerView recyclerView = view.findViewById(R.id.profilePostRV);
        PostItemAdapter adapter = new PostItemAdapter(postData ,R.layout.feed_fragment_profile);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new PostItemAdapter.ClickListener() {
            @Override
            public void onItemClick(int pos, PostItemAdapter.ViewHolder holder) {
                Intent intent = new Intent(getActivity(), DetailedFeedActivity.class);
                intent.putExtra("Shared", ViewCompat.getTransitionName(holder.postView));
                Pair<View, String> p4 = Pair.create((View)holder.postCardView, ViewCompat.getTransitionName(holder.postCardView));
                Pair<View, String> p2 = Pair.create((View)holder.postActionLayout, ViewCompat.getTransitionName(holder.postActionLayout));
                Pair<View, String> p3 = Pair.create((View)holder.postEndLine, ViewCompat.getTransitionName(holder.postEndLine));
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(Objects.requireNonNull(getActivity()),p2,p3,p4);
                startActivity(intent, options.toBundle());
            }
//
        });
        return view;



    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

    }
}
