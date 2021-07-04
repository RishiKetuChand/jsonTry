package com.example.jsontry02.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.jsontry02.R;
import com.example.jsontry02.adapters.ModuleAdapter;
import com.example.jsontry02.adapters.ResourceAdapter;
import com.example.jsontry02.adapters.SubjectAdapter;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Resource;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;

public class ResourceActivity extends AppCompatActivity implements ServerCallback {
    LottieAnimationView animationView;
    RecyclerView recyclerView;
    ResourceAdapter adapter;
    Toolbar toolbar;
    String resourceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
        resourceID = getIntent().getStringExtra("resourceId");
        initializeView();
        fetchResources(resourceID);
    }

    private void fetchResources(String resourceID) {
        ApiHelper helper = new ApiHelper(this);
        helper.fetchResource(resourceID,this);
    }

    public void initializeView(){
        animationView = findViewById(R.id.loading);
        toolbar = findViewById(R.id.resource_toolbar);
        toolbar.setTitle(resourceID);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.resourceRecyclerview);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        adapter = new ResourceAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);
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