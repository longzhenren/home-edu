package com.amur.home.msg.client;

import com.amur.home.user.rpc.*;
import com.amur.home.util.ServiceResult;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserGrpcClient {
    @GrpcClient("home-user")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @GrpcClient("home-user")
    private FavServiceGrpc.FavServiceBlockingStub favServiceBlockingStub;

    @GrpcClient("home-user")
    private LikeServiceGrpc.LikeServiceBlockingStub likeServiceBlockingStub;

    public boolean checkUserExists(Long userId) {
        UserServiceProto.UserIdRequest request = UserServiceProto.UserIdRequest.newBuilder().setUserId(userId).build();
        UserServiceProto.CheckUserExistsResponse response = userServiceBlockingStub.checkUserExists(request);
        return response.getExists();
    }

    public ServiceResult<Boolean> addFavIssue(Long userId, Long issueId) {
        FavServiceProto.AddFavIssueRequest request = FavServiceProto.AddFavIssueRequest.newBuilder()
                .setUserId(userId)
                .setIssueId(issueId)
                .build();
        FavServiceProto.AddFavIssueResponse response = favServiceBlockingStub.addFavIssue(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    public ServiceResult<Boolean> delFavIssue(Long userId, Long issueId) {
        FavServiceProto.DelFavIssueRequest request = FavServiceProto.DelFavIssueRequest.newBuilder()
                .setUserId(userId)
                .setIssueId(issueId)
                .build();
        FavServiceProto.DelFavIssueResponse response = favServiceBlockingStub.delFavIssue(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }


    public ServiceResult<List<Long>> getFavIssue(Long userId) {
        FavServiceProto.GetFavIssuesRequest request = FavServiceProto.GetFavIssuesRequest.newBuilder()
                .setUserId(userId)
                .build();
        FavServiceProto.GetFavIssuesResponse response = favServiceBlockingStub.getFavIssues(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success(response.getIssueIdsList());
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }


    public ServiceResult<Boolean> addLikeIssue(Long userId, Long issueId) {
        LikeServiceProto.AddLikeIssueRequest request = LikeServiceProto.AddLikeIssueRequest.newBuilder()
                .setUserId(userId)
                .setIssueId(issueId)
                .build();
        LikeServiceProto.AddLikeIssueResponse response = likeServiceBlockingStub.addLikeIssue(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

    public ServiceResult<Boolean> delLikeIssue(Long userId, Long issueId) {
        LikeServiceProto.DelLikeIssueRequest request = LikeServiceProto.DelLikeIssueRequest.newBuilder()
                .setUserId(userId)
                .setIssueId(issueId)
                .build();
        LikeServiceProto.DelLikeIssueResponse response = likeServiceBlockingStub.delLikeIssue(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }


    public ServiceResult<List<Long>> getLikeIssue(Long userId) {
        LikeServiceProto.GetLikeIssuesRequest request = LikeServiceProto.GetLikeIssuesRequest.newBuilder()
                .setUserId(userId)
                .build();
        LikeServiceProto.GetLikeIssuesResponse response = likeServiceBlockingStub.getLikeIssues(request);
        if (response.getResult().getSuccess()) {
            return ServiceResult.success(response.getIssueIdsList());
        } else {
            return ServiceResult.ex(response.getResult().getMessage());
        }
    }

}
