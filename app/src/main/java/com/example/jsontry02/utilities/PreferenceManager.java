package com.example.jsontry02.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.jsontry02.activities.SplashscreenActivity;

import static android.content.Context.MODE_PRIVATE;

public class PreferenceManager {
	private static final String COURSE_ID = "courseId";
	private static final String SUBJECT_ID = "subjectId";

	Context context;
	public PreferenceManager(Context context){
		this.context = context;
	}
	private void saveString(String key,String value){

		// Storing data into SharedPreferences
		SharedPreferences sharedPreferences =context.getSharedPreferences("MySharedPref",MODE_PRIVATE);

		// Creating an Editor object to edit(write to the file)
		SharedPreferences.Editor myEdit = sharedPreferences.edit();

		// Storing the key and its value as the data fetched from editText
		myEdit.putString(key, value);

	// Once the changes have been made,
	// we need to commit to apply those changes made,
	// otherwise, it will throw an error
		myEdit.commit();
	}

	public void saveCourseId(String courseId){
		saveString(COURSE_ID,courseId);
	}

	public String getCourseId(){
		SharedPreferences sharedPreferences =context.getSharedPreferences("MySharedPref",MODE_PRIVATE);
		return sharedPreferences.getString(COURSE_ID,"");
	}

	public void saveSubjectId(String subjectId){
		saveString(SUBJECT_ID,subjectId);
	}

	public String getSubjectId(){
		SharedPreferences sharedPreferences =context.getSharedPreferences("MySharedPref",MODE_PRIVATE);
		return sharedPreferences.getString(SUBJECT_ID,"");
	}
}
