package com.amur.home.user.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: home.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HomeServiceGrpc {

  private HomeServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.user.rpc.HomeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.GetHomeBaseRequest,
      com.amur.home.user.rpc.Home.GetHomeBaseResponse> getGetHomeBaseInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHomeBaseInfo",
      requestType = com.amur.home.user.rpc.Home.GetHomeBaseRequest.class,
      responseType = com.amur.home.user.rpc.Home.GetHomeBaseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.GetHomeBaseRequest,
      com.amur.home.user.rpc.Home.GetHomeBaseResponse> getGetHomeBaseInfoMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.GetHomeBaseRequest, com.amur.home.user.rpc.Home.GetHomeBaseResponse> getGetHomeBaseInfoMethod;
    if ((getGetHomeBaseInfoMethod = HomeServiceGrpc.getGetHomeBaseInfoMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getGetHomeBaseInfoMethod = HomeServiceGrpc.getGetHomeBaseInfoMethod) == null) {
          HomeServiceGrpc.getGetHomeBaseInfoMethod = getGetHomeBaseInfoMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.GetHomeBaseRequest, com.amur.home.user.rpc.Home.GetHomeBaseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHomeBaseInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.GetHomeBaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.GetHomeBaseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("GetHomeBaseInfo"))
              .build();
        }
      }
    }
    return getGetHomeBaseInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.GetHomeDetailRequest,
      com.amur.home.user.rpc.Home.GetHomeDetailResponse> getGetHomeDetailInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHomeDetailInfo",
      requestType = com.amur.home.user.rpc.Home.GetHomeDetailRequest.class,
      responseType = com.amur.home.user.rpc.Home.GetHomeDetailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.GetHomeDetailRequest,
      com.amur.home.user.rpc.Home.GetHomeDetailResponse> getGetHomeDetailInfoMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.GetHomeDetailRequest, com.amur.home.user.rpc.Home.GetHomeDetailResponse> getGetHomeDetailInfoMethod;
    if ((getGetHomeDetailInfoMethod = HomeServiceGrpc.getGetHomeDetailInfoMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getGetHomeDetailInfoMethod = HomeServiceGrpc.getGetHomeDetailInfoMethod) == null) {
          HomeServiceGrpc.getGetHomeDetailInfoMethod = getGetHomeDetailInfoMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.GetHomeDetailRequest, com.amur.home.user.rpc.Home.GetHomeDetailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHomeDetailInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.GetHomeDetailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.GetHomeDetailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("GetHomeDetailInfo"))
              .build();
        }
      }
    }
    return getGetHomeDetailInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.amur.home.user.rpc.Home.GetHomeListResponse> getGetHomeListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHomeList",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.amur.home.user.rpc.Home.GetHomeListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.amur.home.user.rpc.Home.GetHomeListResponse> getGetHomeListMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.amur.home.user.rpc.Home.GetHomeListResponse> getGetHomeListMethod;
    if ((getGetHomeListMethod = HomeServiceGrpc.getGetHomeListMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getGetHomeListMethod = HomeServiceGrpc.getGetHomeListMethod) == null) {
          HomeServiceGrpc.getGetHomeListMethod = getGetHomeListMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.amur.home.user.rpc.Home.GetHomeListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHomeList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.GetHomeListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("GetHomeList"))
              .build();
        }
      }
    }
    return getGetHomeListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.CreateHomeRequest,
      com.amur.home.user.rpc.Home.CreateHomeResponse> getCreateHomeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHome",
      requestType = com.amur.home.user.rpc.Home.CreateHomeRequest.class,
      responseType = com.amur.home.user.rpc.Home.CreateHomeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.CreateHomeRequest,
      com.amur.home.user.rpc.Home.CreateHomeResponse> getCreateHomeMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.CreateHomeRequest, com.amur.home.user.rpc.Home.CreateHomeResponse> getCreateHomeMethod;
    if ((getCreateHomeMethod = HomeServiceGrpc.getCreateHomeMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getCreateHomeMethod = HomeServiceGrpc.getCreateHomeMethod) == null) {
          HomeServiceGrpc.getCreateHomeMethod = getCreateHomeMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.CreateHomeRequest, com.amur.home.user.rpc.Home.CreateHomeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHome"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.CreateHomeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.CreateHomeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("CreateHome"))
              .build();
        }
      }
    }
    return getCreateHomeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.UpdateHomeRequest,
      com.amur.home.user.rpc.Home.UpdateHomeResponse> getUpdateHomeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHome",
      requestType = com.amur.home.user.rpc.Home.UpdateHomeRequest.class,
      responseType = com.amur.home.user.rpc.Home.UpdateHomeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.UpdateHomeRequest,
      com.amur.home.user.rpc.Home.UpdateHomeResponse> getUpdateHomeMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.UpdateHomeRequest, com.amur.home.user.rpc.Home.UpdateHomeResponse> getUpdateHomeMethod;
    if ((getUpdateHomeMethod = HomeServiceGrpc.getUpdateHomeMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getUpdateHomeMethod = HomeServiceGrpc.getUpdateHomeMethod) == null) {
          HomeServiceGrpc.getUpdateHomeMethod = getUpdateHomeMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.UpdateHomeRequest, com.amur.home.user.rpc.Home.UpdateHomeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHome"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.UpdateHomeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.UpdateHomeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("UpdateHome"))
              .build();
        }
      }
    }
    return getUpdateHomeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.DeleteHomeRequest,
      com.amur.home.user.rpc.Home.DeleteHomeResponse> getDeleteHomeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHome",
      requestType = com.amur.home.user.rpc.Home.DeleteHomeRequest.class,
      responseType = com.amur.home.user.rpc.Home.DeleteHomeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.DeleteHomeRequest,
      com.amur.home.user.rpc.Home.DeleteHomeResponse> getDeleteHomeMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.DeleteHomeRequest, com.amur.home.user.rpc.Home.DeleteHomeResponse> getDeleteHomeMethod;
    if ((getDeleteHomeMethod = HomeServiceGrpc.getDeleteHomeMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getDeleteHomeMethod = HomeServiceGrpc.getDeleteHomeMethod) == null) {
          HomeServiceGrpc.getDeleteHomeMethod = getDeleteHomeMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.DeleteHomeRequest, com.amur.home.user.rpc.Home.DeleteHomeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHome"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.DeleteHomeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.DeleteHomeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("DeleteHome"))
              .build();
        }
      }
    }
    return getDeleteHomeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.GetHomeUserListRequest,
      com.amur.home.user.rpc.Home.GetHomeUserListResponse> getGetHomeUserListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHomeUserList",
      requestType = com.amur.home.user.rpc.Home.GetHomeUserListRequest.class,
      responseType = com.amur.home.user.rpc.Home.GetHomeUserListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.GetHomeUserListRequest,
      com.amur.home.user.rpc.Home.GetHomeUserListResponse> getGetHomeUserListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.GetHomeUserListRequest, com.amur.home.user.rpc.Home.GetHomeUserListResponse> getGetHomeUserListMethod;
    if ((getGetHomeUserListMethod = HomeServiceGrpc.getGetHomeUserListMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getGetHomeUserListMethod = HomeServiceGrpc.getGetHomeUserListMethod) == null) {
          HomeServiceGrpc.getGetHomeUserListMethod = getGetHomeUserListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.GetHomeUserListRequest, com.amur.home.user.rpc.Home.GetHomeUserListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHomeUserList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.GetHomeUserListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.GetHomeUserListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("GetHomeUserList"))
              .build();
        }
      }
    }
    return getGetHomeUserListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.UpdateHomeUserRequest,
      com.amur.home.user.rpc.Home.UpdateHomeUserResponse> getUpdateHomeUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHomeUser",
      requestType = com.amur.home.user.rpc.Home.UpdateHomeUserRequest.class,
      responseType = com.amur.home.user.rpc.Home.UpdateHomeUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.UpdateHomeUserRequest,
      com.amur.home.user.rpc.Home.UpdateHomeUserResponse> getUpdateHomeUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.UpdateHomeUserRequest, com.amur.home.user.rpc.Home.UpdateHomeUserResponse> getUpdateHomeUserMethod;
    if ((getUpdateHomeUserMethod = HomeServiceGrpc.getUpdateHomeUserMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getUpdateHomeUserMethod = HomeServiceGrpc.getUpdateHomeUserMethod) == null) {
          HomeServiceGrpc.getUpdateHomeUserMethod = getUpdateHomeUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.UpdateHomeUserRequest, com.amur.home.user.rpc.Home.UpdateHomeUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHomeUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.UpdateHomeUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.UpdateHomeUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("UpdateHomeUser"))
              .build();
        }
      }
    }
    return getUpdateHomeUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.DeleteHomeUserRequest,
      com.amur.home.user.rpc.Home.DeleteHomeUserResponse> getDeleteHomeUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHomeUser",
      requestType = com.amur.home.user.rpc.Home.DeleteHomeUserRequest.class,
      responseType = com.amur.home.user.rpc.Home.DeleteHomeUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.DeleteHomeUserRequest,
      com.amur.home.user.rpc.Home.DeleteHomeUserResponse> getDeleteHomeUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.DeleteHomeUserRequest, com.amur.home.user.rpc.Home.DeleteHomeUserResponse> getDeleteHomeUserMethod;
    if ((getDeleteHomeUserMethod = HomeServiceGrpc.getDeleteHomeUserMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getDeleteHomeUserMethod = HomeServiceGrpc.getDeleteHomeUserMethod) == null) {
          HomeServiceGrpc.getDeleteHomeUserMethod = getDeleteHomeUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.DeleteHomeUserRequest, com.amur.home.user.rpc.Home.DeleteHomeUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHomeUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.DeleteHomeUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.DeleteHomeUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("DeleteHomeUser"))
              .build();
        }
      }
    }
    return getDeleteHomeUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.SetHomeAdminRequest,
      com.amur.home.user.rpc.Home.SetHomeAdminResponse> getSetHomeAdminMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetHomeAdmin",
      requestType = com.amur.home.user.rpc.Home.SetHomeAdminRequest.class,
      responseType = com.amur.home.user.rpc.Home.SetHomeAdminResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.SetHomeAdminRequest,
      com.amur.home.user.rpc.Home.SetHomeAdminResponse> getSetHomeAdminMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.SetHomeAdminRequest, com.amur.home.user.rpc.Home.SetHomeAdminResponse> getSetHomeAdminMethod;
    if ((getSetHomeAdminMethod = HomeServiceGrpc.getSetHomeAdminMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getSetHomeAdminMethod = HomeServiceGrpc.getSetHomeAdminMethod) == null) {
          HomeServiceGrpc.getSetHomeAdminMethod = getSetHomeAdminMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.SetHomeAdminRequest, com.amur.home.user.rpc.Home.SetHomeAdminResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetHomeAdmin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.SetHomeAdminRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.SetHomeAdminResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("SetHomeAdmin"))
              .build();
        }
      }
    }
    return getSetHomeAdminMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.AddHomeImageRequest,
      com.amur.home.user.rpc.Home.AddHomeImageResponse> getAddHomeImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addHomeImage",
      requestType = com.amur.home.user.rpc.Home.AddHomeImageRequest.class,
      responseType = com.amur.home.user.rpc.Home.AddHomeImageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.AddHomeImageRequest,
      com.amur.home.user.rpc.Home.AddHomeImageResponse> getAddHomeImageMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.Home.AddHomeImageRequest, com.amur.home.user.rpc.Home.AddHomeImageResponse> getAddHomeImageMethod;
    if ((getAddHomeImageMethod = HomeServiceGrpc.getAddHomeImageMethod) == null) {
      synchronized (HomeServiceGrpc.class) {
        if ((getAddHomeImageMethod = HomeServiceGrpc.getAddHomeImageMethod) == null) {
          HomeServiceGrpc.getAddHomeImageMethod = getAddHomeImageMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.Home.AddHomeImageRequest, com.amur.home.user.rpc.Home.AddHomeImageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addHomeImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.AddHomeImageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.Home.AddHomeImageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HomeServiceMethodDescriptorSupplier("addHomeImage"))
              .build();
        }
      }
    }
    return getAddHomeImageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HomeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HomeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HomeServiceStub>() {
        @java.lang.Override
        public HomeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HomeServiceStub(channel, callOptions);
        }
      };
    return HomeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HomeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HomeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HomeServiceBlockingStub>() {
        @java.lang.Override
        public HomeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HomeServiceBlockingStub(channel, callOptions);
        }
      };
    return HomeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HomeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HomeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HomeServiceFutureStub>() {
        @java.lang.Override
        public HomeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HomeServiceFutureStub(channel, callOptions);
        }
      };
    return HomeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HomeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getHomeBaseInfo(com.amur.home.user.rpc.Home.GetHomeBaseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeBaseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHomeBaseInfoMethod(), responseObserver);
    }

    /**
     */
    public void getHomeDetailInfo(com.amur.home.user.rpc.Home.GetHomeDetailRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeDetailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHomeDetailInfoMethod(), responseObserver);
    }

    /**
     */
    public void getHomeList(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHomeListMethod(), responseObserver);
    }

    /**
     */
    public void createHome(com.amur.home.user.rpc.Home.CreateHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.CreateHomeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateHomeMethod(), responseObserver);
    }

    /**
     */
    public void updateHome(com.amur.home.user.rpc.Home.UpdateHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.UpdateHomeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateHomeMethod(), responseObserver);
    }

    /**
     */
    public void deleteHome(com.amur.home.user.rpc.Home.DeleteHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.DeleteHomeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteHomeMethod(), responseObserver);
    }

    /**
     */
    public void getHomeUserList(com.amur.home.user.rpc.Home.GetHomeUserListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeUserListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHomeUserListMethod(), responseObserver);
    }

    /**
     */
    public void updateHomeUser(com.amur.home.user.rpc.Home.UpdateHomeUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.UpdateHomeUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateHomeUserMethod(), responseObserver);
    }

    /**
     */
    public void deleteHomeUser(com.amur.home.user.rpc.Home.DeleteHomeUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.DeleteHomeUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteHomeUserMethod(), responseObserver);
    }

    /**
     */
    public void setHomeAdmin(com.amur.home.user.rpc.Home.SetHomeAdminRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.SetHomeAdminResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetHomeAdminMethod(), responseObserver);
    }

    /**
     */
    public void addHomeImage(com.amur.home.user.rpc.Home.AddHomeImageRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.AddHomeImageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddHomeImageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetHomeBaseInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.GetHomeBaseRequest,
                com.amur.home.user.rpc.Home.GetHomeBaseResponse>(
                  this, METHODID_GET_HOME_BASE_INFO)))
          .addMethod(
            getGetHomeDetailInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.GetHomeDetailRequest,
                com.amur.home.user.rpc.Home.GetHomeDetailResponse>(
                  this, METHODID_GET_HOME_DETAIL_INFO)))
          .addMethod(
            getGetHomeListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.amur.home.user.rpc.Home.GetHomeListResponse>(
                  this, METHODID_GET_HOME_LIST)))
          .addMethod(
            getCreateHomeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.CreateHomeRequest,
                com.amur.home.user.rpc.Home.CreateHomeResponse>(
                  this, METHODID_CREATE_HOME)))
          .addMethod(
            getUpdateHomeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.UpdateHomeRequest,
                com.amur.home.user.rpc.Home.UpdateHomeResponse>(
                  this, METHODID_UPDATE_HOME)))
          .addMethod(
            getDeleteHomeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.DeleteHomeRequest,
                com.amur.home.user.rpc.Home.DeleteHomeResponse>(
                  this, METHODID_DELETE_HOME)))
          .addMethod(
            getGetHomeUserListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.GetHomeUserListRequest,
                com.amur.home.user.rpc.Home.GetHomeUserListResponse>(
                  this, METHODID_GET_HOME_USER_LIST)))
          .addMethod(
            getUpdateHomeUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.UpdateHomeUserRequest,
                com.amur.home.user.rpc.Home.UpdateHomeUserResponse>(
                  this, METHODID_UPDATE_HOME_USER)))
          .addMethod(
            getDeleteHomeUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.DeleteHomeUserRequest,
                com.amur.home.user.rpc.Home.DeleteHomeUserResponse>(
                  this, METHODID_DELETE_HOME_USER)))
          .addMethod(
            getSetHomeAdminMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.SetHomeAdminRequest,
                com.amur.home.user.rpc.Home.SetHomeAdminResponse>(
                  this, METHODID_SET_HOME_ADMIN)))
          .addMethod(
            getAddHomeImageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.Home.AddHomeImageRequest,
                com.amur.home.user.rpc.Home.AddHomeImageResponse>(
                  this, METHODID_ADD_HOME_IMAGE)))
          .build();
    }
  }

  /**
   */
  public static final class HomeServiceStub extends io.grpc.stub.AbstractAsyncStub<HomeServiceStub> {
    private HomeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HomeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HomeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getHomeBaseInfo(com.amur.home.user.rpc.Home.GetHomeBaseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeBaseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHomeBaseInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHomeDetailInfo(com.amur.home.user.rpc.Home.GetHomeDetailRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeDetailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHomeDetailInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHomeList(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHomeListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createHome(com.amur.home.user.rpc.Home.CreateHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.CreateHomeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHomeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateHome(com.amur.home.user.rpc.Home.UpdateHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.UpdateHomeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHomeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteHome(com.amur.home.user.rpc.Home.DeleteHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.DeleteHomeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHomeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHomeUserList(com.amur.home.user.rpc.Home.GetHomeUserListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeUserListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHomeUserListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateHomeUser(com.amur.home.user.rpc.Home.UpdateHomeUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.UpdateHomeUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHomeUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteHomeUser(com.amur.home.user.rpc.Home.DeleteHomeUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.DeleteHomeUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHomeUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setHomeAdmin(com.amur.home.user.rpc.Home.SetHomeAdminRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.SetHomeAdminResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetHomeAdminMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addHomeImage(com.amur.home.user.rpc.Home.AddHomeImageRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.AddHomeImageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddHomeImageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HomeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HomeServiceBlockingStub> {
    private HomeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HomeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HomeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.GetHomeBaseResponse getHomeBaseInfo(com.amur.home.user.rpc.Home.GetHomeBaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHomeBaseInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.GetHomeDetailResponse getHomeDetailInfo(com.amur.home.user.rpc.Home.GetHomeDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHomeDetailInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.GetHomeListResponse getHomeList(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHomeListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.CreateHomeResponse createHome(com.amur.home.user.rpc.Home.CreateHomeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHomeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.UpdateHomeResponse updateHome(com.amur.home.user.rpc.Home.UpdateHomeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHomeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.DeleteHomeResponse deleteHome(com.amur.home.user.rpc.Home.DeleteHomeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHomeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.GetHomeUserListResponse getHomeUserList(com.amur.home.user.rpc.Home.GetHomeUserListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHomeUserListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.UpdateHomeUserResponse updateHomeUser(com.amur.home.user.rpc.Home.UpdateHomeUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHomeUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.DeleteHomeUserResponse deleteHomeUser(com.amur.home.user.rpc.Home.DeleteHomeUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHomeUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.SetHomeAdminResponse setHomeAdmin(com.amur.home.user.rpc.Home.SetHomeAdminRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetHomeAdminMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.Home.AddHomeImageResponse addHomeImage(com.amur.home.user.rpc.Home.AddHomeImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddHomeImageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HomeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HomeServiceFutureStub> {
    private HomeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HomeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HomeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.GetHomeBaseResponse> getHomeBaseInfo(
        com.amur.home.user.rpc.Home.GetHomeBaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHomeBaseInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.GetHomeDetailResponse> getHomeDetailInfo(
        com.amur.home.user.rpc.Home.GetHomeDetailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHomeDetailInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.GetHomeListResponse> getHomeList(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHomeListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.CreateHomeResponse> createHome(
        com.amur.home.user.rpc.Home.CreateHomeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHomeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.UpdateHomeResponse> updateHome(
        com.amur.home.user.rpc.Home.UpdateHomeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHomeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.DeleteHomeResponse> deleteHome(
        com.amur.home.user.rpc.Home.DeleteHomeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHomeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.GetHomeUserListResponse> getHomeUserList(
        com.amur.home.user.rpc.Home.GetHomeUserListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHomeUserListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.UpdateHomeUserResponse> updateHomeUser(
        com.amur.home.user.rpc.Home.UpdateHomeUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHomeUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.DeleteHomeUserResponse> deleteHomeUser(
        com.amur.home.user.rpc.Home.DeleteHomeUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHomeUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.SetHomeAdminResponse> setHomeAdmin(
        com.amur.home.user.rpc.Home.SetHomeAdminRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetHomeAdminMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.Home.AddHomeImageResponse> addHomeImage(
        com.amur.home.user.rpc.Home.AddHomeImageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddHomeImageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_HOME_BASE_INFO = 0;
  private static final int METHODID_GET_HOME_DETAIL_INFO = 1;
  private static final int METHODID_GET_HOME_LIST = 2;
  private static final int METHODID_CREATE_HOME = 3;
  private static final int METHODID_UPDATE_HOME = 4;
  private static final int METHODID_DELETE_HOME = 5;
  private static final int METHODID_GET_HOME_USER_LIST = 6;
  private static final int METHODID_UPDATE_HOME_USER = 7;
  private static final int METHODID_DELETE_HOME_USER = 8;
  private static final int METHODID_SET_HOME_ADMIN = 9;
  private static final int METHODID_ADD_HOME_IMAGE = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HomeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HomeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_HOME_BASE_INFO:
          serviceImpl.getHomeBaseInfo((com.amur.home.user.rpc.Home.GetHomeBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeBaseResponse>) responseObserver);
          break;
        case METHODID_GET_HOME_DETAIL_INFO:
          serviceImpl.getHomeDetailInfo((com.amur.home.user.rpc.Home.GetHomeDetailRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeDetailResponse>) responseObserver);
          break;
        case METHODID_GET_HOME_LIST:
          serviceImpl.getHomeList((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeListResponse>) responseObserver);
          break;
        case METHODID_CREATE_HOME:
          serviceImpl.createHome((com.amur.home.user.rpc.Home.CreateHomeRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.CreateHomeResponse>) responseObserver);
          break;
        case METHODID_UPDATE_HOME:
          serviceImpl.updateHome((com.amur.home.user.rpc.Home.UpdateHomeRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.UpdateHomeResponse>) responseObserver);
          break;
        case METHODID_DELETE_HOME:
          serviceImpl.deleteHome((com.amur.home.user.rpc.Home.DeleteHomeRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.DeleteHomeResponse>) responseObserver);
          break;
        case METHODID_GET_HOME_USER_LIST:
          serviceImpl.getHomeUserList((com.amur.home.user.rpc.Home.GetHomeUserListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.GetHomeUserListResponse>) responseObserver);
          break;
        case METHODID_UPDATE_HOME_USER:
          serviceImpl.updateHomeUser((com.amur.home.user.rpc.Home.UpdateHomeUserRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.UpdateHomeUserResponse>) responseObserver);
          break;
        case METHODID_DELETE_HOME_USER:
          serviceImpl.deleteHomeUser((com.amur.home.user.rpc.Home.DeleteHomeUserRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.DeleteHomeUserResponse>) responseObserver);
          break;
        case METHODID_SET_HOME_ADMIN:
          serviceImpl.setHomeAdmin((com.amur.home.user.rpc.Home.SetHomeAdminRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.SetHomeAdminResponse>) responseObserver);
          break;
        case METHODID_ADD_HOME_IMAGE:
          serviceImpl.addHomeImage((com.amur.home.user.rpc.Home.AddHomeImageRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.Home.AddHomeImageResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HomeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HomeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.user.rpc.Home.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HomeService");
    }
  }

  private static final class HomeServiceFileDescriptorSupplier
      extends HomeServiceBaseDescriptorSupplier {
    HomeServiceFileDescriptorSupplier() {}
  }

  private static final class HomeServiceMethodDescriptorSupplier
      extends HomeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HomeServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HomeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HomeServiceFileDescriptorSupplier())
              .addMethod(getGetHomeBaseInfoMethod())
              .addMethod(getGetHomeDetailInfoMethod())
              .addMethod(getGetHomeListMethod())
              .addMethod(getCreateHomeMethod())
              .addMethod(getUpdateHomeMethod())
              .addMethod(getDeleteHomeMethod())
              .addMethod(getGetHomeUserListMethod())
              .addMethod(getUpdateHomeUserMethod())
              .addMethod(getDeleteHomeUserMethod())
              .addMethod(getSetHomeAdminMethod())
              .addMethod(getAddHomeImageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
