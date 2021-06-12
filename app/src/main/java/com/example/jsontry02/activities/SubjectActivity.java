package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView;
import com.example.jsontry02.R;
import com.example.jsontry02.adapters.SubjectAdapter;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;

public class SubjectActivity extends AppCompatActivity implements ServerCallback {

	TextView textView;
	LottieAnimationView animationView;
	RecyclerView recyclerView;
	SubjectAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject);
		initializeView();
		fetchSubjects(getIntent().getStringExtra("courseId"));

	}
	public void initializeView(){
		getSupportActionBar().hide();
		animationView = findViewById(R.id.loading);
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
	public void onDataRecieved(List<Course> data) {

	}

	@Override
	public void onSubjectDataRecieved(List<Subject> data) {
		for(Subject sub : data){
			System.out.println(sub.getName());
		}

		animationView.setVisibility(View.GONE);
		adapter.setData(data);
		adapter.notifyDataSetChanged();
	}
}