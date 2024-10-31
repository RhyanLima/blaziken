package com.blaziken.api_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blaziken.api_backend.model.User;
import com.blaziken.api_backend.repository.UserRepository;
import com.blaziken.api_backend.security.dto.AutenticationDTO;
import com.blaziken.api_backend.security.dto.LoginResponseDTO;
import com.blaziken.api_backend.security.dto.RegisterDTO;
import com.blaziken.api_backend.service.TokenService;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AutenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.employeeRegistration(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generate((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data) {
        if (this.userRepository.findByEmployeeRegistration(data.employeeRegistration()) != null) 
        {
            return ResponseEntity.badRequest().build();
        } 
        else 
        {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User
            (
                data.name(),
                data.email(),
                data.employeeRegistration(),
                encryptedPassword, 
                data.role()
            );
            this.userRepository.save(newUser);

            return ResponseEntity.ok().build();
        }
    }

}
