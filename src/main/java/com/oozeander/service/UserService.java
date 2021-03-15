package com.oozeander.service;

import com.oozeander.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> saveAll(List<User> users);
    List<User> getUsers();
    Optional<User> getUserByEmail(String email);
}