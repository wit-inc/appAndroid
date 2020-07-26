package com.ch.wit.LogIn;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
 import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.ch.wit.MainActivity;
import com.ch.wit.R;
import com.ch.wit.SignUp.SignUpActivity;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity);




        LinearLayout v = findViewById(R.id.auth_layout);
        Drawable d = v.getBackground();
        if(d instanceof  AnimatedVectorDrawable) {
            AnimatedVectorDrawable avd = (AnimatedVectorDrawable)d;
            avd.start();
        }
        else if(d instanceof  AnimatedVectorDrawableCompat)  {
            AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat)d;
            avd.start();
        }

    }

    public void authUser(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
