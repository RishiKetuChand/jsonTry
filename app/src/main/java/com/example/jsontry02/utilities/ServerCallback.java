package com.example.jsontry02.utilities;

import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Subject;

import java.util.List;

public interface ServerCallback {
	public void onDataRecieved(List<Course> data);
	public void onSubjectDataRecieved(List<Subject> data);
}
