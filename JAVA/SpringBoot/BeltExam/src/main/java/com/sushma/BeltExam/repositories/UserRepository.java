package com.sushma.BeltExam.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;



import com.sushma.BeltExam.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);
	
	


}
