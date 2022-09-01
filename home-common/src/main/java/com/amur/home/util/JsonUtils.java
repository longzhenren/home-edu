package com.amur.home.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    /**
     * json转换成对象
     */
    public static <T> T toObject(Class clazz, String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return (T) mapper.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            System.out.println(jsonString + "转化失败");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象转换成json
     */
    public static String toJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            System.out.println(object + "转化失败");
            e.printStackTrace();
        }
        return null;
    }
}