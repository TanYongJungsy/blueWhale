package com.mingx.controller;


import com.mingx.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public  class testController {

//    @Value("${param.config}")
//    private String config;

    @Autowired
    private ISysUserService  iSysUserService;

    @GetMapping("/helloUser")
    public void helloUser() {

     System.out.println(iSysUserService.getById("1"));

    }

}