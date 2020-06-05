package com.chen.order.controller;

import com.chen.order.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Controller
 * <p>
 * @Author LeifChen
 * @Date 2020-06-04
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestConfig testConfig;

    @GetMapping("/print")
    public String print(){
        return testConfig.getName() + " : " + testConfig.getAge();
    }
}
