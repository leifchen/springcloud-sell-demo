package com.chen.order.enums;

import lombok.Getter;

/**
 * 订单状态枚举
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
@Getter
public enum OrderStatusEnum {
    /**
     * 订单状态
     */
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
