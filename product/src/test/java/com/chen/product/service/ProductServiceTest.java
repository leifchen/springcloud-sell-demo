package com.chen.product.service;

import com.chen.product.common.ProductInfoOutput;
import com.chen.product.model.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * 商品Service测试
 * <p>
 * @Author LeifChen
 * @Date 2020-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        assertTrue(list.size() > 0);
    }

    @Test
    public void findList() {
        List<ProductInfoOutput> list = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));
        assertTrue(list.size() > 0);
    }
}