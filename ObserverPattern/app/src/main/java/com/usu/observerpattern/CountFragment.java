package com.usu.observerpattern;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CountFragment extends Fragment implements Observable.Observer {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count, container, false);
        MainActivity activity = (MainActivity) getActivity();
        activity.getCount().subscribe(this);
        return view;
    }

    @Override
    public void notify(Observable observable) {
        Count count = (Count) observable;
        TextView textView = getView().findViewById(R.id.count);
        textView.setText("" + count.getCount());
    }
}
