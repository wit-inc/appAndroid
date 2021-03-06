package com.ch.wit.Profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ch.wit.Adapters.PostItemAdapter;
import com.ch.wit.Feeds.DetailedFeedActivity;
import com.ch.wit.MessageFragment;
import com.ch.wit.R;

import java.util.ArrayList;
import java.util.Objects;

public class UserProfileFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        if (parent != null) {
            parent.removeAllViews();
        }
        View view =  inflater.inflate(R.layout.fragment_user_profile, parent, false);

//        Button addFriendBV = view.findViewById(R.id.addFriendBV);
//        addFriendBV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Button button  = (Button) v;
//                Toast.makeText(getContext(), button.getText().toString(), Toast.LENGTH_SHORT).show();
//                if(button.getText().toString().equals("Add friend")){
//                    button.setText("Requested");
//                }
//                if(button.getText().toString().equals("Requested")){
//                    button.setText("Friend");
//                    button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_tick, 0, 0, 0);
//                }
//
//            }
//
//
//        });
//
//        ImageButton messageIB = view.findViewById(R.id.messageIB);
//        messageIB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.add(R.id.main_fragment, new MessageFragment());
//                ft.commit();
//
//            }
//
//
//        });
//        ImageButton backBV = view.findViewById(R.id.backBV);
//        backBV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                Fragment fragment = getFragmentManager().findFragmentById(R.id.main_fragment);
//                ft.remove(fragment);
//                ft.addToBackStack(null);
//                ft.commit();
//
//            }
//        });

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

            @Override
            public void onProfileClick(String profileId) {

            }

            @Override
            public void onMoreClick(int adapterPosition, PostItemAdapter.ViewHolder holder) {
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext() , android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("Report");
                arrayAdapter.add("Bookmark");
                arrayAdapter.add("Add To Todo");
                new AlertDialog.Builder(getContext()).setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = arrayAdapter.getItem(which);
                        AlertDialog.Builder builderInner = new AlertDialog.Builder(getContext());
                        builderInner.setMessage(strName);
                        builderInner.setTitle("Your Selected Item is");
                        builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which) {
                                dialog.dismiss();
                            }
                        });
                        builderInner.show();
                    }
                }).show();
            }
//
        });
        return view;



    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

    }
}