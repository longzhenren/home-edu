package com.amur.home.user.service.impl;

import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.mapper.UserInfoMapper;
import com.amur.home.user.service.UserInfoService;
import com.amur.home.util.QueryUtil;
import com.amur.home.util.ServiceResult;
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
    public ServiceResult<Page<UserInfo>> queryUserInfo(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize) {
        QueryWrapper<UserInfo> queryWrapper = QueryUtil.buildQueryWrapper(params, sortField, sortOrder);
        Page<UserInfo> page = new Page<>(pageNumber, pageSize);
        Page<UserInfo> result = userInfoMapper.selectPage(page, queryWrapper);
        if (result == null || result.getRecords() == null || result.getRecords().isEmpty())
            return ServiceResult.ex("查询结果为空");
        return ServiceResult.success(result);
    }
}
