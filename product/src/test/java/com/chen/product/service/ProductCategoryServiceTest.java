package com.chen.product.service;

import com.chen.product.model.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * 商品类目Service测试
 * <p>
 * @Author LeifChen
 * @Date 2020-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = productCategoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        assertTrue(list.size() > 0);
    }
}