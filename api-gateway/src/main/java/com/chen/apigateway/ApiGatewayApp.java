package com.chen.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关程序入口
 * <p>
 * @Author LeifChen
 * @Date 2020-06-15
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApp.class, args);
    }
}
