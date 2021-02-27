package com.challenge.blogApi.service;

import com.challenge.blogApi.exception.user.UserAlreadyExistsException;
import com.challenge.blogApi.model.User;
import com.challenge.blogApi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean exists(User newUser) {
        for (User user : getAll()) {
            if(user.equals(newUser))
                return true;
        }

        return false;
    }

    @Override
    public User save(User user) {
        if(exists(user))
            throw  new UserAlreadyExistsException();

        return userRepository.save(user);
    }
}
