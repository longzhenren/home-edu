/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * Copyright (c) 2023-2033, AmurBear (hljzhangzhibo@aliyun.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amur.home.auth.controller;

import com.amur.home.auth.granter.ITokenGranter;
import com.amur.home.auth.granter.TokenGranterBuilder;
import com.amur.home.auth.granter.TokenParameter;
import com.amur.home.auth.utils.TokenUtil;
import com.amur.home.common.cache.CacheNames;
import com.amur.home.common.util.ResponseWrapper;
import com.amur.home.secure.AuthInfo;
import com.amur.home.user.entity.AuthEntity;
import com.wf.captcha.SpecCaptcha;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.support.Kv;
import org.springblade.core.tool.utils.Func;
import org.springblade.core.tool.utils.RedisUtil;
import org.springblade.core.tool.utils.WebUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 认证模块
 *
 * @author Chill
 */
@RestController
@AllArgsConstructor
@Tag(name = "用户授权认证", description = "授权接口")
public class AuthController {

    private RedisUtil redisUtil;

    @PostMapping("/token")
    @Operation(summary = "获取认证token", description = "传入账号:username 密码:password")
    public ResponseWrapper<AuthInfo> token(@Parameter(name = "授权类型", required = true) @RequestParam(defaultValue = "password", required = false) String grantType,
                                           @Parameter(name = "刷新令牌") @RequestParam(required = false) String refreshToken,
                                           @Parameter(name = "账号") @RequestParam(required = false) String username,
                                           @Parameter(name = "密码") @RequestParam(required = false) String password) {

        String userType = Func.toStr(WebUtil.getRequest().getHeader(TokenUtil.USER_TYPE_HEADER_KEY), TokenUtil.DEFAULT_USER_TYPE);

        TokenParameter tokenParameter = new TokenParameter();
        tokenParameter.getArgs().set("username", username)
                .set("password", password)
                .set("grantType", grantType)
                .set("refreshToken", refreshToken)
                .set("userType", userType);

        ITokenGranter granter = TokenGranterBuilder.getGranter(grantType);
        AuthEntity AuthEntity = granter.grant(tokenParameter);

        if (AuthEntity == null || AuthEntity.getUser() == null || AuthEntity.getUser().getId() == null) {
            return ResponseWrapper.fail(TokenUtil.USER_NOT_FOUND);
        }

        return ResponseWrapper.data(TokenUtil.createAuthInfo(AuthEntity));
    }

    @GetMapping("/captcha")
    @Operation(summary = "获取验证码")
    public ResponseWrapper<Kv> captcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        // 存入redis并设置过期时间为30分钟
        redisUtil.set(CacheNames.CAPTCHA_KEY + key, verCode, 30L, TimeUnit.MINUTES);
        // 将key和base64返回给前端
        return ResponseWrapper.data(Kv.init().set("key", key).set("image", specCaptcha.toBase64()));
    }

}
