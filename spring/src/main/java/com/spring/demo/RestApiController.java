package com.spring.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class RestApiController {

    @GetMapping
    public String getUsers() {
        return "Hello, this is a simple REST API for users!";
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        // Logic to create the user would go here (e.g., saving to the database)
        return "User created: " + user.getUsername();
    }
}
