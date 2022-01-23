package com.java.news.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class HomeController {

    @GetMapping()
    public ResponseEntity<?> home() {
        return new ResponseEntity<>(new Date(), HttpStatus.OK);
    }

}
