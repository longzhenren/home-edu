//package com.amur.home.user.service.rpc;
//
//import com.amur.home.user.dto.AddHomeImageDto;
//import com.amur.home.user.entity.HomeEntity;
//import com.amur.home.user.entity.UserInfo;
//import com.amur.home.user.rpc.Home.*;
//import com.amur.home.user.rpc.HomeServiceGrpc;
//import com.amur.home.user.rpc.StatusOuterClass.Status;
//import com.amur.home.user.service.impl.HomeServiceImpl;
//import com.amur.home.util.JsonUtils;
//import com.google.protobuf.Empty;
//import io.grpc.stub.StreamObserver;
//import lombok.extern.slf4j.Slf4j;
//import net.devh.boot.grpc.server.service.GrpcService;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//
//@Slf4j
//@GrpcService
//public class HomeRpcServiceImpl extends HomeServiceGrpc.HomeServiceImplBase {
//    @Resource
//    private HomeServiceImpl homeService;
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void getHomeBaseInfo(GetHomeBaseRequest request, StreamObserver<GetHomeBaseResponse> responseObserver) {
//        GetHomeBaseResponse response;
//        HomeEntity homeEntity = homeService.getHomeInfo(request.getHomeId());
//        if (homeEntity != null) {
//            response = GetHomeBaseResponse.newBuilder().setHomeBase(HomeBase.newBuilder().setHomeId(homeEntity.getId()).setHomeName(homeEntity.getName()).setHomeAvatar(homeEntity.getAvatarUrl()).setHomeMemberCount(JSON.parseArray(homeEntity.getHomeUserIds(), Long.class).size()).build()).setStatus(Status.SUCCESS).build();
//        } else {
//            response = GetHomeBaseResponse.newBuilder().setStatus(Status.FAILED).build();
//        }
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void getHomeDetailInfo(GetHomeDetailRequest request, StreamObserver<GetHomeDetailResponse> responseObserver) {
//        GetHomeDetailResponse response;
//        HomeEntity homeEntity = homeService.getHomeInfo(request.getHomeId());
//        if (homeEntity != null) {
//            response = GetHomeDetailResponse.newBuilder().setHomeDetail(HomeDetail.newBuilder().setHomeId(homeEntity.getId()).setHomeName(homeEntity.getName()).setHomeAddress(homeEntity.getAddress()).setHomeRegTime(homeEntity.getCreateTime().toString()).setHomeAvatar(homeEntity.getAvatarUrl()).setHomeMemberCount(JSON.parseArray(homeEntity.getHomeUserIds(), Long.class).size()).addAllHomeImage(JSON.parseArray(homeEntity.getImageUrls(), String.class)).build()).setStatus(Status.SUCCESS).build();
//        } else {
//            response = GetHomeDetailResponse.newBuilder().setStatus(Status.FAILED).build();
//        }
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void getHomeList(Empty request, StreamObserver<GetHomeListResponse> responseObserver) {
//        GetHomeListResponse response = GetHomeListResponse.newBuilder().build();
//        List<HomeEntity> homeList = homeService.getHomeList();
//        for (HomeEntity homeEntity : homeList) {
//            response = response.toBuilder().addHomeList(HomeBase.newBuilder().setHomeId(homeEntity.getId()).setHomeName(homeEntity.getName()).setHomeAvatar(homeEntity.getAvatarUrl()).setHomeMemberCount(((List<Long>) Objects.requireNonNull(JsonUtils.toObject(List.class, homeEntity.getHomeUserIds()))).size()).build()).build();
//        }
//        response.toBuilder().setStatus(Status.SUCCESS).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void createHome(CreateHomeRequest request, StreamObserver<CreateHomeResponse> responseObserver) {
//        CreateHomeResponse response = CreateHomeResponse.newBuilder().build();
//        HomeEntity homeEntity = new HomeEntity();
//        homeEntity.setName(request.getHomeName());
//        homeEntity.setAddress(request.getHomeAddress());
//        homeEntity.setCreateTime(new Date());
//        homeEntity.setAdminId(request.getUserId());
//        Long homeId = homeService.createHome(homeEntity);
//        response = response.toBuilder().setHomeId(homeId).setStatus(Status.SUCCESS).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void updateHome(UpdateHomeRequest request, StreamObserver<UpdateHomeResponse> responseObserver) {
//        UpdateHomeResponse response = UpdateHomeResponse.newBuilder().build();
//        HomeEntity homeEntity = new HomeEntity();
//        homeEntity.setName(request.getHomeName());
//        homeEntity.setAddress(request.getHomeAddress());
//        homeEntity.setAvatarUrl(request.getHomeAvatarUrl());
//        homeEntity.setId(request.getHomeId());
//        response = response.toBuilder().setStatus(homeService.updateHome(homeEntity) ? Status.SUCCESS : Status.FAILED).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void deleteHome(DeleteHomeRequest request, StreamObserver<DeleteHomeResponse> responseObserver) {
//        DeleteHomeResponse response = DeleteHomeResponse.newBuilder().build();
//        response = response.toBuilder().setStatus(homeService.deleteHome(request.getHomeId()) ? Status.SUCCESS : Status.FAILED).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void getHomeUserList(GetHomeUserListRequest request, StreamObserver<GetHomeUserListResponse> responseObserver) {
//        GetHomeUserListResponse response = GetHomeUserListResponse.newBuilder().build();
//        List<UserInfo> userList = homeService.getHomeUserList(request.getHomeId());
//        for (UserInfo userEntity : userList) {
//            response = response.toBuilder().addHomeUserList(HomeUser.newBuilder().setUserId(userEntity.getId()).setUserName(userEntity.getName()).setUserAvatar(userEntity.getAvatarUrl()).build()).build();
//        }
//        response = response.toBuilder().setStatus(Status.SUCCESS).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void updateHomeUser(UpdateHomeUserRequest request, StreamObserver<UpdateHomeUserResponse> responseObserver) {
//        UpdateHomeUserResponse response = UpdateHomeUserResponse.newBuilder().build();
//        response = response.toBuilder().setStatus(homeService.updateHomeUser(request.getHomeId(), request.getUserId()) ? Status.SUCCESS : Status.FAILED).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void deleteHomeUser(DeleteHomeUserRequest request, StreamObserver<DeleteHomeUserResponse> responseObserver) {
//        DeleteHomeUserResponse response = DeleteHomeUserResponse.newBuilder().build();
//        response = response.toBuilder().setStatus(homeService.deleteHomeUser(request.getHomeId(), request.getUserId()) ? Status.SUCCESS : Status.FAILED).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void setHomeAdmin(SetHomeAdminRequest request, StreamObserver<SetHomeAdminResponse> responseObserver) {
//        SetHomeAdminResponse response = SetHomeAdminResponse.newBuilder().build();
//        response = response.toBuilder().setStatus(homeService.setHomeAdmin(request.getHomeId(), request.getUserId()) ? Status.SUCCESS : Status.FAILED).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    /**
//     * @param request
//     * @param responseObserver
//     */
//    @Override
//    public void addHomeImage(AddHomeImageRequest request, StreamObserver<AddHomeImageResponse> responseObserver) {
//        AddHomeImageResponse response = AddHomeImageResponse.newBuilder().build();
//        AddHomeImageDto addHomeImageDto = new AddHomeImageDto();
//        addHomeImageDto.setHomeId(request.getHomeId());
//        addHomeImageDto.setImageUrl(request.getImageUrlList());
//        response = response.toBuilder().setStatus(homeService.addHomeImage(addHomeImageDto) ? Status.SUCCESS : Status.FAILED).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//}
