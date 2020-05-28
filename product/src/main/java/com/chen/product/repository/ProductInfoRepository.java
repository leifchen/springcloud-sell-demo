package com.chen.product.repository;

import com.chen.product.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品Repository
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 根据商品状态查询商品列表
     * @param productStatus 商品状态
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 根据商品ID查询商品列表
     * @param productIdList 商品ID列表
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
