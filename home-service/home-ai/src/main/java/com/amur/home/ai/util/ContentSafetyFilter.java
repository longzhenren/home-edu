package com.amur.home.ai.util;

import org.apache.commons.text.StringEscapeUtils;
import java.util.regex.Pattern;

public class ContentSafetyFilter {
    private static final Pattern PHONE_PATTERN = Pattern.compile("(?<!\\d)(1[3-9]\\d{9})(?!\\d)");
    private static final Pattern ID_CARD_PATTERN = Pattern.compile("\\d{17}[\\dXx]");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

    public static String sanitizeInput(String input) {
        if (input == null) return null;
        String sanitized = StringEscapeUtils.escapeHtml4(input);
        sanitized = sanitized.replaceAll("<script[^>]*>.*?</script>", "");
        return sanitized.trim();
    }

    public static boolean containsSensitiveInfo(String text) {
        if (text == null) return false;
        return PHONE_PATTERN.matcher(text).find()
                || ID_CARD_PATTERN.matcher(text).find()
                || EMAIL_PATTERN.matcher(text).find();
    }

    public static String maskSensitiveInfo(String text) {
        if (text == null) return null;
        text = PHONE_PATTERN.matcher(text).replaceAll("***");
        text = ID_CARD_PATTERN.matcher(text).replaceAll("***");
        text = EMAIL_PATTERN.matcher(text).replaceAll("***");
        return text;
    }
}
