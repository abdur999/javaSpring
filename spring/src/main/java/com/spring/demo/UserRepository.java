package com.spring.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<RegisteredUser, Long> {
}
