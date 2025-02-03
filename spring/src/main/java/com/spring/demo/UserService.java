package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public RegisteredUser registerUser(RegisteredUser user) {
        return userRepository.save(user);
    }
}
