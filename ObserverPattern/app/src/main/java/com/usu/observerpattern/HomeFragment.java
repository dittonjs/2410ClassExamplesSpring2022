package com.usu.observerpattern;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        MainActivity mainActivity = (MainActivity)getActivity();
        view.findViewById(R.id.increment).setOnClickListener(button -> {
            mainActivity.increment();
        });

        view.findViewById(R.id.decrement).setOnClickListener(button -> {
            mainActivity.decrement();
        });

        return view;
    }
}
