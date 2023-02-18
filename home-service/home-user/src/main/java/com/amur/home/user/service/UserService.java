package com.amur.home.user.service;

import com.amur.home.user.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserEntity getUserInfo(Long userId);

    public boolean updateUser(UserEntity userEntity);

    public boolean deleteUser(Long userId);

    public Long createUser(UserEntity userEntity);

    public UserEntity getUserByName(String username);

    public boolean updatePassword(Long userId, String oldPassword, String newPassword);
}
