package com.amur.home.auth.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码工具类
 *
 * @author Louis
 * @date Sep 1, 2018
 */
public class PasswordUtils {

    /**
     * 匹配密码
     *
     * @param rawPass 明文
     * @param encPass 密文
     * @return
     */
    public static boolean matches(String rawPass, String encPass) {
        return new BCryptPasswordEncoder().matches(encPass, rawPass);
    }

    /**
     * 明文密码加密
     *
     * @param password 明文
     * @return
     */
    public static String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
