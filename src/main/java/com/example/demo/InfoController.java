package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping(value = "/info")
    public String getUsers() {
        return "Hello!";
    }
}