package com.mingx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient

public class SeverStockApp {
    public static void main(String[] args) {  SpringApplication.run(SeverStockApp.class,args); }
}