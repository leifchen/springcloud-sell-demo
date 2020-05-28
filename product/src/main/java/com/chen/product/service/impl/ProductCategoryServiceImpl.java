package com.chen.product.service.impl;

import com.chen.product.model.ProductCategory;
import com.chen.product.repository.ProductCategoryRepository;
import com.chen.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品类目Service实现
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
