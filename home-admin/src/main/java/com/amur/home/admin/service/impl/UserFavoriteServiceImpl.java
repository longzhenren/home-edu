package com.amur.home.admin.service.impl;

import com.amur.home.admin.mapper.UserFavoriteMapper;
import com.amur.home.admin.service.UserFavoriteService;
import com.amur.home.user.entity.UserFavorite;
import com.amur.home.util.QueryUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserFavoriteServiceImpl extends ServiceImpl<UserFavoriteMapper, UserFavorite> implements UserFavoriteService {
    @Resource
    private UserFavoriteMapper userFavoriteMapper;

    @Override
    public Page<UserFavorite> queryUserFavorites(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize) {
        QueryWrapper<UserFavorite> queryWrapper = QueryUtil.buildQueryWrapper(params, sortField, sortOrder);
        Page<UserFavorite> page = new Page<>(pageNumber, pageSize);
        return userFavoriteMapper.selectPage(page, queryWrapper);
    }
}
