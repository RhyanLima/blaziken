package com.blaziken.api_backend.security.dto;

import com.blaziken.api_backend.model.Product;

public record ProductResponseDTO
(
    String id,
    String name,
    Integer price,
    String base64Image
) 
{
    public ProductResponseDTO
    (
        Product product
    )
    {
        this(product.getId(), product.getName(), product.getPrice(), product.getBase64Image());
    }
}
