package com.example.jsontry02.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.jsontry02.R;
import com.example.jsontry02.adapters.VideoAdapter;
import com.example.jsontry02.adapters.VideoPlayAdapter;
import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Videos;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class VideoPlayActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    String videoTitle,videoSubject,videoSem,videoBranch,videoResId;
    VideoPlayAdapter adapter;
    YouTubePlayerView youTubePlayerView;
    List<Videos> videoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        videoTitle= getIntent().getStringExtra("videoTitle");
        videoBranch = getIntent().getStringExtra("videoBranch");
        videoSem = getIntent().getStringExtra("videoSem");
        videoSubject = getIntent().getStringExtra("videoSubject");
        videoResId = getIntent().getStringExtra("videoResId");
        videoData = getIntent().getExtras().getParcelableArrayList("VideoList");
        initializeView();
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = videoResId;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

    }
    public void initializeView(){
        toolbar = findViewById(R.id.video_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.videoPlayRecyclerview);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        adapter = new VideoPlayAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);
        adapter.setData(videoData);
        adapter.notifyDataSetChanged();
        adapter.getFilter().filter(videoSubject);
        youTubePlayerView = findViewById(R.id.youtube_player_view);
    }
}