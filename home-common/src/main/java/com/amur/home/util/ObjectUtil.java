package com.amur.home.util;

import org.springframework.lang.Nullable;

public class ObjectUtil extends org.springframework.util.ObjectUtils {
    public static boolean isNotEmpty(@Nullable Object obj) {
        return !ObjectUtil.isEmpty(obj);
    }
}
