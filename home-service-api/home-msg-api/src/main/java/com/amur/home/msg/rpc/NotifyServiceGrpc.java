package com.amur.home.msg.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: Notify.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NotifyServiceGrpc {

  private NotifyServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.msg.rpc.NotifyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest,
      com.amur.home.msg.rpc.NotifyServiceProto.Notify> getGetNotifyStreamByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotifyStreamByUserId",
      requestType = com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest.class,
      responseType = com.amur.home.msg.rpc.NotifyServiceProto.Notify.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest,
      com.amur.home.msg.rpc.NotifyServiceProto.Notify> getGetNotifyStreamByUserIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest, com.amur.home.msg.rpc.NotifyServiceProto.Notify> getGetNotifyStreamByUserIdMethod;
    if ((getGetNotifyStreamByUserIdMethod = NotifyServiceGrpc.getGetNotifyStreamByUserIdMethod) == null) {
      synchronized (NotifyServiceGrpc.class) {
        if ((getGetNotifyStreamByUserIdMethod = NotifyServiceGrpc.getGetNotifyStreamByUserIdMethod) == null) {
          NotifyServiceGrpc.getGetNotifyStreamByUserIdMethod = getGetNotifyStreamByUserIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest, com.amur.home.msg.rpc.NotifyServiceProto.Notify>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNotifyStreamByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.msg.rpc.NotifyServiceProto.Notify.getDefaultInstance()))
              .setSchemaDescriptor(new NotifyServiceMethodDescriptorSupplier("GetNotifyStreamByUserId"))
              .build();
        }
      }
    }
    return getGetNotifyStreamByUserIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NotifyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotifyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotifyServiceStub>() {
        @java.lang.Override
        public NotifyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotifyServiceStub(channel, callOptions);
        }
      };
    return NotifyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotifyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotifyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotifyServiceBlockingStub>() {
        @java.lang.Override
        public NotifyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotifyServiceBlockingStub(channel, callOptions);
        }
      };
    return NotifyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NotifyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotifyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotifyServiceFutureStub>() {
        @java.lang.Override
        public NotifyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotifyServiceFutureStub(channel, callOptions);
        }
      };
    return NotifyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class NotifyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getNotifyStreamByUserId(com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.NotifyServiceProto.Notify> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNotifyStreamByUserIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetNotifyStreamByUserIdMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest,
                com.amur.home.msg.rpc.NotifyServiceProto.Notify>(
                  this, METHODID_GET_NOTIFY_STREAM_BY_USER_ID)))
          .build();
    }
  }

  /**
   */
  public static final class NotifyServiceStub extends io.grpc.stub.AbstractAsyncStub<NotifyServiceStub> {
    private NotifyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotifyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotifyServiceStub(channel, callOptions);
    }

    /**
     */
    public void getNotifyStreamByUserId(com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.NotifyServiceProto.Notify> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetNotifyStreamByUserIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NotifyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<NotifyServiceBlockingStub> {
    private NotifyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotifyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotifyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.amur.home.msg.rpc.NotifyServiceProto.Notify> getNotifyStreamByUserId(
        com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetNotifyStreamByUserIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NotifyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<NotifyServiceFutureStub> {
    private NotifyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotifyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotifyServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_NOTIFY_STREAM_BY_USER_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NotifyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NotifyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_NOTIFY_STREAM_BY_USER_ID:
          serviceImpl.getNotifyStreamByUserId((com.amur.home.msg.rpc.NotifyServiceProto.UserIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.msg.rpc.NotifyServiceProto.Notify>) responseObserver);
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

  private static abstract class NotifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotifyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.msg.rpc.NotifyServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NotifyService");
    }
  }

  private static final class NotifyServiceFileDescriptorSupplier
      extends NotifyServiceBaseDescriptorSupplier {
    NotifyServiceFileDescriptorSupplier() {}
  }

  private static final class NotifyServiceMethodDescriptorSupplier
      extends NotifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NotifyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (NotifyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NotifyServiceFileDescriptorSupplier())
              .addMethod(getGetNotifyStreamByUserIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
