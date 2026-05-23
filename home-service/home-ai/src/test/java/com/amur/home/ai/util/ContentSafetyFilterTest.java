package com.amur.home.ai.util;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ContentSafetyFilterTest {

    @Test
    @DisplayName("HTML注入过滤")
    void testSanitizeInput_HTMLInjection() {
        String input = "<script>alert('xss')</script>Hello";
        String result = ContentSafetyFilter.sanitizeInput(input);
        assertNotNull(result);
        assertFalse(result.contains("<script>"));
    }

    @Test
    @DisplayName("空输入处理")
    void testSanitizeInput_Null() {
        assertNull(ContentSafetyFilter.sanitizeInput(null));
    }

    @Test
    @DisplayName("手机号检测")
    void testContainsSensitiveInfo_Phone() {
        assertTrue(ContentSafetyFilter.containsSensitiveInfo("我的手机号是13800138000"));
    }

    @Test
    @DisplayName("邮箱检测")
    void testContainsSensitiveInfo_Email() {
        assertTrue(ContentSafetyFilter.containsSensitiveInfo("联系我test@example.com"));
    }

    @Test
    @DisplayName("身份证号检测")
    void testContainsSensitiveInfo_IDCard() {
        assertTrue(ContentSafetyFilter.containsSensitiveInfo("身份证110101199003071234"));
    }

    @Test
    @DisplayName("敏感信息脱敏")
    void testMaskSensitiveInfo() {
        String input = "电话13800138000邮箱test@example.com";
        String result = ContentSafetyFilter.maskSensitiveInfo(input);
        assertTrue(result.contains("***"));
        assertFalse(result.contains("13800138000"));
    }

    @Test
    @DisplayName("无敏感信息")
    void testContainsSensitiveInfo_None() {
        assertFalse(ContentSafetyFilter.containsSensitiveInfo("今天天气真好"));
    }
}
