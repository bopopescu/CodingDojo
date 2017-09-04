package com.sushma.BeltExam.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sushma.BeltExam.repositories.SemesterRepository;
import com.sushma.BeltExam.repositories.UserRepository;
import com.sushma.BeltExam.models.User;
import com.sushma.BeltExam.models.Course;

import com.sushma.BeltExam.repositories.CourseRepository;

@Service
public class CourseService {
	private UserRepository userRepository;
	private CourseRepository courseRepository;
	private SemesterRepository semesterRepository;
	
	public CourseService(UserRepository userRepository, SemesterRepository semesterRepository, CourseRepository courseRepository) {
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
		this.semesterRepository = semesterRepository;
	}
	
	public List<Course> findallCourses() {
		return (List<Course>) courseRepository.findAll();
	}

}
