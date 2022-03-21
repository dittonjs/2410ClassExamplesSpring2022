package com.usu.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.HORIZONTAL);
        Switch mySwitch = new Switch(this, 200);
        Switch mySwitch2 = new Switch(this, 120);
        Switch mySwitch3 = new Switch(this, 400);
        Switch mySwitch4 = new Switch(this, 30);
        mainLayout.addView(mySwitch);
        mainLayout.addView(mySwitch2);
        mainLayout.addView(mySwitch3);
        mainLayout.addView(mySwitch4);

        setContentView(mainLayout);
    }
}