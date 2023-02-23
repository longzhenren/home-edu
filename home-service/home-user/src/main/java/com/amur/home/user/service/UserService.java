package com.amur.home.user.service;

import com.amur.home.user.entity.UserInfo;
import com.amur.home.util.ServiceResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UserService {
    ServiceResult<UserInfo> getUserInfo(Long userId);

    ServiceResult<Void> updateUser(UserInfo userInfo);

    ServiceResult<String> updateAvatar(MultipartFile file);

    ServiceResult<Void> deleteUser(Long userId);

    ServiceResult<Long> createUser(String userName);

    ServiceResult<UserInfo> getUserByName(String username);

    ServiceResult<Void> favUser(Long favId, String nickName, Long userId);
}
