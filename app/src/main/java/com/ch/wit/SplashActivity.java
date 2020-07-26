package com.ch.wit;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.View;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.ch.wit.LogIn.AuthActivity;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Pair<View, String> p1 = Pair.create(findViewById(R.id.logoBV), "logoSE");
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this ,p1);
                Intent intent = new Intent(SplashActivity.this, AuthActivity.class);
                startActivity(intent, options.toBundle());
                SplashActivity.this.finish();
            }
        }, 3000);

        }
    }
