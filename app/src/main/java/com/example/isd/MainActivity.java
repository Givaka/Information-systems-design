package com.example.isd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView browser = new WebView(this);
        setContentView(browser);
        browser.loadUrl("https://youtu.be/dQw4w9WgXcQ?si=vFDaOnDASjCNKqC0");
    }
}