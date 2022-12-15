package com.amur.homeuser.service;

import com.amur.homeuser.entity.UserEntity;

public interface UserService {
    public UserEntity getUserInfo(Long userId);
    public boolean updateUser(UserEntity userEntity);
    public boolean deleteUser(Long userId);
    public Long createUser(UserEntity userEntity);
}
