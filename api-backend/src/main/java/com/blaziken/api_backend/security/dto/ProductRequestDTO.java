package com.blaziken.api_backend.security.dto;

public record ProductRequestDTO
(
    String name, 
    Integer price, 
    String base64Image
) 
{

}
