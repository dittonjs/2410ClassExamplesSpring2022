package com.usu.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatTextView textView = new AppCompatTextView(this);
        textView.setText("I am in CS 2420!");
        setContentView(textView);
    }
}