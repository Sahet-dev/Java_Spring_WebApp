package com.sahet.simplewebapp.controller;

import com.sahet.simplewebapp.model.Users;
import com.sahet.simplewebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String  login(@RequestBody Users user) {
        return userService.verify(user);
    }
}
