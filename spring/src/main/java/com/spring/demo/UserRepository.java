package com.spring.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<RegisteredUser, Long> {
    Optional<RegisteredUser> findByEmail(String emailAddress);

    Optional<RegisteredUser> findByPhoneNo(String phone_no);

}
