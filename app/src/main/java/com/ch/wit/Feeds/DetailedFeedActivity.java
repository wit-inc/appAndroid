package com.ch.wit.Feeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.ch.wit.Adapters.CommentItemAdapter;
import com.ch.wit.Adapters.PostItemAdapter;
import com.ch.wit.R;

import java.util.ArrayList;

public class DetailedFeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_feed_activity);
        Button postFeedBV =findViewById(R.id.postFeedBV);
        ImageButton likeButton = findViewById(R.id.likeIB);
        View.OnClickListener likeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setActivated(!v.isActivated());
            }
        };
        likeButton.setOnClickListener(likeListener);
        postFeedBV.setOnClickListener(likeListener);

        ArrayList<Integer> postData = new ArrayList<>();
        postData.add(1);
        postData.add(2);
        postData.add(1);
        postData.add(2);
        RecyclerView recyclerView = findViewById(R.id.commentSectionRV);
        CommentItemAdapter adapter = new CommentItemAdapter  (postData, R.layout.comment_fragment);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
