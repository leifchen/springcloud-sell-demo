package com.chen.user.service;

import com.chen.user.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * 用户Service测试
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByOpenid() {
        UserInfo buyer = userService.findByOpenid("buyer");
        assertNotNull(buyer);
        UserInfo seller = userService.findByOpenid("seller");
        assertNotNull(seller);
    }
}