package com.example.jsontry02.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class SliderImages implements Parcelable {
    String id;
    String imageUrl;
    String infoUrl;

    public SliderImages(Parcel in) {
        id = in.readString();
        imageUrl = in.readString();
        infoUrl = in.readString();
    }

    public static final Creator<SliderImages> CREATOR = new Creator<SliderImages>() {
        @Override
        public SliderImages createFromParcel(Parcel in) {
            return new SliderImages(in);
        }

        @Override
        public SliderImages[] newArray(int size) {
            return new SliderImages[size];
        }
    };

    public SliderImages() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(imageUrl);
        dest.writeString(infoUrl);
    }
}
