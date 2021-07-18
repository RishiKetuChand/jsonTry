package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.jsontry02.R;
import com.example.jsontry02.adapters.SubjectAdapter;
import com.example.jsontry02.adapters.VideoAdapter;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Resource;
import com.example.jsontry02.dto.Result;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.dto.Videos;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity implements ServerCallback {
    LottieAnimationView videoLoading;
    Toolbar toolbar;
    RecyclerView recyclerView;
    VideoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initializeView();
        fetchVideos();

    }
    public void initializeView(){
        videoLoading = findViewById(R.id.video_loading);
        toolbar = findViewById(R.id.video_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.videoRecyclerview);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        adapter = new VideoAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);
    }
    private void fetchVideos() {
        ApiHelper helper = new ApiHelper(this);
        helper.fetchVideos(this);
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

    }

    @Override
    public void onVideoReceived(List<Videos> data) {
        videoLoading.setVisibility(View.GONE);
        adapter.setData(data);
        adapter.notifyDataSetChanged();

    }

}