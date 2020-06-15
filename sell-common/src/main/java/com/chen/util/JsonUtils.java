package com.chen.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * JSON工具类
 * <p>
 * @Author LeifChen
 * @Date 2020-05-26
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 转换为json字符串
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * json转对象
     * @param string
     * @param classType
     * @return
     */
    public static <T> Object fromJson(String string, Class<T> classType) {
        try {
            return objectMapper.readValue(string, classType);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * json转复杂对象
     * @param string
     * @param typeReference
     * @return
     */
    public static <T> Object fromJson(String string, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(string, typeReference);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
