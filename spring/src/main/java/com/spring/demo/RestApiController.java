package com.spring.demo;

import Response.PartialResponse;
import Response.ValidationResponse;
import com.spring.demo.validator.MobileNumberValidator;
import exceptiion.ErrorDetails;
import exceptiion.InvalidDataException;
import exceptiion.ResourceAlreadyExistException;
import exceptiion.RquestDateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.json.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
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
    public ResponseEntity<?> createUser(@RequestBody RegisteredUser user) {
        //Check for required parameter if its missing set response
        PartialResponse response;
        if(user.getFirstName() == null || user.getLastName() == null || user.getUsername() == null || user.getEmail() == null || user.getPhoneNo() == null || user.getDob() == null || user.getGender() == null || user.getWhatsappNo() == null || user.getProfileImageUrl() == null ) {
            response = new PartialResponse("Failure","you have other missing parameter");
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                    .body(response);
        } else {
            if(!MobileNumberValidator.isValidMobileNumber(user.getPhoneNo())) {
                throw new InvalidDataException("User","phone",user.getPhoneNo());
            }
            // Logic to create the user would go here (e.g., saving to the database)
            // Save the user
            ValidationResponse validResponse = userService.checkIfExists(user.getEmail(),user.getPhoneNo());
            if(validResponse.getCode() == 0) {
                RegisteredUser savedUser = userService.registerUser(user);
                response = new PartialResponse("Success", "User registered successfully");
                // Returning the list wrapped in ResponseEntity
            } else if(validResponse.getCode() == 1) {
//                response = new PartialResponse("Failure", "Email or phone number already exist");
                // Returning the list wrapped in ResponseEntity
                throw new ResourceAlreadyExistException("User","email",user.getEmail());
            } else {
                throw new ResourceAlreadyExistException("User","phone",user.getPhoneNo());
            }
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

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleResourceAlreadyExists(ResourceAlreadyExistException ex, WebRequest request) {

        // Log the error
        //logger.error("Error occurred: {}", ex.getMessage());

        // Create ErrorDetails object
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                ex.getResourceName(),
                ex.getFieldName(),
                ex.getFieldValue()
        );

        // Return structured JSON response with 409 Conflict status
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<Object> handleInvalidMobileNumberException(InvalidDataException ex, WebRequest request) {
        // Return a 400 Bad Request status with a custom message
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                ex.getResourceName(),
                ex.getFieldName(),
                ex.getFieldValue()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                "Internal Server Error",
                request.getDescription(false),
                "Unknown",
                "Unknown",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
