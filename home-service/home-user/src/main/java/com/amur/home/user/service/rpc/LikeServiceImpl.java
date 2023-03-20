package com.amur.home.user.service.rpc;

import com.amur.home.user.entity.UserLike;
import com.amur.home.user.mapper.UserLikeMapper;
import com.amur.home.user.rpc.LikeServiceGrpc;
import com.amur.home.user.rpc.LikeServiceProto;
import com.amur.home.user.rpc.ServiceResultProto;
import io.grpc.stub.StreamObserver;

import javax.annotation.Resource;

public class LikeServiceImpl extends LikeServiceGrpc.LikeServiceImplBase {
    @Resource
    private UserLikeMapper userLikeMapper;

    @Override
    public void getLikeCourses(LikeServiceProto.GetLikeCoursesRequest request, StreamObserver<LikeServiceProto.GetLikeCoursesResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        if (userLike == null) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).build();
            LikeServiceProto.GetLikeCoursesResponse response = LikeServiceProto.GetLikeCoursesResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.GetLikeCoursesResponse response = LikeServiceProto.GetLikeCoursesResponse.newBuilder().addAllCourseIds(userLike.getCourseIds()).setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void addLikeCourse(LikeServiceProto.AddLikeCourseRequest request, StreamObserver<LikeServiceProto.AddLikeCourseResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getCourseIds().add(request.getCourseId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("添加失败").build();
            LikeServiceProto.AddLikeCourseResponse response = LikeServiceProto.AddLikeCourseResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.AddLikeCourseResponse response = LikeServiceProto.AddLikeCourseResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delLikeCourse(LikeServiceProto.DelLikeCourseRequest request, StreamObserver<LikeServiceProto.DelLikeCourseResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getCourseIds().remove(request.getCourseId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("删除失败").build();
            LikeServiceProto.DelLikeCourseResponse response = LikeServiceProto.DelLikeCourseResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.DelLikeCourseResponse response = LikeServiceProto.DelLikeCourseResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getLikeHomes(LikeServiceProto.GetLikeHomesRequest request, StreamObserver<LikeServiceProto.GetLikeHomesResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        if (userLike == null) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).build();
            LikeServiceProto.GetLikeHomesResponse response = LikeServiceProto.GetLikeHomesResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.GetLikeHomesResponse response = LikeServiceProto.GetLikeHomesResponse.newBuilder().addAllHomeIds(userLike.getHomeIds()).setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void addLikeHome(LikeServiceProto.AddLikeHomeRequest request, StreamObserver<LikeServiceProto.AddLikeHomeResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getHomeIds().add(request.getHomeId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("添加失败").build();
            LikeServiceProto.AddLikeHomeResponse response = LikeServiceProto.AddLikeHomeResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.AddLikeHomeResponse response = LikeServiceProto.AddLikeHomeResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delLikeHome(LikeServiceProto.DelLikeHomeRequest request, StreamObserver<LikeServiceProto.DelLikeHomeResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getHomeIds().remove(request.getHomeId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("删除失败").build();
            LikeServiceProto.DelLikeHomeResponse response = LikeServiceProto.DelLikeHomeResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.DelLikeHomeResponse response = LikeServiceProto.DelLikeHomeResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getLikeUsers(LikeServiceProto.GetLikeUsersRequest request, StreamObserver<LikeServiceProto.GetLikeUsersResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        if (userLike == null) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).build();
            LikeServiceProto.GetLikeUsersResponse response = LikeServiceProto.GetLikeUsersResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.GetLikeUsersResponse response = LikeServiceProto.GetLikeUsersResponse.newBuilder().addAllUserIds(userLike.getUserIds()).setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void addLikeUser(LikeServiceProto.AddLikeUserRequest request, StreamObserver<LikeServiceProto.AddLikeUserResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getUserIds().add(request.getLikeUserId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("添加失败").build();
            LikeServiceProto.AddLikeUserResponse response = LikeServiceProto.AddLikeUserResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.AddLikeUserResponse response = LikeServiceProto.AddLikeUserResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delLikeUser(LikeServiceProto.DelLikeUserRequest request, StreamObserver<LikeServiceProto.DelLikeUserResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getUserIds().remove(request.getLikeUserId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("删除失败").build();
            LikeServiceProto.DelLikeUserResponse response = LikeServiceProto.DelLikeUserResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.DelLikeUserResponse response = LikeServiceProto.DelLikeUserResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getLikeCourseLists(LikeServiceProto.GetLikeCourseListsRequest request, StreamObserver<LikeServiceProto.GetLikeCourseListsResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        if (userLike == null) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).build();
            LikeServiceProto.GetLikeCourseListsResponse response = LikeServiceProto.GetLikeCourseListsResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.GetLikeCourseListsResponse response = LikeServiceProto.GetLikeCourseListsResponse.newBuilder().addAllCourseListIds(userLike.getCourseListIds()).setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void addLikeCourseList(LikeServiceProto.AddLikeCourseListRequest request, StreamObserver<LikeServiceProto.AddLikeCourseListResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getCourseListIds().add(request.getCourseListId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("添加失败").build();
            LikeServiceProto.AddLikeCourseListResponse response = LikeServiceProto.AddLikeCourseListResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.AddLikeCourseListResponse response = LikeServiceProto.AddLikeCourseListResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delLikeCourseList(LikeServiceProto.DelLikeCourseListRequest request, StreamObserver<LikeServiceProto.DelLikeCourseListResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getCourseListIds().remove(request.getCourseListId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("删除失败").build();
            LikeServiceProto.DelLikeCourseListResponse response = LikeServiceProto.DelLikeCourseListResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.DelLikeCourseListResponse response = LikeServiceProto.DelLikeCourseListResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getLikeCourseWares(LikeServiceProto.GetLikeCourseWaresRequest request, StreamObserver<LikeServiceProto.GetLikeCourseWaresResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        if (userLike == null) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).build();
            LikeServiceProto.GetLikeCourseWaresResponse response = LikeServiceProto.GetLikeCourseWaresResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.GetLikeCourseWaresResponse response = LikeServiceProto.GetLikeCourseWaresResponse.newBuilder().addAllCourseWareIds(userLike.getCourseWareIds()).setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void addLikeCourseWare(LikeServiceProto.AddLikeCourseWareRequest request, StreamObserver<LikeServiceProto.AddLikeCourseWareResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getCourseWareIds().add(request.getCourseWareId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("添加失败").build();
            LikeServiceProto.AddLikeCourseWareResponse response = LikeServiceProto.AddLikeCourseWareResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.AddLikeCourseWareResponse response = LikeServiceProto.AddLikeCourseWareResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delLikeCourseWare(LikeServiceProto.DelLikeCourseWareRequest request, StreamObserver<LikeServiceProto.DelLikeCourseWareResponse> responseObserver) {
        UserLike userLike = userLikeMapper.selectById(request.getUserId());
        userLike.getCourseWareIds().remove(request.getCourseWareId());
        if (userLikeMapper.updateById(userLike) <= 0) {
            ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("删除失败").build();
            LikeServiceProto.DelLikeCourseWareResponse response = LikeServiceProto.DelLikeCourseWareResponse.newBuilder().setResult(res).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult res = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
        LikeServiceProto.DelLikeCourseWareResponse response = LikeServiceProto.DelLikeCourseWareResponse.newBuilder().setResult(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
