package com.spring.demo;

import Response.PartialResponse;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PartialResponse> createUser(@RequestBody RegisteredUser user) {
        //Check for required parameter if its missing set response
        PartialResponse response;
        if(user.getFirstName() == null || user.getLastName() == null || user.getUsername() == null || user.getEmail() == null || user.getPhoneNo() == null || user.getDob() == null || user.getGender() == null || user.getWhatsappNo() == null || user.getProfileImageUrl() == null ) {
            response = new PartialResponse("Failure","you have other missing parameter");
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                    .body(response);
        } else {
            // Logic to create the user would go here (e.g., saving to the database)
            // Save the user
            RegisteredUser savedUser = userService.registerUser(user);
            response = new PartialResponse("Success","User registered successfully");
            // Returning the list wrapped in ResponseEntity
            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        }
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
