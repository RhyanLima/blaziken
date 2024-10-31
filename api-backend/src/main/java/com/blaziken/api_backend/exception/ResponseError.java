package com.blaziken.api_backend.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {

    private Date timestamp = new Date();
    private String status = "error";
    private int statusCode = 400;
    private String erro;
}
