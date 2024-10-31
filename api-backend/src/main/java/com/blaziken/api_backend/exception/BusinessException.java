package com.blaziken.api_backend.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String mensage) 
    { 
	    super(mensage); 
    }
    
    public BusinessException(String mensage, Object ... params) 
    { 
	    super(String.format(mensage, params)); 
    }

}
