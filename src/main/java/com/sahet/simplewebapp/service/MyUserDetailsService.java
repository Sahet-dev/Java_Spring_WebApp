package com.sahet.simplewebapp.service;

import com.sahet.simplewebapp.model.UserPrincipal;
import com.sahet.simplewebapp.model.Users;
import com.sahet.simplewebapp.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    private final UserRepo repo;
    public MyUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }
}
