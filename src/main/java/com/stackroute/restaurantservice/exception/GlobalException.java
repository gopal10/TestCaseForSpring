package com.stackroute.restaurantservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = RestaurantNotFound.class)
    public ResponseEntity<String> exceptionhandler(RestaurantNotFound e) {
        return new ResponseEntity<>("erorr exception occured in Global " + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = RestaurantAlreadyException.class)
    public ResponseEntity<String> exceptionhandler(RestaurantAlreadyException e) {
        return new ResponseEntity<>("erorr exception occured in Global " + e.getMessage(), HttpStatus.CONFLICT);
    }
}
