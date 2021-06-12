package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.jsontry02.R;
import com.github.barteksc.pdfviewer.PDFView;

public class FileViewActivity extends AppCompatActivity {
	WebView webView;
	PDFView pdfView;
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_view);
//		pdfView = findViewById(R.id.pdfv);
//		Uri uri = Uri.parse(getIntent().getStringExtra("pdfUrl"));
//		pdfView.fromUri(uri).load();

		webView = findViewById(R.id.webView);
		WebViewClient client = new WebViewClient();
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setSupportZoom(true);
		webView.loadUrl(getIntent().getStringExtra("pdfUrl"));
		System.out.println(getIntent().getStringExtra("pdfUrl"));
		//webView.loadUrl("https://www.google.com");
	}
}