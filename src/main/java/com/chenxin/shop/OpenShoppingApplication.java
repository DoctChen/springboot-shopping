package com.chenxin.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: @EnableTransactionManagement启用注解事务管理
 * @title: OpenShoppingApplication
 * @Author Star_Chen
 * @Date: 2022/5/2 15:15
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.chenxin.shop.modules.test.dao","com.chenxin.shop.modules.pms.mapper"})
@EnableTransactionManagement
public class OpenShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenShoppingApplication.class, args);
    }

}
