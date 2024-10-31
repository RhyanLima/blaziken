package com.blaziken.api_backend.security.dto;

import com.blaziken.api_backend.security.roles.UserRole;

public record RegisterDTO
( 
    String name,
    String email,
    String employeeRegistration,
    String password,
    UserRole role
)
{

}
