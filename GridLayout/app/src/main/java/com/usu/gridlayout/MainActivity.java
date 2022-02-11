package com.usu.gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridLayout phoneLayout = new GridLayout(this);

        ArrayList<PhoneButtonData> buttonData = new ArrayList<>();
        buttonData.add(new PhoneButtonData(R.string.one, 1, 0, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.two, 1, 1, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.three, 1, 2, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.four, 2, 0, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.five, 2, 1, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.six, 2, 2, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.seven, 3, 0, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.eight, 3, 1, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.nine, 3, 2, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.zero, 4,  0, 3, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData(R.string.clear, 5, 0, 1, PhoneButtonData.ButtonType.Clear));
        buttonData.add(new PhoneButtonData(R.string.call, 5, 1, 2 , PhoneButtonData.ButtonType.Call));

        AppCompatTextView numberDisplay = new AppCompatTextView(this);
        GridLayout.LayoutParams numberParams = new GridLayout.LayoutParams();
        numberParams.rowSpec = GridLayout.spec(0, 1.0f);
        numberParams.columnSpec = GridLayout.spec(0, 3, 1.0f);
        numberDisplay.setTextSize(32);
        numberDisplay.setGravity(Gravity.CENTER);
        numberDisplay.setLayoutParams(numberParams);
        phoneLayout.addView(numberDisplay);

        buttonData.forEach(data -> {
            AppCompatButton button = new AppCompatButton(this);
            button.setTextSize(24);
            button.setText(data.textId);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(data.row, 1.0f);
            params.columnSpec = GridLayout.spec(data.col, data.colSpan, 1.0f);
            button.setLayoutParams(params);
            button.setOnClickListener(view -> {
                button.setBackgroundColor(getResources().getColor(R.color.purple_700, null));
                if (data.type == PhoneButtonData.ButtonType.Number) {
                    numberDisplay.setText(numberDisplay.getText() + getResources().getString(data.textId));
                } else if (data.type == PhoneButtonData.ButtonType.Call) {
                    Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                    phoneIntent.setData(Uri.parse("tel:"+numberDisplay.getText()));
                    startActivity(phoneIntent);
                } else {
                    numberDisplay.setText("");
                }
            });

            phoneLayout.addView(button);
        });
        // put bread
        // put cheese
        // put mayo
        // put ham
        // put bread


        // make ham sandwich

        setContentView(phoneLayout);
    }
}