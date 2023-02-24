package com.amur.home.course.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: CourseWare.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CourseWareServiceGrpc {

  private CourseWareServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.course.rpc.CourseWareService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest,
      com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse> getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Upload",
      requestType = com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest.class,
      responseType = com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest,
      com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse> getUploadMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest, com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse> getUploadMethod;
    if ((getUploadMethod = CourseWareServiceGrpc.getUploadMethod) == null) {
      synchronized (CourseWareServiceGrpc.class) {
        if ((getUploadMethod = CourseWareServiceGrpc.getUploadMethod) == null) {
          CourseWareServiceGrpc.getUploadMethod = getUploadMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest, com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Upload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseWareServiceMethodDescriptorSupplier("Upload"))
              .build();
        }
      }
    }
    return getUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest,
      com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse> getDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Download",
      requestType = com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest.class,
      responseType = com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest,
      com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse> getDownloadMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest, com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse> getDownloadMethod;
    if ((getDownloadMethod = CourseWareServiceGrpc.getDownloadMethod) == null) {
      synchronized (CourseWareServiceGrpc.class) {
        if ((getDownloadMethod = CourseWareServiceGrpc.getDownloadMethod) == null) {
          CourseWareServiceGrpc.getDownloadMethod = getDownloadMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest, com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Download"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseWareServiceMethodDescriptorSupplier("Download"))
              .build();
        }
      }
    }
    return getDownloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest,
      com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse> getPreviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Preview",
      requestType = com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest.class,
      responseType = com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest,
      com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse> getPreviewMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest, com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse> getPreviewMethod;
    if ((getPreviewMethod = CourseWareServiceGrpc.getPreviewMethod) == null) {
      synchronized (CourseWareServiceGrpc.class) {
        if ((getPreviewMethod = CourseWareServiceGrpc.getPreviewMethod) == null) {
          CourseWareServiceGrpc.getPreviewMethod = getPreviewMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest, com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Preview"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseWareServiceMethodDescriptorSupplier("Preview"))
              .build();
        }
      }
    }
    return getPreviewMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CourseWareServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseWareServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseWareServiceStub>() {
        @java.lang.Override
        public CourseWareServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseWareServiceStub(channel, callOptions);
        }
      };
    return CourseWareServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CourseWareServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseWareServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseWareServiceBlockingStub>() {
        @java.lang.Override
        public CourseWareServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseWareServiceBlockingStub(channel, callOptions);
        }
      };
    return CourseWareServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CourseWareServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseWareServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseWareServiceFutureStub>() {
        @java.lang.Override
        public CourseWareServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseWareServiceFutureStub(channel, callOptions);
        }
      };
    return CourseWareServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CourseWareServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void upload(com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUploadMethod(), responseObserver);
    }

    /**
     */
    public void download(com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDownloadMethod(), responseObserver);
    }

    /**
     */
    public void preview(com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPreviewMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUploadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest,
                com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse>(
                  this, METHODID_UPLOAD)))
          .addMethod(
            getDownloadMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest,
                com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse>(
                  this, METHODID_DOWNLOAD)))
          .addMethod(
            getPreviewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest,
                com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse>(
                  this, METHODID_PREVIEW)))
          .build();
    }
  }

  /**
   */
  public static final class CourseWareServiceStub extends io.grpc.stub.AbstractAsyncStub<CourseWareServiceStub> {
    private CourseWareServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseWareServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseWareServiceStub(channel, callOptions);
    }

    /**
     */
    public void upload(com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void download(com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void preview(com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPreviewMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CourseWareServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CourseWareServiceBlockingStub> {
    private CourseWareServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseWareServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseWareServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse upload(com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse> download(
        com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDownloadMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse preview(com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPreviewMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CourseWareServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CourseWareServiceFutureStub> {
    private CourseWareServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseWareServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseWareServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse> upload(
        com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse> preview(
        com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPreviewMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPLOAD = 0;
  private static final int METHODID_DOWNLOAD = 1;
  private static final int METHODID_PREVIEW = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CourseWareServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CourseWareServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD:
          serviceImpl.upload((com.amur.home.course.rpc.CourseWareServiceProto.UploadRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseWareServiceProto.UploadResponse>) responseObserver);
          break;
        case METHODID_DOWNLOAD:
          serviceImpl.download((com.amur.home.course.rpc.CourseWareServiceProto.DownloadRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseWareServiceProto.DownloadResponse>) responseObserver);
          break;
        case METHODID_PREVIEW:
          serviceImpl.preview((com.amur.home.course.rpc.CourseWareServiceProto.PreviewRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseWareServiceProto.PreviewResponse>) responseObserver);
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

  private static abstract class CourseWareServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CourseWareServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.course.rpc.CourseWareServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CourseWareService");
    }
  }

  private static final class CourseWareServiceFileDescriptorSupplier
      extends CourseWareServiceBaseDescriptorSupplier {
    CourseWareServiceFileDescriptorSupplier() {}
  }

  private static final class CourseWareServiceMethodDescriptorSupplier
      extends CourseWareServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CourseWareServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CourseWareServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CourseWareServiceFileDescriptorSupplier())
              .addMethod(getUploadMethod())
              .addMethod(getDownloadMethod())
              .addMethod(getPreviewMethod())
              .build();
        }
      }
    }
    return result;
  }
}
