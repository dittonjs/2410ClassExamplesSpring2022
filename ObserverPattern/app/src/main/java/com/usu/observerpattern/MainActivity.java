package com.usu.observerpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Count count = new Count();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public Count getCount() {
        return count;
    }

    public void increment() {
        count.increment();
    }

    public void decrement() {
        count.decrement();
    }
}