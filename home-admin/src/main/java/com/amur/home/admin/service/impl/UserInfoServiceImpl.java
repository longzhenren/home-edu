package com.amur.home.admin.service.impl;

import com.amur.home.admin.mapper.UserInfoMapper;
import com.amur.home.admin.service.UserInfoService;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.util.QueryUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public Page<UserInfo> queryUserInfos(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize) {
        QueryWrapper<UserInfo> queryWrapper = QueryUtil.buildQueryWrapper(params, sortField, sortOrder);
        Page<UserInfo> page = new Page<>(pageNumber, pageSize);
        return userInfoMapper.selectPage(page, queryWrapper);
    }
}
