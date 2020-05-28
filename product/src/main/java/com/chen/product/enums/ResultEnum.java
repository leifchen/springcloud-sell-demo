package com.chen.product.enums;

import lombok.Getter;

/**
 * 返回结果枚举
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
@Getter
public enum ResultEnum {
    /**
     * 返回产品结果
     */
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
