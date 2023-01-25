package com.amur.home.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.amur.home.auth.client.UserGrpcClient;
import com.amur.home.user.entity.UserEntity;
import com.amur.home.util.RedisUtils;
import com.amur.home.util.ResponseWrapper;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private Producer producer;
    @Autowired
    private UserGrpcClient userGrpcClient;

    @Resource
    private RedisUtils redisUtils;

    /**
     * 获取验证码
     *
     * @param response
     * @param request
     * @throws Exception
     */
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
     * @param username
     * @param password
     * @param captcha
     * @param request
     * @return
     */
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
        UserEntity user = userGrpcClient.getUserEntityByUserName(username);
        //用户信息
        if (user == null) {
            return ResponseWrapper.fail("帐号不存在");
        }
        if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            return ResponseWrapper.fail("密码不正确");
        }
        redisUtils.set("user:" + user.getId(), user);
        StpUtil.login(user.getId());
        user.setPassword(null);
        Map<String, Object> map = new HashMap<>();
        map.put("token", StpUtil.getTokenInfo());
        map.put("user", user);
        return ResponseWrapper.data(map);
    }

    @PostMapping(value = "/logout")
    public ResponseWrapper<?> logout() {
        StpUtil.logout();
        redisUtils.remove("user:" + StpUtil.getLoginId());
        return ResponseWrapper.status(true);
    }
}
