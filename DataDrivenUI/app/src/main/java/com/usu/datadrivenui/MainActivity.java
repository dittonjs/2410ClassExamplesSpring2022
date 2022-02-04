package com.usu.datadrivenui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        ArrayList<String> contacts = new ArrayList<>();
        double num = Math.random() * 500000 + 100;
        for (int i = 0; i < num; i ++) {
            AppCompatTextView nameTextView = new AppCompatTextView(this);
            nameTextView.setText("User: " + i);
            mainLayout.addView(nameTextView);
        }

        ScrollView scrollView = new ScrollView(this);
        scrollView.addView(mainLayout);
        setContentView(scrollView);

    }
}