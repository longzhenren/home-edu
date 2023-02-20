package com.amur.home.auth.controller;

import com.amur.home.auth.service.AuthService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Map;

@Tag(name = "登录模块")
@RestController
@Slf4j
public class AuthController {
    @Resource
    private Producer producer;

    @Resource
    private AuthService authService;

    /**
     * 获取验证码
     *
     * @param response 响应
     * @param request  请求
     * @throws Exception 异常
     */
    @Operation(summary = "获取验证码")
    @GetMapping(value = "/captcha.jpg", produces = "image/jpeg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setHeader("Cache-Control", "no-store,no-cache");
        response.setContentType("image/jpeg");
        String text = producer.createText();
        BufferedImage image = producer.createImage(text);
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.close();
    }

    /**
     * 登录入口
     *
     * @param username 用户名
     * @param password 密码
     * @param captcha  验证码
     * @param request  请求
     * @return 登录结果
     */
    @Operation(summary = "登录")
    @Parameters(value = {@Parameter(name = "username", description = "用户名"), @Parameter(name = "password", description = "密码"), @Parameter(name = "captcha", description = "验证码")})
    @PostMapping(value = "/login")
    public ResponseWrapper<Map<String, Object>> login(String username, String password, String captcha, HttpServletRequest request) {
        //从session中获取之前保存的验证码，跟前台传过来的验证码进行匹配
        if (captcha != null) {
            Object savedCaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (savedCaptcha == null) {
                return ResponseWrapper.fail("验证码已失效");
            }
            if (!captcha.equals(savedCaptcha)) {
                return ResponseWrapper.fail("验证码不正确");
            }
        }
        ServiceResult<Map<String, Object>> res = authService.login(username, password);
        return ResponseWrapper.data(res.getData());
    }

    @PostMapping(value = "/logout")
    public ResponseWrapper<?> logout() {
        ServiceResult<Void> res = authService.logout();
        return ResponseWrapper.status(res.isSuccess());
    }

    @PostMapping(value = "/register")
    public ResponseWrapper<?> register(String username, String password, String captcha, HttpServletRequest request) {
        //从session中获取之前保存的验证码，跟前台传过来的验证码进行匹配
        if (captcha != null) {
            Object savedCaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (savedCaptcha == null) {
                return ResponseWrapper.fail("验证码已失效");
            }
            if (!captcha.equals(savedCaptcha)) {
                return ResponseWrapper.fail("验证码不正确");
            }
        }
        ServiceResult<Long> res = authService.register(username, password);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.status(true);
    }
}
