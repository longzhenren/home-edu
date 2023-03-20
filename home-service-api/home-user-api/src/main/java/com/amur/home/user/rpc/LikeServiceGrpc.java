package com.amur.home.user.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: like.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LikeServiceGrpc {

  private LikeServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.user.rpc.LikeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse> getGetLikeCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLikeCourses",
      requestType = com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse> getGetLikeCoursesMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse> getGetLikeCoursesMethod;
    if ((getGetLikeCoursesMethod = LikeServiceGrpc.getGetLikeCoursesMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getGetLikeCoursesMethod = LikeServiceGrpc.getGetLikeCoursesMethod) == null) {
          LikeServiceGrpc.getGetLikeCoursesMethod = getGetLikeCoursesMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLikeCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("GetLikeCourses"))
              .build();
        }
      }
    }
    return getGetLikeCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse> getAddLikeCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddLikeCourse",
      requestType = com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse> getAddLikeCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse> getAddLikeCourseMethod;
    if ((getAddLikeCourseMethod = LikeServiceGrpc.getAddLikeCourseMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getAddLikeCourseMethod = LikeServiceGrpc.getAddLikeCourseMethod) == null) {
          LikeServiceGrpc.getAddLikeCourseMethod = getAddLikeCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddLikeCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("AddLikeCourse"))
              .build();
        }
      }
    }
    return getAddLikeCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse> getDelLikeCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelLikeCourse",
      requestType = com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse> getDelLikeCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse> getDelLikeCourseMethod;
    if ((getDelLikeCourseMethod = LikeServiceGrpc.getDelLikeCourseMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getDelLikeCourseMethod = LikeServiceGrpc.getDelLikeCourseMethod) == null) {
          LikeServiceGrpc.getDelLikeCourseMethod = getDelLikeCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelLikeCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("DelLikeCourse"))
              .build();
        }
      }
    }
    return getDelLikeCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse> getGetLikeHomesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLikeHomes",
      requestType = com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse> getGetLikeHomesMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse> getGetLikeHomesMethod;
    if ((getGetLikeHomesMethod = LikeServiceGrpc.getGetLikeHomesMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getGetLikeHomesMethod = LikeServiceGrpc.getGetLikeHomesMethod) == null) {
          LikeServiceGrpc.getGetLikeHomesMethod = getGetLikeHomesMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLikeHomes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("GetLikeHomes"))
              .build();
        }
      }
    }
    return getGetLikeHomesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse> getAddLikeHomeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddLikeHome",
      requestType = com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse> getAddLikeHomeMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse> getAddLikeHomeMethod;
    if ((getAddLikeHomeMethod = LikeServiceGrpc.getAddLikeHomeMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getAddLikeHomeMethod = LikeServiceGrpc.getAddLikeHomeMethod) == null) {
          LikeServiceGrpc.getAddLikeHomeMethod = getAddLikeHomeMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddLikeHome"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("AddLikeHome"))
              .build();
        }
      }
    }
    return getAddLikeHomeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse> getDelLikeHomeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelLikeHome",
      requestType = com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse> getDelLikeHomeMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse> getDelLikeHomeMethod;
    if ((getDelLikeHomeMethod = LikeServiceGrpc.getDelLikeHomeMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getDelLikeHomeMethod = LikeServiceGrpc.getDelLikeHomeMethod) == null) {
          LikeServiceGrpc.getDelLikeHomeMethod = getDelLikeHomeMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelLikeHome"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("DelLikeHome"))
              .build();
        }
      }
    }
    return getDelLikeHomeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse> getGetLikeUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLikeUsers",
      requestType = com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse> getGetLikeUsersMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse> getGetLikeUsersMethod;
    if ((getGetLikeUsersMethod = LikeServiceGrpc.getGetLikeUsersMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getGetLikeUsersMethod = LikeServiceGrpc.getGetLikeUsersMethod) == null) {
          LikeServiceGrpc.getGetLikeUsersMethod = getGetLikeUsersMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLikeUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("GetLikeUsers"))
              .build();
        }
      }
    }
    return getGetLikeUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse> getAddLikeUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddLikeUser",
      requestType = com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse> getAddLikeUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse> getAddLikeUserMethod;
    if ((getAddLikeUserMethod = LikeServiceGrpc.getAddLikeUserMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getAddLikeUserMethod = LikeServiceGrpc.getAddLikeUserMethod) == null) {
          LikeServiceGrpc.getAddLikeUserMethod = getAddLikeUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddLikeUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("AddLikeUser"))
              .build();
        }
      }
    }
    return getAddLikeUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse> getDelLikeUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelLikeUser",
      requestType = com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse> getDelLikeUserMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse> getDelLikeUserMethod;
    if ((getDelLikeUserMethod = LikeServiceGrpc.getDelLikeUserMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getDelLikeUserMethod = LikeServiceGrpc.getDelLikeUserMethod) == null) {
          LikeServiceGrpc.getDelLikeUserMethod = getDelLikeUserMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelLikeUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("DelLikeUser"))
              .build();
        }
      }
    }
    return getDelLikeUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse> getGetLikeCourseListsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLikeCourseLists",
      requestType = com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse> getGetLikeCourseListsMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse> getGetLikeCourseListsMethod;
    if ((getGetLikeCourseListsMethod = LikeServiceGrpc.getGetLikeCourseListsMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getGetLikeCourseListsMethod = LikeServiceGrpc.getGetLikeCourseListsMethod) == null) {
          LikeServiceGrpc.getGetLikeCourseListsMethod = getGetLikeCourseListsMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLikeCourseLists"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("GetLikeCourseLists"))
              .build();
        }
      }
    }
    return getGetLikeCourseListsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse> getAddLikeCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddLikeCourseList",
      requestType = com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse> getAddLikeCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse> getAddLikeCourseListMethod;
    if ((getAddLikeCourseListMethod = LikeServiceGrpc.getAddLikeCourseListMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getAddLikeCourseListMethod = LikeServiceGrpc.getAddLikeCourseListMethod) == null) {
          LikeServiceGrpc.getAddLikeCourseListMethod = getAddLikeCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddLikeCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("AddLikeCourseList"))
              .build();
        }
      }
    }
    return getAddLikeCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse> getDelLikeCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelLikeCourseList",
      requestType = com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse> getDelLikeCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse> getDelLikeCourseListMethod;
    if ((getDelLikeCourseListMethod = LikeServiceGrpc.getDelLikeCourseListMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getDelLikeCourseListMethod = LikeServiceGrpc.getDelLikeCourseListMethod) == null) {
          LikeServiceGrpc.getDelLikeCourseListMethod = getDelLikeCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelLikeCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("DelLikeCourseList"))
              .build();
        }
      }
    }
    return getDelLikeCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse> getGetLikeCourseWaresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLikeCourseWares",
      requestType = com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest,
      com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse> getGetLikeCourseWaresMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse> getGetLikeCourseWaresMethod;
    if ((getGetLikeCourseWaresMethod = LikeServiceGrpc.getGetLikeCourseWaresMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getGetLikeCourseWaresMethod = LikeServiceGrpc.getGetLikeCourseWaresMethod) == null) {
          LikeServiceGrpc.getGetLikeCourseWaresMethod = getGetLikeCourseWaresMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest, com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLikeCourseWares"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("GetLikeCourseWares"))
              .build();
        }
      }
    }
    return getGetLikeCourseWaresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse> getAddLikeCourseWareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddLikeCourseWare",
      requestType = com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest,
      com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse> getAddLikeCourseWareMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse> getAddLikeCourseWareMethod;
    if ((getAddLikeCourseWareMethod = LikeServiceGrpc.getAddLikeCourseWareMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getAddLikeCourseWareMethod = LikeServiceGrpc.getAddLikeCourseWareMethod) == null) {
          LikeServiceGrpc.getAddLikeCourseWareMethod = getAddLikeCourseWareMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest, com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddLikeCourseWare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("AddLikeCourseWare"))
              .build();
        }
      }
    }
    return getAddLikeCourseWareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse> getDelLikeCourseWareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelLikeCourseWare",
      requestType = com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest.class,
      responseType = com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest,
      com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse> getDelLikeCourseWareMethod() {
    io.grpc.MethodDescriptor<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse> getDelLikeCourseWareMethod;
    if ((getDelLikeCourseWareMethod = LikeServiceGrpc.getDelLikeCourseWareMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getDelLikeCourseWareMethod = LikeServiceGrpc.getDelLikeCourseWareMethod) == null) {
          LikeServiceGrpc.getDelLikeCourseWareMethod = getDelLikeCourseWareMethod =
              io.grpc.MethodDescriptor.<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest, com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelLikeCourseWare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("DelLikeCourseWare"))
              .build();
        }
      }
    }
    return getDelLikeCourseWareMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LikeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LikeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LikeServiceStub>() {
        @java.lang.Override
        public LikeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LikeServiceStub(channel, callOptions);
        }
      };
    return LikeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LikeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LikeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LikeServiceBlockingStub>() {
        @java.lang.Override
        public LikeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LikeServiceBlockingStub(channel, callOptions);
        }
      };
    return LikeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LikeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LikeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LikeServiceFutureStub>() {
        @java.lang.Override
        public LikeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LikeServiceFutureStub(channel, callOptions);
        }
      };
    return LikeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LikeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getLikeCourses(com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLikeCoursesMethod(), responseObserver);
    }

    /**
     */
    public void addLikeCourse(com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddLikeCourseMethod(), responseObserver);
    }

    /**
     */
    public void delLikeCourse(com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelLikeCourseMethod(), responseObserver);
    }

    /**
     */
    public void getLikeHomes(com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLikeHomesMethod(), responseObserver);
    }

    /**
     */
    public void addLikeHome(com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddLikeHomeMethod(), responseObserver);
    }

    /**
     */
    public void delLikeHome(com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelLikeHomeMethod(), responseObserver);
    }

    /**
     */
    public void getLikeUsers(com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLikeUsersMethod(), responseObserver);
    }

    /**
     */
    public void addLikeUser(com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddLikeUserMethod(), responseObserver);
    }

    /**
     */
    public void delLikeUser(com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelLikeUserMethod(), responseObserver);
    }

    /**
     */
    public void getLikeCourseLists(com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLikeCourseListsMethod(), responseObserver);
    }

    /**
     */
    public void addLikeCourseList(com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddLikeCourseListMethod(), responseObserver);
    }

    /**
     */
    public void delLikeCourseList(com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelLikeCourseListMethod(), responseObserver);
    }

    /**
     */
    public void getLikeCourseWares(com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLikeCourseWaresMethod(), responseObserver);
    }

    /**
     */
    public void addLikeCourseWare(com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddLikeCourseWareMethod(), responseObserver);
    }

    /**
     */
    public void delLikeCourseWare(com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelLikeCourseWareMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetLikeCoursesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest,
                com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse>(
                  this, METHODID_GET_LIKE_COURSES)))
          .addMethod(
            getAddLikeCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest,
                com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse>(
                  this, METHODID_ADD_LIKE_COURSE)))
          .addMethod(
            getDelLikeCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest,
                com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse>(
                  this, METHODID_DEL_LIKE_COURSE)))
          .addMethod(
            getGetLikeHomesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest,
                com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse>(
                  this, METHODID_GET_LIKE_HOMES)))
          .addMethod(
            getAddLikeHomeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest,
                com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse>(
                  this, METHODID_ADD_LIKE_HOME)))
          .addMethod(
            getDelLikeHomeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest,
                com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse>(
                  this, METHODID_DEL_LIKE_HOME)))
          .addMethod(
            getGetLikeUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest,
                com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse>(
                  this, METHODID_GET_LIKE_USERS)))
          .addMethod(
            getAddLikeUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest,
                com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse>(
                  this, METHODID_ADD_LIKE_USER)))
          .addMethod(
            getDelLikeUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest,
                com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse>(
                  this, METHODID_DEL_LIKE_USER)))
          .addMethod(
            getGetLikeCourseListsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest,
                com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse>(
                  this, METHODID_GET_LIKE_COURSE_LISTS)))
          .addMethod(
            getAddLikeCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest,
                com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse>(
                  this, METHODID_ADD_LIKE_COURSE_LIST)))
          .addMethod(
            getDelLikeCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest,
                com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse>(
                  this, METHODID_DEL_LIKE_COURSE_LIST)))
          .addMethod(
            getGetLikeCourseWaresMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest,
                com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse>(
                  this, METHODID_GET_LIKE_COURSE_WARES)))
          .addMethod(
            getAddLikeCourseWareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest,
                com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse>(
                  this, METHODID_ADD_LIKE_COURSE_WARE)))
          .addMethod(
            getDelLikeCourseWareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest,
                com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse>(
                  this, METHODID_DEL_LIKE_COURSE_WARE)))
          .build();
    }
  }

  /**
   */
  public static final class LikeServiceStub extends io.grpc.stub.AbstractAsyncStub<LikeServiceStub> {
    private LikeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LikeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LikeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getLikeCourses(com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLikeCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLikeCourse(com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLikeCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delLikeCourse(com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelLikeCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLikeHomes(com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLikeHomesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLikeHome(com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLikeHomeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delLikeHome(com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelLikeHomeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLikeUsers(com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLikeUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLikeUser(com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLikeUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delLikeUser(com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelLikeUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLikeCourseLists(com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLikeCourseListsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLikeCourseList(com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLikeCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delLikeCourseList(com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelLikeCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLikeCourseWares(com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLikeCourseWaresMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLikeCourseWare(com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLikeCourseWareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delLikeCourseWare(com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelLikeCourseWareMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LikeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LikeServiceBlockingStub> {
    private LikeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LikeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LikeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse getLikeCourses(com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLikeCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse addLikeCourse(com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLikeCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse delLikeCourse(com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelLikeCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse getLikeHomes(com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLikeHomesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse addLikeHome(com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLikeHomeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse delLikeHome(com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelLikeHomeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse getLikeUsers(com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLikeUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse addLikeUser(com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLikeUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse delLikeUser(com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelLikeUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse getLikeCourseLists(com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLikeCourseListsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse addLikeCourseList(com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLikeCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse delLikeCourseList(com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelLikeCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse getLikeCourseWares(com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLikeCourseWaresMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse addLikeCourseWare(com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLikeCourseWareMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse delLikeCourseWare(com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelLikeCourseWareMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LikeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LikeServiceFutureStub> {
    private LikeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LikeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LikeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse> getLikeCourses(
        com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLikeCoursesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse> addLikeCourse(
        com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLikeCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse> delLikeCourse(
        com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelLikeCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse> getLikeHomes(
        com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLikeHomesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse> addLikeHome(
        com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLikeHomeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse> delLikeHome(
        com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelLikeHomeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse> getLikeUsers(
        com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLikeUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse> addLikeUser(
        com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLikeUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse> delLikeUser(
        com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelLikeUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse> getLikeCourseLists(
        com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLikeCourseListsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse> addLikeCourseList(
        com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLikeCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse> delLikeCourseList(
        com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelLikeCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse> getLikeCourseWares(
        com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLikeCourseWaresMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse> addLikeCourseWare(
        com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLikeCourseWareMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse> delLikeCourseWare(
        com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelLikeCourseWareMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LIKE_COURSES = 0;
  private static final int METHODID_ADD_LIKE_COURSE = 1;
  private static final int METHODID_DEL_LIKE_COURSE = 2;
  private static final int METHODID_GET_LIKE_HOMES = 3;
  private static final int METHODID_ADD_LIKE_HOME = 4;
  private static final int METHODID_DEL_LIKE_HOME = 5;
  private static final int METHODID_GET_LIKE_USERS = 6;
  private static final int METHODID_ADD_LIKE_USER = 7;
  private static final int METHODID_DEL_LIKE_USER = 8;
  private static final int METHODID_GET_LIKE_COURSE_LISTS = 9;
  private static final int METHODID_ADD_LIKE_COURSE_LIST = 10;
  private static final int METHODID_DEL_LIKE_COURSE_LIST = 11;
  private static final int METHODID_GET_LIKE_COURSE_WARES = 12;
  private static final int METHODID_ADD_LIKE_COURSE_WARE = 13;
  private static final int METHODID_DEL_LIKE_COURSE_WARE = 14;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LikeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LikeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LIKE_COURSES:
          serviceImpl.getLikeCourses((com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeCoursesResponse>) responseObserver);
          break;
        case METHODID_ADD_LIKE_COURSE:
          serviceImpl.addLikeCourse((com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseResponse>) responseObserver);
          break;
        case METHODID_DEL_LIKE_COURSE:
          serviceImpl.delLikeCourse((com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseResponse>) responseObserver);
          break;
        case METHODID_GET_LIKE_HOMES:
          serviceImpl.getLikeHomes((com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeHomesResponse>) responseObserver);
          break;
        case METHODID_ADD_LIKE_HOME:
          serviceImpl.addLikeHome((com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeHomeResponse>) responseObserver);
          break;
        case METHODID_DEL_LIKE_HOME:
          serviceImpl.delLikeHome((com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeHomeResponse>) responseObserver);
          break;
        case METHODID_GET_LIKE_USERS:
          serviceImpl.getLikeUsers((com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeUsersResponse>) responseObserver);
          break;
        case METHODID_ADD_LIKE_USER:
          serviceImpl.addLikeUser((com.amur.home.user.rpc.LikeServiceProto.AddLikeUserRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeUserResponse>) responseObserver);
          break;
        case METHODID_DEL_LIKE_USER:
          serviceImpl.delLikeUser((com.amur.home.user.rpc.LikeServiceProto.DelLikeUserRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeUserResponse>) responseObserver);
          break;
        case METHODID_GET_LIKE_COURSE_LISTS:
          serviceImpl.getLikeCourseLists((com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseListsResponse>) responseObserver);
          break;
        case METHODID_ADD_LIKE_COURSE_LIST:
          serviceImpl.addLikeCourseList((com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseListResponse>) responseObserver);
          break;
        case METHODID_DEL_LIKE_COURSE_LIST:
          serviceImpl.delLikeCourseList((com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseListResponse>) responseObserver);
          break;
        case METHODID_GET_LIKE_COURSE_WARES:
          serviceImpl.getLikeCourseWares((com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.GetLikeCourseWaresResponse>) responseObserver);
          break;
        case METHODID_ADD_LIKE_COURSE_WARE:
          serviceImpl.addLikeCourseWare((com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.AddLikeCourseWareResponse>) responseObserver);
          break;
        case METHODID_DEL_LIKE_COURSE_WARE:
          serviceImpl.delLikeCourseWare((com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.user.rpc.LikeServiceProto.DelLikeCourseWareResponse>) responseObserver);
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

  private static abstract class LikeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LikeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.user.rpc.LikeServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LikeService");
    }
  }

  private static final class LikeServiceFileDescriptorSupplier
      extends LikeServiceBaseDescriptorSupplier {
    LikeServiceFileDescriptorSupplier() {}
  }

  private static final class LikeServiceMethodDescriptorSupplier
      extends LikeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LikeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LikeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LikeServiceFileDescriptorSupplier())
              .addMethod(getGetLikeCoursesMethod())
              .addMethod(getAddLikeCourseMethod())
              .addMethod(getDelLikeCourseMethod())
              .addMethod(getGetLikeHomesMethod())
              .addMethod(getAddLikeHomeMethod())
              .addMethod(getDelLikeHomeMethod())
              .addMethod(getGetLikeUsersMethod())
              .addMethod(getAddLikeUserMethod())
              .addMethod(getDelLikeUserMethod())
              .addMethod(getGetLikeCourseListsMethod())
              .addMethod(getAddLikeCourseListMethod())
              .addMethod(getDelLikeCourseListMethod())
              .addMethod(getGetLikeCourseWaresMethod())
              .addMethod(getAddLikeCourseWareMethod())
              .addMethod(getDelLikeCourseWareMethod())
              .build();
        }
      }
    }
    return result;
  }
}
