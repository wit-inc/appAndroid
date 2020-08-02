package com.ch.wit.Feeds;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ch.wit.Adapters.CommentItemAdapter;
import com.ch.wit.R;
import java.util.ArrayList;

public class DetailedFeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setAllowEnterTransitionOverlap(false);
//        getWindow().setAllowReturnTransitionOverlap(false);
//        getWindow().setEnterTransition(null);
        setContentView(R.layout.detailed_feed_activity);
        ImageButton likeButton = findViewById(R.id.likeIB);
        View.OnClickListener likeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setActivated(!v.isActivated());
            }
        };
        likeButton.setOnClickListener(likeListener);

        final Button postFeedBV =findViewById(R.id.postFeedBV);
        final EditText addCommentEV = findViewById(R.id.addCommentEV);
        postFeedBV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.isActivated()){
                    Toast.makeText(DetailedFeedActivity.this, "Posting...", Toast.LENGTH_SHORT).show();
                    addCommentEV.setText("");
                }
            }
        });
        addCommentEV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                postFeedBV.setActivated(!s.toString().equals(""));
            }
        });

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

    @Override
    public void onBackPressed() {
//        getWindow().setExitTransition(null);
        super.onBackPressed();
    }
}
