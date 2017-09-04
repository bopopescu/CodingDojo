package com.sushma.BeltExam.services;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sushma.BeltExam.models.User;
import com.sushma.BeltExam.repositories.UserRepository;
import com.sushma.BeltExam.models.GetPackage;
import com.sushma.BeltExam.models.Role;
import com.sushma.BeltExam.repositories.PackageRepository;
import com.sushma.BeltExam.repositories.RoleRepository;
@Service
public class UserService {
	private UserRepository userRepository;
	private PackageRepository packageRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, PackageRepository packageRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.packageRepository =packageRepository;
	}
	
	//1
	public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
	}
	
	//2
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}
	
	//3
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> findallUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public List<Role> findRoleByName(String name){
		return roleRepository.findByName(name);
	}

	public void removePerson(Long id) {
		userRepository.delete(id);
		
	}

	public User FindOneUser(Long id) {
		return userRepository.findOne(id);
		
	}

	public void updateUser(Long personid, User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(Long personid, int dueDay, GetPackage getpackage) {
		User person = userRepository.findOne(personid);
		GetPackage getpack = packageRepository.findOne(getpackage.getId());
		System.out.println("sadsd"+getpackage.getId());
		int getdate = person.getCreatedAt().getDate();
		System.out.println(getdate);
		getdate += dueDay;
		Calendar c = Calendar.getInstance(); 
		c.setTime(person.getCreatedAt()); 
		c.add(Calendar.DATE, dueDay);
		Date dt = c.getTime();

		person.setYepgetsomedueDay(dt);
		userRepository.save(person);
//		person.getPackages().add(getpack);
		person.setGetpackage(getpack);
		getpack.getGetusers().add(person);
		packageRepository.save(getpack);
		
		
	}



}
