package com.ch.wit;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.Toast;

import com.ch.wit.Extras.ExtrasFragment;
import com.ch.wit.Feeds.FeedsFragment;
import com.ch.wit.PostFeed.PostFeedFragment;
import com.ch.wit.Profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private int dir = R.id.feeds;
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if(dir==item.getItemId()){
                if(dir == R.id.new_post)
                    Toast.makeText(MainActivity.this, "Posting", Toast.LENGTH_SHORT).show();
                return true;
            }
            dir = item.getItemId();
            switch (item.getItemId()) {
                case R.id.feeds:
                    ft.replace(R.id.main_fragment, new FeedsFragment());
                    Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                    ft.commit();
                    return true;
                case R.id.extras:
                    ft.replace(R.id.main_fragment, new ExtrasFragment());
                    Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                    ft.commit();
                    return true;
                case R.id.new_post:
                    ft.add(R.id.main_fragment, new PostFeedFragment());
                    Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                    ft.commit();
                    return true;
                case R.id.message:
                    return true;
                case R.id.profile:
                    ft.replace(R.id.main_fragment, new ProfileFragment());
                    Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
                    ft.commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
