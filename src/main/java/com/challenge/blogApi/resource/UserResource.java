package com.challenge.blogApi.resource;

import com.challenge.blogApi.exception.user.UserAlreadyExistsException;
import com.challenge.blogApi.model.User;
import com.challenge.blogApi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.*;
import java.util.Set;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        try {
            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
        } catch(UserAlreadyExistsException uaee) {
            throw new ResponseStatusException(uaee.hashCode(), uaee.getMessage(), uaee);
        }
    }
}
