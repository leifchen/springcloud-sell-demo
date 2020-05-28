package com.chen.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品信息出参
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
@Data
public class ProductInfoOutput {

    private String productId;
    /**
     * 名字
     */
    private String productName;
    /**
     * 单价
     */
    private BigDecimal productPrice;
    /**
     * 库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 图标
     */
    private String productIcon;
    /**
     * 状态, 0正常1下架
     */
    private Integer productStatus;
    /**
     * 类目编号
     */
    private Integer categoryType;
}
