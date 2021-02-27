package com.challenge.blogApi.service;

import com.challenge.blogApi.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public boolean exists(User newUser);

    public User save(User user);
}