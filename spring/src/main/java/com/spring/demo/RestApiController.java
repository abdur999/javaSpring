package com.spring.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Date;

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

    @PostMapping("/date")
    public ResponseEntity<String> inputDate(@RequestBody RquestDateDTO rdd) {
        Date receivedDate = rdd.getDate();
        return ResponseEntity.ok("Received date: "+receivedDate);
    }
    @PostMapping("/signup")
    public String createUser(@RequestBody RegisteredUser user) {
        // Logic to create the user would go here (e.g., saving to the database)
        JSONObject totalJson = new JSONObject();
        totalJson.put("message","Success");
        totalJson.put("user",user.getDob());
        return totalJson.toString();
    }
    @GetMapping("/list")
    public List<RegisteredUser> getAllUser() {
        return Arrays.asList(
                new RegisteredUser("John Doe", "johndoe@example.com"),
                new RegisteredUser("Jane Doe", "jane.doe@example.com")
        );
    }

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisteredUser> registerUser(@RequestBody RegisteredUser user) {
        RegisteredUser registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }
}
