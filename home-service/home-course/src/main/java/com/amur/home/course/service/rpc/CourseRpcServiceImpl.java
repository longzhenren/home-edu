package com.amur.home.course.service.rpc;

import com.amur.home.common.Constants;
import com.amur.home.course.converter.CourseProtoConverter;
import com.amur.home.course.entity.CourseComment;
import com.amur.home.course.entity.CourseInfo;
import com.amur.home.course.entity.CourseList;
import com.amur.home.course.mapper.CourseCommentMapper;
import com.amur.home.course.mapper.CourseInfoMapper;
import com.amur.home.course.mapper.CourseListMapper;
import com.amur.home.course.mapper.CourseShareMapper;
import com.amur.home.course.rpc.CourseServiceGrpc;
import com.amur.home.course.rpc.CourseServiceProto;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@GrpcService
public class CourseRpcServiceImpl extends CourseServiceGrpc.CourseServiceImplBase {

    @Resource
    private CourseInfoMapper courseInfoMapper;

    @Resource
    private CourseListMapper courseListMapper;

    @Resource
    private CourseShareMapper courseShareMapper;

    @Resource
    private CourseCommentMapper courseCommentMapper;


    @Override
    public void createCourse(CourseServiceProto.CourseInfo request, StreamObserver<CourseServiceProto.CreateCourseResponse> responseObserver) {
        CourseInfo course = CourseProtoConverter.toCourseInfo(request);
        courseInfoMapper.insert(course);
        CourseServiceProto.CreateCourseResponse response = CourseServiceProto.CreateCourseResponse.newBuilder().setCourseId(course.getId()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateCourse(CourseServiceProto.UpdateCourseRequest request, StreamObserver<CourseServiceProto.UpdateCourseResponse> responseObserver) {
        CourseInfo course = CourseProtoConverter.toCourseInfo(request.getCourseInfo());
        courseInfoMapper.updateById(course);
        CourseServiceProto.UpdateCourseResponse response = CourseServiceProto.UpdateCourseResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void createCourseList(CourseServiceProto.CourseList request, StreamObserver<CourseServiceProto.CreateCourseListResponse> responseObserver) {
        CourseList courseList = CourseProtoConverter.toCourseList(request);
        courseListMapper.insert(courseList);
        CourseServiceProto.CreateCourseListResponse response = CourseServiceProto.CreateCourseListResponse.newBuilder().setListId(courseList.getId()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCourseList(CourseServiceProto.DeleteCourseListRequest request, StreamObserver<CourseServiceProto.DeleteCourseListResponse> responseObserver) {
        courseListMapper.deleteById(request.getListId());
        CourseServiceProto.DeleteCourseListResponse response = CourseServiceProto.DeleteCourseListResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateCourseList(CourseServiceProto.UpdateCourseListRequest request, StreamObserver<CourseServiceProto.UpdateCourseListResponse> responseObserver) {
        CourseList courseList = CourseProtoConverter.toCourseList(request.getCourseList());
        courseListMapper.updateById(courseList);
        CourseServiceProto.UpdateCourseListResponse response = CourseServiceProto.UpdateCourseListResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

//    @Override
//    public void updateCourseAccess(CourseServiceProto.UpdateCourseAccessRequest request, StreamObserver<CourseServiceProto.UpdateCourseAccessResponse> responseObserver) {
//        CourseInfo course = courseInfoMapper.selectById(request.getCourseId());
//        if (course == null) {
//            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
//            return;
//        }
//        course.setAccess(request.getAccess());
//        courseInfoMapper.updateById(course);
//        CourseServiceProto.UpdateCourseAccessResponse response = CourseServiceProto.UpdateCourseAccessResponse.newBuilder().setSuccess(true).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }

    @Override
    public void getCourseInfo(CourseServiceProto.GetCourseInfoRequest request, StreamObserver<CourseServiceProto.GetCourseInfoResponse> responseObserver) {
        CourseInfo course = courseInfoMapper.selectById(request.getCourseId());
        if (course == null) {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return;
        }
        CourseServiceProto.CourseInfo courseInfo = CourseProtoConverter.toCourseInfoProto(course);
        CourseServiceProto.GetCourseInfoResponse response = CourseServiceProto.GetCourseInfoResponse.newBuilder().setCourseInfo(courseInfo).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void rankCourse(CourseServiceProto.RankCourseRequest request, StreamObserver<CourseServiceProto.RankCourseResponse> responseObserver) {
        CourseInfo course = courseInfoMapper.selectById(request.getCourseId());
        if (course == null) {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return;
        }
        CourseServiceProto.RankCourseResponse response = CourseServiceProto.RankCourseResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateComment(CourseServiceProto.UpdateCommentRequest request, StreamObserver<CourseServiceProto.UpdateCommentResponse> responseObserver) {
        CourseInfo course = courseInfoMapper.selectById(request.getCourseId());
        if (course == null) {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return;
        }
        CourseComment courseComment = courseCommentMapper.selectById(request.getCommentId());
        if (courseComment == null) {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return;
        }
        courseComment.setContent(request.getComment());
        courseCommentMapper.updateById(courseComment);
        CourseServiceProto.UpdateCommentResponse response = CourseServiceProto.UpdateCommentResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void createComment(CourseServiceProto.CreateCommentRequest request, StreamObserver<CourseServiceProto.CreateCommentResponse> responseObserver) {
        CourseInfo course = courseInfoMapper.selectById(request.getCourseId());
        if (course == null) {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return;
        }
        CourseComment courseComment = new CourseComment();
        courseComment.setCourseId(request.getCourseId());
        courseComment.setUserId(request.getUserId());
        courseComment.setContent(request.getComment());
        if (courseCommentMapper.insert(courseComment) > 0) {
            course.setCommentCount(course.getCommentCount() + 1);
            courseInfoMapper.updateById(course);
        } else {
            responseObserver.onError(Status.INTERNAL.asRuntimeException());
            return;
        }
        CourseServiceProto.CreateCommentResponse response = CourseServiceProto.CreateCommentResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void likeCourse(CourseServiceProto.LikeCourseRequest request, StreamObserver<CourseServiceProto.LikeCourseResponse> responseObserver) {
        CourseInfo course = courseInfoMapper.selectById(request.getCourseId());
        if (course == null) {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return;
        }
        course.setLikeCount(course.getLikeCount() + 1);
        courseInfoMapper.updateById(course);
        CourseServiceProto.LikeCourseResponse response = CourseServiceProto.LikeCourseResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void listAllCourses(CourseServiceProto.ListAllCoursesRequest request, StreamObserver<CourseServiceProto.ListAllCoursesResponse> responseObserver) {
        long limit = request.getLimit();
        long offset = request.getOffset();
        List<CourseInfo> courses = courseInfoMapper.selectList(new QueryWrapper<CourseInfo>().orderByDesc("create_time").last("LIMIT " + offset + "," + limit));
        List<CourseServiceProto.CourseInfo> courseInfos = new ArrayList<>();
        for (CourseInfo course : courses) {
            courseInfos.add(CourseProtoConverter.toCourseInfoProto(course));
        }
        CourseServiceProto.ListAllCoursesResponse response = CourseServiceProto.ListAllCoursesResponse.newBuilder().addAllCourseInfo(courseInfos).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void searchCourses(CourseServiceProto.SearchCoursesRequest request, StreamObserver<CourseServiceProto.SearchCoursesResponse> responseObserver) {
        String keyword = request.getKeyword();
        long limit = request.getLimit();
        long offset = request.getOffset();
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", keyword).or().like("description", keyword).orderByDesc("create_time").last("LIMIT " + offset + "," + limit);
        List<CourseInfo> courses = courseInfoMapper.selectList(queryWrapper);
        List<CourseServiceProto.CourseInfo> courseInfoProtos = new ArrayList<>();
        for (CourseInfo course : courses) {
            courseInfoProtos.add(CourseProtoConverter.toCourseInfoProto(course));
        }
        CourseServiceProto.SearchCoursesResponse response = CourseServiceProto.SearchCoursesResponse.newBuilder().addAllCourseInfo(courseInfoProtos).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCourse(CourseServiceProto.DeleteCourseRequest request, StreamObserver<CourseServiceProto.DeleteCourseResponse> responseObserver) {
        CourseInfo course = courseInfoMapper.selectById(request.getCourseId());
        if (course == null) {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return;
        }
        courseInfoMapper.deleteById(course.getId());
        CourseServiceProto.DeleteCourseResponse response = CourseServiceProto.DeleteCourseResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void favCourse(CourseServiceProto.FavCourseRequest request, StreamObserver<CourseServiceProto.FavCourseResponse> responseObserver) {
        CourseInfo course = courseInfoMapper.selectById(request.getCourseId());
        if (course == null) {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return;
        }
        course.setFavCount(course.getFavCount() + 1);
        courseInfoMapper.updateById(course);
        //TODO: 将课程添加到用户收藏列表
        CourseServiceProto.FavCourseResponse response = CourseServiceProto.FavCourseResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void joinCourseByShareToken(CourseServiceProto.JoinCourseByShareTokenRequest request, StreamObserver<CourseServiceProto.JoinCourseByShareTokenResponse> responseObserver) {
        super.joinCourseByShareToken(request, responseObserver);
    }


    @Override
    public void generateShareToken(CourseServiceProto.GenerateShareTokenRequest request, StreamObserver<CourseServiceProto.GenerateShareTokenResponse> responseObserver) {
        super.generateShareToken(request, responseObserver);
    }


    @Override
    public void getShareInfo(CourseServiceProto.GetShareInfoRequest request, StreamObserver<CourseServiceProto.GetShareInfoResponse> responseObserver) {
        super.getShareInfo(request, responseObserver);
    }


    @Override
    public void deleteShareToken(CourseServiceProto.DeleteShareTokenRequest request, StreamObserver<CourseServiceProto.DeleteShareTokenResponse> responseObserver) {
        super.deleteShareToken(request, responseObserver);
    }


    @Override
    public void hasJoined(CourseServiceProto.HasJoinedRequest request, StreamObserver<CourseServiceProto.HasJoinedResponse> responseObserver) {
        super.hasJoined(request, responseObserver);
    }


    @Override
    public void listShareInfoByUserId(CourseServiceProto.ListShareInfoByUserIdRequest request, StreamObserver<CourseServiceProto.ListShareInfoByUserIdResponse> responseObserver) {
        super.listShareInfoByUserId(request, responseObserver);
    }


    @Override
    public void cancelShareToken(CourseServiceProto.CancelShareTokenRequest request, StreamObserver<CourseServiceProto.CancelShareTokenResponse> responseObserver) {
        super.cancelShareToken(request, responseObserver);
    }



    @Override
    public void listCourseByUserId(CourseServiceProto.ListCourseByUserIdRequest request, StreamObserver<CourseServiceProto.ListCourseByUserIdResponse> responseObserver) {
        super.listCourseByUserId(request, responseObserver);
    }


    @Override
    public void listCourseByListId(CourseServiceProto.ListCourseByListIdRequest request, StreamObserver<CourseServiceProto.ListCourseByListIdResponse> responseObserver) {
        super.listCourseByListId(request, responseObserver);
    }


}

