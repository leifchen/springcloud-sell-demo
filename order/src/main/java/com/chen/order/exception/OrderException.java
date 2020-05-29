package com.chen.order.exception;

import com.chen.order.enums.ResultEnum;

/**
 * 订单异常
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
