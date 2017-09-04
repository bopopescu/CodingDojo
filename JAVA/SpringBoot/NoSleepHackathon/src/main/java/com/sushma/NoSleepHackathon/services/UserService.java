package com.sushma.NoSleepHackathon.services;

import java.util.List;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.sushma.NoSleepHackathon.models.User;
import com.sushma.NoSleepHackathon.repositories.*;

@Service
public class UserService {
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	//1
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
