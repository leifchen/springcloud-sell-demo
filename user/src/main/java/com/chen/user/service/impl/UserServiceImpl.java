package com.chen.user.service.impl;

import com.chen.user.model.UserInfo;
import com.chen.user.repository.UserInfoRepository;
import com.chen.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserInfo findByOpenid(String openid) {
		return repository.findByOpenid(openid);
	}
}
