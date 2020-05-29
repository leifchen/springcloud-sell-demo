package com.chen.order.enums;

import lombok.Getter;

/**
 * 支付状态枚举
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
@Getter
public enum PayStatusEnum {
    /**
     * 支付状态
     */
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
