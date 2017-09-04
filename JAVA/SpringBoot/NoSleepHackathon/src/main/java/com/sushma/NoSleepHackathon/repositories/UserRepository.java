package com.sushma.NoSleepHackathon.repositories;

import org.springframework.data.repository.CrudRepository;


import com.sushma.NoSleepHackathon.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
