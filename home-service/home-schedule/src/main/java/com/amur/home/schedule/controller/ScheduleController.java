package com.amur.home.schedule.controller;

import com.amur.home.schedule.entity.Schedule;
import com.amur.home.schedule.service.ScheduleService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Tag(name = "日程管理")
@RestController("/schedule")
public class ScheduleController {
    @Resource
    private ScheduleService scheduleService;

    @Operation(summary = "添加日程")
    @PostMapping("/add")
    @Parameters({@Parameter(name = "title", description = "日程标题", required = true), @Parameter(name = "content", description = "日程内容", required = true), @Parameter(name = "startTime", description = "开始时间", required = true), @Parameter(name = "endTime", description = "结束时间", required = true)})
    public ResponseWrapper<Long> addSchedule(Long createUserId, Long userId, String title, String content, Date startTime, Date endTime, String location, String remark, String color, Boolean allDay, Boolean canEdit) {
        ServiceResult<Long> res = scheduleService.addSchedule(createUserId, userId, title, content, startTime, endTime, location, remark, color, allDay, canEdit);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "删除日程")
    @PostMapping("/del")
    @Parameters({@Parameter(name = "id", description = "日程id", required = true)})
    public ResponseWrapper<Void> delSchedule(Long id) {
        ServiceResult<Void> res = scheduleService.delSchedule(id);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "修改日程")
    @PostMapping("/update")
    @Parameters({@Parameter(name = "id", description = "日程id", required = true), @Parameter(name = "title", description = "日程标题", required = true), @Parameter(name = "content", description = "日程内容", required = true), @Parameter(name = "startTime", description = "开始时间", required = true), @Parameter(name = "endTime", description = "结束时间", required = true)})
    public ResponseWrapper<Void> updateSchedule(Long id, String title, String content, Date startTime, Date endTime, String location, String remark, String color, Boolean allDay) {
        ServiceResult<Void> res = scheduleService.updateSchedule(id, title, content, startTime, endTime, location, remark, color, allDay);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "日程详细")
    @PostMapping("/info/id")
    @Parameters({@Parameter(name = "id", description = "日程id", required = true)})
    public ResponseWrapper<Schedule> getScheduleInfoById(Long id) {
        ServiceResult<Schedule> res = scheduleService.getScheduleInfoById(id);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "查询用户日程")
    @PostMapping("/info/user")
    @Parameters({@Parameter(name = "userid", description = "用户id", required = true)})
    public ResponseWrapper<List<Schedule>> getScheduleInfoByUserId(Long userid) {
        ServiceResult<List<Schedule>> res = scheduleService.getScheduleInfoByUserId(userid);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "查询指定时间范围内的用户日程")
    @PostMapping("/info/user/time")
    @Parameters({@Parameter(name = "userid", description = "用户id", required = true), @Parameter(name = "keyword", description = "关键字", required = true), @Parameter(name = "startTime", description = "开始时间", required = true), @Parameter(name = "endTime", description = "结束时间", required = true)})
    public ResponseWrapper<List<Schedule>> getScheduleInfoByUserIdAndTime(Long userid, String keyword, Date startTime, Date endTime) {
        ServiceResult<List<Schedule>> res = scheduleService.getScheduleInfoByUserIdAndTime(userid, keyword, startTime, endTime);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

}
