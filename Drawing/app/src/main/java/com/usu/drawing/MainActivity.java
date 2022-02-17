package com.usu.drawing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout controlsLayout = new LinearLayout(this);
        DrawingView drawingView = new DrawingView(this);

        AppCompatButton squareButton = new AppCompatButton(this);
        squareButton.setText("Square∂");
        squareButton.setOnClickListener((view) -> {
            drawingView.setMode(DrawingView.Mode.Square);
        });

        AppCompatButton circleButton = new AppCompatButton(this);
        circleButton.setText("Circle");
        circleButton.setOnClickListener(view -> {
            drawingView.setMode(DrawingView.Mode.Circle);
        });
        controlsLayout.addView(squareButton);
        controlsLayout.addView(circleButton);
        mainLayout.addView(controlsLayout);
        mainLayout.addView(drawingView);

        setContentView(mainLayout);
    }
}