package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.jsontry02.R;
import com.example.jsontry02.dto.Result;
import com.example.jsontry02.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class ResultWebViewActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    List<Result> resultData;
    String requiredType,resultUrl;
    WebView webView;
    Toolbar toolbar;
    List<Result> resultList = new ArrayList<>();
    int i=0;
    PreferenceManager preferenceManager = new PreferenceManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_web_view);
        resultData = getIntent().getExtras().getParcelableArrayList("resultData");
        resultList= resultData;
        requiredType = getIntent().getStringExtra("requiredSearch");
        lottieAnimationView=findViewById(R.id.loading);
        toolbar = findViewById(R.id.result_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webView= findViewById(R.id.webView);
        checkRequiredSearch();
        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewCallBack());
        webView.loadUrl(resultUrl);
    }

    private void checkRequiredSearch() {
       switch (requiredType){
            case "vtu4u":
                resultUrl = resultList.get(i).getVtu4u();
                break;
            case "custom":
                resultUrl = resultList.get(i).getCustomRes001()+preferenceManager.getUserUSN()+resultList.get(i).getCustomRes002();
                break;
            case "official":
                resultUrl = resultList.get(i).getOfficialWebResult();
                break;
        }

    }
    private class WebViewCallBack extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            lottieAnimationView.setVisibility(View.GONE);
            super.onPageStarted(view, url, favicon);
        }
    }
}