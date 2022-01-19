package com.mingx.feign;

import com.mingx.service.testFeignService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class testUserServiceFallbackFactory implements FallbackFactory<testFeignService> {


    @Override
    public testFeignService create(Throwable throwable) {
        System.out.println("进入熔断器了");
        throw new RuntimeException();
    }

}
