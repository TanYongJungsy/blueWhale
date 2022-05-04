package com.mingx.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//NONE【性能最佳，适用于生产】：不记录任何日志（默认值）
//BASIC【适用于生产环境追踪问题】：仅记录请求方法、URL、响应状态代码以及执行时间
//HEADERS：记录BASIC级别的基础上，记录请求和响应的header。
//FULL【比较适用于开发及测试环境定位问题】：记录请求和响应的header、body和元数 据。
//@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level openFeignLogging(){
        return Logger.Level.FULL;
    }
}
