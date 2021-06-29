package com.example.jsontry02.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.airbnb.lottie.LottieAnimationView;
import com.example.jsontry02.R;
import com.example.jsontry02.adapters.ModuleAdapter;
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
    Toolbar toolbar;
    String subjectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
        subjectId = getIntent().getStringExtra("subjectId");
        toolbar = findViewById(R.id.module_toolbar);
        toolbar.setTitle(subjectId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeView();
        fetchModules(subjectId);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.module_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        adapter.getFilter().filter(newText);
                        return false;
                    }
                });
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }
}