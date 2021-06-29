package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.jsontry02.R;
import com.github.barteksc.pdfviewer.PDFView;

public class FileViewActivity extends AppCompatActivity {
	PDFView pdfView;
	String toolbar_name,pdfUrl;
	Toolbar toolbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_view);
		pdfUrl=getIntent().getStringExtra("pdfUrl");

		Uri uri = Uri.parse(getIntent().getStringExtra("pdfUrl"));

		toolbar = findViewById(R.id.pdfView_toolbar);
		toolbar.setTitle(toolbar_name);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		pdfView = findViewById(R.id.pdfView);

		pdfView.fromUri(uri).load();
		//pdfView.fromAsset(pdfUrl).load();
	}
}