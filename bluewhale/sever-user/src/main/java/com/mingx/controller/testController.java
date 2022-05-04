package com.mingx.controller;

import com.mingx.entity.Result;
import com.mingx.feign.ISysUserService;
import com.mingx.feign.testFeignService;
import com.mingx.utils.RedisOps;
import com.mingx.utils.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/user")
public  class testController {

    @Value("${server.port}")
    private String port;

    @Resource
    private ISysUserService iSysUserService;

    @Resource
    private testFeignService feignService;

    @Resource
    private RedisOps RedisOps;

    @Resource
    RedisRepository redisRepository;

    //@Resource
    //private KafkaProducer kafkaProducer;

//    @Resource
//    private KafkaProducer kafkaProducer;


    @GetMapping("/helloUser")
    public Result helloUser() {


//        redisRepository.putHashValue("zyj", "name", "存入redie客户端不能乱码谢谢");
//        System.out.println(redisRepository.getHashValues("zyj", "name"));
        return Result.succeed( feignService.getTokenByUserId(port));
    }

    //    @GetMapping("/testkafka")
//    @Transactional(rollbackFor = Exception.class)
    // public void sendMsg() { kafkaProducer.send("this is a test kafka topic messagel"); }}
//    @GetMapping("/testKafka")
//    @Transactional(rollbackFor = Exception.class)
//    public Result testKafka() {
//        kafkaProducer.send("6666");
//        return Result.succeed();
//    }


}