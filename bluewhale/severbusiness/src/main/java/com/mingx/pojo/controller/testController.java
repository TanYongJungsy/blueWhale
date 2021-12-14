package com.mingx.pojo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public  class testController {

//    @Value("${param.config}")
//    private String config;

    @GetMapping("/helloUser")
    public String helloUser() {

        return "hello User ,param.config = ";

    }

}