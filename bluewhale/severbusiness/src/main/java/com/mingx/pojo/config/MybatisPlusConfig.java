package com.mingx.pojo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * MybatisPlus分页插件
 * @author Admin
 *
 */
@Configuration
@MapperScan("com.mingx.mapper")
public class MybatisPlusConfig {

    /**
     *     分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}