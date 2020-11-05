package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class BrowserActivity extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_browser);

        wv=(WebView)findViewById(R.id.webview);
        String url="https://github.com";
        wv.getSettings().getJavaScriptEnabled();
        wv.loadUrl(url);
    }
}