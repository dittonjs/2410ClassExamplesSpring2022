package com.usu.customcomponents;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.resources.TextAppearance;

public class LabeledInput extends LinearLayout {
    AppCompatEditText editText;
    public LabeledInput(Context context, String labelText) {
        super(context);
        AppCompatTextView label = new AppCompatTextView(context);
        label.setText(labelText);
        label.setTextSize(40);
        editText = new AppCompatEditText(context);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        LinearLayout.LayoutParams nameLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        nameLayoutParams.weight = 1;
        editText.setLayoutParams(nameLayoutParams);
        addView(label);
        addView(editText);
    }

    public String getText() {
        return editText.getText().toString();
    }



}
