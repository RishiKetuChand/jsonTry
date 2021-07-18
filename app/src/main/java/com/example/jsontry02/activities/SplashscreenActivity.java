package com.example.jsontry02.activities;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;


import androidx.appcompat.app.AppCompatActivity;

import com.example.jsontry02.R;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Resource;
import com.example.jsontry02.dto.Result;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.dto.Videos;
import com.example.jsontry02.utilities.ApiHelper;
import com.example.jsontry02.utilities.ConnectivityCheck;
import com.example.jsontry02.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;

public class SplashscreenActivity extends AppCompatActivity implements ServerCallback {
	BroadcastReceiver broadcastReceiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splashscreen);
		broadcastReceiver = new ConnectivityCheck();
		registerRequest();


		//ApiHelper class is created to group all the firebase calls at one place
		ApiHelper helper = new ApiHelper(this);
		helper.fetchCources(this);
	}

	@Override
	public void onDataReceived(List<Course> data) {
		//this method is called from apiHelper class as callback
		Intent activitityIntent = new Intent(this, HomeActivity.class);
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

	@Override
	public void onResourceDataReceived(List<Resource> data) {

	}

	@Override
	public void onResultReceived(List<Result> data) {

	}

	@Override
	public void onVideoReceived(List<Videos> data) {

	}

	public void registerRequest(){
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
			registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
		}
	}
	protected void unregisterRequest(){
		try {
			unregisterReceiver(broadcastReceiver);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterRequest();
	}
}