package com.example.dictionaryapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.widget.Toolbar;


public class WebviewMain extends AppCompatActivity {
    WebView webView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_main);

        webView = findViewById(R.id.wb_Webview);
        toolbar = findViewById(R.id.tb_Toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("package");
        if(bundle != null) {
            String name = bundle.getString("chuoi");
            getSupportActionBar().setTitle(name);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("https://tracau.vn/?s=" + name);
            webView.setWebChromeClient(new WebChromeClient());

        }
    }
}
