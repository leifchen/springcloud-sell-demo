package com.chen.user.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Redis常量
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RedisConst {

	public static final String TOKEN_TEMPLATE = "token_%s";
}
