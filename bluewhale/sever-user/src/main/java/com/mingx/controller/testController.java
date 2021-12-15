package com.mingx.controller;

import com.mingx.entity.Result;
import com.mingx.pojo.SysUser;
import com.mingx.service.ISysUserService;
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
    private RedisOps RedisOps;

    @GetMapping("/helloUser")
    public Result helloUser() {


        SysUser user=iSysUserService.getById("1");
        RedisOps.setJsonString("pppp",user,10);
        System.out.println(RedisOps.getJsonObject(user.getName(),SysUser.class));

      //  System.out.println(user);
        return Result.succeed();
    }

    public static void main(String[] args) {


//            try {
//                //连接本地Redis服务
//                Jedis jedis = new Jedis("1.117.239.58", 6379);
//
//                jedis.auth("tyj666");//密码
//                String ping = jedis.ping();
//                if (ping.equalsIgnoreCase("PONG")) {
//                    System.out.println("redis缓存有效！" + ping);
//                    jedis.set("test","good");
//                }
//                jedis.close(); // 释放连接资源
//            } catch (Exception e) {
//                System.out.println("redis缓存失败！");
//
//            }


    }
    }


