package com.mingx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stock")
public class TestController {


    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String helloUser(@RequestParam("userCode") String code) {
       System.out.println("负载均衡拿到了"+port);
       return "负载均衡拿到了"+port;
        //  System.out.println(user);
        //return Result.succeed();
    }
}
