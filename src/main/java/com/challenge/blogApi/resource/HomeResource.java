package com.challenge.blogApi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeResource {

    @GetMapping
    public String getStarted() {
        return "This is a blog API!";
    }
}
