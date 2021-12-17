package com.mingx.service;


import com.mingx.entity.Result;
import com.mingx.feign.testUserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sever-stock", fallbackFactory = testUserServiceFallbackFactory.class, decode404 = true)
public interface testFeignService {

    @GetMapping("/stock/test")
    Result<?> getTokenByUserId(@RequestParam("userCode") Long userId);

}
