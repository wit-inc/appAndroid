package com.ch.wit;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, AuthActivity.class);
                startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, 3000);

        }
    }
