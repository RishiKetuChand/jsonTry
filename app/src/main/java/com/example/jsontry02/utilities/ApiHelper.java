package com.example.jsontry02.utilities;

import android.content.Context;
import android.os.Handler;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jsontry02.activities.SplashscreenActivity;
import com.example.jsontry02.activities.SubjectActivity;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Subject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApiHelper {
	Context context;
	public ApiHelper(Context context){
		this.context = context;
	}
	private static String BASE_URL ="https://college-notes-188a4-default-rtdb.firebaseio.com/main";
	private static final String SUBJECT_BASE ="https://college-notes-188a4-default-rtdb.firebaseio.com/main/subjects/";
	private static final String COURSE_ENDPOINT ="/courses.json";
	public void fetchCources(SplashscreenActivity splashscreenActivity){
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,BASE_URL+COURSE_ENDPOINT,null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				processCourses(response,splashscreenActivity);
			}
		},null);
		VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjectRequest);

	}

	private void processCourses(JSONObject response,SplashscreenActivity splashscreenActivity) {
		List<Course> courses = new ArrayList<>();
		if(null != response){
			Iterator<String> keys = response.keys();

			while(keys.hasNext()) {
				String key = keys.next();
				try {
					if (response.get(key) instanceof JSONObject) {
						// do something with jsonObject here
						JSONObject temp = response.getJSONObject(key);
						Course course = new Course();
						course.setId(temp.getString("id"));
						course.setName(temp.getString("name"));
						course.setThumb(temp.getString("thumb"));
						courses.add(course);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		splashscreenActivity.onDataRecieved(courses);
	}


	public void fetchSubjects(String courseId, SubjectActivity subjectActivity) {
		String url = SUBJECT_BASE+courseId+".json";
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				processSubjects(response,subjectActivity);
			}
		},null);
		VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjectRequest);

	}

	private void processSubjects(JSONObject response, SubjectActivity subjectActivity) {
		List<Subject> subjects = new ArrayList<>();
		if(null != response){
			Iterator<String> keys = response.keys();

			while(keys.hasNext()) {
				String key = keys.next();
				try {
					if (response.get(key) instanceof JSONObject) {
						// do something with jsonObject here
						JSONObject temp = response.getJSONObject(key);
						Subject subject = new Subject();
						subject.setId(temp.getString("id"));
						subject.setName(temp.getString("name"));
						subject.setResourceUrl(temp.getString("resourceUrl"));
						subject.setSemesterName(temp.getString("semesterName"));
						subjects.add(subject);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		subjectActivity.onSubjectDataRecieved(subjects);
	}
}
