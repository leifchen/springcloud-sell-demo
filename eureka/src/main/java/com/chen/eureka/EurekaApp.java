package com.chen.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server启动入口
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }
}
