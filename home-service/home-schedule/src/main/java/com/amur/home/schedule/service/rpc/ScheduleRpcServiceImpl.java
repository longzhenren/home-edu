package com.amur.home.schedule.service.rpc;

import com.amur.home.schedule.converter.ScheduleProtoConverter;
import com.amur.home.schedule.converter.ServiceResultProtoConverter;
import com.amur.home.schedule.entity.Schedule;
import com.amur.home.schedule.mapper.ScheduleMapper;
import com.amur.home.schedule.rpc.ScheduleServiceGrpc;
import com.amur.home.schedule.rpc.ScheduleServiceProto;
import com.amur.home.schedule.rpc.ServiceResultProto;
import com.amur.home.schedule.service.ScheduleService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class ScheduleRpcServiceImpl extends ScheduleServiceGrpc.ScheduleServiceImplBase {

    @Resource
    private ScheduleService scheduleService;

    @Resource
    private ScheduleMapper scheduleMapper;

    private static Timestamp toTimestamp(Date date) {
        return Timestamp.newBuilder().setSeconds(date.toInstant().getEpochSecond()).setNanos(date.toInstant().getNano()).build();
    }

    private static Date toDate(Timestamp timestamp) {
        return Date.from(Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()));
    }

    @Override
    public void addSchedule(ScheduleServiceProto.AddScheduleRequest request, StreamObserver<ScheduleServiceProto.AddScheduleResponse> responseObserver) {
        Long createUserId = request.getCreateUserId();
        Long userId = request.getUserId();
        String title = request.getTitle();
        String content = request.getContent();
        Date startTime = ScheduleProtoConverter.toDate(request.getStartTime());
        Date endTime = ScheduleProtoConverter.toDate(request.getEndTime());
        String location = request.getLocation();
        String remark = request.getRemark();
        String color = request.getColor();
        Boolean allDay = request.getAllDay();
        Boolean canEdit = request.getCanEdit();

        ServiceResult<Long> serviceResult = scheduleService.addSchedule(createUserId, userId, title, content, startTime, endTime, location, remark, color, allDay, canEdit);
        ScheduleServiceProto.AddScheduleResponse response;
        ServiceResultProto.ServiceResult serviceResultProto = ServiceResultProtoConverter.toServiceResultProto(serviceResult);
        if (serviceResult.isSuccess()) {
            response = ScheduleServiceProto.AddScheduleResponse.newBuilder().setResult(serviceResultProto).setId(serviceResult.getData()).build();
        } else {
            response = ScheduleServiceProto.AddScheduleResponse.newBuilder().setResult(serviceResultProto).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delSchedule(ScheduleServiceProto.DelScheduleRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        Long id = request.getId();
        ServiceResult<Void> serviceResult = scheduleService.delSchedule(id);
        ServiceResultProto.ServiceResult serviceResultProto = ServiceResultProtoConverter.toServiceResultProto(serviceResult);
        responseObserver.onNext(serviceResultProto);
        responseObserver.onCompleted();
    }

    @Override
    public void updateSchedule(ScheduleServiceProto.UpdateScheduleRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        Long id = request.getId();
        String title = request.getTitle();
        String content = request.getContent();
        Date startTime = ScheduleProtoConverter.toDate(request.getStartTime());
        Date endTime = ScheduleProtoConverter.toDate(request.getEndTime());
        String location = request.getLocation();
        String remark = request.getRemark();
        String color = request.getColor();
        Boolean allDay = request.getAllDay();

        ServiceResult<Void> serviceResult = scheduleService.updateSchedule(id, title, content, startTime, endTime, location, remark, color, allDay);
        ServiceResultProto.ServiceResult serviceResultProto = ServiceResultProtoConverter.toServiceResultProto(serviceResult);
        responseObserver.onNext(serviceResultProto);
        responseObserver.onCompleted();
    }

    @Override
    public void getScheduleInfoById(ScheduleServiceProto.GetScheduleInfoByIdRequest request, StreamObserver<ScheduleServiceProto.GetScheduleInfoResponse> responseObserver) {
        Long id = request.getId();
        ServiceResult<Schedule> serviceResult = scheduleService.getScheduleInfoById(id);
        if (!serviceResult.isSuccess()) {
            responseObserver.onNext(ScheduleServiceProto.GetScheduleInfoResponse.newBuilder().setResult(ServiceResultProtoConverter.toServiceResultProto(serviceResult)).build());
            responseObserver.onCompleted();
            return;
        }
        ScheduleServiceProto.Schedule schedule = ScheduleProtoConverter.toScheduleProto(serviceResult.getData());

        ScheduleServiceProto.GetScheduleInfoResponse response = ScheduleServiceProto.GetScheduleInfoResponse.newBuilder().setSchedule(schedule).setResult(ServiceResultProtoConverter.toServiceResultProto(serviceResult)).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getScheduleInfoByUserId(ScheduleServiceProto.GetScheduleInfoByUserIdRequest request, StreamObserver<ScheduleServiceProto.GetScheduleListResponse> responseObserver) {
        Long userId = request.getUserId();
        ServiceResult<List<Schedule>> serviceResult = scheduleService.getScheduleInfoByUserId(userId);
        if (!serviceResult.isSuccess()) {
            responseObserver.onNext(ScheduleServiceProto.GetScheduleListResponse.newBuilder().setResult(ServiceResultProtoConverter.toServiceResultProto(serviceResult)).build());
            responseObserver.onCompleted();
            return;
        }
        List<Schedule> schedules = serviceResult.getData();
        List<ScheduleServiceProto.Schedule> scheduleList = schedules.stream().map(ScheduleProtoConverter::toScheduleProto).collect(Collectors.toList());
        ScheduleServiceProto.GetScheduleListResponse response = ScheduleServiceProto.GetScheduleListResponse.newBuilder().addAllSchedules(scheduleList).setResult(ServiceResultProtoConverter.toServiceResultProto(serviceResult)).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getScheduleInfoByUserIdAndTime(ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest request, StreamObserver<ScheduleServiceProto.GetScheduleListResponse> responseObserver) {
        Long userId = request.getUserId();
        String keyword = request.getKeyword();
        Date startTime = ScheduleProtoConverter.toDate(request.getStartTime());
        Date endTime = ScheduleProtoConverter.toDate(request.getEndTime());

        ServiceResult<List<Schedule>> serviceResult = scheduleService.getScheduleInfoByUserIdAndTime(userId, keyword, startTime, endTime);

        if (!serviceResult.isSuccess()) {
            responseObserver.onNext(ScheduleServiceProto.GetScheduleListResponse.newBuilder().setResult(ServiceResultProtoConverter.toServiceResultProto(serviceResult)).build());
            responseObserver.onCompleted();
            return;
        }
        List<Schedule> schedules = serviceResult.getData();
        List<ScheduleServiceProto.Schedule> scheduleList = schedules.stream().map(ScheduleProtoConverter::toScheduleProto).collect(Collectors.toList());
        ScheduleServiceProto.GetScheduleListResponse response = ScheduleServiceProto.GetScheduleListResponse.newBuilder().addAllSchedules(scheduleList).setResult(ServiceResultProtoConverter.toServiceResultProto(serviceResult)).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delScheduleByCourseId(ScheduleServiceProto.DelScheduleByCourseIdRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        scheduleService.delScheduleByCourseId(request.getCourseId());
        ServiceResultProto.ServiceResult response = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void updateScheduleByCourseId(ScheduleServiceProto.UpdateScheduleByCourseIdRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<>();
        Long courseId = request.getCourseId();
        queryWrapper.eq("remark", courseId.toString());
        List<Schedule> list = scheduleMapper.selectList(queryWrapper);
        for (Schedule schedule : list) {
            schedule.setContent(request.getContent());
            schedule.setLocation(request.getLocation());
            schedule.setStartTime(toDate(request.getStartTime()));
            schedule.setEndTime(toDate(request.getEndTime()));
            schedule.setTitle(request.getTitle());
            scheduleMapper.updateById(schedule);
        }
        ServiceResultProto.ServiceResult response = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delScheduleByCourseIdAndUserId(ScheduleServiceProto.DelScheduleByCourseIdAndUserIdRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<>();
        Long courseId = request.getCourseId();
        Long userId = request.getUserId();
        queryWrapper.eq("remark", courseId.toString());
        queryWrapper.eq("userId", userId);
        scheduleMapper.delete(queryWrapper);
        ServiceResultProto.ServiceResult response = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
