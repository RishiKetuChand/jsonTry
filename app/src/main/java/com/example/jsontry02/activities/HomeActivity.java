package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.example.jsontry02.R;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Result;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    CardView notesCard, quizzerCard, timerCard,resultCard,tipsCard,booksCard,videoCard,reviewCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        List<Course> courseData = getIntent().getExtras().getParcelableArrayList("courses");
        notesCard=findViewById(R.id.notes_card);
        quizzerCard=findViewById(R.id.quizzer_card);
        timerCard=findViewById(R.id.timeTable_card);
        resultCard=findViewById(R.id.result_card);
        tipsCard=findViewById(R.id.tips_card);
        booksCard=findViewById(R.id.books_card);
        videoCard=findViewById(R.id.video_card);
        reviewCard=findViewById(R.id.complaints_card);

        notesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeActivity.this,MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("coursesList", (ArrayList<? extends Parcelable>) courseData);
                activityIntent.putExtras(bundle);
                startActivity(activityIntent);
            }
        });
        resultCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(HomeActivity.this, ResultActivity.class);
                startActivity(i);
            }
        });
    }
}