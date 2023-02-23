package com.amur.home.course.client;

import com.amur.home.user.rpc.FavServiceGrpc;
import com.amur.home.user.rpc.FavServiceProto;
import com.amur.home.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CourseGrpcClient {
    @GrpcClient("home-user")
    private FavServiceGrpc.FavServiceBlockingStub favServiceBlockingStub;

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
            return ServiceResult.fail(response.getResult().getMessage());
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
            return ServiceResult.fail(response.getResult().getMessage());
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
            return ServiceResult.fail(response.getResult().getMessage());
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
            return ServiceResult.fail(response.getResult().getMessage());
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
            return ServiceResult.fail(response.getResult().getMessage());
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
            return ServiceResult.fail(response.getResult().getMessage());
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
            return ServiceResult.fail(response.getResult().getMessage());
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
            return ServiceResult.fail(response.getResult().getMessage());
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
            return ServiceResult.fail(response.getResult().getMessage());
        }
    }
}
