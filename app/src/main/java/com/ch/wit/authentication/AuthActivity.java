package com.ch.wit.authentication;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
 import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.ch.wit.MainActivity;
import com.ch.wit.R;

public class AuthActivity extends AppCompatActivity {
    final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity);
        FrameLayout v = findViewById(R.id.splashLayout);
        Drawable d = v.getBackground();
        if(d instanceof  AnimatedVectorDrawable) {
            AnimatedVectorDrawable avd = (AnimatedVectorDrawable)d;
            avd.start();
        }
        else if(d instanceof  AnimatedVectorDrawableCompat)  {
            AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat)d;
            avd.start();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.auth_fragment,new LoginFragment()).commit();
    }

//    public void logIn(View view) {
//        Toast.makeText(this, "LogIn", Toast.LENGTH_SHORT).show();
//        ft.replace(R.id.auth_fragment, new LoginFragment()).commit();
//
//    }
//
//    public void signUp(View view) {
//        Toast.makeText(this, "SignUp", Toast.LENGTH_SHORT).show();
//        ft.replace(R.id.auth_fragment, new SignUpFragment()).commit();
//
//
//    }
}
