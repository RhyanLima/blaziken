package com.blaziken.api_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blaziken.api_backend.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String employeeRegistration) throws UsernameNotFoundException {
        return userRepository.findByEmployeeRegistration(employeeRegistration);
    }

}
