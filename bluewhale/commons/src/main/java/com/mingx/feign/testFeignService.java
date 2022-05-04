package com.mingx.feign;



import com.mingx.feignFallbackFactory.testUserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sever-stock", path = "/stock",fallbackFactory = testUserServiceFallbackFactory.class, decode404 = true)
public interface testFeignService {

    @GetMapping("/test")
    String getTokenByUserId(@RequestParam("userCode") String port);

}
