package com.amur.home.course.converter;

import com.amur.home.common.Constants;
import com.amur.home.course.entity.*;
import com.amur.home.course.rpc.CourseServiceProto;
import com.google.protobuf.*;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseProtoConverter {
    public static CourseInfo toCourseInfo(CourseServiceProto.CourseInfo courseInfoProto) {
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setId(courseInfoProto.getId());
        courseInfo.setName(courseInfoProto.getName());
        courseInfo.setDescription(courseInfoProto.getDescription());
        courseInfo.setHomeId(courseInfoProto.getHomeId());
        courseInfo.setCoverUrl(courseInfoProto.getCoverUrl());
        courseInfo.setTeacherIds(new HashSet<>(courseInfoProto.getTeacherIdsList()));
        courseInfo.setStudentIds(new HashSet<>(courseInfoProto.getStudentIdsList()));
        courseInfo.setIssueIds(new HashSet<>(courseInfoProto.getIssueIdsList()));
        courseInfo.setStatus(courseInfoProto.getStatus());
        courseInfo.setOpen(courseInfoProto.getOpen());
        courseInfo.setLikeCount(courseInfoProto.getLikeCount());
        courseInfo.setFavCount(courseInfoProto.getFavCount());
        courseInfo.setCommentCount(courseInfoProto.getCommentCount());
        courseInfo.setScore(courseInfoProto.getScore());
        courseInfo.setScoreCount(courseInfoProto.getScoreCount());
        if (courseInfoProto.hasCreateTime()) {
            courseInfo.setCreateTime(toDate(courseInfoProto.getCreateTime()));
        }
        if (courseInfoProto.hasUpdateTime()) {
            courseInfo.setUpdateTime(toDate(courseInfoProto.getUpdateTime()));
        }
        if (courseInfoProto.hasStartTime()) {
            courseInfo.setCreateTime(toDate(courseInfoProto.getStartTime()));
        }
        if (courseInfoProto.hasEndTime()) {
            courseInfo.setUpdateTime(toDate(courseInfoProto.getEndTime()));
        }
        return courseInfo;
    }

    public static CourseList toCourseList(CourseServiceProto.CourseList courseListProto) {
        CourseList courseList = new CourseList();
        courseList.setId(courseListProto.getId());
        courseList.setHomeId(courseListProto.getHomeId());
        courseList.setCourseIds(new HashSet<>(courseListProto.getCourseIdsList()));
        courseList.setTitle(courseListProto.getTitle());
        courseList.setDescription(courseListProto.getDescription());
        courseList.setCoverUrl(courseListProto.getCoverUrl());
        courseList.setOpen(courseListProto.getOpen());
        if (courseListProto.hasCreateTime()) {
            courseList.setCreateTime(toDate(courseListProto.getCreateTime()));
        }
        if (courseListProto.hasUpdateTime()) {
            courseList.setUpdateTime(toDate(courseListProto.getUpdateTime()));
        }
        return courseList;
    }

    public static CourseShare toCourseShare(CourseServiceProto.CourseShare courseShareProto) {
        CourseShare courseShare = new CourseShare();
        courseShare.setToken(courseShareProto.getToken());
        courseShare.setCourseId(courseShareProto.getCourseId());
        courseShare.setInviterId(courseShareProto.getInviterId());
        courseShare.setInviteAs(Constants.InviteAs.valueOf(courseShareProto.getInviteAs()));
        if (courseShareProto.hasExpireTime()) {
            courseShare.setCreateTime(toDate(courseShareProto.getExpireTime()));
        }
        if (courseShareProto.hasCreateTime()) {
            courseShare.setCreateTime(toDate(courseShareProto.getCreateTime()));
        }
        if (courseShareProto.hasUpdateTime()) {
            courseShare.setUpdateTime(toDate(courseShareProto.getUpdateTime()));
        }
        return courseShare;
    }

    public static CourseWare toCourseWare(CourseServiceProto.CourseWare proto) {
        CourseWare entity = new CourseWare();
        entity.setId(proto.getId());
        entity.setCourseId(proto.getCourseId());
        entity.setFileName(proto.getFileName());
        entity.setDescription(proto.getDescription());
        entity.setFileUrl(proto.getFileUrl());
        entity.setCreateTime(toDate(proto.getCreateTime()));
        entity.setUpdateTime(toDate(proto.getUpdateTime()));

        Map<String, Object> additionalProperties = proto.getAdditionalPropertiesMap().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> unpack(entry.getValue())
                ));
        entity.setAdditionalProperties(additionalProperties);

        return entity;
    }

    private static Object unpack(Any any) {
        try {
            return any.unpack(StringValue.class).getValue();
        } catch (InvalidProtocolBufferException e1) {
            try {
                return any.unpack(BoolValue.class).getValue();
            } catch (InvalidProtocolBufferException e2) {
                try {
                    return any.unpack(DoubleValue.class).getValue();
                } catch (InvalidProtocolBufferException e3) {
                    try {
                        return any.unpack(FloatValue.class).getValue();
                    } catch (InvalidProtocolBufferException e4) {
                        try {
                            return any.unpack(Int32Value.class).getValue();
                        } catch (InvalidProtocolBufferException e5) {
                            try {
                                return any.unpack(Int64Value.class).getValue();
                            } catch (InvalidProtocolBufferException e6) {
                                try {
                                    return any.unpack(CourseServiceProto.CourseWare.class);
                                } catch (Exception e7) {
                                    return e7;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static CourseServiceProto.CourseShare toCourseShareProto(CourseShare courseShare) {
        CourseServiceProto.CourseShare.Builder builder = CourseServiceProto.CourseShare.newBuilder();
        builder.setToken(courseShare.getToken());
        builder.setCourseId(courseShare.getCourseId());
        builder.setInviterId(courseShare.getInviterId());
        builder.setInviteAs(courseShare.getInviteAs().getValue());
        if (courseShare.getExpireTime() != null) {
            builder.setExpireTime(toTimestamp(courseShare.getExpireTime()));
        }
        if (courseShare.getUpdateTime() != null) {
            builder.setUpdateTime(toTimestamp(courseShare.getUpdateTime()));
        }
        if (courseShare.getCreateTime() != null) {
            builder.setCreateTime(toTimestamp(courseShare.getCreateTime()));
        }
        return builder.build();
    }


    public static CourseServiceProto.CourseList toCourseListProto(CourseList courseList) {
        CourseServiceProto.CourseList.Builder builder = CourseServiceProto.CourseList.newBuilder();

        builder.setId(courseList.getId());
        builder.setHomeId(courseList.getHomeId());
        builder.addAllCourseIds(courseList.getCourseIds().stream().mapToLong(Long::valueOf).boxed().collect(Collectors.toList()));
        builder.setTitle(courseList.getTitle());
        builder.setDescription(courseList.getDescription());
        builder.setCoverUrl(courseList.getCoverUrl());
        builder.setOpen(courseList.isOpen());
        if (courseList.getCreateTime() != null) {
            builder.setCreateTime(toTimestamp(courseList.getCreateTime()));
        }
        if (courseList.getUpdateTime() != null) {
            builder.setUpdateTime(toTimestamp(courseList.getUpdateTime()));
        }
        return builder.build();
    }

    public static CourseServiceProto.CourseInfo toCourseInfoProto(CourseInfo courseInfo) {
        CourseServiceProto.CourseInfo.Builder builder = CourseServiceProto.CourseInfo.newBuilder();
        builder.setId(courseInfo.getId());
        builder.setName(courseInfo.getName());
        builder.setDescription(courseInfo.getDescription());
        builder.setHomeId(courseInfo.getHomeId());
        builder.setCoverUrl(courseInfo.getCoverUrl());
        builder.addAllTeacherIds(courseInfo.getTeacherIds());
        builder.addAllStudentIds(courseInfo.getStudentIds());
        builder.addAllIssueIds(courseInfo.getIssueIds());
        builder.setStatus(courseInfo.getStatus());
        builder.setStartTime(Timestamp.newBuilder().setSeconds(courseInfo.getStartTime().getTime() / 1000));
        builder.setEndTime(Timestamp.newBuilder().setSeconds(courseInfo.getEndTime().getTime() / 1000));
        builder.setOpen(courseInfo.isOpen());
        builder.setLikeCount(courseInfo.getLikeCount());
        builder.setFavCount(courseInfo.getFavCount());
        builder.setCommentCount(courseInfo.getCommentCount());
        builder.setScore(courseInfo.getScore());
        builder.setScoreCount(courseInfo.getScoreCount());
        if (courseInfo.getCreateTime() != null) {
            builder.setCreateTime(toTimestamp(courseInfo.getCreateTime()));
        }
        if (courseInfo.getUpdateTime() != null) {
            builder.setUpdateTime(toTimestamp(courseInfo.getUpdateTime()));
        }
        return builder.build();
    }

    public static CourseServiceProto.CourseComment toCourseCommentProto(CourseComment courseComment) {
        CourseServiceProto.CourseComment.Builder builder = CourseServiceProto.CourseComment.newBuilder();
        builder.setId(courseComment.getId()).setCourseId(courseComment.getCourseId()).setUserId(courseComment.getUserId()).setContent(courseComment.getContent()).setReply(courseComment.getReply()).setReplyUserId(courseComment.getReplyUserId()).setReplyTime(courseComment.getReplyTime()).setLikeCount(courseComment.getLikeCount()).setScore(courseComment.getScore());
        if (courseComment.getCreateTime() != null) {
            builder.setCreateTime(toTimestamp(courseComment.getCreateTime()));
        }
        if (courseComment.getUpdateTime() != null) {
            builder.setUpdateTime(toTimestamp(courseComment.getUpdateTime()));
        }

        return builder.build();
    }

    public static CourseComment toCourseComment(CourseServiceProto.CourseComment courseCommentProto) {
        CourseComment courseComment = new CourseComment();
        courseComment.setId(courseCommentProto.getId());
        courseComment.setCourseId(courseCommentProto.getCourseId());
        courseComment.setUserId(courseCommentProto.getUserId());
        courseComment.setContent(courseCommentProto.getContent());
        courseComment.setReply(courseCommentProto.getReply());
        courseComment.setReplyUserId(courseCommentProto.getReplyUserId());
        courseComment.setReplyTime(courseCommentProto.getReplyTime());
        courseComment.setLikeCount(courseCommentProto.getLikeCount());
        courseComment.setScore(courseCommentProto.getScore());
        if (courseCommentProto.hasCreateTime()) {
            courseComment.setCreateTime(toDate(courseCommentProto.getCreateTime()));
        }

        if (courseCommentProto.hasUpdateTime()) {
            courseComment.setUpdateTime(toDate(courseCommentProto.getUpdateTime()));
        }
        return courseComment;
    }

    private static Timestamp toTimestamp(Date date) {
        return Timestamp.newBuilder().setSeconds(date.toInstant().getEpochSecond()).setNanos(date.toInstant().getNano()).build();
    }

    private static Date toDate(Timestamp timestamp) {
        return Date.from(Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()));
    }


//    public static CourseServiceProto.CourseInfo.Builder toProtoBuilder(CourseInfo courseInfo) {
//        CourseServiceProto.CourseInfo.Builder builder = CourseServiceProto.CourseInfo.newBuilder();
//
//        Field[] fields = CourseInfo.class.getDeclaredFields();
//
//        for (Field field : fields) {
//            try {
//                field.setAccessible(true);
//                Object value = field.get(courseInfo);
//
//                if (value != null) {
//                    if (field.getName().equals("teacherIds") || field.getName().equals("studentIds") || field.getName().equals("issueIds")) {
//                        builder.addAllTeacherIds((Iterable<Long>) value);
//                    } else {
//                        String fieldName = field.getName().replaceAll("([A-Z])", "_$1").toLowerCase();
//                        switch (fieldName) {
//                            case "start_time":
//                                builder.setStartTime((com.google.protobuf.Timestamp) value);
//                                break;
//                            case "end_time":
//                                builder.setEndTime((com.google.protobuf.Timestamp) value);
//                                break;
//                            case "like_count":
//                                builder.setLikeCount((Long) value);
//                                break;
//                            case "fav_count":
//                                builder.setFavCount((Long) value);
//                                break;
//                            case "comment_count":
//                                builder.setCommentCount((Long) value);
//                                break;
//                            case "score_count":
//                                builder.setScoreCount((Long) value);
//                                break;
//                            case "create_time":
//                                builder.setCreateTime((com.google.protobuf.Timestamp) value);
//                                break;
//                            case "update_time":
//                                builder.setUpdateTime((com.google.protobuf.Timestamp) value);
//                                break;
//                            default:
//                                builder.setField(CourseServiceProto.CourseInfo.getDescriptor().findFieldByName(fieldName), value);
//                        }
//                    }
//                }
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return builder;
//    }
//
//    public static CourseInfo fromProto(CourseServiceProto.CourseInfo courseInfoProto) {
//        CourseInfo courseInfo = new CourseInfo();
//
//        Field[] fields = CourseInfo.class.getDeclaredFields();
//
//        for (Field field : fields) {
//            try {
//                field.setAccessible(true);
//                String fieldName = field.getName().replaceAll("([A-Z])", "_$1").toLowerCase();
//                Object value;
//
//                if (field.getName().equals("teacherIds") || field.getName().equals("studentIds") || field.getName().equals("issueIds")) {
//                    value = new HashSet<>(courseInfoProto.getTeacherIdsList());
//                } else {
//                    if (fieldName.equals("start_time")) {
//                        value = courseInfoProto.getStartTime();
//                    } else if (fieldName.equals("end_time")) {
//                        value = courseInfoProto.getEndTime();
//                    } else if (fieldName.equals("like_count")) {
//                        value = courseInfoProto.getLikeCount();
//                    } else if (fieldName.equals("fav_count")) {
//                        value = courseInfoProto.getFavCount();
//                    } else if (fieldName.equals("comment_count")) {
//                        value = courseInfoProto.getCommentCount();
//                    } else if (fieldName.equals("score_count")) {
//                        value = courseInfoProto.getScoreCount();
//                    } else if (fieldName.equals("create_time")) {
//                        value = courseInfoProto.getCreateTime();
//                    } else if (fieldName.equals("update_time")) {
//                        value = courseInfoProto.getUpdateTime();
//                    } else {
//                        value = courseInfoProto.getField(CourseServiceProto.CourseInfo.getDescriptor().findFieldByName(fieldName));
//                    }
//                }
//
//                if (value != null) {
//                    field.set(courseInfo, value);
//                }
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return courseInfo;
//    }
}
    
