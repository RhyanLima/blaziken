package com.blaziken.api_backend.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.blaziken.api_backend.security.roles.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String email;

    private String employeeRegistration;

    private String password;

    private UserRole role;

    public User
    (
        String name, 
        String email, 
        String employeeRegistration, 
        String password, 
        UserRole role
    )
    {
        this.name = name;
        this.email = email;
        this.employeeRegistration = employeeRegistration;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        if (this.role == UserRole.ADMIN) 
        {
            return List.of( new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        else 
        {
            return List.of( new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getUsername() 
    {
        return name;
    }

}
