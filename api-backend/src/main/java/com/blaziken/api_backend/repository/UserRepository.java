package com.blaziken.api_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.blaziken.api_backend.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByEmployeeRegistration
    (
        String employeeRegistration
    );

}
