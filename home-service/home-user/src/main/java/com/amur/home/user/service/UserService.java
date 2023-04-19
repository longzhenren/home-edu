package com.amur.home.user.service;

import com.amur.home.common.Constants;
import com.amur.home.dto.PageResult;
import com.amur.home.user.entity.UserFavorite;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.entity.UserLike;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public interface UserService extends IService<UserInfo> {
    ServiceResult<UserInfo> getUserInfo(Long userId);

    ServiceResult<Void> updateUser(Long userId, String description, String phone, String email, String avatarUrl, String sex, Integer age, Constants.UserRelativeType relativeType);

    ServiceResult<String> updateAvatar(MultipartFile file);

    ServiceResult<Void> deleteUser(Long userId);

    ServiceResult<Long> createUser(String userName);

    ServiceResult<UserInfo> getUserByName(String username);

    ServiceResult<Void> favUser(Long favId, String nickName, Long userId);

    ServiceResult<Boolean> checkUserExists(long userId);

    ServiceResult<PageResult<UserInfo>> searchUserInfo(Long homeId, String keyword, String email, String phone, Integer pageNum, Integer pageSize);
}
