package com.amur.home.schedule.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: Schedule.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ScheduleServiceGrpc {

  private ScheduleServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.schedule.rpc.ScheduleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest,
      com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse> getAddScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddSchedule",
      requestType = com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest.class,
      responseType = com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest,
      com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse> getAddScheduleMethod() {
    io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest, com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse> getAddScheduleMethod;
    if ((getAddScheduleMethod = ScheduleServiceGrpc.getAddScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getAddScheduleMethod = ScheduleServiceGrpc.getAddScheduleMethod) == null) {
          ScheduleServiceGrpc.getAddScheduleMethod = getAddScheduleMethod =
              io.grpc.MethodDescriptor.<com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest, com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("AddSchedule"))
              .build();
        }
      }
    }
    return getAddScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest,
      com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> getDelScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelSchedule",
      requestType = com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest.class,
      responseType = com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest,
      com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> getDelScheduleMethod() {
    io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest, com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> getDelScheduleMethod;
    if ((getDelScheduleMethod = ScheduleServiceGrpc.getDelScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getDelScheduleMethod = ScheduleServiceGrpc.getDelScheduleMethod) == null) {
          ScheduleServiceGrpc.getDelScheduleMethod = getDelScheduleMethod =
              io.grpc.MethodDescriptor.<com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest, com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("DelSchedule"))
              .build();
        }
      }
    }
    return getDelScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest,
      com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> getUpdateScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSchedule",
      requestType = com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest.class,
      responseType = com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest,
      com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> getUpdateScheduleMethod() {
    io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest, com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> getUpdateScheduleMethod;
    if ((getUpdateScheduleMethod = ScheduleServiceGrpc.getUpdateScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getUpdateScheduleMethod = ScheduleServiceGrpc.getUpdateScheduleMethod) == null) {
          ScheduleServiceGrpc.getUpdateScheduleMethod = getUpdateScheduleMethod =
              io.grpc.MethodDescriptor.<com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest, com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("UpdateSchedule"))
              .build();
        }
      }
    }
    return getUpdateScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest,
      com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse> getGetScheduleInfoByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScheduleInfoById",
      requestType = com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest.class,
      responseType = com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest,
      com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse> getGetScheduleInfoByIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest, com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse> getGetScheduleInfoByIdMethod;
    if ((getGetScheduleInfoByIdMethod = ScheduleServiceGrpc.getGetScheduleInfoByIdMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getGetScheduleInfoByIdMethod = ScheduleServiceGrpc.getGetScheduleInfoByIdMethod) == null) {
          ScheduleServiceGrpc.getGetScheduleInfoByIdMethod = getGetScheduleInfoByIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest, com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScheduleInfoById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("GetScheduleInfoById"))
              .build();
        }
      }
    }
    return getGetScheduleInfoByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest,
      com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> getGetScheduleInfoByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScheduleInfoByUserId",
      requestType = com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest.class,
      responseType = com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest,
      com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> getGetScheduleInfoByUserIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest, com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> getGetScheduleInfoByUserIdMethod;
    if ((getGetScheduleInfoByUserIdMethod = ScheduleServiceGrpc.getGetScheduleInfoByUserIdMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getGetScheduleInfoByUserIdMethod = ScheduleServiceGrpc.getGetScheduleInfoByUserIdMethod) == null) {
          ScheduleServiceGrpc.getGetScheduleInfoByUserIdMethod = getGetScheduleInfoByUserIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest, com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScheduleInfoByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("GetScheduleInfoByUserId"))
              .build();
        }
      }
    }
    return getGetScheduleInfoByUserIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest,
      com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> getGetScheduleInfoByUserIdAndTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScheduleInfoByUserIdAndTime",
      requestType = com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest.class,
      responseType = com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest,
      com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> getGetScheduleInfoByUserIdAndTimeMethod() {
    io.grpc.MethodDescriptor<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest, com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> getGetScheduleInfoByUserIdAndTimeMethod;
    if ((getGetScheduleInfoByUserIdAndTimeMethod = ScheduleServiceGrpc.getGetScheduleInfoByUserIdAndTimeMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getGetScheduleInfoByUserIdAndTimeMethod = ScheduleServiceGrpc.getGetScheduleInfoByUserIdAndTimeMethod) == null) {
          ScheduleServiceGrpc.getGetScheduleInfoByUserIdAndTimeMethod = getGetScheduleInfoByUserIdAndTimeMethod =
              io.grpc.MethodDescriptor.<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest, com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScheduleInfoByUserIdAndTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("GetScheduleInfoByUserIdAndTime"))
              .build();
        }
      }
    }
    return getGetScheduleInfoByUserIdAndTimeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ScheduleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceStub>() {
        @java.lang.Override
        public ScheduleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScheduleServiceStub(channel, callOptions);
        }
      };
    return ScheduleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScheduleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceBlockingStub>() {
        @java.lang.Override
        public ScheduleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScheduleServiceBlockingStub(channel, callOptions);
        }
      };
    return ScheduleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ScheduleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceFutureStub>() {
        @java.lang.Override
        public ScheduleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScheduleServiceFutureStub(channel, callOptions);
        }
      };
    return ScheduleServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ScheduleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addSchedule(com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddScheduleMethod(), responseObserver);
    }

    /**
     */
    public void delSchedule(com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelScheduleMethod(), responseObserver);
    }

    /**
     */
    public void updateSchedule(com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateScheduleMethod(), responseObserver);
    }

    /**
     */
    public void getScheduleInfoById(com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScheduleInfoByIdMethod(), responseObserver);
    }

    /**
     */
    public void getScheduleInfoByUserId(com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScheduleInfoByUserIdMethod(), responseObserver);
    }

    /**
     */
    public void getScheduleInfoByUserIdAndTime(com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScheduleInfoByUserIdAndTimeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest,
                com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse>(
                  this, METHODID_ADD_SCHEDULE)))
          .addMethod(
            getDelScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest,
                com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult>(
                  this, METHODID_DEL_SCHEDULE)))
          .addMethod(
            getUpdateScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest,
                com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult>(
                  this, METHODID_UPDATE_SCHEDULE)))
          .addMethod(
            getGetScheduleInfoByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest,
                com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse>(
                  this, METHODID_GET_SCHEDULE_INFO_BY_ID)))
          .addMethod(
            getGetScheduleInfoByUserIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest,
                com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse>(
                  this, METHODID_GET_SCHEDULE_INFO_BY_USER_ID)))
          .addMethod(
            getGetScheduleInfoByUserIdAndTimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest,
                com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse>(
                  this, METHODID_GET_SCHEDULE_INFO_BY_USER_ID_AND_TIME)))
          .build();
    }
  }

  /**
   */
  public static final class ScheduleServiceStub extends io.grpc.stub.AbstractAsyncStub<ScheduleServiceStub> {
    private ScheduleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceStub(channel, callOptions);
    }

    /**
     */
    public void addSchedule(com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddScheduleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delSchedule(com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelScheduleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateSchedule(com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateScheduleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getScheduleInfoById(com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScheduleInfoByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getScheduleInfoByUserId(com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScheduleInfoByUserIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getScheduleInfoByUserIdAndTime(com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScheduleInfoByUserIdAndTimeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ScheduleServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ScheduleServiceBlockingStub> {
    private ScheduleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse addSchedule(com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddScheduleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult delSchedule(com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelScheduleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult updateSchedule(com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateScheduleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse getScheduleInfoById(com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScheduleInfoByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse getScheduleInfoByUserId(com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScheduleInfoByUserIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse getScheduleInfoByUserIdAndTime(com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScheduleInfoByUserIdAndTimeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ScheduleServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ScheduleServiceFutureStub> {
    private ScheduleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse> addSchedule(
        com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddScheduleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> delSchedule(
        com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelScheduleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult> updateSchedule(
        com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateScheduleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse> getScheduleInfoById(
        com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScheduleInfoByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> getScheduleInfoByUserId(
        com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScheduleInfoByUserIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse> getScheduleInfoByUserIdAndTime(
        com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScheduleInfoByUserIdAndTimeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_SCHEDULE = 0;
  private static final int METHODID_DEL_SCHEDULE = 1;
  private static final int METHODID_UPDATE_SCHEDULE = 2;
  private static final int METHODID_GET_SCHEDULE_INFO_BY_ID = 3;
  private static final int METHODID_GET_SCHEDULE_INFO_BY_USER_ID = 4;
  private static final int METHODID_GET_SCHEDULE_INFO_BY_USER_ID_AND_TIME = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ScheduleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ScheduleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_SCHEDULE:
          serviceImpl.addSchedule((com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.AddScheduleResponse>) responseObserver);
          break;
        case METHODID_DEL_SCHEDULE:
          serviceImpl.delSchedule((com.amur.home.schedule.rpc.ScheduleServiceProto.DelScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult>) responseObserver);
          break;
        case METHODID_UPDATE_SCHEDULE:
          serviceImpl.updateSchedule((com.amur.home.schedule.rpc.ScheduleServiceProto.UpdateScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ServiceResultProto.ServiceResult>) responseObserver);
          break;
        case METHODID_GET_SCHEDULE_INFO_BY_ID:
          serviceImpl.getScheduleInfoById((com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoResponse>) responseObserver);
          break;
        case METHODID_GET_SCHEDULE_INFO_BY_USER_ID:
          serviceImpl.getScheduleInfoByUserId((com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse>) responseObserver);
          break;
        case METHODID_GET_SCHEDULE_INFO_BY_USER_ID_AND_TIME:
          serviceImpl.getScheduleInfoByUserIdAndTime((com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleInfoByUserIdAndTimeRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.schedule.rpc.ScheduleServiceProto.GetScheduleListResponse>) responseObserver);
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

  private static abstract class ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScheduleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.schedule.rpc.ScheduleServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ScheduleService");
    }
  }

  private static final class ScheduleServiceFileDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier {
    ScheduleServiceFileDescriptorSupplier() {}
  }

  private static final class ScheduleServiceMethodDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ScheduleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ScheduleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ScheduleServiceFileDescriptorSupplier())
              .addMethod(getAddScheduleMethod())
              .addMethod(getDelScheduleMethod())
              .addMethod(getUpdateScheduleMethod())
              .addMethod(getGetScheduleInfoByIdMethod())
              .addMethod(getGetScheduleInfoByUserIdMethod())
              .addMethod(getGetScheduleInfoByUserIdAndTimeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
