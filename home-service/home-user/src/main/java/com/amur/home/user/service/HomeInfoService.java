package com.amur.home.user.service;

import com.amur.home.user.entity.HomeInfo;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface HomeInfoService extends IService<HomeInfo> {
    ServiceResult<Page<HomeInfo>> queryHomeInfo(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize);
}
