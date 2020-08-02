package com.ch.wit.authentication;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ch.wit.MainActivity;
import com.ch.wit.Profile.ProfileFragment;
import com.ch.wit.R;
import com.ch.wit.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {
    UserDetails userDetails = new UserDetails() {
        @Override
        public void action() {
            Toast.makeText(getContext(), "Loged In", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        FragmentLoginBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_login, container, false);
        View view = binding.getRoot();
        binding.setUserDetails(userDetails);
        TextView signUpTV = view.findViewById(R.id.signUpTV);
        signUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.auth_fragment, new SignUpFragment()).commit();
            }
        });
        return view;
    }
}