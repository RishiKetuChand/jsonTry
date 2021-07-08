package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements ServerCallback {
    LottieAnimationView animationView;
    Button vtu4uResult, customUSNResult, officialSiteResult;
    TextView customUSNResultText;
    Toolbar toolbar;
    Bundle bundle = new Bundle();

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


        ApiHelper apiHelper = new ApiHelper(this);
        apiHelper.fetchResult(this);

        // set text of customUSNResultText using login deatils
    }

    @Override
    public void onDataReceived(List<Course> data) {

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
        vtu4uResult.setClickable(true);
        customUSNResult.setClickable(true);
        officialSiteResult.setClickable(true);
        animationView.setVisibility(View.GONE);
        bundle.putParcelableArrayList("resultData", (ArrayList<? extends Parcelable>) data);

    }
}