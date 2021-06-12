package com.example.jsontry02;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsontry02.Objects.Courses;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    private final static String URL="https://college-notes-188a4-default-rtdb.firebaseio.com/main.json";
    RecyclerView recyclerView;
    Adapter adapter;
    TextView textView;
    Courses courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        textView=findViewById(R.id.textView);
        StringRequest request= new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder= new GsonBuilder();
                Gson gson=gsonBuilder.create();
                Courses courses=  gson.fromJson(response, Courses.class);
                recyclerView.setAdapter(adapter);
                textView.setText(courses.getC101().getName().toString());

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);
    }
}