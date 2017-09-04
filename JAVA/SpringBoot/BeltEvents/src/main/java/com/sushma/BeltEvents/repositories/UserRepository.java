package com.sushma.BeltEvents.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sushma.BeltEvents.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
