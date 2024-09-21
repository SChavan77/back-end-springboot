package com.first.spring.FirstSpringBootProject;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExe.class)
    public ResponseEntity<UserResponse> handleResourceNotFound(int id){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(UserResponse.builder()
                    .errMessage(id+": Resource Not Found").build());
    }

}
