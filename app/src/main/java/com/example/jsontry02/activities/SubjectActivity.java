package com.example.jsontry02.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import com.airbnb.lottie.LottieAnimationView;
import com.example.jsontry02.R;
import com.example.jsontry02.adapters.SubjectAdapter;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.PreferenceManager;
import com.example.jsontry02.utilities.ServerCallback;
import com.skydoves.powerspinner.PowerSpinnerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SubjectActivity extends AppCompatActivity implements ServerCallback{

	LottieAnimationView animationView;
	RecyclerView recyclerView;
	SubjectAdapter adapter;
	Toolbar toolbar;
	String courseId,spinnerItem ="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject);
		courseId = getIntent().getStringExtra("courseId");
		if(null == courseId){
			courseId = fetchValueFromPreference();
		}
		else{
			saveCourseIdToPreference(courseId);
		}
		String temp  =  fetchValueFromPreference();
		initializeView();
		fetchSubjects(courseId);
	}

	private String fetchValueFromPreference() {
		PreferenceManager pm = new PreferenceManager(getApplicationContext());
		return pm.getCourseId();

	}
	private void saveCourseIdToPreference(String courseId){
		PreferenceManager pm = new PreferenceManager(getApplicationContext());
		pm.saveCourseId(courseId);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onRestart() {
		super.onRestart();

	}


	@Override
	protected void onResume() {
		super.onResume();
	}

	public void initializeView(){
		toolbar = findViewById(R.id.subject_toolbar);
		toolbar.setTitle(courseId);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		recyclerView = findViewById(R.id.subjectRecyclerview);
		RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(lm);
		adapter = new SubjectAdapter(this, new ArrayList<>());
		recyclerView.setAdapter(adapter);
	}


//	@Override
//	protected void onRestoreInstanceState(Bundle savedInstanceState) {
//		super.onRestoreInstanceState(savedInstanceState);
//		courseId = savedInstanceState.getString("courseId");
//	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putString("courseId",courseId);
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

		MenuItem item = menu.findItem(R.id.filter);
		Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.semFilter, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				spinnerItem=parent.getItemAtPosition(position).toString();
				StartFiltering();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
		return true;
	}

	private void StartFiltering() {
		if(spinnerItem.equals("All Sem")){
			adapter.getFilter().filter("");
		} else if (spinnerItem.equals("3rd Sem")){
			adapter.getFilter().filter("03");
		} else if (spinnerItem.equals("4th Sem")){
			adapter.getFilter().filter("04");
		} else if (spinnerItem.equals("5th Sem")){
			adapter.getFilter().filter("05");
		} else if (spinnerItem.equals("6th Sem")){
			adapter.getFilter().filter("06");
		} else if (spinnerItem.equals("7th Sem")){
			adapter.getFilter().filter("07");
		} else{
			adapter.getFilter().filter("08");
		}
	}

	@SuppressLint("NonConstantResourceId")
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
			case R.id.filter:

				return true;
			default:return super.onOptionsItemSelected(item);
		}
	}
}
//adapter.getFilter().filter("08");