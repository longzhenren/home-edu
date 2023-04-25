package com.amur.home.tinyid.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: tinyId.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IdServiceGrpc {

  private IdServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.tinyid.rpc.IdService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.tinyid.rpc.TinyId.GenIdReq,
      com.amur.home.tinyid.rpc.TinyId.Resp> getGenIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenId",
      requestType = com.amur.home.tinyid.rpc.TinyId.GenIdReq.class,
      responseType = com.amur.home.tinyid.rpc.TinyId.Resp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.tinyid.rpc.TinyId.GenIdReq,
      com.amur.home.tinyid.rpc.TinyId.Resp> getGenIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.tinyid.rpc.TinyId.GenIdReq, com.amur.home.tinyid.rpc.TinyId.Resp> getGenIdMethod;
    if ((getGenIdMethod = IdServiceGrpc.getGenIdMethod) == null) {
      synchronized (IdServiceGrpc.class) {
        if ((getGenIdMethod = IdServiceGrpc.getGenIdMethod) == null) {
          IdServiceGrpc.getGenIdMethod = getGenIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.tinyid.rpc.TinyId.GenIdReq, com.amur.home.tinyid.rpc.TinyId.Resp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.tinyid.rpc.TinyId.GenIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.tinyid.rpc.TinyId.Resp.getDefaultInstance()))
              .setSchemaDescriptor(new IdServiceMethodDescriptorSupplier("GenId"))
              .build();
        }
      }
    }
    return getGenIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IdServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IdServiceStub>() {
        @java.lang.Override
        public IdServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IdServiceStub(channel, callOptions);
        }
      };
    return IdServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IdServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IdServiceBlockingStub>() {
        @java.lang.Override
        public IdServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IdServiceBlockingStub(channel, callOptions);
        }
      };
    return IdServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IdServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IdServiceFutureStub>() {
        @java.lang.Override
        public IdServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IdServiceFutureStub(channel, callOptions);
        }
      };
    return IdServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class IdServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void genId(com.amur.home.tinyid.rpc.TinyId.GenIdReq request,
        io.grpc.stub.StreamObserver<com.amur.home.tinyid.rpc.TinyId.Resp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.tinyid.rpc.TinyId.GenIdReq,
                com.amur.home.tinyid.rpc.TinyId.Resp>(
                  this, METHODID_GEN_ID)))
          .build();
    }
  }

  /**
   */
  public static final class IdServiceStub extends io.grpc.stub.AbstractAsyncStub<IdServiceStub> {
    private IdServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdServiceStub(channel, callOptions);
    }

    /**
     */
    public void genId(com.amur.home.tinyid.rpc.TinyId.GenIdReq request,
        io.grpc.stub.StreamObserver<com.amur.home.tinyid.rpc.TinyId.Resp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class IdServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<IdServiceBlockingStub> {
    private IdServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.amur.home.tinyid.rpc.TinyId.Resp genId(com.amur.home.tinyid.rpc.TinyId.GenIdReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class IdServiceFutureStub extends io.grpc.stub.AbstractFutureStub<IdServiceFutureStub> {
    private IdServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.tinyid.rpc.TinyId.Resp> genId(
        com.amur.home.tinyid.rpc.TinyId.GenIdReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GEN_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IdServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IdServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GEN_ID:
          serviceImpl.genId((com.amur.home.tinyid.rpc.TinyId.GenIdReq) request,
              (io.grpc.stub.StreamObserver<com.amur.home.tinyid.rpc.TinyId.Resp>) responseObserver);
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

  private static abstract class IdServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IdServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.tinyid.rpc.TinyId.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IdService");
    }
  }

  private static final class IdServiceFileDescriptorSupplier
      extends IdServiceBaseDescriptorSupplier {
    IdServiceFileDescriptorSupplier() {}
  }

  private static final class IdServiceMethodDescriptorSupplier
      extends IdServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IdServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IdServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IdServiceFileDescriptorSupplier())
              .addMethod(getGenIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
