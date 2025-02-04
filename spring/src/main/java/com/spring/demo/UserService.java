package com.spring.demo;

import Response.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public RegisteredUser registerUser(RegisteredUser user) {
        return userRepository.save(user);
    }

    public ValidationResponse checkIfExists(String email, String phoneNumber) {
        Optional<RegisteredUser> userByEmail = userRepository.findByEmail(email);
        Optional<RegisteredUser> userByPhone = userRepository.findByPhoneNo(phoneNumber);

        if (userByEmail.isPresent()) {
            return new ValidationResponse(1, "Email already exists", "Email already exists");
        } else if (userByPhone.isPresent()) {
            return new ValidationResponse(2, "Phone number already exists", "Phone number already exists");
        }
        return new ValidationResponse(0, "Email and phone number exist", "Email and phone number exist");
    }
}

