package com.usu.framelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Popup popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout mainLayout = new FrameLayout(this);
        AppCompatButton openButton = new AppCompatButton(this);
        openButton.setText("Open");
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setBackgroundColor(Color.MAGENTA);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400);
        content.setLayoutParams(params);
        params.gravity = Gravity.CENTER;

        content.addView(openButton);
        mainLayout.addView(content);
        popup = new Popup(this);

        openButton.setOnClickListener(view -> {
            ArrayList<String> messages = new ArrayList<>();
            messages.add("Hi!");
            messages.add("School is great!");
            messages.add("I have a brown dog");
            popup.display(messages);
        });
        mainLayout.addView(popup);
        setContentView(mainLayout);
    }

    @Override
    public void onBackPressed() {
        if (popup.isOpen()) {
            popup.close();
        } else {
            super.onBackPressed();
        }
    }
}