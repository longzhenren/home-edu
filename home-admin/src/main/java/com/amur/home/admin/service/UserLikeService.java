package com.amur.home.admin.service;

import com.amur.home.user.entity.HomeInfo;
import com.amur.home.user.entity.UserLike;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserLikeService extends IService<UserLike> {
    Page<UserLike> queryUserLikes(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize);
}
