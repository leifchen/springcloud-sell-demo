package com.chen.user.exception;

import com.chen.user.enums.ResultEnum;

/**
 * 用户异常信息
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
public class UserException extends RuntimeException {

    private Integer code;

    public UserException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}