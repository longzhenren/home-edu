package com.amur.home.course.client;

import com.amur.home.user.rpc.*;
import com.amur.home.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserGrpcClient {
    @GrpcClient("home-user")
    private FavServiceGrpc.FavServiceBlockingStub favServiceBlockingStub;

    @GrpcClient("home-user")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @GrpcClient("home-user")
    private LikeServiceGrpc.LikeServiceBlockingStub likeServiceBlockingStub;

    /**
     * 获取收藏的课程id列表
     *
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    public ServiceResult<List<Long>> getFavCourses(Long userId) {
        FavServiceProto.GetFavCoursesRequest request = FavServiceProto.GetFavCoursesRequest.newBuilder().setUserId(userId).build();
        FavServiceProto.GetFavCoursesResponse response = favServiceBlockingStub.getFavCourses(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success(response.getCourseIdsList());
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    /**
     * 添加收藏的课程id
     *
     * @param userId   用户ID
     * @param courseId 添加收藏课程ID
     * @return 服务返回结果统一封装
     */
    public ServiceResult<Void> addFavCourse(Long userId, Long courseId) {
        FavServiceProto.AddFavCourseRequest request = FavServiceProto.AddFavCourseRequest.newBuilder().setUserId(userId).setCourseId(courseId).build();
        FavServiceProto.AddFavCourseResponse response = favServiceBlockingStub.addFavCourse(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    /**
     * 删除收藏的课程id
     *
     * @param userId   用户ID
     * @param courseId 删除收藏课程ID
     * @return 服务返回结果统一封装
     */
    public ServiceResult<Void> delFavCourse(Long userId, Long courseId) {
        FavServiceProto.DelFavCourseRequest request = FavServiceProto.DelFavCourseRequest.newBuilder().setUserId(userId).setCourseId(courseId).build();
        FavServiceProto.DelFavCourseResponse response = favServiceBlockingStub.delFavCourse(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    /**
     * 获取收藏的课程列表id
     *
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    public ServiceResult<List<Long>> getFavCourseLists(Long userId) {
        FavServiceProto.GetFavCourseListsRequest request = FavServiceProto.GetFavCourseListsRequest.newBuilder().setUserId(userId).build();
        FavServiceProto.GetFavCourseListsResponse response = favServiceBlockingStub.getFavCourseLists(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success(response.getCourseListIdsList());
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    /**
     * 添加收藏的课程列表id
     *
     * @param userId       用户ID
     * @param courseListId 添加收藏课程列表ID
     * @return 服务返回结果统一封装
     */
    public ServiceResult<Void> addFavCourseList(Long userId, Long courseListId) {
        FavServiceProto.AddFavCourseListRequest request = FavServiceProto.AddFavCourseListRequest.newBuilder().setUserId(userId).setCourseListId(courseListId).build();
        FavServiceProto.AddFavCourseListResponse response = favServiceBlockingStub.addFavCourseList(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    /**
     * 删除收藏的课程列表id
     *
     * @param userId       用户ID
     * @param courseListId 删除收藏课程列表ID
     * @return 服务返回结果统一封装
     */
    public ServiceResult<Void> delFavCourseList(Long userId, Long courseListId) {
        FavServiceProto.DelFavCourseListRequest request = FavServiceProto.DelFavCourseListRequest.newBuilder().setUserId(userId).setCourseListId(courseListId).build();
        FavServiceProto.DelFavCourseListResponse response = favServiceBlockingStub.delFavCourseList(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    /**
     * 获取收藏的课件id
     *
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    public ServiceResult<List<Long>> getFavCourseWares(Long userId) {
        FavServiceProto.GetFavCourseWaresRequest request = FavServiceProto.GetFavCourseWaresRequest.newBuilder().setUserId(userId).build();
        FavServiceProto.GetFavCourseWaresResponse response = favServiceBlockingStub.getFavCourseWares(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success(response.getCourseWareIdsList());
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    /**
     * 添加收藏的课程列表id
     *
     * @param userId       用户ID
     * @param courseWareId 添加收藏课件ID
     * @return 服务返回结果统一封装
     */
    public ServiceResult<Void> addFavCourseWare(Long userId, Long courseWareId) {
        FavServiceProto.AddFavCourseWareRequest request = FavServiceProto.AddFavCourseWareRequest.newBuilder().setUserId(userId).setCourseWareId(courseWareId).build();
        FavServiceProto.AddFavCourseWareResponse response = favServiceBlockingStub.addFavCourseWare(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    /**
     * 删除收藏的课程列表id
     *
     * @param userId       用户ID
     * @param courseWareId 删除收藏课件ID
     * @return 服务返回结果统一封装
     */
    public ServiceResult<Void> delFavCourseWare(Long userId, Long courseWareId) {
        FavServiceProto.DelFavCourseWareRequest request = FavServiceProto.DelFavCourseWareRequest.newBuilder().setUserId(userId).setCourseWareId(courseWareId).build();
        FavServiceProto.DelFavCourseWareResponse response = favServiceBlockingStub.delFavCourseWare(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    public ServiceResult<Boolean> checkUserExists(Long userId) {
        UserServiceProto.UserIdRequest request = UserServiceProto.UserIdRequest.newBuilder().setUserId(userId).build();
        UserServiceProto.CheckUserExistsResponse response = userServiceBlockingStub.checkUserExists(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success(response.getExists());
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    public ServiceResult<List<Long>> getUserLikeCourses(Long userId) {
        LikeServiceProto.GetLikeCoursesRequest request = LikeServiceProto.GetLikeCoursesRequest.newBuilder().setUserId(userId).build();
        LikeServiceProto.GetLikeCoursesResponse response = likeServiceBlockingStub.getLikeCourses(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success(response.getCourseIdsList());
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    public ServiceResult<Boolean> addUserLikeCourse(Long userId, Long courseId) {
        LikeServiceProto.AddLikeCourseRequest request = LikeServiceProto.AddLikeCourseRequest.newBuilder().setUserId(userId).setCourseId(courseId).build();
        LikeServiceProto.AddLikeCourseResponse response = likeServiceBlockingStub.addLikeCourse(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    public ServiceResult<Boolean> delUserLikeCourse(Long userId, Long courseId) {
        LikeServiceProto.DelLikeCourseRequest request = LikeServiceProto.DelLikeCourseRequest.newBuilder().setUserId(userId).setCourseId(courseId).build();
        LikeServiceProto.DelLikeCourseResponse response = likeServiceBlockingStub.delLikeCourse(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    public ServiceResult<List<Long>> getUserLikeCourseLists(Long userId) {
        LikeServiceProto.GetLikeCourseListsRequest request = LikeServiceProto.GetLikeCourseListsRequest.newBuilder().setUserId(userId).build();
        LikeServiceProto.GetLikeCourseListsResponse response = likeServiceBlockingStub.getLikeCourseLists(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success(response.getCourseListIdsList());
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    public ServiceResult<Boolean> addUserLikeCourseList(Long userId, Long courseListId) {
        LikeServiceProto.AddLikeCourseListRequest request = LikeServiceProto.AddLikeCourseListRequest.newBuilder().setUserId(userId).setCourseListId(courseListId).build();
        LikeServiceProto.AddLikeCourseListResponse response = likeServiceBlockingStub.addLikeCourseList(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    public ServiceResult<Boolean> delUserLikeCourseList(Long userId, Long courseListId) {
        LikeServiceProto.DelLikeCourseListRequest request = LikeServiceProto.DelLikeCourseListRequest.newBuilder().setUserId(userId).setCourseListId(courseListId).build();
        LikeServiceProto.DelLikeCourseListResponse response = likeServiceBlockingStub.delLikeCourseList(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }
}
