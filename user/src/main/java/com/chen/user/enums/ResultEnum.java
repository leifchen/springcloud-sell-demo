package com.chen.user.enums;

import lombok.Getter;

/**
 * 返回结果枚举
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
@Getter
public enum ResultEnum {
    /**
     * 返回结果
     */
    LOGIN_FAIL(1, "登录失败"),
    ROLE_ERROR(2, "角色权限有误"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
