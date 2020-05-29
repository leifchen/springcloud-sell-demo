package com.chen.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 主键生成工具类
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KeyUtils {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
