package com.mingx.controller;


import com.mingx.utils.CacheUtity;
import com.mingx.utils.RedisUtil;
import com.mingx.entity.Result;
import com.mingx.pojo.SysUser;
import com.mingx.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/user")
public  class testController {

//    @Value("${param.config}")
//    private String config;

    @Resource
    private ISysUserService  iSysUserService;

    @Resource
    private RedisUtil redisUtil;

    @GetMapping("/helloUser")
    public Result helloUser() {

        SysUser user=iSysUserService.getById("1");
        System.out.println(user);
      if( redisUtil.get(user.getName())!=null){
          System.out.println("99999");
      }

   return Result.succeed(   redisUtil.get(user.getName()) );
    }

    public static void main(String[] args) {

    }

}