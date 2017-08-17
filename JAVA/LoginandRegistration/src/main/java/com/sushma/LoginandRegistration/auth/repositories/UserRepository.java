package com.sushma.LoginandRegistration.auth.repositories;

import org.springframework.stereotype.Repository;

import com.sushma.LoginandRegistration.auth.models.User;

@Repository

public interface UserRepository {
    User findByUsername(String username);

}
