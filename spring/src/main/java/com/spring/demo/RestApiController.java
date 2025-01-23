package com.spring.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class RestApiController {

    @GetMapping("/welcome")
    public String welcome() {
        JSONObject totalJson = new JSONObject();
        JSONObject userJson = new JSONObject();
        userJson.put("name", "John Doe");
        userJson.put("email", "john.doe@example.com");
        totalJson.put("user",userJson);
        totalJson.put("message","Success");
        return totalJson.toString();
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        // Logic to create the user would go here (e.g., saving to the database)
        JSONObject totalJson = new JSONObject();
        totalJson.put("message","Success");
        totalJson.put("user",user.getUsername());
        return totalJson.toString();
    }
    @GetMapping("/list")
    public List<User> getAllUser() {
        return Arrays.asList(
                new User("John Doe", "johndoe@example.com"),
                new User("Jane Doe", "jane.doe@example.com")
        );
    }
}
