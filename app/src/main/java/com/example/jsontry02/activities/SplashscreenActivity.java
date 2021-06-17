package com.example.jsontry02.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;


import androidx.appcompat.app.AppCompatActivity;

import com.example.jsontry02.MainActivity;
import com.example.jsontry02.R;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;

public class SplashscreenActivity extends AppCompatActivity implements ServerCallback {
	Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		//ApiHelper class is created to group all the firebase calls at one place
		ApiHelper helper = new ApiHelper(this);
		helper.fetchCources(this);
	}

	@Override
	public void onDataReceived(List<Course> data) {
		//this method is called from apihelper class as callback
		Intent activitityIntent = new Intent(this, MainActivity.class);
		Bundle bundle = new Bundle();
		bundle.putParcelableArrayList("courses", (ArrayList<? extends Parcelable>) data);
		activitityIntent.putExtras(bundle);
		startActivity(activitityIntent);
		finish();
	}

	@Override
	public void onSubjectDataReceived(List<Subject> data) {

	}

	@Override
	public void onModuleDataReceived(List<Module> data) {

	}
}