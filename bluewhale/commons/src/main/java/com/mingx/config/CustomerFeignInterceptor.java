package com.mingx.config;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public  class CustomerFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("进入feign拦截器");
//        requestTemplate.header("id","");//请求头
//        requestTemplate.query("userCode","aaa");//加一个参数
//        requestTemplate.uri("=啦啦啦");
    }
}
