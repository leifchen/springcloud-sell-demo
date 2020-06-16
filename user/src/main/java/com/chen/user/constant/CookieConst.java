package com.chen.user.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Cookie常量
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CookieConst {

	public static final String TOKEN = "token";
	public static final String OPENID = "openid";
	/**
	 * 过期时间(单位:s)
	 */
	public static final Integer EXPIRE = 7200;
}
