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
package com.amur.home.auth.utils;

import com.amur.home.common.constant.TokenConstant;
import com.amur.home.core.tool.utils.Func;
import com.amur.home.secure.AuthInfo;
import com.amur.home.secure.TokenInfo;
import com.amur.home.secure.utils.SecureUtil;
import com.amur.home.user.entity.AuthEntity;
import com.amur.home.user.entity.UserEntity;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证工具类
 *
 * @author Chill
 */
public class TokenUtil {

    public final static String CAPTCHA_HEADER_KEY = "Captcha-Key";
    public final static String CAPTCHA_HEADER_CODE = "Captcha-Code";
    public final static String CAPTCHA_NOT_CORRECT = "验证码不正确";
    public final static String USER_TYPE_HEADER_KEY = "User-Type";
    public final static String DEFAULT_USER_TYPE = "web";
    public final static String USER_NOT_FOUND = "用户名或密码错误";
    public final static String HEADER_KEY = "Authorization";
    public final static String HEADER_PREFIX = "Basic ";
    public final static String DEFAULT_AVATAR = "https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png";

    /**
     * 创建认证token
     *
     * @param AuthEntity 用户信息
     * @return token
     */
    public static AuthInfo createAuthInfo(AuthEntity AuthEntity) {
        UserEntity user = AuthEntity.getUser();

        //设置jwt参数
        Map<String, String> param = new HashMap<>(8);
        param.put(TokenConstant.TOKEN_TYPE, TokenConstant.ACCESS_TOKEN);
        param.put(TokenConstant.OAUTH_ID, AuthEntity.getOauthId());
        param.put(TokenConstant.USER_ID, Func.toStr(user.getId()));
        param.put(TokenConstant.ROLE_ID, Func.toStr(user.getRoleId()));
        param.put(TokenConstant.HOME_ID, Func.toStr(user.getHomeId()));
        param.put(TokenConstant.USER_NAME, Func.toStr(user.getName()));
        param.put(TokenConstant.ROLE_NAME, Func.join(AuthEntity.getRoles()));

        TokenInfo accessToken = SecureUtil.createJWT(param, "audience", "issuer", TokenConstant.ACCESS_TOKEN);

        return getAuthInfo(AuthEntity, user, accessToken);
    }

    /**
     * 创建refreshToken
     *
     * @param AuthEntity 用户信息
     * @return refreshToken
     */
    private static TokenInfo createRefreshToken(AuthEntity AuthEntity) {
        UserEntity user = AuthEntity.getUser();
        Map<String, String> param = new HashMap<>(16);
        param.put(TokenConstant.TOKEN_TYPE, TokenConstant.REFRESH_TOKEN);
        param.put(TokenConstant.USER_ID, Func.toStr(user.getId()));
        return SecureUtil.createJWT(param, "audience", "issuer", TokenConstant.REFRESH_TOKEN);
    }

    @NotNull
    private static AuthInfo getAuthInfo(AuthEntity AuthEntity, UserEntity user, TokenInfo accessToken) {
        AuthInfo authInfo = new AuthInfo();
        authInfo.setUserId(user.getId());
        authInfo.setOauthId(AuthEntity.getOauthId());
        authInfo.setAccount(user.getName());
        authInfo.setUserName(user.getName());
        authInfo.setAuthority(Func.join(AuthEntity.getRoles()));
        authInfo.setAccessToken(accessToken.getToken());
        authInfo.setExpiresIn(accessToken.getExpire());
        authInfo.setRefreshToken(createRefreshToken(AuthEntity).getToken());
        authInfo.setTokenType(TokenConstant.BEARER);
        authInfo.setLicense(TokenConstant.LICENSE_NAME);
        return authInfo;
    }
}
