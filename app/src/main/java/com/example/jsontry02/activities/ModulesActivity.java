package com.example.jsontry02.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.jsontry02.R;
import com.example.jsontry02.adapters.ModuleAdapter;
import com.example.jsontry02.adapters.SubjectAdapter;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;

public class ModulesActivity extends AppCompatActivity implements ServerCallback {
    LottieAnimationView animationView;
    RecyclerView recyclerView;
    ModuleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
        initializeView();
        fetchModules(getIntent().getStringExtra("subjectId"));
    }
    public void initializeView() {
        animationView = findViewById(R.id.loading);
        recyclerView = findViewById(R.id.moduleRecyclerView);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        adapter = new ModuleAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);
    }

    private void fetchModules(String subjectId) {
        ApiHelper helper = new ApiHelper(this);
        helper.fetchModules(subjectId,this);
    }

    @Override
    public void onDataReceived(List<Course> data) {

    }

    @Override
    public void onSubjectDataReceived(List<Subject> data) {

    }

    @Override
    public void onModuleDataReceived(List<Module> data) {
        for(Module mod : data){
            System.out.println(mod.getName());
        }

        animationView.setVisibility(View.GONE);
        adapter.setData(data);
        adapter.notifyDataSetChanged();

    }
}