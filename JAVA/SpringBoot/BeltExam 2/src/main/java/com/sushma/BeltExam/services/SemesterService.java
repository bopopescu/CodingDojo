package com.sushma.BeltExam.services;

import org.springframework.stereotype.Service;

import com.sushma.BeltExam.models.Semester;
import com.sushma.BeltExam.models.User;
import com.sushma.BeltExam.repositories.CourseRepository;
import com.sushma.BeltExam.repositories.SemesterRepository;
import com.sushma.BeltExam.repositories.UserRepository;

@Service

public class SemesterService {
	private UserRepository userRepository;
	private CourseRepository courseRepository;
	private SemesterRepository semesterRepository;
	
	public SemesterService(UserRepository userRepository, SemesterRepository semesterRepository, CourseRepository courseRepository) {
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
		this.semesterRepository = semesterRepository;
	}

	public void saveSemester(User user) {
//		User getuser = userRepository.findOne(user.getId());
//		int year = getuser.getCreatedAt().getYear()+1900;
//		
//		int month = getuser.getCreatedAt().getMonth()+1;
//		for(int i = 0; i < 4; i++) {
//			if(month >= 8) {
//				Semester gfall = semesterRepository.save(new Semester("Fall", year));
//				System.out.println(gfall);
//				user.getSemesters().add(gfall);
//			}
//			else {
//				Semester gspring = semesterRepository.save(new Semester("Spring", year));
//				user.getSemesters().add(gspring);
//			}
//			month = (month+6)%12;
//			year++;
//		}
		
	}

}
