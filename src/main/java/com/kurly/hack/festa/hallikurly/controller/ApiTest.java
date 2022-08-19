package com.kurly.hack.festa.hallikurly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class ApiTest {

    @GetMapping
    public String test(){
        return "is TEST";
    }
}
