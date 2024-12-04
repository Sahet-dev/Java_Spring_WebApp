package com.sahet.simplewebapp.service;

import com.sahet.simplewebapp.model.Users;
import com.sahet.simplewebapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepo.save(user);
    }
}
