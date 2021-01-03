package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WebView extends AppCompatActivity {
android.webkit.WebView webView;
    public static final String EXTRA_URL="https://github.com/noorisan/Android-Studio-Codes-App";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        FloatingActionButton fab =findViewById(R.id.fab_btn);
        webView=findViewById(R.id.webView);
        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new Callback());
        String url=getIntent().getStringExtra(EXTRA_URL);
        String text=url;
        webView.loadUrl(text);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WebView.this,Tabslayout.class);
                i.putExtra(Tabslayout.EXTRA_DATA,"WebView");
                startActivity(i);
            }
        });
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(android.webkit.WebView view, KeyEvent event) {
            return false;
        }
    }
}