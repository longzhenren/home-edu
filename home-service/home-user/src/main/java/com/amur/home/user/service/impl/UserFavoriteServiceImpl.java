package com.amur.home.user.service.impl;

import com.amur.home.user.entity.UserFavorite;
import com.amur.home.user.mapper.UserFavMapper;
import com.amur.home.user.service.UserFavoriteService;
import com.amur.home.util.QueryUtil;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserFavoriteServiceImpl extends ServiceImpl<UserFavMapper, UserFavorite> implements UserFavoriteService {
    @Resource
    private UserFavMapper userFavoriteMapper;

    @Override
    public ServiceResult<Page<UserFavorite>> queryUserFavorite(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize) {
        QueryWrapper<UserFavorite> queryWrapper = QueryUtil.buildQueryWrapper(params, sortField, sortOrder);
        Page<UserFavorite> page = new Page<>(pageNumber, pageSize);
        Page<UserFavorite> result = userFavoriteMapper.selectPage(page, queryWrapper);
        if (result == null || result.getRecords() == null || result.getRecords().isEmpty())
            return ServiceResult.ex("查询结果为空");
        return ServiceResult.success(result);
    }
}
