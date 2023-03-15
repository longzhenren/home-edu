package com.amur.home.schedule.service;

import com.amur.home.schedule.entity.Schedule;
import com.amur.home.util.ServiceResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public interface ScheduleService {
    ServiceResult<Long> addSchedule(Long createUserId, Long userId, String title, String content, Date startTime, Date endTime, String location, String remark, String color, Boolean allDay, Boolean canEdit);

    ServiceResult<Void> delSchedule(Long id);

    ServiceResult<Void> updateSchedule(Long id, String title, String content, Date startTime, Date endTime, String location, String remark, String color, Boolean allDay);

    ServiceResult<Schedule> getScheduleInfoById(Long id);

    ServiceResult<List<Schedule>> getScheduleInfoByUserId(Long userid);

    ServiceResult<List<Schedule>> getScheduleInfoByUserIdAndTime(Long userid, String keyword, Date startTime, Date endTime);

    ServiceResult<Void> delScheduleByCourseId(Long courseId);
}
