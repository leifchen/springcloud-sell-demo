package com.chen.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 减库存入参
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DecreaseStockInput {

    private String productId;
    private Integer productQuantity;
}