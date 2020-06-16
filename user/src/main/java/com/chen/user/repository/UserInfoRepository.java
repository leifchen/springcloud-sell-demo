package com.chen.user.repository;

import com.chen.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户Repository
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    /**
     * 根据openid查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
