package com.usu.customcomponents;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;

public class CustomButton extends LinearLayout {
    public CustomButton(Context context, String text) {
        super(context);
        AppCompatButton button = new AppCompatButton(context);
        button.setText(text);
        button.setBackgroundColor(Color.MAGENTA);
        addView(button);
    }
}
