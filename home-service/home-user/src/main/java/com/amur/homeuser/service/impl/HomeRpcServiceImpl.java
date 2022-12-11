package com.amur.homeuser.service.impl;

import com.amur.homeuser.rpc.Home;
import com.amur.homeuser.rpc.HomeServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

public class HomeRpcServiceImpl extends HomeServiceGrpc.HomeServiceImplBase {
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getHomeBaseInfo(Home.GetHomeBaseRequest request, StreamObserver<Home.GetHomeBaseResponse> responseObserver) {
        super.getHomeBaseInfo(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getHomeDetailInfo(Home.GetHomeBaseRequest request, StreamObserver<Home.GetHomeDetailResponse> responseObserver) {
        super.getHomeDetailInfo(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getHomeList(Empty request, StreamObserver<Home.GetHomeListResponse> responseObserver) {
        super.getHomeList(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void createHome(Home.CreateHomeRequest request, StreamObserver<Home.CreateHomeResponse> responseObserver) {
        super.createHome(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void updateHome(Home.UpdateHomeRequest request, StreamObserver<Home.UpdateHomeResponse> responseObserver) {
        super.updateHome(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void deleteHome(Home.DeleteHomeRequest request, StreamObserver<Home.DeleteHomeResponse> responseObserver) {
        super.deleteHome(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getHomeUserList(Home.GetHomeUserListRequest request, StreamObserver<Home.GetHomeUserListResponse> responseObserver) {
        super.getHomeUserList(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void updateHomeUser(Home.UpdateHomeUserRequest request, StreamObserver<Home.UpdateHomeUserResponse> responseObserver) {
        super.updateHomeUser(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void deleteHomeUser(Home.DeleteHomeUserRequest request, StreamObserver<Home.DeleteHomeUserResponse> responseObserver) {
        super.deleteHomeUser(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void setHomeAdmin(Home.SetHomeAdminRequest request, StreamObserver<Home.SetHomeAdminResponse> responseObserver) {
        super.setHomeAdmin(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void addHomeImage(Home.AddHomeImageRequest request, StreamObserver<Home.AddHomeImageResponse> responseObserver) {
        super.addHomeImage(request, responseObserver);
    }
}
