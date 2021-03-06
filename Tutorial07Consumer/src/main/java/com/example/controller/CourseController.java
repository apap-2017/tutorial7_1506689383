package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;
import com.example.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	CourseService courseDAO;

	@RequestMapping("/course/view/{id}")
	public String viewCoursePath(Model model, @PathVariable(value = "id") String id) {
		CourseModel course = courseDAO.selectCourse(id);

		if (course != null) {
			model.addAttribute("course", course);
			model.addAttribute("title", "View Course");
			return "viewcourse";
		} else {
			model.addAttribute("id", id);
			model.addAttribute("title", "Course Not Found");
			return "course-not-found";
		}
	}
	
	@RequestMapping("/course/viewall")
	public String viewall(Model model) {
		List<CourseModel> courses = courseDAO.viewAll();
		
		model.addAttribute("courses", courses);
		return "viewall-course";
	}
}
