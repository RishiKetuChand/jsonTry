package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.example.jsontry02.R;
import com.example.jsontry02.adapters.SliderAdapter;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.SliderImages;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    SliderView sliderView;
    CardView notesCard, quizzerCard, timerCard,resultCard,sgpaCard,booksCard,videoCard,reviewCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        List<Course> courseData = getIntent().getExtras().getParcelableArrayList("courses");
        List<SliderImages> imagesData = getIntent().getExtras().getParcelableArrayList("imagesData");
        notesCard=findViewById(R.id.notes_card);
        quizzerCard=findViewById(R.id.quizzer_card);
        timerCard=findViewById(R.id.timeTable_card);
        resultCard=findViewById(R.id.result_card);
        sgpaCard=findViewById(R.id.sgpa_card);
        booksCard=findViewById(R.id.books_card);
        videoCard=findViewById(R.id.video_card);
        reviewCard=findViewById(R.id.complaints_card);
        sliderView=findViewById(R.id.imageSlider);
        SliderAdapter adapter = new SliderAdapter(this,new ArrayList<>());
        adapter.setData(imagesData);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.BLACK);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

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

        sgpaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(HomeActivity.this, SgpaCaluActivity.class);
                startActivity(i);
            }
        });
        videoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(HomeActivity.this, VideoActivity.class);
                startActivity(i);
            }
        });
    }
}