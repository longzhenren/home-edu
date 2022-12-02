package com.amur.home.msg.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: Announcement.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AnnouncementServiceGrpc {

  private AnnouncementServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.msg.rpc.AnnouncementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse> getGetAnnouncementListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnnouncementList",
      requestType = com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest.class,
      responseType = com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse> getGetAnnouncementListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse> getGetAnnouncementListMethod;
    if ((getGetAnnouncementListMethod = AnnouncementServiceGrpc.getGetAnnouncementListMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getGetAnnouncementListMethod = AnnouncementServiceGrpc.getGetAnnouncementListMethod) == null) {
          AnnouncementServiceGrpc.getGetAnnouncementListMethod = getGetAnnouncementListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnnouncementList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("GetAnnouncementList"))
              .build();
        }
      }
    }
    return getGetAnnouncementListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse> getGetAnnouncementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnnouncement",
      requestType = com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest.class,
      responseType = com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse> getGetAnnouncementMethod() {
    io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse> getGetAnnouncementMethod;
    if ((getGetAnnouncementMethod = AnnouncementServiceGrpc.getGetAnnouncementMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getGetAnnouncementMethod = AnnouncementServiceGrpc.getGetAnnouncementMethod) == null) {
          AnnouncementServiceGrpc.getGetAnnouncementMethod = getGetAnnouncementMethod =
              io.grpc.MethodDescriptor.<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnnouncement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("GetAnnouncement"))
              .build();
        }
      }
    }
    return getGetAnnouncementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse> getCreateAnnouncementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnnouncement",
      requestType = com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest.class,
      responseType = com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse> getCreateAnnouncementMethod() {
    io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse> getCreateAnnouncementMethod;
    if ((getCreateAnnouncementMethod = AnnouncementServiceGrpc.getCreateAnnouncementMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getCreateAnnouncementMethod = AnnouncementServiceGrpc.getCreateAnnouncementMethod) == null) {
          AnnouncementServiceGrpc.getCreateAnnouncementMethod = getCreateAnnouncementMethod =
              io.grpc.MethodDescriptor.<com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAnnouncement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("CreateAnnouncement"))
              .build();
        }
      }
    }
    return getCreateAnnouncementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse> getUpdateAnnouncementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAnnouncement",
      requestType = com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest.class,
      responseType = com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse> getUpdateAnnouncementMethod() {
    io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse> getUpdateAnnouncementMethod;
    if ((getUpdateAnnouncementMethod = AnnouncementServiceGrpc.getUpdateAnnouncementMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getUpdateAnnouncementMethod = AnnouncementServiceGrpc.getUpdateAnnouncementMethod) == null) {
          AnnouncementServiceGrpc.getUpdateAnnouncementMethod = getUpdateAnnouncementMethod =
              io.grpc.MethodDescriptor.<com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAnnouncement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("UpdateAnnouncement"))
              .build();
        }
      }
    }
    return getUpdateAnnouncementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse> getDeleteAnnouncementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAnnouncement",
      requestType = com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest.class,
      responseType = com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest,
      com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse> getDeleteAnnouncementMethod() {
    io.grpc.MethodDescriptor<com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse> getDeleteAnnouncementMethod;
    if ((getDeleteAnnouncementMethod = AnnouncementServiceGrpc.getDeleteAnnouncementMethod) == null) {
      synchronized (AnnouncementServiceGrpc.class) {
        if ((getDeleteAnnouncementMethod = AnnouncementServiceGrpc.getDeleteAnnouncementMethod) == null) {
          AnnouncementServiceGrpc.getDeleteAnnouncementMethod = getDeleteAnnouncementMethod =
              io.grpc.MethodDescriptor.<com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest, com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAnnouncement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnnouncementServiceMethodDescriptorSupplier("DeleteAnnouncement"))
              .build();
        }
      }
    }
    return getDeleteAnnouncementMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AnnouncementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceStub>() {
        @java.lang.Override
        public AnnouncementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnnouncementServiceStub(channel, callOptions);
        }
      };
    return AnnouncementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnnouncementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceBlockingStub>() {
        @java.lang.Override
        public AnnouncementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnnouncementServiceBlockingStub(channel, callOptions);
        }
      };
    return AnnouncementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AnnouncementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnnouncementServiceFutureStub>() {
        @java.lang.Override
        public AnnouncementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnnouncementServiceFutureStub(channel, callOptions);
        }
      };
    return AnnouncementServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AnnouncementServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAnnouncementList(com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnnouncementListMethod(), responseObserver);
    }

    /**
     */
    public void getAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnnouncementMethod(), responseObserver);
    }

    /**
     */
    public void createAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAnnouncementMethod(), responseObserver);
    }

    /**
     */
    public void updateAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAnnouncementMethod(), responseObserver);
    }

    /**
     */
    public void deleteAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAnnouncementMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAnnouncementListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest,
                com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse>(
                  this, METHODID_GET_ANNOUNCEMENT_LIST)))
          .addMethod(
            getGetAnnouncementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest,
                com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse>(
                  this, METHODID_GET_ANNOUNCEMENT)))
          .addMethod(
            getCreateAnnouncementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest,
                com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse>(
                  this, METHODID_CREATE_ANNOUNCEMENT)))
          .addMethod(
            getUpdateAnnouncementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest,
                com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse>(
                  this, METHODID_UPDATE_ANNOUNCEMENT)))
          .addMethod(
            getDeleteAnnouncementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest,
                com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse>(
                  this, METHODID_DELETE_ANNOUNCEMENT)))
          .build();
    }
  }

  /**
   */
  public static final class AnnouncementServiceStub extends io.grpc.stub.AbstractAsyncStub<AnnouncementServiceStub> {
    private AnnouncementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnnouncementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnnouncementServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAnnouncementList(com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnnouncementListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnnouncementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnnouncementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAnnouncementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAnnouncementMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AnnouncementServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AnnouncementServiceBlockingStub> {
    private AnnouncementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnnouncementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnnouncementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse getAnnouncementList(com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnnouncementListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse getAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnnouncementMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse createAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnnouncementMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse updateAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAnnouncementMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse deleteAnnouncement(com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnnouncementMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AnnouncementServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AnnouncementServiceFutureStub> {
    private AnnouncementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnnouncementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnnouncementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse> getAnnouncementList(
        com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnnouncementListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse> getAnnouncement(
        com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnnouncementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse> createAnnouncement(
        com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnnouncementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse> updateAnnouncement(
        com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAnnouncementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse> deleteAnnouncement(
        com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAnnouncementMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ANNOUNCEMENT_LIST = 0;
  private static final int METHODID_GET_ANNOUNCEMENT = 1;
  private static final int METHODID_CREATE_ANNOUNCEMENT = 2;
  private static final int METHODID_UPDATE_ANNOUNCEMENT = 3;
  private static final int METHODID_DELETE_ANNOUNCEMENT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnnouncementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnnouncementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANNOUNCEMENT_LIST:
          serviceImpl.getAnnouncementList((com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementListResponse>) responseObserver);
          break;
        case METHODID_GET_ANNOUNCEMENT:
          serviceImpl.getAnnouncement((com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.GetAnnouncementResponse>) responseObserver);
          break;
        case METHODID_CREATE_ANNOUNCEMENT:
          serviceImpl.createAnnouncement((com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.CreateAnnouncementResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ANNOUNCEMENT:
          serviceImpl.updateAnnouncement((com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.UpdateAnnouncementResponse>) responseObserver);
          break;
        case METHODID_DELETE_ANNOUNCEMENT:
          serviceImpl.deleteAnnouncement((com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.AnnouncementServiceProto.DeleteAnnouncementResponse>) responseObserver);
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

  private static abstract class AnnouncementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnnouncementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.msg.rpc.AnnouncementServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnnouncementService");
    }
  }

  private static final class AnnouncementServiceFileDescriptorSupplier
      extends AnnouncementServiceBaseDescriptorSupplier {
    AnnouncementServiceFileDescriptorSupplier() {}
  }

  private static final class AnnouncementServiceMethodDescriptorSupplier
      extends AnnouncementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AnnouncementServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AnnouncementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AnnouncementServiceFileDescriptorSupplier())
              .addMethod(getGetAnnouncementListMethod())
              .addMethod(getGetAnnouncementMethod())
              .addMethod(getCreateAnnouncementMethod())
              .addMethod(getUpdateAnnouncementMethod())
              .addMethod(getDeleteAnnouncementMethod())
              .build();
        }
      }
    }
    return result;
  }
}
