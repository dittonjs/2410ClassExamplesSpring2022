package com.usu.webviewandpermissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        AppCompatButton button = new AppCompatButton(this);
        button.setText("LOAD SITE");
        WebView webView = new WebView(this);
        View.OnClickListener listener = (view) -> {};
        button.setOnClickListener(view -> {
            webView.loadUrl("https://usu.edu");
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        mainLayout.addView(button);
        mainLayout.addView(webView);
        setContentView(mainLayout);
    }
}