package com.amur.home.user.service;

import com.amur.home.user.entity.UserEntity;

public interface UserService {
    public UserEntity getUserInfo(Long userId);
    public boolean updateUser(UserEntity userEntity);
    public boolean deleteUser(Long userId);
    public Long createUser(UserEntity userEntity);
}
