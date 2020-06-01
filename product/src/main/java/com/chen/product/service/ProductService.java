package com.chen.product.service;

import com.chen.product.model.ProductInfo;
import com.chen.vo.DecreaseStockInput;
import com.chen.vo.ProductInfoOutput;

import java.util.List;

/**
 * 商品Service接口
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
