package com.amur.home.admin.service;

import com.amur.home.user.entity.UserInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserInfoService extends IService<UserInfo> {
    Page<UserInfo> queryUserInfos(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize);
}
