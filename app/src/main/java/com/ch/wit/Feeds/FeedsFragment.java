package com.ch.wit.Feeds;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.ch.wit.Adapters.PostItemAdapter;
import com.ch.wit.MainActivity;
import com.ch.wit.Profile.ProfileFragment;
import com.ch.wit.R;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Objects;


public class FeedsFragment extends Fragment {
    private DrawerLayout drawer;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        if (parent != null) {
            parent.removeAllViews();
        }

        getActivity().getWindow().setAllowEnterTransitionOverlap(false);
        getActivity().getWindow().setAllowReturnTransitionOverlap(false);
        View view = inflater.inflate(R.layout.fragment_feeds, parent, false);
        ArrayList<Integer> postData = new ArrayList<>();
        postData.add(1);
        postData.add(2);
        postData.add(1);
        postData.add(2);
        final RecyclerView recyclerView = view.findViewById(R.id.PostRecyclerView);
        PostItemAdapter adapter = new PostItemAdapter(postData, R.layout.feed_fragment);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PostItemAdapter.ClickListener() {
            @Override
            public void onItemClick(int pos, final PostItemAdapter.ViewHolder holder) {
                recyclerView.smoothScrollToPosition(pos);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getActivity(), DetailedFeedActivity.class);
                        intent.putExtra("Shared", ViewCompat.getTransitionName(holder.postView));
                        Pair<View, String> p4 = Pair.create((View)holder.postCardView, ViewCompat.getTransitionName(holder.postCardView));
                        Pair<View, String> p2 = Pair.create((View)holder.postActionLayout, ViewCompat.getTransitionName(holder.postActionLayout));
                        Pair<View, String> p3 = Pair.create((View)holder.postEndLine, ViewCompat.getTransitionName(holder.postEndLine));
                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(Objects.requireNonNull(getActivity()),p2,p3,p4);
                        startActivity(intent, options.toBundle());
                    }
                }, 250);

            }

            @Override
            public void onProfileClick(String profileId) {
                Toast.makeText(getContext(), profileId, Toast.LENGTH_SHORT).show();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_fragment, new ProfileFragment()).addToBackStack(null).commit();
            }

            @Override
            public void onMoreClick(int adapterPosition, PostItemAdapter.ViewHolder holder) {
                final String[] options = {"Report ", "Bookmark ", "Add To Todo"};
                new AlertDialog.Builder(getContext(), R.style.CustomAlertDialog).setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), options[which].replaceFirst(" ","ed "), Toast.LENGTH_SHORT).show();
                    }
                }).create().show();

            }
//
        });
        NavigationView navigationView = view.findViewById(R.id.nav_view);
        drawer = view.findViewById(R.id.drawer_layout);
      ImageButton button = view.findViewById(R.id.searchIBV);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.END);
            }
        });


        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    }
    @Override
    public void onDetach() {
      if(drawer.isDrawerOpen(GravityCompat.END))
          drawer.closeDrawer(GravityCompat.END);
      else
        super.onDetach();
    }

}
