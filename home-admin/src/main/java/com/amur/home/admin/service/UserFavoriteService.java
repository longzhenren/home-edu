package com.amur.home.admin.service;

import com.amur.home.user.entity.UserFavorite;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserFavoriteService extends IService<UserFavorite> {
    Page<UserFavorite> queryUserFavorites(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize);
}
