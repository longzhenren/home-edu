package com.amur.home.auth.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: auth.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthServiceGrpc {

  private AuthServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.auth.rpc.AuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest,
      com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse> getGetAuthByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthById",
      requestType = com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest.class,
      responseType = com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest,
      com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse> getGetAuthByIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest, com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse> getGetAuthByIdMethod;
    if ((getGetAuthByIdMethod = AuthServiceGrpc.getGetAuthByIdMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGetAuthByIdMethod = AuthServiceGrpc.getGetAuthByIdMethod) == null) {
          AuthServiceGrpc.getGetAuthByIdMethod = getGetAuthByIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest, com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuthById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("GetAuthById"))
              .build();
        }
      }
    }
    return getGetAuthByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest,
      com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getAddPermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddPermission",
      requestType = com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest.class,
      responseType = com.amur.home.auth.rpc.ServiceResultProto.ServiceResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest,
      com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getAddPermissionMethod() {
    io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest, com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getAddPermissionMethod;
    if ((getAddPermissionMethod = AuthServiceGrpc.getAddPermissionMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getAddPermissionMethod = AuthServiceGrpc.getAddPermissionMethod) == null) {
          AuthServiceGrpc.getAddPermissionMethod = getAddPermissionMethod =
              io.grpc.MethodDescriptor.<com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest, com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddPermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.ServiceResultProto.ServiceResult.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("AddPermission"))
              .build();
        }
      }
    }
    return getAddPermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest,
      com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getRemovePermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemovePermission",
      requestType = com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest.class,
      responseType = com.amur.home.auth.rpc.ServiceResultProto.ServiceResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest,
      com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getRemovePermissionMethod() {
    io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest, com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getRemovePermissionMethod;
    if ((getRemovePermissionMethod = AuthServiceGrpc.getRemovePermissionMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getRemovePermissionMethod = AuthServiceGrpc.getRemovePermissionMethod) == null) {
          AuthServiceGrpc.getRemovePermissionMethod = getRemovePermissionMethod =
              io.grpc.MethodDescriptor.<com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest, com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemovePermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.ServiceResultProto.ServiceResult.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("RemovePermission"))
              .build();
        }
      }
    }
    return getRemovePermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest,
      com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getAddRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddRole",
      requestType = com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest.class,
      responseType = com.amur.home.auth.rpc.ServiceResultProto.ServiceResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest,
      com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getAddRoleMethod() {
    io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest, com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getAddRoleMethod;
    if ((getAddRoleMethod = AuthServiceGrpc.getAddRoleMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getAddRoleMethod = AuthServiceGrpc.getAddRoleMethod) == null) {
          AuthServiceGrpc.getAddRoleMethod = getAddRoleMethod =
              io.grpc.MethodDescriptor.<com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest, com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.ServiceResultProto.ServiceResult.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("AddRole"))
              .build();
        }
      }
    }
    return getAddRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest,
      com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getRemoveRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveRole",
      requestType = com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest.class,
      responseType = com.amur.home.auth.rpc.ServiceResultProto.ServiceResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest,
      com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getRemoveRoleMethod() {
    io.grpc.MethodDescriptor<com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest, com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> getRemoveRoleMethod;
    if ((getRemoveRoleMethod = AuthServiceGrpc.getRemoveRoleMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getRemoveRoleMethod = AuthServiceGrpc.getRemoveRoleMethod) == null) {
          AuthServiceGrpc.getRemoveRoleMethod = getRemoveRoleMethod =
              io.grpc.MethodDescriptor.<com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest, com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.auth.rpc.ServiceResultProto.ServiceResult.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("RemoveRole"))
              .build();
        }
      }
    }
    return getRemoveRoleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub>() {
        @java.lang.Override
        public AuthServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceStub(channel, callOptions);
        }
      };
    return AuthServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub>() {
        @java.lang.Override
        public AuthServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceBlockingStub(channel, callOptions);
        }
      };
    return AuthServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub>() {
        @java.lang.Override
        public AuthServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceFutureStub(channel, callOptions);
        }
      };
    return AuthServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AuthServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *  rpc Login (LoginRequest) returns (LoginResponse){};
     *  rpc Logout (LogoutRequest) returns (LogoutResponse){};
     *  rpc Register (RegisterRequest) returns (RegisterResponse){};
     * </pre>
     */
    public void getAuthById(com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAuthByIdMethod(), responseObserver);
    }

    /**
     */
    public void addPermission(com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddPermissionMethod(), responseObserver);
    }

    /**
     */
    public void removePermission(com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemovePermissionMethod(), responseObserver);
    }

    /**
     */
    public void addRole(com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddRoleMethod(), responseObserver);
    }

    /**
     */
    public void removeRole(com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveRoleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAuthByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest,
                com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse>(
                  this, METHODID_GET_AUTH_BY_ID)))
          .addMethod(
            getAddPermissionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest,
                com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>(
                  this, METHODID_ADD_PERMISSION)))
          .addMethod(
            getRemovePermissionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest,
                com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>(
                  this, METHODID_REMOVE_PERMISSION)))
          .addMethod(
            getAddRoleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest,
                com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>(
                  this, METHODID_ADD_ROLE)))
          .addMethod(
            getRemoveRoleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest,
                com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>(
                  this, METHODID_REMOVE_ROLE)))
          .build();
    }
  }

  /**
   */
  public static final class AuthServiceStub extends io.grpc.stub.AbstractAsyncStub<AuthServiceStub> {
    private AuthServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *  rpc Login (LoginRequest) returns (LoginResponse){};
     *  rpc Logout (LogoutRequest) returns (LogoutResponse){};
     *  rpc Register (RegisterRequest) returns (RegisterResponse){};
     * </pre>
     */
    public void getAuthById(com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addPermission(com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddPermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removePermission(com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemovePermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addRole(com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeRole(com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveRoleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AuthServiceBlockingStub> {
    private AuthServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *  rpc Login (LoginRequest) returns (LoginResponse){};
     *  rpc Logout (LogoutRequest) returns (LogoutResponse){};
     *  rpc Register (RegisterRequest) returns (RegisterResponse){};
     * </pre>
     */
    public com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse getAuthById(com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.auth.rpc.ServiceResultProto.ServiceResult addPermission(com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddPermissionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.auth.rpc.ServiceResultProto.ServiceResult removePermission(com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemovePermissionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.auth.rpc.ServiceResultProto.ServiceResult addRole(com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.auth.rpc.ServiceResultProto.ServiceResult removeRole(com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveRoleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AuthServiceFutureStub> {
    private AuthServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *  rpc Login (LoginRequest) returns (LoginResponse){};
     *  rpc Logout (LogoutRequest) returns (LogoutResponse){};
     *  rpc Register (RegisterRequest) returns (RegisterResponse){};
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse> getAuthById(
        com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> addPermission(
        com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddPermissionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> removePermission(
        com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemovePermissionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> addRole(
        com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddRoleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult> removeRole(
        com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveRoleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AUTH_BY_ID = 0;
  private static final int METHODID_ADD_PERMISSION = 1;
  private static final int METHODID_REMOVE_PERMISSION = 2;
  private static final int METHODID_ADD_ROLE = 3;
  private static final int METHODID_REMOVE_ROLE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AUTH_BY_ID:
          serviceImpl.getAuthById((com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.AuthServiceProto.GetAuthByIdResponse>) responseObserver);
          break;
        case METHODID_ADD_PERMISSION:
          serviceImpl.addPermission((com.amur.home.auth.rpc.AuthServiceProto.AddPermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>) responseObserver);
          break;
        case METHODID_REMOVE_PERMISSION:
          serviceImpl.removePermission((com.amur.home.auth.rpc.AuthServiceProto.RemovePermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>) responseObserver);
          break;
        case METHODID_ADD_ROLE:
          serviceImpl.addRole((com.amur.home.auth.rpc.AuthServiceProto.AddRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>) responseObserver);
          break;
        case METHODID_REMOVE_ROLE:
          serviceImpl.removeRole((com.amur.home.auth.rpc.AuthServiceProto.RemoveRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.auth.rpc.ServiceResultProto.ServiceResult>) responseObserver);
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

  private static abstract class AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.auth.rpc.AuthServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthService");
    }
  }

  private static final class AuthServiceFileDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier {
    AuthServiceFileDescriptorSupplier() {}
  }

  private static final class AuthServiceMethodDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthServiceFileDescriptorSupplier())
              .addMethod(getGetAuthByIdMethod())
              .addMethod(getAddPermissionMethod())
              .addMethod(getRemovePermissionMethod())
              .addMethod(getAddRoleMethod())
              .addMethod(getRemoveRoleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
