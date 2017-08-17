package com.sushma.SpringSecurityDemo.auth.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sushma.SpringSecurityDemo.auth.models.Role;
import com.sushma.SpringSecurityDemo.auth.models.User;
import com.sushma.SpringSecurityDemo.auth.repositories.*;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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

}
