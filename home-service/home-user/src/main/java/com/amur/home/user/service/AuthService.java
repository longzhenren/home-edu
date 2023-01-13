package com.amur.home.user.service;

import com.amur.home.user.entity.AuthEntity;

public interface AuthService {
    public AuthEntity getAuthInfo(String username,String password);
    public AuthEntity getAuthInfo(long userId);
}
