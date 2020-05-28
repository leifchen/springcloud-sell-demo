package com.chen.product.service;

import com.chen.product.model.ProductCategory;

import java.util.List;

/**
 * 商品类目Service接口
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
public interface ProductCategoryService {

    /**
     * 根据类目编号查询商品类目列表
     * @param categoryTypeList 类目编号列表
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
