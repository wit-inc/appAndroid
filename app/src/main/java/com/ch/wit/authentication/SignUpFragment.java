package com.ch.wit.authentication;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ch.wit.R;
import com.ch.wit.databinding.FragmentSignUpBinding;

public class SignUpFragment extends Fragment {
    UserDetails userDetails = new UserDetails() {
        @Override
        public void action() {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.auth_fragment, new UserDetailsFragment()).commit();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        FragmentSignUpBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_sign_up
                , container, false);
        View view = binding.getRoot();
        binding.setUserDetails(userDetails);

        TextView logInTV = view.findViewById(R.id.logInTV);
        logInTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.auth_fragment, new LoginFragment()).commit();
                Toast.makeText(getContext(), "resr", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
}