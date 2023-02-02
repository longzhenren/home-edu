package com.amur.home.auth.service;


import com.amur.home.auth.entity.UserAuth;
import com.amur.home.util.ServiceResult;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AuthService {
    public ServiceResult<Map<String, Object>> login(String userName, String password);

    public ServiceResult<Void> logout();

    public ServiceResult<Long> register(String userName, String password);

    public ServiceResult<UserAuth> getUserAuthById(Long id);

    ServiceResult<Void> addPermission(Long id, String permission);

    ServiceResult<Void> removePermission(Long id, String permission);

    ServiceResult<Void> addRole(Long id, String role);

    ServiceResult<Void> removeRole(Long id, String role);
}
