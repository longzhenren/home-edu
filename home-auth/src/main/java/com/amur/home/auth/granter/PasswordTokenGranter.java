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
package com.amur.home.auth.granter;

import com.amur.home.auth.client.AuthGrpcClient;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.utils.Func;
import com.amur.home.user.entity.AuthEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * PasswordTokenGranter
 *
 * @author Chill
 */
@Component
@AllArgsConstructor
public class PasswordTokenGranter implements ITokenGranter {

	public static final String GRANT_TYPE = "password";

	@Resource
	AuthGrpcClient authGrpcClient;

	@Override
	public AuthEntity grant(TokenParameter tokenParameter) {
		String username = tokenParameter.getArgs().getStr("username");
		String password = tokenParameter.getArgs().getStr("password");
		AuthEntity authEntity = null;
		if (Func.isNoneBlank(username, password)) {
			authEntity = authGrpcClient.getAuthEntity(username, password);
		}
		return authEntity;
	}

}
