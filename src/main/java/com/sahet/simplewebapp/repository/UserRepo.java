package com.sahet.simplewebapp.repository;

import com.sahet.simplewebapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);


}
