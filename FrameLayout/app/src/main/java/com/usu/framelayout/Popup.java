package com.usu.framelayout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.ArrayList;

public class Popup extends LinearLayout {
    private boolean isOpen = false;
    private LinearLayout content;
    public Popup(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setBackgroundColor(Color.argb(.5f, 0, 0, 0));
        setVisibility(INVISIBLE);
        setPadding(48, 48, 48, 48);
        setGravity(Gravity.CENTER);

        setOnClickListener((view) -> close());

        LinearLayout wrapper = new LinearLayout(context);
        wrapper.setOrientation(VERTICAL);
        wrapper.setBackgroundColor(Color.WHITE);
        wrapper.setOnClickListener(view -> {});

        content = new LinearLayout(context);
        content.setOrientation(VERTICAL);

        wrapper.addView(content);
        AppCompatButton closeButton = new AppCompatButton(context);
        closeButton.setText("Close");
        closeButton.setOnClickListener(view -> this.close());

        wrapper.addView(closeButton);

        addView(wrapper);
    }

    public void display(ArrayList<String> messages) {
        setVisibility(VISIBLE);
        isOpen = true;
        content.removeAllViews();
        messages.forEach((message) -> {

            AppCompatTextView textView = new AppCompatTextView(getContext());
            textView.setText(message);
            content.addView(textView);
        });
    }

    public void close() {
        setVisibility(INVISIBLE);
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
