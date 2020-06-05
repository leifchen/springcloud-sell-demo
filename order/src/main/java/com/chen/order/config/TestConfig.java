package com.chen.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Test配置
 * <p>
 * @Author LeifChen
 * @Date 2020-06-04
 */
@Data
@Component
@ConfigurationProperties("test")
public class TestConfig {

    private String name;
    private Integer age;
}
