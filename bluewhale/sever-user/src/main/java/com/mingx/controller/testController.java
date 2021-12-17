package com.mingx.controller;

import com.mingx.entity.Result;
import com.mingx.service.ISysUserService;
import com.mingx.service.testFeignService;
import com.mingx.utils.RedisOps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/user")
public  class testController {

//    @Value("${spring.redis}")
//    private String config;

    @Resource
    private ISysUserService  iSysUserService;

    @Resource
    private testFeignService feignService;

    @Resource
    private RedisOps RedisOps;

    @GetMapping("/helloUser")
    public Result helloUser() {


        feignService.getTokenByUserId(999L);
//        SysUser user=iSysUserService.getById("1");
//        RedisOps.setJsonString("pppp",user,10);
//        System.out.println(RedisOps.getJsonObject(user.getName(),SysUser.class));

       System.out.println("99999999999999999999999");
        return Result.succeed();
    }

    public static void main(String[] args) {





    }
    }


