package com.chen.product.exception;

import com.chen.product.enums.ResultEnum;

/**
 * 商品异常信息
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
