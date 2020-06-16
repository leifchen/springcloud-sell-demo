package com.chen.user.service;


import com.chen.user.model.UserInfo;

/**
 * 用户Service接口
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
public interface UserService {

	/**
	 * 根据openid查询用户信息
	 * @param openid
	 * @return
	 */
	UserInfo findByOpenid(String openid);
}
