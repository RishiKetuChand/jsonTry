package com.example.jsontry02;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.utilities.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String URL="https://college-notes-188a4-default-rtdb.firebaseio.com/main/courses.json";
    RecyclerView recyclerView;
    Adapter adapter;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        adapter = new Adapter(this,new ArrayList<>());

        RecyclerView.LayoutManager lm = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(lm);

        recyclerView.setAdapter(adapter);

        fetchCources();

    }

    private void fetchCources(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,URL,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                process(response);
            }
        },null);
        VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);

    }

    private void process(JSONObject response) {
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
                        courses.add(course);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        updateUi(courses);
    }

    private void updateUi(List<Course> courses) {
        adapter.setData(courses);
        adapter.notifyDataSetChanged();
    }
}




