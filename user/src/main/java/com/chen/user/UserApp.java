package com.chen.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户程序入口
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserApp {

	public static void main(String[] args) {
		SpringApplication.run(UserApp.class, args);
	}
}
