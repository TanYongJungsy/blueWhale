package com.mingx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stock")
public class TestController {


    @GetMapping("/test")
    public void helloUser(@RequestParam("userCode") Long userId) {

       System.out.println("服务调用成功拿到了"+userId);

        //  System.out.println(user);
        //return Result.succeed();
    }
}
