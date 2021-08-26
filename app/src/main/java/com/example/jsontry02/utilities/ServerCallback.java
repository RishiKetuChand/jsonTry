package com.example.jsontry02.utilities;

import com.example.jsontry02.dto.Course;
import com.example.jsontry02.dto.Module;
import com.example.jsontry02.dto.Resource;
import com.example.jsontry02.dto.Result;
import com.example.jsontry02.dto.SliderImages;
import com.example.jsontry02.dto.Subject;
import com.example.jsontry02.dto.Videos;

import java.util.List;

public interface ServerCallback {
	public void onDataReceived(List<Course> data, List<SliderImages> imageData);
	public void onSubjectDataReceived(List<Subject> data);
	public void onModuleDataReceived(List<Module> data);
	public void onResourceDataReceived(List<Resource> data);
	public void onResultReceived(List<Result> data);
	public void onVideoReceived(List<Videos> data);
}
