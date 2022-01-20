package com.example.mediaprovieder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity{

    Button search,back;
    EditText search_home;
    WebView webView;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    search_home=findViewById(R.id.search_text);
    search=findViewById(R.id.search_home);
    back=findViewById(R.id.button);
    webView=findViewById(R.id.web);
   url=getIntent().getExtras().get("urlAddress").toString();
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());


    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else
        {
            super.onBackPressed();
        }
    }
}