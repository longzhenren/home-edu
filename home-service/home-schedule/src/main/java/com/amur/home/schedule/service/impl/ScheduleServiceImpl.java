package com.amur.home.schedule.service.impl;

import com.amur.home.common.Constants;
import com.amur.home.schedule.client.TinyIdGrpcClient;
import com.amur.home.schedule.entity.Schedule;
import com.amur.home.schedule.mapper.ScheduleMapper;
import com.amur.home.schedule.service.ScheduleService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;

    @Resource
    private TinyIdGrpcClient tinyIdGrpcClient;

    @Override
    public ServiceResult<Long> addSchedule(Long createUserId, Long userId, String title, String content, Date startTime, Date endTime, String location, String remark, String color, Boolean allDay, Boolean canEdit) {
        Schedule schedule = new Schedule();
//        if (StpUtil.getLoginId() != createUserId) {
//            return ServiceResult.fail("参数非法:不匹配的创建者ID");
//        }
        schedule.setId(tinyIdGrpcClient.getNextId(Constants.TableName.SCHEDULE.getDesc()).getData());
        schedule.setCreateUserId(createUserId);
        schedule.setUserId(userId);
        schedule.setTitle(title);
        schedule.setContent(content);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setLocation(location);
        schedule.setRemark(remark);
        schedule.setColor(color);
        schedule.setAllDay(allDay);
        schedule.setCanEdit(canEdit);
        if (scheduleMapper.insert(schedule) > 0) {
            return ServiceResult.success(schedule.getId());
        } else {
            return ServiceResult.fail("添加日程失败");
        }
    }

    @Override
    public ServiceResult<Void> delSchedule(Long id) {
        int result = scheduleMapper.deleteById(id);
        if (result == 0) {
            return ServiceResult.fail("删除日程失败");
        }
        return ServiceResult.success();
    }

    @Override
    public ServiceResult<Void> updateSchedule(Long id, String title, String content, Date startTime, Date endTime, String location, String remark, String color, Boolean allDay) {
        Schedule schedule = scheduleMapper.selectById(id);
        if (schedule == null) {
            return ServiceResult.fail("日程不存在");
        }
        if (!schedule.getCanEdit()) {
            return ServiceResult.fail("日程不可编辑");
        }
//        if (StpUtil.getLoginId() != schedule.getCreateUserId()) {
//            return ServiceResult.fail("无权限编辑日程");
//        }
        schedule.setTitle(title);
        schedule.setContent(content);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setLocation(location);
        schedule.setRemark(remark);
        schedule.setColor(color);
        schedule.setAllDay(allDay);
        int result = scheduleMapper.updateById(schedule);
        if (result == 0) {
            return ServiceResult.fail("更新日程失败");
        }
        return ServiceResult.success();
    }

    @Override
    public ServiceResult<Schedule> getScheduleInfoById(Long id) {
        Schedule schedule = scheduleMapper.selectById(id);
        if (schedule == null) {
            return ServiceResult.fail("日程不存在");
        }
        return ServiceResult.success(schedule);
    }

    @Override
    public ServiceResult<List<Schedule>> getScheduleInfoByUserId(Long userId) {
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).orderByDesc("start_time").orderByDesc("end_time");
        List<Schedule> schedules = scheduleMapper.selectList(queryWrapper);
        if (schedules == null || schedules.isEmpty()) {
            return ServiceResult.fail("用户当前日程列表为空");
        }
        return ServiceResult.success(schedules);
    }

    @Override
    public ServiceResult<List<Schedule>> getScheduleInfoByUserIdAndTime(Long userId, String keyword, Date startTime, Date endTime) {
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        if (StringUtils.isNotBlank(keyword)) {
            queryWrapper.and(qw -> qw.like("title", keyword).or().like("content", keyword));
        }
        if (startTime != null) {
            queryWrapper.ge("start_time", startTime);
        }
        if (endTime != null) {
            queryWrapper.le("end_time", endTime);
        }
        List<Schedule> schedules = scheduleMapper.selectList(queryWrapper);
        if (schedules == null || schedules.isEmpty()) {
            return ServiceResult.fail("用户当前日程列表为空");
        }
        return ServiceResult.success(schedules);
    }
}
