package com.sammal.plantation.users.controller;

import jakarta.validation.ValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String validExceptionHandler(MethodArgumentNotValidException e) {

        return e.getFieldError().getDefaultMessage();
    }

    @ExceptionHandler(UserPrincipalNotFoundException.class)
    public String userNotFoundExceptionHandler(UserPrincipalNotFoundException e) {

        return e.getName();
    }

    @ExceptionHandler(ValidationException.class)
    public String validationExceptionHandler(ValidationException e) {

        return e.getMessage();
    }
}
