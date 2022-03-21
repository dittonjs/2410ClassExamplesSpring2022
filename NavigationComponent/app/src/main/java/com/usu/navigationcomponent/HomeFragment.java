package com.usu.navigationcomponent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        NavController controller = NavHostFragment.findNavController(this);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view.findViewById(R.id.toProfile).setOnClickListener(button -> {
            controller.navigate(R.id.action_homeFragment_to_profileFragment);
        });

        view.findViewById(R.id.finalDestination).setOnClickListener(button -> {
            controller.navigate(R.id.action_homeFragment_to_finalDestinationFragment);
        });

        return view;
    }
}