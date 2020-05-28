package com.chen.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 程序入口
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
@EnableEurekaClient
@SpringBootApplication
public class ProductApp {

    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class, args);
    }
}
