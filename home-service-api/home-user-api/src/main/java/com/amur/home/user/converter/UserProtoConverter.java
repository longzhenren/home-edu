package com.amur.home.user.converter;

import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.rpc.UserServiceProto;
import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.util.Date;

public class UserProtoConverter {

    public static UserInfo toUserInfo(UserServiceProto.UserInfo proto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(proto.getId());
        userInfo.setName(proto.getName());
        userInfo.setDescription(proto.getDescription());
        userInfo.setPhone(proto.getPhone());
        userInfo.setEmail(proto.getEmail());
        userInfo.setAvatarUrl(proto.getAvatarUrl());
        userInfo.setHomeId(proto.getId());
        userInfo.setSex(proto.getSex());
        userInfo.setAge(proto.getAge());
        userInfo.setCreateTime(toDate(proto.getCreateTime()));
        userInfo.setUpdateTime(toDate(proto.getUpdateTime()));
        return userInfo;
    }

    public static UserServiceProto.UserInfo toUserInfoProto(UserInfo userInfo) {
        UserServiceProto.UserInfo.Builder builder = UserServiceProto.UserInfo.newBuilder();
        builder.setId(userInfo.getId());
        builder.setName(userInfo.getName());
        builder.setDescription(userInfo.getDescription() == null ? "" : userInfo.getDescription());
        builder.setPhone(userInfo.getPhone() == null ? "" : userInfo.getPhone());
        builder.setEmail(userInfo.getEmail() == null ? "" : userInfo.getEmail());
        builder.setAvatarUrl(userInfo.getAvatarUrl() == null ? "" : userInfo.getAvatarUrl());
        builder.setId(userInfo.getHomeId() == null ? 0 : userInfo.getHomeId());
        builder.setSex(userInfo.getSex() == null ? "" : userInfo.getSex());
        builder.setAge(userInfo.getAge() == null ? 0 : userInfo.getAge());
        builder.setCreateTime(toTimestamp(userInfo.getCreateTime() == null ? new Date() : userInfo.getCreateTime()));
        builder.setUpdateTime(toTimestamp(userInfo.getUpdateTime() == null ? new Date() : userInfo.getUpdateTime()));
        return builder.build();
    }

    private static Timestamp toTimestamp(Date date) {
        return Timestamp.newBuilder().setSeconds(date.toInstant().getEpochSecond()).setNanos(date.toInstant().getNano()).build();
    }

    private static Date toDate(Timestamp timestamp) {
        return Date.from(Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()));
    }
}
