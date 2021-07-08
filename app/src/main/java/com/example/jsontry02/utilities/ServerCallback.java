package com.example.jsontry02.utilities;

import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Resource;
import com.example.jsontry02.dto.Result;
import com.example.jsontry02.dto.Subject;

import java.util.List;

public interface ServerCallback {
	public void onDataReceived(List<Course> data);
	public void onSubjectDataReceived(List<Subject> data);
	public void onModuleDataReceived(List<Module> data);
	public void onResourceDataReceived(List<Resource> data);
	public void onResultReceived(List<Result> data);
}
