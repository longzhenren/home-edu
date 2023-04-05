package com.amur.home.admin.service.impl;

import com.amur.home.admin.mapper.ScheduleMapper;
import com.amur.home.admin.service.ScheduleService;
import com.amur.home.schedule.entity.Schedule;
import com.amur.home.util.QueryUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule> implements ScheduleService {
    @Resource
    private ScheduleMapper ScheduleMapper;

    @Override
    public Page<Schedule> querySchedules(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize) {
        QueryWrapper<Schedule> queryWrapper = QueryUtil.buildQueryWrapper(params, sortField, sortOrder);
        Page<Schedule> page = new Page<>(pageNumber, pageSize);
        return ScheduleMapper.selectPage(page, queryWrapper);
    }
}
