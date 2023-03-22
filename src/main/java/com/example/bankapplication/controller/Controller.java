package com.example.bankapplication.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/data")
    public String getTestData() {
        return "Test DATA";
    }
}

