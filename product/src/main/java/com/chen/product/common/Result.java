package com.chen.product.common;

import lombok.Data;

/**
 * HTTP统一请求返回对象
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
@Data
public class Result {

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private Object data;

    public static Result success(Object object) {
        Result result = new Result();
        result.setData(object);
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }
}
