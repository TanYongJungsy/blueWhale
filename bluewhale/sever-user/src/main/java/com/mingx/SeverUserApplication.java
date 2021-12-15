package com.mingx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class SeverUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeverUserApplication.class,args);
    }
}
