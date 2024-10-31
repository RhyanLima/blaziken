package com.blaziken.api_backend.security.roles;

public enum UserRole {

    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role) { this.role = role; }

    public String getRole() { return role; }
}
