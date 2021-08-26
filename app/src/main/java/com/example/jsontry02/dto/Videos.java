package com.example.jsontry02.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Videos implements Parcelable {


    private String videoId;
    private String videoTitle;
    private String videoSubject;
    private String videoSem;
    private String videoBranch;
    private String videoResId;
    private String videoCoveredTopic;

    public Videos(Parcel in) {
        videoId = in.readString();
        videoTitle = in.readString();
        videoSubject = in.readString();
        videoSem = in.readString();
        videoBranch = in.readString();
        videoResId = in.readString();
        videoCoveredTopic = in.readString();
    }

    public static final Creator<Videos> CREATOR = new Creator<Videos>() {
        @Override
        public Videos createFromParcel(Parcel in) {
            return new Videos(in);
        }

        @Override
        public Videos[] newArray(int size) {
            return new Videos[size];
        }
    };

    public Videos() {

    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoSubject() {
        return videoSubject;
    }

    public void setVideoSubject(String videoSubject) {
        this.videoSubject = videoSubject;
    }

    public String getVideoSem() {
        return videoSem;
    }

    public void setVideoSem(String videoSem) {
        this.videoSem = videoSem;
    }

    public String getVideoBranch() {
        return videoBranch;
    }

    public void setVideoBranch(String videoBranch) {
        this.videoBranch = videoBranch;
    }

    public String getVideoResId() {
        return videoResId;
    }

    public void setVideoResId(String videoResId) {
        this.videoResId = videoResId;
    }

    public String getVideoCoveredTopic() {
        return videoCoveredTopic;
    }

    public void setVideoCoveredTopic(String videoCoveredTopic) {
        this.videoCoveredTopic = videoCoveredTopic;
    }
    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(videoId);
        dest.writeString(videoTitle);
        dest.writeString(videoSubject);
        dest.writeString(videoSem);
        dest.writeString(videoBranch);
        dest.writeString(videoResId);
        dest.writeString(videoCoveredTopic);
    }
}
