package com.example.client_mob403;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.client_mob403.user.userModel;


public class ProfileFragment extends Fragment {
    private TextView tvUsername, tvEmail, tvFullName;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvFullName = view.findViewById(R.id.tvFullname);
        tvEmail = view.findViewById(R.id.tvEmail);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        String nameUser = sharedPreferences.getString("username", "");
        String fullName = sharedPreferences.getString("fullname", "");
        String email = sharedPreferences.getString("email", "");


        tvUsername.setText(nameUser);
        tvFullName.setText(fullName);
        tvEmail.setText(email);


        return view;
    }
}