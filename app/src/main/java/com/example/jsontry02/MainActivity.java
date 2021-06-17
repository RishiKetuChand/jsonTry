package com.example.jsontry02;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jsontry02.adapters.CourseAdapter;
import com.example.jsontry02.dto.Course;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String URL="https://college-notes-188a4-default-rtdb.firebaseio.com/main/courses.json";
    RecyclerView recyclerView;
    CourseAdapter adapter;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        List<Course> courseData = getIntent().getExtras().getParcelableArrayList("courses");
        adapter = new CourseAdapter(this,courseData);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);

        recyclerView.setAdapter(adapter);

    }

}




