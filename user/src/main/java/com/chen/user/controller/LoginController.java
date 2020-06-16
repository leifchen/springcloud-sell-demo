package com.chen.user.controller;

import com.chen.common.Result;
import com.chen.user.constant.CookieConst;
import com.chen.user.constant.RedisConst;
import com.chen.user.enums.ResultEnum;
import com.chen.user.enums.RoleEnum;
import com.chen.user.exception.UserException;
import com.chen.user.model.UserInfo;
import com.chen.user.service.UserService;
import com.chen.user.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 登录controller
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 买家登录
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    public Result buyer(@RequestParam("openid") String openid,
                        HttpServletResponse response) {

        // 1.openid和数据库里的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            throw new UserException(ResultEnum.LOGIN_FAIL);
        }

        // 2.判断角色
        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())) {
            throw new UserException(ResultEnum.ROLE_ERROR);
        }

        // 3.cookie里设置openid=buyer
        CookieUtils.set(response, CookieConst.OPENID, openid, CookieConst.EXPIRE);

        return Result.success();
    }

    @GetMapping("/seller")
    public Result seller(@RequestParam("openid") String openid,
                         HttpServletRequest request,
                         HttpServletResponse response) {

        // 判断是否已登录
        Cookie cookie = CookieUtils.get(request, CookieConst.TOKEN);
        if (cookie != null &&
                !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConst.TOKEN_TEMPLATE, cookie.getValue())))) {
            return Result.success();
        }

        // 1.openid和数据库里的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            throw new UserException(ResultEnum.LOGIN_FAIL);
        }

        // 2.判断角色
        if (!RoleEnum.SELLER.getCode().equals(userInfo.getRole())) {
            throw new UserException(ResultEnum.ROLE_ERROR);
        }

        // 3.redis设置key=UUID, value=seller
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConst.EXPIRE;
        stringRedisTemplate.opsForValue().set(String.format(RedisConst.TOKEN_TEMPLATE, token),
                openid,
                expire,
                TimeUnit.SECONDS);

        // 4.cookie里设置token=UUID
        CookieUtils.set(response, CookieConst.TOKEN, token, CookieConst.EXPIRE);

        return Result.success();
    }
}
