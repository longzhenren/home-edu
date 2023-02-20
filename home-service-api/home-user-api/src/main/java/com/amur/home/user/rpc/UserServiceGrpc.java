package com.amur.home.user.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: user.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.user.rpc.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserIdRequest,
      com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> getGetUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserInfo",
      requestType = com.amur.home.user.rpc.UserServiceProto.UserIdRequest.class,
      responseType = com.amur.home.user.rpc.UserServiceProto.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserIdRequest,
      com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> getGetUserInfoMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserIdRequest, com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> getGetUserInfoMethod;
    if ((getGetUserInfoMethod = UserServiceGrpc.getGetUserInfoMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserInfoMethod = UserServiceGrpc.getGetUserInfoMethod) == null) {
          UserServiceGrpc.getGetUserInfoMethod = getGetUserInfoMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.UserServiceProto.UserIdRequest, com.amur.home.user.rpc.UserServiceProto.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.UserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserInfo"))
              .build();
        }
      }
    }
    return getGetUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserInfoRequest,
      com.amur.home.user.rpc.UserServiceProto.ServiceResult> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = com.amur.home.user.rpc.UserServiceProto.UserInfoRequest.class,
      responseType = com.amur.home.user.rpc.UserServiceProto.ServiceResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserInfoRequest,
      com.amur.home.user.rpc.UserServiceProto.ServiceResult> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserInfoRequest, com.amur.home.user.rpc.UserServiceProto.ServiceResult> getUpdateUserMethod;
    if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
          UserServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.UserServiceProto.UserInfoRequest, com.amur.home.user.rpc.UserServiceProto.ServiceResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.UserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.ServiceResult.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UpdateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserIdRequest,
      com.amur.home.user.rpc.UserServiceProto.ServiceResult> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = com.amur.home.user.rpc.UserServiceProto.UserIdRequest.class,
      responseType = com.amur.home.user.rpc.UserServiceProto.ServiceResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserIdRequest,
      com.amur.home.user.rpc.UserServiceProto.ServiceResult> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserIdRequest, com.amur.home.user.rpc.UserServiceProto.ServiceResult> getDeleteUserMethod;
    if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
          UserServiceGrpc.getDeleteUserMethod = getDeleteUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.UserServiceProto.UserIdRequest, com.amur.home.user.rpc.UserServiceProto.ServiceResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.UserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.ServiceResult.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("DeleteUser"))
              .build();
        }
      }
    }
    return getDeleteUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserInfoRequest,
      com.amur.home.user.rpc.UserServiceProto.UserIdResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = com.amur.home.user.rpc.UserServiceProto.UserInfoRequest.class,
      responseType = com.amur.home.user.rpc.UserServiceProto.UserIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserInfoRequest,
      com.amur.home.user.rpc.UserServiceProto.UserIdResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserInfoRequest, com.amur.home.user.rpc.UserServiceProto.UserIdResponse> getCreateUserMethod;
    if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
          UserServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.UserServiceProto.UserInfoRequest, com.amur.home.user.rpc.UserServiceProto.UserIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.UserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.UserIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserNameRequest,
      com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> getGetUserByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserByName",
      requestType = com.amur.home.user.rpc.UserServiceProto.UserNameRequest.class,
      responseType = com.amur.home.user.rpc.UserServiceProto.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserNameRequest,
      com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> getGetUserByNameMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.UserServiceProto.UserNameRequest, com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> getGetUserByNameMethod;
    if ((getGetUserByNameMethod = UserServiceGrpc.getGetUserByNameMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserByNameMethod = UserServiceGrpc.getGetUserByNameMethod) == null) {
          UserServiceGrpc.getGetUserByNameMethod = getGetUserByNameMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.UserServiceProto.UserNameRequest, com.amur.home.user.rpc.UserServiceProto.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.UserNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.UserServiceProto.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserByName"))
              .build();
        }
      }
    }
    return getGetUserByNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserInfo(com.amur.home.user.rpc.UserServiceProto.UserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserInfoMethod(), responseObserver);
    }

    /**
     */
    public void updateUser(com.amur.home.user.rpc.UserServiceProto.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.ServiceResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    public void deleteUser(com.amur.home.user.rpc.UserServiceProto.UserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.ServiceResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    /**
     */
    public void createUser(com.amur.home.user.rpc.UserServiceProto.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.UserIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    public void getUserByName(com.amur.home.user.rpc.UserServiceProto.UserNameRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserByNameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.UserServiceProto.UserIdRequest,
                com.amur.home.user.rpc.UserServiceProto.UserInfoResponse>(
                  this, METHODID_GET_USER_INFO)))
          .addMethod(
            getUpdateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.UserServiceProto.UserInfoRequest,
                com.amur.home.user.rpc.UserServiceProto.ServiceResult>(
                  this, METHODID_UPDATE_USER)))
          .addMethod(
            getDeleteUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.UserServiceProto.UserIdRequest,
                com.amur.home.user.rpc.UserServiceProto.ServiceResult>(
                  this, METHODID_DELETE_USER)))
          .addMethod(
            getCreateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.UserServiceProto.UserInfoRequest,
                com.amur.home.user.rpc.UserServiceProto.UserIdResponse>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            getGetUserByNameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.UserServiceProto.UserNameRequest,
                com.amur.home.user.rpc.UserServiceProto.UserInfoResponse>(
                  this, METHODID_GET_USER_BY_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUserInfo(com.amur.home.user.rpc.UserServiceProto.UserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(com.amur.home.user.rpc.UserServiceProto.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.ServiceResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(com.amur.home.user.rpc.UserServiceProto.UserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.ServiceResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createUser(com.amur.home.user.rpc.UserServiceProto.UserInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.UserIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserByName(com.amur.home.user.rpc.UserServiceProto.UserNameRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserByNameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.amur.home.user.rpc.UserServiceProto.UserInfoResponse getUserInfo(com.amur.home.user.rpc.UserServiceProto.UserIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.UserServiceProto.ServiceResult updateUser(com.amur.home.user.rpc.UserServiceProto.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.UserServiceProto.ServiceResult deleteUser(com.amur.home.user.rpc.UserServiceProto.UserIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.UserServiceProto.UserIdResponse createUser(com.amur.home.user.rpc.UserServiceProto.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.UserServiceProto.UserInfoResponse getUserByName(com.amur.home.user.rpc.UserServiceProto.UserNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserByNameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> getUserInfo(
        com.amur.home.user.rpc.UserServiceProto.UserIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.UserServiceProto.ServiceResult> updateUser(
        com.amur.home.user.rpc.UserServiceProto.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.UserServiceProto.ServiceResult> deleteUser(
        com.amur.home.user.rpc.UserServiceProto.UserIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.UserServiceProto.UserIdResponse> createUser(
        com.amur.home.user.rpc.UserServiceProto.UserInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.UserServiceProto.UserInfoResponse> getUserByName(
        com.amur.home.user.rpc.UserServiceProto.UserNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserByNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_INFO = 0;
  private static final int METHODID_UPDATE_USER = 1;
  private static final int METHODID_DELETE_USER = 2;
  private static final int METHODID_CREATE_USER = 3;
  private static final int METHODID_GET_USER_BY_NAME = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_INFO:
          serviceImpl.getUserInfo((com.amur.home.user.rpc.UserServiceProto.UserIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.UserInfoResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((com.amur.home.user.rpc.UserServiceProto.UserInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.ServiceResult>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((com.amur.home.user.rpc.UserServiceProto.UserIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.ServiceResult>) responseObserver);
          break;
        case METHODID_CREATE_USER:
          serviceImpl.createUser((com.amur.home.user.rpc.UserServiceProto.UserInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.UserIdResponse>) responseObserver);
          break;
        case METHODID_GET_USER_BY_NAME:
          serviceImpl.getUserByName((com.amur.home.user.rpc.UserServiceProto.UserNameRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.UserServiceProto.UserInfoResponse>) responseObserver);
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

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.user.rpc.UserServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getGetUserInfoMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getDeleteUserMethod())
              .addMethod(getCreateUserMethod())
              .addMethod(getGetUserByNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
