/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.validation.demo.exception;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 *
 * @author Hi
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
        ErrorResponse response = ErrorResponse.createInstance();
        e.getConstraintViolations()
         .forEach(constraintViolation -> response.addMessage(constraintViolation.getPropertyPath().toString() + " : " + constraintViolation.getMessage()));

        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorResponse response = ErrorResponse.createInstance();

        e.getBindingResult().getFieldErrors()
         .forEach(fieldError -> response.addMessage(fieldError.getField() + " : " + fieldError.getDefaultMessage()));

        return response;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorResponse handleBindException(BindException e) {
        ErrorResponse response = ErrorResponse.createInstance();

        e.getBindingResult().getFieldErrors()
                 .forEach(fieldError -> response.addMessage(fieldError.getField() + " : " + fieldError.getDefaultMessage()));

        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    ErrorResponse handleException(Exception e) {
        ErrorResponse response = ErrorResponse.createInstance();

        response.addMessage(e.getMessage());

        return response;
    }
}
