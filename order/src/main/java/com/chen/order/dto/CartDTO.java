package com.chen.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购物车DTO
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;
}
