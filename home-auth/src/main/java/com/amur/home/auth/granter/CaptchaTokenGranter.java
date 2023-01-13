/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
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
package com.amur.home.auth.granter;

import com.amur.home.auth.client.AuthGrpcClient;
import com.amur.home.auth.utils.TokenUtil;
import com.amur.home.common.cache.CacheNames;
import com.amur.home.user.entity.AuthEntity;
import lombok.AllArgsConstructor;
import com.amur.home.auth.exception.ServiceException;
import org.springblade.core.tool.utils.Func;
import org.springblade.core.tool.utils.RedisUtil;
import org.springblade.core.tool.utils.StringUtil;
import org.springblade.core.tool.utils.WebUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 验证码TokenGranter
 *
 * @author Chill
 */
@Component
@AllArgsConstructor
public class CaptchaTokenGranter implements ITokenGranter {

    public static final String GRANT_TYPE = "captcha";

    @Resource
    AuthGrpcClient authGrpcClient;

    private RedisUtil redisUtil;

    @Override
    public AuthEntity grant(TokenParameter tokenParameter) {
        HttpServletRequest request = WebUtil.getRequest();

        String key = request.getHeader(TokenUtil.CAPTCHA_HEADER_KEY);
        String code = request.getHeader(TokenUtil.CAPTCHA_HEADER_CODE);
        // 获取验证码
        String redisCode = String.valueOf(redisUtil.get(CacheNames.CAPTCHA_KEY + key));
        // 判断验证码
        if (code == null || !StringUtil.equalsIgnoreCase(redisCode, code)) {
            throw new ServiceException(TokenUtil.CAPTCHA_NOT_CORRECT);
        }

        String username = tokenParameter.getArgs().getStr("username");
        String password = tokenParameter.getArgs().getStr("password");
        AuthEntity authEntity = null;
        if (Func.isNoneBlank(username, password)) {
            authEntity = authGrpcClient.getAuthEntity(username, password);
        }
        return authEntity;
    }

}
