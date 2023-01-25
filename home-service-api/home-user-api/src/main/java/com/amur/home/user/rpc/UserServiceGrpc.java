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
  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserBaseRequest,
      com.amur.home.user.rpc.User.GetUserBaseResponse> getGetUserBaseInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserBaseInfo",
      requestType = com.amur.home.user.rpc.User.GetUserBaseRequest.class,
      responseType = com.amur.home.user.rpc.User.GetUserBaseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserBaseRequest,
      com.amur.home.user.rpc.User.GetUserBaseResponse> getGetUserBaseInfoMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserBaseRequest, com.amur.home.user.rpc.User.GetUserBaseResponse> getGetUserBaseInfoMethod;
    if ((getGetUserBaseInfoMethod = UserServiceGrpc.getGetUserBaseInfoMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserBaseInfoMethod = UserServiceGrpc.getGetUserBaseInfoMethod) == null) {
          UserServiceGrpc.getGetUserBaseInfoMethod = getGetUserBaseInfoMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.User.GetUserBaseRequest, com.amur.home.user.rpc.User.GetUserBaseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserBaseInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserBaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserBaseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserBaseInfo"))
              .build();
        }
      }
    }
    return getGetUserBaseInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserDetailRequest,
      com.amur.home.user.rpc.User.GetUserDetailResponse> getGetUserDetailInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserDetailInfo",
      requestType = com.amur.home.user.rpc.User.GetUserDetailRequest.class,
      responseType = com.amur.home.user.rpc.User.GetUserDetailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserDetailRequest,
      com.amur.home.user.rpc.User.GetUserDetailResponse> getGetUserDetailInfoMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserDetailRequest, com.amur.home.user.rpc.User.GetUserDetailResponse> getGetUserDetailInfoMethod;
    if ((getGetUserDetailInfoMethod = UserServiceGrpc.getGetUserDetailInfoMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserDetailInfoMethod = UserServiceGrpc.getGetUserDetailInfoMethod) == null) {
          UserServiceGrpc.getGetUserDetailInfoMethod = getGetUserDetailInfoMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.User.GetUserDetailRequest, com.amur.home.user.rpc.User.GetUserDetailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserDetailInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserDetailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserDetailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserDetailInfo"))
              .build();
        }
      }
    }
    return getGetUserDetailInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserAuthByNameRequest,
      com.amur.home.user.rpc.User.GetUserAuthByNameResponse> getGetUserAuthByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserAuthByName",
      requestType = com.amur.home.user.rpc.User.GetUserAuthByNameRequest.class,
      responseType = com.amur.home.user.rpc.User.GetUserAuthByNameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserAuthByNameRequest,
      com.amur.home.user.rpc.User.GetUserAuthByNameResponse> getGetUserAuthByNameMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserAuthByNameRequest, com.amur.home.user.rpc.User.GetUserAuthByNameResponse> getGetUserAuthByNameMethod;
    if ((getGetUserAuthByNameMethod = UserServiceGrpc.getGetUserAuthByNameMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserAuthByNameMethod = UserServiceGrpc.getGetUserAuthByNameMethod) == null) {
          UserServiceGrpc.getGetUserAuthByNameMethod = getGetUserAuthByNameMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.User.GetUserAuthByNameRequest, com.amur.home.user.rpc.User.GetUserAuthByNameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserAuthByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserAuthByNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserAuthByNameResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserAuthByName"))
              .build();
        }
      }
    }
    return getGetUserAuthByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserAuthByIdRequest,
      com.amur.home.user.rpc.User.GetUserAuthByIdResponse> getGetUserAuthByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserAuthById",
      requestType = com.amur.home.user.rpc.User.GetUserAuthByIdRequest.class,
      responseType = com.amur.home.user.rpc.User.GetUserAuthByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserAuthByIdRequest,
      com.amur.home.user.rpc.User.GetUserAuthByIdResponse> getGetUserAuthByIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserAuthByIdRequest, com.amur.home.user.rpc.User.GetUserAuthByIdResponse> getGetUserAuthByIdMethod;
    if ((getGetUserAuthByIdMethod = UserServiceGrpc.getGetUserAuthByIdMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserAuthByIdMethod = UserServiceGrpc.getGetUserAuthByIdMethod) == null) {
          UserServiceGrpc.getGetUserAuthByIdMethod = getGetUserAuthByIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.User.GetUserAuthByIdRequest, com.amur.home.user.rpc.User.GetUserAuthByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserAuthById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserAuthByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserAuthByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserAuthById"))
              .build();
        }
      }
    }
    return getGetUserAuthByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest,
      com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse> getGetUserPermissionsByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUserPermissionsByName",
      requestType = com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest.class,
      responseType = com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest,
      com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse> getGetUserPermissionsByNameMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest, com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse> getGetUserPermissionsByNameMethod;
    if ((getGetUserPermissionsByNameMethod = UserServiceGrpc.getGetUserPermissionsByNameMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserPermissionsByNameMethod = UserServiceGrpc.getGetUserPermissionsByNameMethod) == null) {
          UserServiceGrpc.getGetUserPermissionsByNameMethod = getGetUserPermissionsByNameMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest, com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUserPermissionsByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("getUserPermissionsByName"))
              .build();
        }
      }
    }
    return getGetUserPermissionsByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.CreateUserRequest,
      com.amur.home.user.rpc.User.CreateUserResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = com.amur.home.user.rpc.User.CreateUserRequest.class,
      responseType = com.amur.home.user.rpc.User.CreateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.CreateUserRequest,
      com.amur.home.user.rpc.User.CreateUserResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.CreateUserRequest, com.amur.home.user.rpc.User.CreateUserResponse> getCreateUserMethod;
    if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
          UserServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.User.CreateUserRequest, com.amur.home.user.rpc.User.CreateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.CreateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.CreateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.UpdateUserRequest,
      com.amur.home.user.rpc.User.UpdateUserResponse> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = com.amur.home.user.rpc.User.UpdateUserRequest.class,
      responseType = com.amur.home.user.rpc.User.UpdateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.UpdateUserRequest,
      com.amur.home.user.rpc.User.UpdateUserResponse> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.UpdateUserRequest, com.amur.home.user.rpc.User.UpdateUserResponse> getUpdateUserMethod;
    if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
          UserServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.User.UpdateUserRequest, com.amur.home.user.rpc.User.UpdateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.UpdateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.UpdateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UpdateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.DeleteUserRequest,
      com.amur.home.user.rpc.User.DeleteUserResponse> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = com.amur.home.user.rpc.User.DeleteUserRequest.class,
      responseType = com.amur.home.user.rpc.User.DeleteUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.DeleteUserRequest,
      com.amur.home.user.rpc.User.DeleteUserResponse> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.User.DeleteUserRequest, com.amur.home.user.rpc.User.DeleteUserResponse> getDeleteUserMethod;
    if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getDeleteUserMethod = UserServiceGrpc.getDeleteUserMethod) == null) {
          UserServiceGrpc.getDeleteUserMethod = getDeleteUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.User.DeleteUserRequest, com.amur.home.user.rpc.User.DeleteUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.DeleteUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.User.DeleteUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("DeleteUser"))
              .build();
        }
      }
    }
    return getDeleteUserMethod;
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
    public void getUserBaseInfo(com.amur.home.user.rpc.User.GetUserBaseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserBaseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserBaseInfoMethod(), responseObserver);
    }

    /**
     */
    public void getUserDetailInfo(com.amur.home.user.rpc.User.GetUserDetailRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserDetailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserDetailInfoMethod(), responseObserver);
    }

    /**
     */
    public void getUserAuthByName(com.amur.home.user.rpc.User.GetUserAuthByNameRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserAuthByNameResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserAuthByNameMethod(), responseObserver);
    }

    /**
     */
    public void getUserAuthById(com.amur.home.user.rpc.User.GetUserAuthByIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserAuthByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserAuthByIdMethod(), responseObserver);
    }

    /**
     */
    public void getUserPermissionsByName(com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserPermissionsByNameMethod(), responseObserver);
    }

    /**
     */
    public void createUser(com.amur.home.user.rpc.User.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.CreateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    public void updateUser(com.amur.home.user.rpc.User.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    public void deleteUser(com.amur.home.user.rpc.User.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.DeleteUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserBaseInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.User.GetUserBaseRequest,
                com.amur.home.user.rpc.User.GetUserBaseResponse>(
                  this, METHODID_GET_USER_BASE_INFO)))
          .addMethod(
            getGetUserDetailInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.User.GetUserDetailRequest,
                com.amur.home.user.rpc.User.GetUserDetailResponse>(
                  this, METHODID_GET_USER_DETAIL_INFO)))
          .addMethod(
            getGetUserAuthByNameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.User.GetUserAuthByNameRequest,
                com.amur.home.user.rpc.User.GetUserAuthByNameResponse>(
                  this, METHODID_GET_USER_AUTH_BY_NAME)))
          .addMethod(
            getGetUserAuthByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.User.GetUserAuthByIdRequest,
                com.amur.home.user.rpc.User.GetUserAuthByIdResponse>(
                  this, METHODID_GET_USER_AUTH_BY_ID)))
          .addMethod(
            getGetUserPermissionsByNameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest,
                com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse>(
                  this, METHODID_GET_USER_PERMISSIONS_BY_NAME)))
          .addMethod(
            getCreateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.User.CreateUserRequest,
                com.amur.home.user.rpc.User.CreateUserResponse>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            getUpdateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.User.UpdateUserRequest,
                com.amur.home.user.rpc.User.UpdateUserResponse>(
                  this, METHODID_UPDATE_USER)))
          .addMethod(
            getDeleteUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.User.DeleteUserRequest,
                com.amur.home.user.rpc.User.DeleteUserResponse>(
                  this, METHODID_DELETE_USER)))
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
    public void getUserBaseInfo(com.amur.home.user.rpc.User.GetUserBaseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserBaseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserBaseInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserDetailInfo(com.amur.home.user.rpc.User.GetUserDetailRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserDetailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserDetailInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserAuthByName(com.amur.home.user.rpc.User.GetUserAuthByNameRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserAuthByNameResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserAuthByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserAuthById(com.amur.home.user.rpc.User.GetUserAuthByIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserAuthByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserAuthByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserPermissionsByName(com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserPermissionsByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createUser(com.amur.home.user.rpc.User.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.CreateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(com.amur.home.user.rpc.User.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(com.amur.home.user.rpc.User.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.DeleteUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
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
    public com.amur.home.user.rpc.User.GetUserBaseResponse getUserBaseInfo(com.amur.home.user.rpc.User.GetUserBaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserBaseInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.User.GetUserDetailResponse getUserDetailInfo(com.amur.home.user.rpc.User.GetUserDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserDetailInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.User.GetUserAuthByNameResponse getUserAuthByName(com.amur.home.user.rpc.User.GetUserAuthByNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserAuthByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.User.GetUserAuthByIdResponse getUserAuthById(com.amur.home.user.rpc.User.GetUserAuthByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserAuthByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse getUserPermissionsByName(com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserPermissionsByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.User.CreateUserResponse createUser(com.amur.home.user.rpc.User.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.User.UpdateUserResponse updateUser(com.amur.home.user.rpc.User.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.User.DeleteUserResponse deleteUser(com.amur.home.user.rpc.User.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.User.GetUserBaseResponse> getUserBaseInfo(
        com.amur.home.user.rpc.User.GetUserBaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserBaseInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.User.GetUserDetailResponse> getUserDetailInfo(
        com.amur.home.user.rpc.User.GetUserDetailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserDetailInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.User.GetUserAuthByNameResponse> getUserAuthByName(
        com.amur.home.user.rpc.User.GetUserAuthByNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserAuthByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.User.GetUserAuthByIdResponse> getUserAuthById(
        com.amur.home.user.rpc.User.GetUserAuthByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserAuthByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse> getUserPermissionsByName(
        com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserPermissionsByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.User.CreateUserResponse> createUser(
        com.amur.home.user.rpc.User.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.User.UpdateUserResponse> updateUser(
        com.amur.home.user.rpc.User.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.User.DeleteUserResponse> deleteUser(
        com.amur.home.user.rpc.User.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_BASE_INFO = 0;
  private static final int METHODID_GET_USER_DETAIL_INFO = 1;
  private static final int METHODID_GET_USER_AUTH_BY_NAME = 2;
  private static final int METHODID_GET_USER_AUTH_BY_ID = 3;
  private static final int METHODID_GET_USER_PERMISSIONS_BY_NAME = 4;
  private static final int METHODID_CREATE_USER = 5;
  private static final int METHODID_UPDATE_USER = 6;
  private static final int METHODID_DELETE_USER = 7;

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
        case METHODID_GET_USER_BASE_INFO:
          serviceImpl.getUserBaseInfo((com.amur.home.user.rpc.User.GetUserBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserBaseResponse>) responseObserver);
          break;
        case METHODID_GET_USER_DETAIL_INFO:
          serviceImpl.getUserDetailInfo((com.amur.home.user.rpc.User.GetUserDetailRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserDetailResponse>) responseObserver);
          break;
        case METHODID_GET_USER_AUTH_BY_NAME:
          serviceImpl.getUserAuthByName((com.amur.home.user.rpc.User.GetUserAuthByNameRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserAuthByNameResponse>) responseObserver);
          break;
        case METHODID_GET_USER_AUTH_BY_ID:
          serviceImpl.getUserAuthById((com.amur.home.user.rpc.User.GetUserAuthByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserAuthByIdResponse>) responseObserver);
          break;
        case METHODID_GET_USER_PERMISSIONS_BY_NAME:
          serviceImpl.getUserPermissionsByName((com.amur.home.user.rpc.User.GetUserPermissionsByNameRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.GetUserPermissionsByNameResponse>) responseObserver);
          break;
        case METHODID_CREATE_USER:
          serviceImpl.createUser((com.amur.home.user.rpc.User.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.CreateUserResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((com.amur.home.user.rpc.User.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.UpdateUserResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((com.amur.home.user.rpc.User.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.User.DeleteUserResponse>) responseObserver);
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
      return com.amur.home.user.rpc.User.getDescriptor();
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
              .addMethod(getGetUserBaseInfoMethod())
              .addMethod(getGetUserDetailInfoMethod())
              .addMethod(getGetUserAuthByNameMethod())
              .addMethod(getGetUserAuthByIdMethod())
              .addMethod(getGetUserPermissionsByNameMethod())
              .addMethod(getCreateUserMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getDeleteUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
