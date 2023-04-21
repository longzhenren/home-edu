package com.amur.home.user.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: fav.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FavServiceGrpc {

  private FavServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.user.rpc.FavService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest,
      com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse> getGetFavCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFavCourses",
      requestType = com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest,
      com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse> getGetFavCoursesMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest, com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse> getGetFavCoursesMethod;
    if ((getGetFavCoursesMethod = FavServiceGrpc.getGetFavCoursesMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getGetFavCoursesMethod = FavServiceGrpc.getGetFavCoursesMethod) == null) {
          FavServiceGrpc.getGetFavCoursesMethod = getGetFavCoursesMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest, com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFavCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("GetFavCourses"))
              .build();
        }
      }
    }
    return getGetFavCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest,
      com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse> getAddFavCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddFavCourse",
      requestType = com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest,
      com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse> getAddFavCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest, com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse> getAddFavCourseMethod;
    if ((getAddFavCourseMethod = FavServiceGrpc.getAddFavCourseMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getAddFavCourseMethod = FavServiceGrpc.getAddFavCourseMethod) == null) {
          FavServiceGrpc.getAddFavCourseMethod = getAddFavCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest, com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddFavCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("AddFavCourse"))
              .build();
        }
      }
    }
    return getAddFavCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest,
      com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse> getDelFavCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelFavCourse",
      requestType = com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest,
      com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse> getDelFavCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest, com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse> getDelFavCourseMethod;
    if ((getDelFavCourseMethod = FavServiceGrpc.getDelFavCourseMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getDelFavCourseMethod = FavServiceGrpc.getDelFavCourseMethod) == null) {
          FavServiceGrpc.getDelFavCourseMethod = getDelFavCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest, com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelFavCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("DelFavCourse"))
              .build();
        }
      }
    }
    return getDelFavCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest,
      com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse> getGetFavCourseListsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFavCourseLists",
      requestType = com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest,
      com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse> getGetFavCourseListsMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest, com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse> getGetFavCourseListsMethod;
    if ((getGetFavCourseListsMethod = FavServiceGrpc.getGetFavCourseListsMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getGetFavCourseListsMethod = FavServiceGrpc.getGetFavCourseListsMethod) == null) {
          FavServiceGrpc.getGetFavCourseListsMethod = getGetFavCourseListsMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest, com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFavCourseLists"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("GetFavCourseLists"))
              .build();
        }
      }
    }
    return getGetFavCourseListsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest,
      com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse> getAddFavCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddFavCourseList",
      requestType = com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest,
      com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse> getAddFavCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest, com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse> getAddFavCourseListMethod;
    if ((getAddFavCourseListMethod = FavServiceGrpc.getAddFavCourseListMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getAddFavCourseListMethod = FavServiceGrpc.getAddFavCourseListMethod) == null) {
          FavServiceGrpc.getAddFavCourseListMethod = getAddFavCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest, com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddFavCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("AddFavCourseList"))
              .build();
        }
      }
    }
    return getAddFavCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest,
      com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse> getDelFavCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelFavCourseList",
      requestType = com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest,
      com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse> getDelFavCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest, com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse> getDelFavCourseListMethod;
    if ((getDelFavCourseListMethod = FavServiceGrpc.getDelFavCourseListMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getDelFavCourseListMethod = FavServiceGrpc.getDelFavCourseListMethod) == null) {
          FavServiceGrpc.getDelFavCourseListMethod = getDelFavCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest, com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelFavCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("DelFavCourseList"))
              .build();
        }
      }
    }
    return getDelFavCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest,
      com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse> getGetFavCourseWaresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFavCourseWares",
      requestType = com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest,
      com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse> getGetFavCourseWaresMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest, com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse> getGetFavCourseWaresMethod;
    if ((getGetFavCourseWaresMethod = FavServiceGrpc.getGetFavCourseWaresMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getGetFavCourseWaresMethod = FavServiceGrpc.getGetFavCourseWaresMethod) == null) {
          FavServiceGrpc.getGetFavCourseWaresMethod = getGetFavCourseWaresMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest, com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFavCourseWares"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("GetFavCourseWares"))
              .build();
        }
      }
    }
    return getGetFavCourseWaresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest,
      com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse> getAddFavCourseWareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddFavCourseWare",
      requestType = com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest,
      com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse> getAddFavCourseWareMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest, com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse> getAddFavCourseWareMethod;
    if ((getAddFavCourseWareMethod = FavServiceGrpc.getAddFavCourseWareMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getAddFavCourseWareMethod = FavServiceGrpc.getAddFavCourseWareMethod) == null) {
          FavServiceGrpc.getAddFavCourseWareMethod = getAddFavCourseWareMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest, com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddFavCourseWare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("AddFavCourseWare"))
              .build();
        }
      }
    }
    return getAddFavCourseWareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest,
      com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse> getDelFavCourseWareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelFavCourseWare",
      requestType = com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest,
      com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse> getDelFavCourseWareMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest, com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse> getDelFavCourseWareMethod;
    if ((getDelFavCourseWareMethod = FavServiceGrpc.getDelFavCourseWareMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getDelFavCourseWareMethod = FavServiceGrpc.getDelFavCourseWareMethod) == null) {
          FavServiceGrpc.getDelFavCourseWareMethod = getDelFavCourseWareMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest, com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelFavCourseWare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("DelFavCourseWare"))
              .build();
        }
      }
    }
    return getDelFavCourseWareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest,
      com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse> getGetFavIssuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFavIssues",
      requestType = com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest,
      com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse> getGetFavIssuesMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest, com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse> getGetFavIssuesMethod;
    if ((getGetFavIssuesMethod = FavServiceGrpc.getGetFavIssuesMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getGetFavIssuesMethod = FavServiceGrpc.getGetFavIssuesMethod) == null) {
          FavServiceGrpc.getGetFavIssuesMethod = getGetFavIssuesMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest, com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFavIssues"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("GetFavIssues"))
              .build();
        }
      }
    }
    return getGetFavIssuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest,
      com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse> getAddFavIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddFavIssue",
      requestType = com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest,
      com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse> getAddFavIssueMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest, com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse> getAddFavIssueMethod;
    if ((getAddFavIssueMethod = FavServiceGrpc.getAddFavIssueMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getAddFavIssueMethod = FavServiceGrpc.getAddFavIssueMethod) == null) {
          FavServiceGrpc.getAddFavIssueMethod = getAddFavIssueMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest, com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddFavIssue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("AddFavIssue"))
              .build();
        }
      }
    }
    return getAddFavIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest,
      com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse> getDelFavIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelFavIssue",
      requestType = com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest.class,
      responseType = com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest,
      com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse> getDelFavIssueMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest, com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse> getDelFavIssueMethod;
    if ((getDelFavIssueMethod = FavServiceGrpc.getDelFavIssueMethod) == null) {
      synchronized (FavServiceGrpc.class) {
        if ((getDelFavIssueMethod = FavServiceGrpc.getDelFavIssueMethod) == null) {
          FavServiceGrpc.getDelFavIssueMethod = getDelFavIssueMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest, com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelFavIssue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FavServiceMethodDescriptorSupplier("DelFavIssue"))
              .build();
        }
      }
    }
    return getDelFavIssueMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FavServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FavServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FavServiceStub>() {
        @java.lang.Override
        public FavServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FavServiceStub(channel, callOptions);
        }
      };
    return FavServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FavServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FavServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FavServiceBlockingStub>() {
        @java.lang.Override
        public FavServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FavServiceBlockingStub(channel, callOptions);
        }
      };
    return FavServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FavServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FavServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FavServiceFutureStub>() {
        @java.lang.Override
        public FavServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FavServiceFutureStub(channel, callOptions);
        }
      };
    return FavServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FavServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFavCourses(com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFavCoursesMethod(), responseObserver);
    }

    /**
     */
    public void addFavCourse(com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddFavCourseMethod(), responseObserver);
    }

    /**
     */
    public void delFavCourse(com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelFavCourseMethod(), responseObserver);
    }

    /**
     */
    public void getFavCourseLists(com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFavCourseListsMethod(), responseObserver);
    }

    /**
     */
    public void addFavCourseList(com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddFavCourseListMethod(), responseObserver);
    }

    /**
     */
    public void delFavCourseList(com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelFavCourseListMethod(), responseObserver);
    }

    /**
     */
    public void getFavCourseWares(com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFavCourseWaresMethod(), responseObserver);
    }

    /**
     */
    public void addFavCourseWare(com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddFavCourseWareMethod(), responseObserver);
    }

    /**
     */
    public void delFavCourseWare(com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelFavCourseWareMethod(), responseObserver);
    }

    /**
     */
    public void getFavIssues(com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFavIssuesMethod(), responseObserver);
    }

    /**
     */
    public void addFavIssue(com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddFavIssueMethod(), responseObserver);
    }

    /**
     */
    public void delFavIssue(com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelFavIssueMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFavCoursesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest,
                com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse>(
                  this, METHODID_GET_FAV_COURSES)))
          .addMethod(
            getAddFavCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest,
                com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse>(
                  this, METHODID_ADD_FAV_COURSE)))
          .addMethod(
            getDelFavCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest,
                com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse>(
                  this, METHODID_DEL_FAV_COURSE)))
          .addMethod(
            getGetFavCourseListsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest,
                com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse>(
                  this, METHODID_GET_FAV_COURSE_LISTS)))
          .addMethod(
            getAddFavCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest,
                com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse>(
                  this, METHODID_ADD_FAV_COURSE_LIST)))
          .addMethod(
            getDelFavCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest,
                com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse>(
                  this, METHODID_DEL_FAV_COURSE_LIST)))
          .addMethod(
            getGetFavCourseWaresMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest,
                com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse>(
                  this, METHODID_GET_FAV_COURSE_WARES)))
          .addMethod(
            getAddFavCourseWareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest,
                com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse>(
                  this, METHODID_ADD_FAV_COURSE_WARE)))
          .addMethod(
            getDelFavCourseWareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest,
                com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse>(
                  this, METHODID_DEL_FAV_COURSE_WARE)))
          .addMethod(
            getGetFavIssuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest,
                com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse>(
                  this, METHODID_GET_FAV_ISSUES)))
          .addMethod(
            getAddFavIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest,
                com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse>(
                  this, METHODID_ADD_FAV_ISSUE)))
          .addMethod(
            getDelFavIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest,
                com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse>(
                  this, METHODID_DEL_FAV_ISSUE)))
          .build();
    }
  }

  /**
   */
  public static final class FavServiceStub extends io.grpc.stub.AbstractAsyncStub<FavServiceStub> {
    private FavServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FavServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FavServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFavCourses(com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFavCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addFavCourse(com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddFavCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delFavCourse(com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelFavCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFavCourseLists(com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFavCourseListsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addFavCourseList(com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddFavCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delFavCourseList(com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelFavCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFavCourseWares(com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFavCourseWaresMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addFavCourseWare(com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddFavCourseWareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delFavCourseWare(com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelFavCourseWareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFavIssues(com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFavIssuesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addFavIssue(com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddFavIssueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delFavIssue(com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelFavIssueMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FavServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FavServiceBlockingStub> {
    private FavServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FavServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FavServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse getFavCourses(com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFavCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse addFavCourse(com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddFavCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse delFavCourse(com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelFavCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse getFavCourseLists(com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFavCourseListsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse addFavCourseList(com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddFavCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse delFavCourseList(com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelFavCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse getFavCourseWares(com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFavCourseWaresMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse addFavCourseWare(com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddFavCourseWareMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse delFavCourseWare(com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelFavCourseWareMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse getFavIssues(com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFavIssuesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse addFavIssue(com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddFavIssueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse delFavIssue(com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelFavIssueMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FavServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FavServiceFutureStub> {
    private FavServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FavServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FavServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse> getFavCourses(
        com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFavCoursesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse> addFavCourse(
        com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddFavCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse> delFavCourse(
        com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelFavCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse> getFavCourseLists(
        com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFavCourseListsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse> addFavCourseList(
        com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddFavCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse> delFavCourseList(
        com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelFavCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse> getFavCourseWares(
        com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFavCourseWaresMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse> addFavCourseWare(
        com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddFavCourseWareMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse> delFavCourseWare(
        com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelFavCourseWareMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse> getFavIssues(
        com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFavIssuesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse> addFavIssue(
        com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddFavIssueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse> delFavIssue(
        com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelFavIssueMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FAV_COURSES = 0;
  private static final int METHODID_ADD_FAV_COURSE = 1;
  private static final int METHODID_DEL_FAV_COURSE = 2;
  private static final int METHODID_GET_FAV_COURSE_LISTS = 3;
  private static final int METHODID_ADD_FAV_COURSE_LIST = 4;
  private static final int METHODID_DEL_FAV_COURSE_LIST = 5;
  private static final int METHODID_GET_FAV_COURSE_WARES = 6;
  private static final int METHODID_ADD_FAV_COURSE_WARE = 7;
  private static final int METHODID_DEL_FAV_COURSE_WARE = 8;
  private static final int METHODID_GET_FAV_ISSUES = 9;
  private static final int METHODID_ADD_FAV_ISSUE = 10;
  private static final int METHODID_DEL_FAV_ISSUE = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FavServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FavServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FAV_COURSES:
          serviceImpl.getFavCourses((com.amur.home.user.rpc.FavServiceProto.GetFavCoursesRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavCoursesResponse>) responseObserver);
          break;
        case METHODID_ADD_FAV_COURSE:
          serviceImpl.addFavCourse((com.amur.home.user.rpc.FavServiceProto.AddFavCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavCourseResponse>) responseObserver);
          break;
        case METHODID_DEL_FAV_COURSE:
          serviceImpl.delFavCourse((com.amur.home.user.rpc.FavServiceProto.DelFavCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavCourseResponse>) responseObserver);
          break;
        case METHODID_GET_FAV_COURSE_LISTS:
          serviceImpl.getFavCourseLists((com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavCourseListsResponse>) responseObserver);
          break;
        case METHODID_ADD_FAV_COURSE_LIST:
          serviceImpl.addFavCourseList((com.amur.home.user.rpc.FavServiceProto.AddFavCourseListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavCourseListResponse>) responseObserver);
          break;
        case METHODID_DEL_FAV_COURSE_LIST:
          serviceImpl.delFavCourseList((com.amur.home.user.rpc.FavServiceProto.DelFavCourseListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavCourseListResponse>) responseObserver);
          break;
        case METHODID_GET_FAV_COURSE_WARES:
          serviceImpl.getFavCourseWares((com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavCourseWaresResponse>) responseObserver);
          break;
        case METHODID_ADD_FAV_COURSE_WARE:
          serviceImpl.addFavCourseWare((com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavCourseWareResponse>) responseObserver);
          break;
        case METHODID_DEL_FAV_COURSE_WARE:
          serviceImpl.delFavCourseWare((com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavCourseWareResponse>) responseObserver);
          break;
        case METHODID_GET_FAV_ISSUES:
          serviceImpl.getFavIssues((com.amur.home.user.rpc.FavServiceProto.GetFavIssuesRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.GetFavIssuesResponse>) responseObserver);
          break;
        case METHODID_ADD_FAV_ISSUE:
          serviceImpl.addFavIssue((com.amur.home.user.rpc.FavServiceProto.AddFavIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.AddFavIssueResponse>) responseObserver);
          break;
        case METHODID_DEL_FAV_ISSUE:
          serviceImpl.delFavIssue((com.amur.home.user.rpc.FavServiceProto.DelFavIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.FavServiceProto.DelFavIssueResponse>) responseObserver);
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

  private static abstract class FavServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FavServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.user.rpc.FavServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FavService");
    }
  }

  private static final class FavServiceFileDescriptorSupplier
      extends FavServiceBaseDescriptorSupplier {
    FavServiceFileDescriptorSupplier() {}
  }

  private static final class FavServiceMethodDescriptorSupplier
      extends FavServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FavServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FavServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FavServiceFileDescriptorSupplier())
              .addMethod(getGetFavCoursesMethod())
              .addMethod(getAddFavCourseMethod())
              .addMethod(getDelFavCourseMethod())
              .addMethod(getGetFavCourseListsMethod())
              .addMethod(getAddFavCourseListMethod())
              .addMethod(getDelFavCourseListMethod())
              .addMethod(getGetFavCourseWaresMethod())
              .addMethod(getAddFavCourseWareMethod())
              .addMethod(getDelFavCourseWareMethod())
              .addMethod(getGetFavIssuesMethod())
              .addMethod(getAddFavIssueMethod())
              .addMethod(getDelFavIssueMethod())
              .build();
        }
      }
    }
    return result;
  }
}
