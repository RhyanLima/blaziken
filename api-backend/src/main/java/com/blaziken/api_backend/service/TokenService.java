package com.blaziken.api_backend.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.blaziken.api_backend.exception.BusinessException;
import com.blaziken.api_backend.model.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generate
    (
        User user
    )
    {
        try
        {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                                        .withIssuer("api-backend")
                                        .withSubject(user.getEmployeeRegistration())
                                        .withExpiresAt(generateExpirationDate())
                                        .sign(algorithm);
            return token;
        }
        catch (JWTCreationException exception)
        {
            throw new BusinessException("Erro while generating token");
        }
    } 

    public String validateToken(String token){
        try 
        {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                                        .withIssuer("spring-security-javajwt-jwt")
                                        .build()
                                        .verify(token)
                                        .getSubject();
        } 
        catch (JWTCreationException exception) 
        {
            return "";
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
