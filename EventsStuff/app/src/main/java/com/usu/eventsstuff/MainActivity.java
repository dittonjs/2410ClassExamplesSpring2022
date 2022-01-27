package com.usu.eventsstuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setBackgroundColor(Color.GRAY);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);


        AppCompatTextView countTextView = new AppCompatTextView(this);
        countTextView.setText("0");
        countTextView.setTextSize(140);
        countTextView.setGravity(Gravity.CENTER);
        countTextView.setBackgroundColor(Color.BLUE);

        mainLayout.addView(countTextView);

        AppCompatButton decrementButton  = new AppCompatButton(this);
        decrementButton.setText("-");
        LinearLayout.LayoutParams decrementButtonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        decrementButtonParams.weight = 1;
        decrementButton.setLayoutParams(decrementButtonParams);

        AppCompatButton incrementButton = new AppCompatButton(this);
        incrementButton.setText("+");
        incrementButton.setBackgroundColor(Color.CYAN);
        LinearLayout.LayoutParams incrementButtonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        incrementButtonParams.weight = 1;
        incrementButton.setLayoutParams(incrementButtonParams);



        LinearLayout buttonsLayout = new LinearLayout(this);
        buttonsLayout.setBackgroundColor(Color.MAGENTA);
        buttonsLayout.setGravity(Gravity.CENTER);
        buttonsLayout.addView(decrementButton);
        buttonsLayout.addView(incrementButton);
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonsLayout.setLayoutParams(buttonLayoutParams);
        buttonLayoutParams.weight = 1;
        mainLayout.addView(buttonsLayout);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                countTextView.setText("" + count);
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                countTextView.setText("" + count);
            }
        });


        setContentView(mainLayout);
    }
}