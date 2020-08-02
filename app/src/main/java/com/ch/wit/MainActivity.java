package com.ch.wit;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.ch.wit.Extras.ExtrasFragment;
import com.ch.wit.Feeds.FeedsFragment;
import com.ch.wit.Post.PostFeedFragment;
import com.ch.wit.Profile.UserProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private int dir = R.id.feeds;
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction  ft = getSupportFragmentManager().beginTransaction();
            if(dir==item.getItemId()){
                if(dir == R.id.new_post)
                    Toast.makeText(MainActivity.this, "Posting", Toast.LENGTH_SHORT).show();
                return true;
            }
            dir = item.getItemId();
            switch (item.getItemId()) {
                case R.id.feeds:
                    ft.replace(R.id.main_fragment, new FeedsFragment());
                    ft.commit();
                    return true;
                case R.id.extras:
                    ft.replace(R.id.main_fragment, new ExtrasFragment());
                    ft.commit();
                    return true;
                case R.id.new_post:
                    ft.add(R.id.main_fragment, new PostFeedFragment());
                    ft.commit();
                    return true;
                case R.id.message:
                    ft.replace(R.id.main_fragment, new MessageFragment());
                    ft.commit();
                    return true;
                case R.id.profile:
                    ft.replace(R.id.main_fragment, new UserProfileFragment());
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
    @Override
    public void onBackPressed() {
//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_fragment);
//        if(fragment != null)
//            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        super.onBackPressed();
        }
    }

