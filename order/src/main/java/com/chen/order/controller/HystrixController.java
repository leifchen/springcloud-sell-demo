package com.chen.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * HystrixController
 * <p>
 * @Author LeifChen
 * @Date 2020-06-17
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number") Integer number) {
        if (number % 2 == 0) {
            return "success";
        }

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:18001/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);

//		throw new RuntimeException("发送异常了");
    }

    private String fallback() {
        return "太拥挤了, 请稍后再试~~";
    }

    private String defaultFallback() {
        return "默认提示：太拥挤了, 请稍后再试~~";
    }
}
