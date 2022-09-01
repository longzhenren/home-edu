package com.amur.home.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;

public class QueryUtil {

    public static <T> T buildQueryWrapper(Map<String, Map<String, Object>> params, String sortField, String sortOrder) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (params != null) {
            for (Map.Entry<String, Map<String, Object>> entry : params.entrySet()) {
                String key = entry.getKey();
                Map<String, Object> valueMap = entry.getValue();
                if (valueMap.containsKey("match")) {
                    switch ((String) valueMap.get("match")) {
                        case "eq":
                            queryWrapper.eq(valueMap.containsKey("value"), key, valueMap.get("value"));
                            break;
                        case "ne":
                            queryWrapper.ne(valueMap.containsKey("value"), key, valueMap.get("value"));
                            break;
                        case "like":
                            queryWrapper.like(valueMap.containsKey("value"), key, valueMap.get("value"));
                            break;
                        case "in":
                            queryWrapper.in(valueMap.containsKey("value"), key, valueMap.get("value"));
                            break;
                        case "notIn":
                            queryWrapper.notIn(valueMap.containsKey("value"), key, valueMap.get("value"));
                            break;
                        case "gt":
                            queryWrapper.gt(valueMap.containsKey("value"), key, valueMap.get("value"));
                            break;
                        case "ge":
                            queryWrapper.ge(valueMap.containsKey("value"), key, valueMap.get("value"));
                            break;
                        case "lt":
                            queryWrapper.lt(valueMap.containsKey("value"), key, valueMap.get("value"));
                            break;
                        case "le":
                            queryWrapper.le(valueMap.containsKey("value"), key, valueMap.get("value"));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if (sortField != null) {
            if (sortOrder.equals("asc")) {
                queryWrapper.orderByAsc(sortField);
            } else {
                queryWrapper.orderByDesc(sortField);
            }
        } else {
            queryWrapper.orderByDesc("id");
        }
        return (T) queryWrapper;
    }
}
