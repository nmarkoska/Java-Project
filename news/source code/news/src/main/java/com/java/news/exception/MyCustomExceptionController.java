package com.java.news.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyCustomExceptionController {
    @ExceptionHandler(value = MyCustomException.class)
    public ResponseEntity<Object> exception(MyCustomException exception) {
        return new ResponseEntity<>(exception.getMessage(), exception.getHttpStatus());
    }

}
