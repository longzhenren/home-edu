package com.amur.home.user.service;

import com.amur.home.user.entity.UserInfo;
import com.amur.home.util.ServiceResult;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public ServiceResult<UserInfo> getUserInfo(Long userId);

    public ServiceResult<Void> updateUser(UserInfo userInfo);

    public ServiceResult<Void> deleteUser(Long userId);

    public ServiceResult<Long> createUser(UserInfo userInfo);

    public ServiceResult<UserInfo> getUserByName(String username);
}
