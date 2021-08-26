package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.jsontry02.R;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Resource;
import com.example.jsontry02.dto.Result;
import com.example.jsontry02.dto.SliderImages;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.dto.Videos;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.PreferenceManager;
import com.example.jsontry02.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements ServerCallback {
    LottieAnimationView animationView;
    Button vtu4uResult, customUSNResult, officialSiteResult;
    TextView customUSNResultText;
    Toolbar toolbar;
    Bundle bundle = new Bundle();
    CardView cardView, cardView2;
    PreferenceManager preferenceManager= new PreferenceManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initializeView();
        vtu4uResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, ResultWebViewActivity.class);
                bundle.putString("requiredSearch","vtu4u");
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        officialSiteResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, ResultWebViewActivity.class);
                bundle.putString("requiredSearch","official");
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        customUSNResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, ResultWebViewActivity.class);
                bundle.putString("requiredSearch","custom");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    public void initializeView() {
        animationView = findViewById(R.id.loading);
        toolbar = findViewById(R.id.result_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        vtu4uResult=findViewById(R.id.vtu4uWebsite);
        customUSNResult=findViewById(R.id.customResultView);
        officialSiteResult=findViewById(R.id.officialWebsiteResult);
        customUSNResultText=findViewById(R.id.usnText);
        cardView=findViewById(R.id.cardView);
        cardView2=findViewById(R.id.cardView2);
        customUSNResult.setText("View Result Of "+preferenceManager.getUserUSN().toUpperCase());
        customUSNResultText.setText("You can directly view result Of " +preferenceManager.getUserUSN().toUpperCase());
        ApiHelper apiHelper = new ApiHelper(this);
        apiHelper.fetchResult(this);

        // set text of customUSNResultText using login deatils
    }

    @Override
    public void onDataReceived(List<Course> data,List<SliderImages> imageData) {

    }

    @Override
    public void onSubjectDataReceived(List<Subject> data) {

    }

    @Override
    public void onModuleDataReceived(List<Module> data) {

    }

    @Override
    public void onResourceDataReceived(List<Resource> data) {

    }

    @Override
    public void onResultReceived(List<Result> data) {
        animationView.setVisibility(View.GONE);
        cardView.setVisibility(View.VISIBLE);
        cardView2.setVisibility(View.VISIBLE);
        bundle.putParcelableArrayList("resultData", (ArrayList<? extends Parcelable>) data);

    }

    @Override
    public void onVideoReceived(List<Videos> data) {

    }
}