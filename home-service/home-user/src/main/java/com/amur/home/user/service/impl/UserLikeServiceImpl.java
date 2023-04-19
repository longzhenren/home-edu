package com.amur.home.user.service.impl;

import com.amur.home.user.entity.UserLike;
import com.amur.home.user.mapper.UserLikeMapper;
import com.amur.home.user.service.UserLikeService;
import com.amur.home.util.QueryUtil;
import com.amur.home.util.ServiceResult;
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
    public ServiceResult<Page<UserLike>> queryUserLike(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize) {
        QueryWrapper<UserLike> queryWrapper = QueryUtil.buildQueryWrapper(params, sortField, sortOrder);
        Page<UserLike> page = new Page<>(pageNumber, pageSize);
        Page<UserLike> result = userLikeMapper.selectPage(page, queryWrapper);
        if (result == null || result.getRecords() == null || result.getRecords().isEmpty())
            return ServiceResult.ex("查询结果为空");
        return ServiceResult.success(result);
    }
}
