package com.sushma.BeltExam.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sushma.BeltExam.models.User;
import com.sushma.BeltExam.models.Semester;
import com.sushma.BeltExam.repositories.SemesterRepository;
import com.sushma.BeltExam.repositories.UserRepository;
@Service
public class UserService {
	private UserRepository userRepository;
	private SemesterRepository semesterRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, SemesterRepository semesterRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.semesterRepository = semesterRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	//1
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		System.out.println("UM"+user.getEmail());
//			int year = user.getCreatedAt().getYear()+1900;
//			
//			int month = user.getCreatedAt().getMonth()+1;
//			for(int i = 0; i < 4; i++) {
//				if(month >= 8) {
//					Semester gfall = semesterRepository.save(new Semester("Fall", year));
//					user.getSemesters().add(gfall);
//				}
//				else {
//					Semester gspring = semesterRepository.save(new Semester("Spring", year));
//					user.getSemesters().add(gspring);
//				}
//				month = (month+6)%12;
//				year++;
//			}
        userRepository.save(user);
        
	}
	

	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> findallUsers() {
		return (List<User>) userRepository.findAll();
	}
	

	public void removePerson(Long id) {
		userRepository.delete(id);
		
	}

	public User FindOneUser(Long id) {
		return userRepository.findOne(id);
		
	}

}
