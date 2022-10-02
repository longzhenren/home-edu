package com.amur.home.user.service;

import com.amur.home.user.entity.UserLike;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserLikeService extends IService<UserLike> {
    ServiceResult<Page<UserLike>> queryUserLike(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize);
}
