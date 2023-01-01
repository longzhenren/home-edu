package com.amur.home.schedule.converter;

import com.amur.home.schedule.entity.Schedule;
import com.amur.home.schedule.rpc.ScheduleServiceProto;
import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.util.Date;

public class ScheduleProtoConverter {

    public static ScheduleServiceProto.Schedule toScheduleProto(Schedule entity) {
        ScheduleServiceProto.Schedule.Builder builder = ScheduleServiceProto.Schedule.newBuilder();
        builder.setId(entity.getId());
        builder.setUserId(entity.getUserId());
        builder.setCreateUserId(entity.getCreateUserId());
        builder.setTitle(entity.getTitle());
        builder.setContent(entity.getContent());
        builder.setLocation(entity.getLocation());
        builder.setRemark(entity.getRemark());
        builder.setColor(entity.getColor());
        builder.setAllDay(entity.getAllDay());
        builder.setCanEdit(entity.getCanEdit());
        builder.setStartTime(toTimestamp(entity.getStartTime()));
        builder.setEndTime(toTimestamp(entity.getEndTime()));
        builder.setCreateTime(toTimestamp(entity.getCreateTime()));
        builder.setUpdateTime(toTimestamp(entity.getUpdateTime()));
        return builder.build();
    }

    public static Schedule toSchedule(ScheduleServiceProto.Schedule rpc) {
        Schedule entity = new Schedule();
        entity.setId(rpc.getId());
        entity.setUserId(rpc.getUserId());
        entity.setCreateUserId(rpc.getCreateUserId());
        entity.setTitle(rpc.getTitle());
        entity.setContent(rpc.getContent());
        entity.setLocation(rpc.getLocation());
        entity.setRemark(rpc.getRemark());
        entity.setColor(rpc.getColor());
        entity.setAllDay(rpc.getAllDay());
        entity.setCanEdit(rpc.getCanEdit());
        entity.setStartTime(toDate(rpc.getStartTime()));
        entity.setEndTime(toDate(rpc.getEndTime()));
        entity.setCreateTime(toDate(rpc.getCreateTime()));
        entity.setUpdateTime(toDate(rpc.getUpdateTime()));
        return entity;
    }

    public static Timestamp toTimestamp(Date date) {
        return Timestamp.newBuilder().setSeconds(date.toInstant().getEpochSecond()).setNanos(date.toInstant().getNano()).build();
    }

    public static Date toDate(Timestamp timestamp) {
        return Date.from(Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()));
    }
}
