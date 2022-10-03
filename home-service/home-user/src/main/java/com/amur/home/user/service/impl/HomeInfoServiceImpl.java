package com.amur.home.user.service.impl;

import com.amur.home.user.entity.HomeInfo;
import com.amur.home.user.mapper.HomeInfoMapper;
import com.amur.home.user.service.HomeInfoService;
import com.amur.home.util.QueryUtil;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class HomeInfoServiceImpl extends ServiceImpl<HomeInfoMapper, HomeInfo> implements HomeInfoService {
    @Resource
    private HomeInfoMapper homeInfoMapper;

    @Override
    public ServiceResult<Page<HomeInfo>> queryHomeInfo(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize) {
        QueryWrapper<HomeInfo> queryWrapper = QueryUtil.buildQueryWrapper(params, sortField, sortOrder);
        Page<HomeInfo> page = new Page<>(pageNumber, pageSize);
        Page<HomeInfo> result = homeInfoMapper.selectPage(page, queryWrapper);
        if (result == null || result.getRecords() == null || result.getRecords().isEmpty())
            return ServiceResult.ex("查询结果为空");
        return ServiceResult.success(result);
    }
}
