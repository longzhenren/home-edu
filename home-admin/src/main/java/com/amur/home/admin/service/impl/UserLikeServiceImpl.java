package com.amur.home.admin.service.impl;

import com.amur.home.admin.mapper.UserLikeMapper;
import com.amur.home.admin.service.UserLikeService;
import com.amur.home.user.entity.UserLike;
import com.amur.home.util.QueryUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserLikeServiceImpl extends ServiceImpl<UserLikeMapper, UserLike> implements UserLikeService {
    @Resource
    private UserLikeMapper userLikeMapper;

    @Override
    public Page<UserLike> queryUserLikes(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize) {
        QueryWrapper<UserLike> queryWrapper = QueryUtil.buildQueryWrapper(params, sortField, sortOrder);
        Page<UserLike> page = new Page<>(pageNumber, pageSize);
        return userLikeMapper.selectPage(page, queryWrapper);
    }
}
