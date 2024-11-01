package com.blaziken.api_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaziken.api_backend.model.Product;


public interface ProductRepository extends JpaRepository<Product, String>{
}
