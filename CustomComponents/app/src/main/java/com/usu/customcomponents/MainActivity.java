package com.usu.customcomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        LabeledInput nameInput = new LabeledInput(this, "Name");
        nameInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hiya!");
            }
        });
        LabeledInput emailInput = new LabeledInput(this, "Email");
        LabeledInput passwordInput = new LabeledInput(this, "Password");
        LabeledInput socialInput = new LabeledInput(this, "SSN");
        LabeledInput lunchNumberInput = new LabeledInput(this, "Lunch Number");

        CustomButton signUpButton = new CustomButton(this, "Sign Up");
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(nameInput.getText());
            }
        });

        mainLayout.addView(nameInput);
        mainLayout.addView(emailInput);
        mainLayout.addView(passwordInput);
        mainLayout.addView(socialInput);
        mainLayout.addView(lunchNumberInput);
        mainLayout.addView(signUpButton);
        setContentView(mainLayout);
    }
}