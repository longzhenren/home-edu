package com.amur.home.admin.service;

import com.amur.home.schedule.entity.Schedule;
import com.amur.home.user.entity.UserLike;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface ScheduleService extends IService<Schedule> {
    Page<Schedule> querySchedules(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize);
}
