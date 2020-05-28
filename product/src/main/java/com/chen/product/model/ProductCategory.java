package com.chen.product.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类目
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;
    /**
     * 类目名字
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}
