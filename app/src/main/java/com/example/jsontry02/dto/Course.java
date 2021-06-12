package com.example.jsontry02.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {
	private String id;
	private String name;
	private String thumb;
	public Course(Parcel in) {
		id = in.readString();
		name = in.readString();
		thumb = in.readString();
	}

	public static final Creator<Course> CREATOR = new Creator<Course>() {
		@Override
		public Course createFromParcel(Parcel in) {
			return new Course(in);
		}

		@Override
		public Course[] newArray(int size) {
			return new Course[size];
		}
	};

	public Course() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(id);
		parcel.writeString(name);
		parcel.writeString(thumb);
	}
}
