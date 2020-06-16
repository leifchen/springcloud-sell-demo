package com.chen.user.enums;

import lombok.Getter;

/**
 * 角色枚举
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
@Getter
public enum RoleEnum {
    /**
     * 角色
     */
    BUYER(1, "买家"),
    SELLER(2, "卖家"),
    ;

    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

