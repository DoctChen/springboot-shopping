package com.chenxin.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chenxin.shop.modules.dao")
public class OpenShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenShoppingApplication.class, args);
    }

}
