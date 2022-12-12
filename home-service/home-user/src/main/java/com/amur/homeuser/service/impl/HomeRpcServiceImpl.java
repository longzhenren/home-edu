package com.amur.homeuser.service.impl;

import com.amur.homeuser.rpc.Home.*;
import com.amur.homeuser.rpc.HomeServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

@GrpcService
public class HomeRpcServiceImpl extends HomeServiceGrpc.HomeServiceImplBase {
    @Resource
    private HomeServiceImpl homeService;
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getHomeBaseInfo(GetHomeBaseRequest request, StreamObserver<GetHomeBaseResponse> responseObserver) {
        GetHomeBaseResponse response = GetHomeBaseResponse.newBuilder().build();
        homeService.getHomeBaseInfo(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getHomeDetailInfo(GetHomeBaseRequest request, StreamObserver<GetHomeDetailResponse> responseObserver) {
        GetHomeDetailResponse response = GetHomeDetailResponse.newBuilder().build();
        homeService.getHomeDetailInfo(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getHomeList(Empty request, StreamObserver<GetHomeListResponse> responseObserver) {
        GetHomeListResponse response = GetHomeListResponse.newBuilder().build();
        homeService.getHomeList();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void createHome(CreateHomeRequest request, StreamObserver<CreateHomeResponse> responseObserver) {
        CreateHomeResponse response = CreateHomeResponse.newBuilder().build();
        homeService.createHome(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void updateHome(UpdateHomeRequest request, StreamObserver<UpdateHomeResponse> responseObserver) {
        UpdateHomeResponse response = UpdateHomeResponse.newBuilder().build();
        homeService.updateHome(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void deleteHome(DeleteHomeRequest request, StreamObserver<DeleteHomeResponse> responseObserver) {
        DeleteHomeResponse response = DeleteHomeResponse.newBuilder().build();
        homeService.deleteHome(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getHomeUserList(GetHomeUserListRequest request, StreamObserver<GetHomeUserListResponse> responseObserver) {
        GetHomeUserListResponse response = GetHomeUserListResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void updateHomeUser(UpdateHomeUserRequest request, StreamObserver<UpdateHomeUserResponse> responseObserver) {
        UpdateHomeUserResponse response = UpdateHomeUserResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void deleteHomeUser(DeleteHomeUserRequest request, StreamObserver<DeleteHomeUserResponse> responseObserver) {
        DeleteHomeUserResponse response = DeleteHomeUserResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void setHomeAdmin(SetHomeAdminRequest request, StreamObserver<SetHomeAdminResponse> responseObserver) {
        SetHomeAdminResponse response = SetHomeAdminResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void addHomeImage(AddHomeImageRequest request, StreamObserver<AddHomeImageResponse> responseObserver) {
        AddHomeImageResponse response = AddHomeImageResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
