package com.chen.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单程序入口
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
@EnableFeignClients(basePackages = "com.chen.product.client")
@SpringCloudApplication
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
