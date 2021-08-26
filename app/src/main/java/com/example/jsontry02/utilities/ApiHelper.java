package com.example.jsontry02.utilities;

import android.content.Context;
import android.provider.MediaStore;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jsontry02.activities.ModulesActivity;
import com.example.jsontry02.activities.ResourceActivity;
import com.example.jsontry02.activities.ResultActivity;
import com.example.jsontry02.activities.SplashscreenActivity;
import com.example.jsontry02.activities.SubjectActivity;
import com.example.jsontry02.activities.VideoActivity;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Resource;
import com.example.jsontry02.dto.Result;
import com.example.jsontry02.dto.SliderImages;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.dto.Videos;

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
	private static final String MODULE_BASE ="https://college-notes-188a4-default-rtdb.firebaseio.com/main/modules/";
	private static final String RESOURCE_BASE ="https://college-notes-188a4-default-rtdb.firebaseio.com/main/resources%20/";
	private static final String COURSE_ENDPOINT ="/courses.json";
	private static final String RESULT_BASE ="https://college-notes-188a4-default-rtdb.firebaseio.com/Result";
	private static final String YOUTUBE_VIDEO ="https://college-notes-188a4-default-rtdb.firebaseio.com/YouTube_Video.json";
	private static final String IMAGE_SLIDER ="https://college-notes-188a4-default-rtdb.firebaseio.com/homeScreenImageSlider.json";
	public void fetchCources(SplashscreenActivity splashscreenActivity){
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,BASE_URL+COURSE_ENDPOINT,null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				//processCourses(response,splashscreenActivity);
				JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET,IMAGE_SLIDER,null, new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response2) {
						processCourses(response,response2,splashscreenActivity);
					}
				},null);
				VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjectRequest2);

			}
		},null);
		VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjectRequest);

	}

	private void processCourses(JSONObject response,JSONObject response2,SplashscreenActivity splashscreenActivity) {
		List<Course> courses = new ArrayList<>();
		List<SliderImages> sliderImages = new ArrayList<>();
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
		if(null != response2){
			Iterator<String> keys = response2.keys();

			while(keys.hasNext()) {
				String key = keys.next();
				try {
					if (response2.get(key) instanceof JSONObject) {
						// do something with jsonObject here
						JSONObject temp = response2.getJSONObject(key);
						SliderImages sliderImage = new SliderImages();
						sliderImage.setId(temp.getString("id"));
						sliderImage.setImageUrl(temp.getString("imgUrl"));
						sliderImage.setInfoUrl(temp.getString("infoUrl"));
						sliderImages.add(sliderImage);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		splashscreenActivity.onDataReceived(courses,sliderImages);
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
						subject.setSemester(temp.getString("semester"));
						subject.setCode(temp.getString("code"));
						subject.setCredits(temp.getString("credits"));
						subjects.add(subject);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		subjectActivity.onSubjectDataReceived(subjects);
	}
	public void fetchModules(String subjectId,ModulesActivity modulesActivity){
		String url = MODULE_BASE+subjectId+".json";
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				processModules(response,modulesActivity);
			}
		},null);
		VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjectRequest);

	}
	private void processModules(JSONObject response, ModulesActivity modulesActivity) {
		List<Module> modules = new ArrayList<>();
		if(null != response){
			Iterator<String> keys = response.keys();

			while(keys.hasNext()) {
				String key = keys.next();
				try {
					if (response.get(key) instanceof JSONObject) {
						// do something with jsonObject here
						JSONObject temp = response.getJSONObject(key);
						Module module= new Module();
						module.setId(temp.getString("id"));
						module.setName(temp.getString("name"));
						module.setResourceID(temp.getString("resourceID"));
						module.setSyllabus(temp.getString("syllabus"));
						module.setModuleNum(temp.getString("moduleNum"));
						modules.add(module);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		modulesActivity.onModuleDataReceived(modules);
	}

	public void fetchResource(String resourceID, ResourceActivity resourceActivity){
		String url = RESOURCE_BASE+resourceID+".json";
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				processResource(response,resourceActivity);
			}
		},null);
		VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjectRequest);

	}
	private void processResource(JSONObject response, ResourceActivity resourceActivity) {
		List<Resource> resources = new ArrayList<>();
		if(null != response){
			Iterator<String> keys = response.keys();

			while(keys.hasNext()) {
				String key = keys.next();
				try {
					if (response.get(key) instanceof JSONObject) {
						// do something with jsonObject here
						JSONObject temp = response.getJSONObject(key);
						Resource resource= new Resource();
						resource.setFile(temp.getString("file"));
						resource.setFileName(temp.getString("fileName"));
						resource.setFileModuleTitle(temp.getString("fileModuleTitle"));
						resource.setFileType(temp.getString("fileType"));
						resources.add(resource);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		resourceActivity.onResourceDataReceived(resources);
	}
	public void fetchResult(ResultActivity resultActivity) {
		String url = RESULT_BASE+".json";
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				processResult(response,resultActivity);
			}
		},null);
		VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjectRequest);

	}

	private void processResult(JSONObject response, ResultActivity resultActivity) {
		List<Result> results = new ArrayList<>();
		if(null != response){
			Iterator<String> keys = response.keys();

			while(keys.hasNext()) {
				String key = keys.next();
				try {
					if (response.get(key) instanceof JSONObject) {
						// do something with jsonObject here
						JSONObject temp = response.getJSONObject(key);
						Result  result = new Result();
						result.setVtu4u(temp.getString("vtu4u"));
						result.setOfficialWebResult(temp.getString("officialWebResult"));
						result.setCustomRes001(temp.getString("customRes001"));
						result.setCustomRes002(temp.getString("customRes002"));
						results.add(result);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		resultActivity.onResultReceived(results);
	}

	public void fetchVideos(VideoActivity videoActivity){
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,YOUTUBE_VIDEO,null, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				processVideos(response,videoActivity);
			}
		},null);
		VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjectRequest);

	}

	private void processVideos(JSONObject response,VideoActivity videoActivity) {
		List<Videos> videos = new ArrayList<>();
		if(null != response){
			Iterator<String> keys = response.keys();

			while(keys.hasNext()) {
				String key = keys.next();
				try {
					if (response.get(key) instanceof JSONObject) {
						// do something with jsonObject here
						JSONObject temp = response.getJSONObject(key);
						Videos video = new Videos();
						video.setVideoId(temp.getString("id"));
						video.setVideoTitle(temp.getString("title"));
						video.setVideoBranch(temp.getString("branch"));
						video.setVideoSem(temp.getString("sem"));
						video.setVideoSubject(temp.getString("sub"));
						video.setVideoCoveredTopic(temp.getString("relatedTopic"));
						video.setVideoResId(temp.getString("resId"));
						videos.add(video);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		videoActivity.onVideoReceived(videos);
	}
}
