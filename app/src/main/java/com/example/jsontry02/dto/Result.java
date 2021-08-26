package com.example.jsontry02.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Result implements Parcelable {
    private String vtu4u;
    private String customRes001;
    private String customRes002;
    private String officialWebResult;

    public Result(Parcel in) {
        vtu4u = in.readString();
        customRes001 = in.readString();
        customRes002 = in.readString();
        officialWebResult = in.readString();
    }

    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public Result() {

    }

    public String getVtu4u() {
        return vtu4u;
    }

    public void setVtu4u(String vtu4u) {
        this.vtu4u = vtu4u;
    }

    public String getCustomRes001() {
        return customRes001;
    }

    public void setCustomRes001(String customRes001) {
        this.customRes001 = customRes001;
    }

    public String getCustomRes002() {
        return customRes002;
    }

    public void setCustomRes002(String customRes002) {
        this.customRes002 = customRes002;
    }

    public String getOfficialWebResult() {
        return officialWebResult;
    }

    public void setOfficialWebResult(String officialWebResult) {
        this.officialWebResult = officialWebResult;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(vtu4u);
        parcel.writeString(customRes001);
        parcel.writeString(customRes002);
        parcel.writeString(officialWebResult);
    }
}
