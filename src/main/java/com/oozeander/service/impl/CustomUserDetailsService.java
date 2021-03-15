package com.oozeander.service.impl;

import com.oozeander.model.User;
import com.oozeander.model.auth.CustomUserDetails;
import com.oozeander.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userService.getUserByEmail(email);
        if (user.isEmpty())
            throw new UsernameNotFoundException("Email " + email + " does not exist");
        else return new CustomUserDetails(user.get());
    }
}