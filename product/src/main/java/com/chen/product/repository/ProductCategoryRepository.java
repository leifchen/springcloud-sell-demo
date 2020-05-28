package com.chen.product.repository;

import com.chen.product.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目Repository
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 根据类目编号查询商品类目列表
     * @param categoryTypeList 类目编号列表
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
