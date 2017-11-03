package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.CourseDAO;
import com.example.model.CourseModel;

public class CourseServiceRest implements CourseService {
	@Autowired
	CourseDAO courseDAO;

	@Override
	public CourseModel selectCourse(String id) {
		return courseDAO.selectCourse(id);
	}

	@Override
	public List<CourseModel> viewAll() {
		return courseDAO.viewAll();
	}
	
	

}
