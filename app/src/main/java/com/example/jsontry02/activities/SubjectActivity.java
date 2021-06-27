package com.example.jsontry02.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.airbnb.lottie.LottieAnimationView;
import com.example.jsontry02.R;
import com.example.jsontry02.adapters.SubjectAdapter;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;

public class SubjectActivity extends AppCompatActivity implements ServerCallback {

	LottieAnimationView animationView;
	RecyclerView recyclerView;
	SubjectAdapter adapter;
	Toolbar toolbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject);
		toolbar = findViewById(R.id.subject_toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		initializeView();
		fetchSubjects(getIntent().getStringExtra("courseId"));
	}
	public void initializeView(){
		recyclerView = findViewById(R.id.subjectRecyclerview);
		RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(lm);
		adapter = new SubjectAdapter(this, new ArrayList<>());
		recyclerView.setAdapter(adapter);

	}

	private void fetchSubjects(String courseId) {
		ApiHelper helper = new ApiHelper(this);
		helper.fetchSubjects(courseId,this);
	}

	@Override
	public void onDataReceived(List<Course> data) {

	}

	@Override
	public void onSubjectDataReceived(List<Subject> data) {
		for(Subject sub : data){
			System.out.println(sub.getName());
		}
		adapter.setData(data);
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onModuleDataReceived(List<Module> data) {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.subject_menu,menu);
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
			case R.id.sem3:
				//code
				return true;
			case R.id.sem4:
				//code
				return true;
			case R.id.sem5:
				//code
				return true;
			case R.id.sem6:
				//code
				return true;
			case R.id.sem7:
				//code
				return true;
			case R.id.sem8:
				//code
				return true;
			default:return super.onOptionsItemSelected(item);
		}

	}

	private void searchingTheSubject(@NonNull MenuItem item) {

	}

}