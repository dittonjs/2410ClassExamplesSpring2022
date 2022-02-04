package com.usu.gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
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
        buttonData.add(new PhoneButtonData("1", 0, 0, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("2", 0, 1, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("3", 0, 2, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("4", 1, 0, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("5", 1, 1, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("6", 1, 2, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("7", 2, 0, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("8", 2, 1, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("9", 2, 2, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("0", 3,  0, 3, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("Clear", 4, 0, 1, PhoneButtonData.ButtonType.Number));
        buttonData.add(new PhoneButtonData("Call", 4, 1, 2 , PhoneButtonData.ButtonType.Number));

        for(int row = 0; row < 4; row ++) {
            for (int col = 0; col < 3; col ++) {
                AppCompatButton button = new AppCompatButton(this);
                button.setText("" + (row * 3 + col));
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(row, 1.0f);
                params.columnSpec = GridLayout.spec(col, 1.0f);
                button.setLayoutParams(params);
                phoneLayout.addView(button);
            }
        }

        setContentView(phoneLayout);
    }
}