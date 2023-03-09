package com.amur.home.course.client;

import com.amur.home.schedule.rpc.ScheduleServiceGrpc;
import com.amur.home.schedule.rpc.ScheduleServiceProto;
import com.amur.home.schedule.rpc.ServiceResultProto;
import com.amur.home.util.ServiceResult;
import com.google.protobuf.Timestamp;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
@Slf4j
public class ScheduleGrpcClient {
    @GrpcClient("home-schedule")
    private ScheduleServiceGrpc.ScheduleServiceBlockingStub scheduleServiceBlockingStub;

    private static Timestamp toTimestamp(Date date) {
        return Timestamp.newBuilder().setSeconds(date.toInstant().getEpochSecond()).setNanos(date.toInstant().getNano()).build();
    }

    private static Date toDate(Timestamp timestamp) {
        return Date.from(Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()));
    }

    public ServiceResult<?> addSchedule(Long creatorId, Long userId, String title, String content, Date startTime, Date endTime, String location, String remark, String color, Boolean allDay, Boolean canEdit) {
        ScheduleServiceProto.AddScheduleRequest request = ScheduleServiceProto.AddScheduleRequest.newBuilder().setCreateUserId(creatorId).setUserId(userId).setAllDay(allDay).setCanEdit(canEdit).setLocation(location).setTitle(title).setContent(content).setRemark(remark).setColor(color).setStartTime(toTimestamp(startTime)).setEndTime(toTimestamp(endTime)).build();
        ScheduleServiceProto.AddScheduleResponse response = scheduleServiceBlockingStub.addSchedule(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(response.getResult().getMessage());
        }
    }

    public ServiceResult<?> updateSchedule(Long id, String title, String content, Date startTime, Date endTime, String location, String remark, String color, Boolean allDay) {
        ScheduleServiceProto.UpdateScheduleRequest request = ScheduleServiceProto.UpdateScheduleRequest.newBuilder().setId(id).setAllDay(allDay).setLocation(location).setTitle(title).setContent(content).setRemark(remark).setColor(color).setStartTime(toTimestamp(startTime)).setEndTime(toTimestamp(endTime)).build();
        ServiceResultProto.ServiceResult response = scheduleServiceBlockingStub.updateSchedule(request);
        if (response.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(response.getMessage());
        }
    }

    public ServiceResult<?> deleteSchedule(Long id) {
        ScheduleServiceProto.DelScheduleRequest request = ScheduleServiceProto.DelScheduleRequest.newBuilder().setId(id).build();
        ServiceResultProto.ServiceResult response = scheduleServiceBlockingStub.delSchedule(request);
        if (response.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(response.getMessage());
        }
    }

    public ServiceResult<?> deleteScheduleByCourseId(Long courseId) {
        ScheduleServiceProto.DelScheduleByCourseIdRequest request = ScheduleServiceProto.DelScheduleByCourseIdRequest.newBuilder().setCourseId(courseId).build();
        ServiceResultProto.ServiceResult response = scheduleServiceBlockingStub.delScheduleByCourseId(request);
        if (response.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(response.getMessage());
        }
    }

    public ServiceResult<?> updateScheduleByCourseId(Long courseId, String title, String content, String location, Date startTime, Date endTime) {
        ScheduleServiceProto.UpdateScheduleByCourseIdRequest request = ScheduleServiceProto.UpdateScheduleByCourseIdRequest.newBuilder().setCourseId(courseId).setContent(content).setStartTime(toTimestamp(startTime)).setEndTime(toTimestamp(endTime)).setTitle(title).setLocation(location).build();
        ServiceResultProto.ServiceResult response = scheduleServiceBlockingStub.updateScheduleByCourseId(request);
        if (response.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(response.getMessage());
        }
    }

    public ServiceResult<?> delScheduleByCourseIdAndUserId(Long courseId,Long userId){
        ScheduleServiceProto.DelScheduleByCourseIdAndUserIdRequest request = ScheduleServiceProto.DelScheduleByCourseIdAndUserIdRequest.newBuilder().setCourseId(courseId).setUserId(userId).build();
        ServiceResultProto.ServiceResult response = scheduleServiceBlockingStub.updateScheduleByCourseId(request);
        if (response.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(response.getMessage());
        }
    }
}
