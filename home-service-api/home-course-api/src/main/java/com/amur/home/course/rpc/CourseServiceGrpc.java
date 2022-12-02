package com.amur.home.course.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.1)",
    comments = "Source: Course.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CourseServiceGrpc {

  private CourseServiceGrpc() {}

  public static final String SERVICE_NAME = "com.amur.home.course.rpc.CourseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CourseInfo,
      com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse> getCreateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCourse",
      requestType = com.amur.home.course.rpc.CourseServiceProto.CourseInfo.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CourseInfo,
      com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse> getCreateCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CourseInfo, com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse> getCreateCourseMethod;
    if ((getCreateCourseMethod = CourseServiceGrpc.getCreateCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getCreateCourseMethod = CourseServiceGrpc.getCreateCourseMethod) == null) {
          CourseServiceGrpc.getCreateCourseMethod = getCreateCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.CourseInfo, com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.CourseInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("CreateCourse"))
              .build();
        }
      }
    }
    return getCreateCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse> getDeleteCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCourse",
      requestType = com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse> getDeleteCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest, com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse> getDeleteCourseMethod;
    if ((getDeleteCourseMethod = CourseServiceGrpc.getDeleteCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getDeleteCourseMethod = CourseServiceGrpc.getDeleteCourseMethod) == null) {
          CourseServiceGrpc.getDeleteCourseMethod = getDeleteCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest, com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("DeleteCourse"))
              .build();
        }
      }
    }
    return getDeleteCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse> getUpdateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCourse",
      requestType = com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse> getUpdateCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest, com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse> getUpdateCourseMethod;
    if ((getUpdateCourseMethod = CourseServiceGrpc.getUpdateCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUpdateCourseMethod = CourseServiceGrpc.getUpdateCourseMethod) == null) {
          CourseServiceGrpc.getUpdateCourseMethod = getUpdateCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest, com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UpdateCourse"))
              .build();
        }
      }
    }
    return getUpdateCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CourseList,
      com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse> getCreateCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCourseList",
      requestType = com.amur.home.course.rpc.CourseServiceProto.CourseList.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CourseList,
      com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse> getCreateCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CourseList, com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse> getCreateCourseListMethod;
    if ((getCreateCourseListMethod = CourseServiceGrpc.getCreateCourseListMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getCreateCourseListMethod = CourseServiceGrpc.getCreateCourseListMethod) == null) {
          CourseServiceGrpc.getCreateCourseListMethod = getCreateCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.CourseList, com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.CourseList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("CreateCourseList"))
              .build();
        }
      }
    }
    return getCreateCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest,
      com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse> getDeleteCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCourseList",
      requestType = com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest,
      com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse> getDeleteCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest, com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse> getDeleteCourseListMethod;
    if ((getDeleteCourseListMethod = CourseServiceGrpc.getDeleteCourseListMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getDeleteCourseListMethod = CourseServiceGrpc.getDeleteCourseListMethod) == null) {
          CourseServiceGrpc.getDeleteCourseListMethod = getDeleteCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest, com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("DeleteCourseList"))
              .build();
        }
      }
    }
    return getDeleteCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest,
      com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse> getUpdateCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCourseList",
      requestType = com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest,
      com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse> getUpdateCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest, com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse> getUpdateCourseListMethod;
    if ((getUpdateCourseListMethod = CourseServiceGrpc.getUpdateCourseListMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUpdateCourseListMethod = CourseServiceGrpc.getUpdateCourseListMethod) == null) {
          CourseServiceGrpc.getUpdateCourseListMethod = getUpdateCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest, com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UpdateCourseList"))
              .build();
        }
      }
    }
    return getUpdateCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest,
      com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse> getUpdateCourseAccessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCourseAccess",
      requestType = com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest,
      com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse> getUpdateCourseAccessMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest, com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse> getUpdateCourseAccessMethod;
    if ((getUpdateCourseAccessMethod = CourseServiceGrpc.getUpdateCourseAccessMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUpdateCourseAccessMethod = CourseServiceGrpc.getUpdateCourseAccessMethod) == null) {
          CourseServiceGrpc.getUpdateCourseAccessMethod = getUpdateCourseAccessMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest, com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCourseAccess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UpdateCourseAccess"))
              .build();
        }
      }
    }
    return getUpdateCourseAccessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest,
      com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse> getGetCourseInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCourseInfo",
      requestType = com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest,
      com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse> getGetCourseInfoMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest, com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse> getGetCourseInfoMethod;
    if ((getGetCourseInfoMethod = CourseServiceGrpc.getGetCourseInfoMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetCourseInfoMethod = CourseServiceGrpc.getGetCourseInfoMethod) == null) {
          CourseServiceGrpc.getGetCourseInfoMethod = getGetCourseInfoMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest, com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCourseInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetCourseInfo"))
              .build();
        }
      }
    }
    return getGetCourseInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse> getRankCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RankCourse",
      requestType = com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse> getRankCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest, com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse> getRankCourseMethod;
    if ((getRankCourseMethod = CourseServiceGrpc.getRankCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getRankCourseMethod = CourseServiceGrpc.getRankCourseMethod) == null) {
          CourseServiceGrpc.getRankCourseMethod = getRankCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest, com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RankCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("RankCourse"))
              .build();
        }
      }
    }
    return getRankCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest,
      com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse> getUpdateCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateComment",
      requestType = com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest,
      com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse> getUpdateCommentMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest, com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse> getUpdateCommentMethod;
    if ((getUpdateCommentMethod = CourseServiceGrpc.getUpdateCommentMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUpdateCommentMethod = CourseServiceGrpc.getUpdateCommentMethod) == null) {
          CourseServiceGrpc.getUpdateCommentMethod = getUpdateCommentMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest, com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UpdateComment"))
              .build();
        }
      }
    }
    return getUpdateCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest,
      com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse> getCreateCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateComment",
      requestType = com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest,
      com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse> getCreateCommentMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest, com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse> getCreateCommentMethod;
    if ((getCreateCommentMethod = CourseServiceGrpc.getCreateCommentMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getCreateCommentMethod = CourseServiceGrpc.getCreateCommentMethod) == null) {
          CourseServiceGrpc.getCreateCommentMethod = getCreateCommentMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest, com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("CreateComment"))
              .build();
        }
      }
    }
    return getCreateCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse> getLikeCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LikeCourse",
      requestType = com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse> getLikeCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest, com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse> getLikeCourseMethod;
    if ((getLikeCourseMethod = CourseServiceGrpc.getLikeCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getLikeCourseMethod = CourseServiceGrpc.getLikeCourseMethod) == null) {
          CourseServiceGrpc.getLikeCourseMethod = getLikeCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest, com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LikeCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("LikeCourse"))
              .build();
        }
      }
    }
    return getLikeCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse> getFavCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FavCourse",
      requestType = com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest,
      com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse> getFavCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest, com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse> getFavCourseMethod;
    if ((getFavCourseMethod = CourseServiceGrpc.getFavCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getFavCourseMethod = CourseServiceGrpc.getFavCourseMethod) == null) {
          CourseServiceGrpc.getFavCourseMethod = getFavCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest, com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FavCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("FavCourse"))
              .build();
        }
      }
    }
    return getFavCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest,
      com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse> getJoinCourseByShareTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinCourseByShareToken",
      requestType = com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest,
      com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse> getJoinCourseByShareTokenMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest, com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse> getJoinCourseByShareTokenMethod;
    if ((getJoinCourseByShareTokenMethod = CourseServiceGrpc.getJoinCourseByShareTokenMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getJoinCourseByShareTokenMethod = CourseServiceGrpc.getJoinCourseByShareTokenMethod) == null) {
          CourseServiceGrpc.getJoinCourseByShareTokenMethod = getJoinCourseByShareTokenMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest, com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinCourseByShareToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("JoinCourseByShareToken"))
              .build();
        }
      }
    }
    return getJoinCourseByShareTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest,
      com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse> getGenerateShareTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateShareToken",
      requestType = com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest,
      com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse> getGenerateShareTokenMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest, com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse> getGenerateShareTokenMethod;
    if ((getGenerateShareTokenMethod = CourseServiceGrpc.getGenerateShareTokenMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGenerateShareTokenMethod = CourseServiceGrpc.getGenerateShareTokenMethod) == null) {
          CourseServiceGrpc.getGenerateShareTokenMethod = getGenerateShareTokenMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest, com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateShareToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GenerateShareToken"))
              .build();
        }
      }
    }
    return getGenerateShareTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest,
      com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse> getGetShareInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetShareInfo",
      requestType = com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest,
      com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse> getGetShareInfoMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest, com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse> getGetShareInfoMethod;
    if ((getGetShareInfoMethod = CourseServiceGrpc.getGetShareInfoMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetShareInfoMethod = CourseServiceGrpc.getGetShareInfoMethod) == null) {
          CourseServiceGrpc.getGetShareInfoMethod = getGetShareInfoMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest, com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetShareInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetShareInfo"))
              .build();
        }
      }
    }
    return getGetShareInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest,
      com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse> getDeleteShareTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteShareToken",
      requestType = com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest,
      com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse> getDeleteShareTokenMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest, com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse> getDeleteShareTokenMethod;
    if ((getDeleteShareTokenMethod = CourseServiceGrpc.getDeleteShareTokenMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getDeleteShareTokenMethod = CourseServiceGrpc.getDeleteShareTokenMethod) == null) {
          CourseServiceGrpc.getDeleteShareTokenMethod = getDeleteShareTokenMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest, com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteShareToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("DeleteShareToken"))
              .build();
        }
      }
    }
    return getDeleteShareTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest,
      com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse> getHasJoinedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HasJoined",
      requestType = com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest,
      com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse> getHasJoinedMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest, com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse> getHasJoinedMethod;
    if ((getHasJoinedMethod = CourseServiceGrpc.getHasJoinedMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getHasJoinedMethod = CourseServiceGrpc.getHasJoinedMethod) == null) {
          CourseServiceGrpc.getHasJoinedMethod = getHasJoinedMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest, com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HasJoined"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("HasJoined"))
              .build();
        }
      }
    }
    return getHasJoinedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest,
      com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse> getListShareInfoByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListShareInfoByUserId",
      requestType = com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest,
      com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse> getListShareInfoByUserIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest, com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse> getListShareInfoByUserIdMethod;
    if ((getListShareInfoByUserIdMethod = CourseServiceGrpc.getListShareInfoByUserIdMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getListShareInfoByUserIdMethod = CourseServiceGrpc.getListShareInfoByUserIdMethod) == null) {
          CourseServiceGrpc.getListShareInfoByUserIdMethod = getListShareInfoByUserIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest, com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListShareInfoByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("ListShareInfoByUserId"))
              .build();
        }
      }
    }
    return getListShareInfoByUserIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest,
      com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse> getCancelShareTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelShareToken",
      requestType = com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest,
      com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse> getCancelShareTokenMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest, com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse> getCancelShareTokenMethod;
    if ((getCancelShareTokenMethod = CourseServiceGrpc.getCancelShareTokenMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getCancelShareTokenMethod = CourseServiceGrpc.getCancelShareTokenMethod) == null) {
          CourseServiceGrpc.getCancelShareTokenMethod = getCancelShareTokenMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest, com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelShareToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("CancelShareToken"))
              .build();
        }
      }
    }
    return getCancelShareTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest,
      com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse> getSearchCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchCourses",
      requestType = com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest,
      com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse> getSearchCoursesMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest, com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse> getSearchCoursesMethod;
    if ((getSearchCoursesMethod = CourseServiceGrpc.getSearchCoursesMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getSearchCoursesMethod = CourseServiceGrpc.getSearchCoursesMethod) == null) {
          CourseServiceGrpc.getSearchCoursesMethod = getSearchCoursesMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest, com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("SearchCourses"))
              .build();
        }
      }
    }
    return getSearchCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest,
      com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse> getListAllCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAllCourses",
      requestType = com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest,
      com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse> getListAllCoursesMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest, com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse> getListAllCoursesMethod;
    if ((getListAllCoursesMethod = CourseServiceGrpc.getListAllCoursesMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getListAllCoursesMethod = CourseServiceGrpc.getListAllCoursesMethod) == null) {
          CourseServiceGrpc.getListAllCoursesMethod = getListAllCoursesMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest, com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAllCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("ListAllCourses"))
              .build();
        }
      }
    }
    return getListAllCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest,
      com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse> getListCourseByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCourseByUserId",
      requestType = com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest,
      com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse> getListCourseByUserIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest, com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse> getListCourseByUserIdMethod;
    if ((getListCourseByUserIdMethod = CourseServiceGrpc.getListCourseByUserIdMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getListCourseByUserIdMethod = CourseServiceGrpc.getListCourseByUserIdMethod) == null) {
          CourseServiceGrpc.getListCourseByUserIdMethod = getListCourseByUserIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest, com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCourseByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("ListCourseByUserId"))
              .build();
        }
      }
    }
    return getListCourseByUserIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest,
      com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse> getListCourseByListIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCourseByListId",
      requestType = com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest.class,
      responseType = com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest,
      com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse> getListCourseByListIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest, com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse> getListCourseByListIdMethod;
    if ((getListCourseByListIdMethod = CourseServiceGrpc.getListCourseByListIdMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getListCourseByListIdMethod = CourseServiceGrpc.getListCourseByListIdMethod) == null) {
          CourseServiceGrpc.getListCourseByListIdMethod = getListCourseByListIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest, com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCourseByListId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("ListCourseByListId"))
              .build();
        }
      }
    }
    return getListCourseByListIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CourseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseServiceStub>() {
        @java.lang.Override
        public CourseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseServiceStub(channel, callOptions);
        }
      };
    return CourseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CourseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseServiceBlockingStub>() {
        @java.lang.Override
        public CourseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseServiceBlockingStub(channel, callOptions);
        }
      };
    return CourseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CourseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseServiceFutureStub>() {
        @java.lang.Override
        public CourseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseServiceFutureStub(channel, callOptions);
        }
      };
    return CourseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CourseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createCourse(com.amur.home.course.rpc.CourseServiceProto.CourseInfo request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCourseMethod(), responseObserver);
    }

    /**
     */
    public void deleteCourse(com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCourseMethod(), responseObserver);
    }

    /**
     */
    public void updateCourse(com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseMethod(), responseObserver);
    }

    /**
     */
    public void createCourseList(com.amur.home.course.rpc.CourseServiceProto.CourseList request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCourseListMethod(), responseObserver);
    }

    /**
     */
    public void deleteCourseList(com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCourseListMethod(), responseObserver);
    }

    /**
     */
    public void updateCourseList(com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseListMethod(), responseObserver);
    }

    /**
     */
    public void updateCourseAccess(com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseAccessMethod(), responseObserver);
    }

    /**
     */
    public void getCourseInfo(com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCourseInfoMethod(), responseObserver);
    }

    /**
     */
    public void rankCourse(com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRankCourseMethod(), responseObserver);
    }

    /**
     */
    public void updateComment(com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCommentMethod(), responseObserver);
    }

    /**
     */
    public void createComment(com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCommentMethod(), responseObserver);
    }

    /**
     */
    public void likeCourse(com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLikeCourseMethod(), responseObserver);
    }

    /**
     */
    public void favCourse(com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFavCourseMethod(), responseObserver);
    }

    /**
     */
    public void joinCourseByShareToken(com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinCourseByShareTokenMethod(), responseObserver);
    }

    /**
     */
    public void generateShareToken(com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateShareTokenMethod(), responseObserver);
    }

    /**
     */
    public void getShareInfo(com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetShareInfoMethod(), responseObserver);
    }

    /**
     */
    public void deleteShareToken(com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteShareTokenMethod(), responseObserver);
    }

    /**
     */
    public void hasJoined(com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHasJoinedMethod(), responseObserver);
    }

    /**
     */
    public void listShareInfoByUserId(com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListShareInfoByUserIdMethod(), responseObserver);
    }

    /**
     */
    public void cancelShareToken(com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelShareTokenMethod(), responseObserver);
    }

    /**
     */
    public void searchCourses(com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchCoursesMethod(), responseObserver);
    }

    /**
     */
    public void listAllCourses(com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAllCoursesMethod(), responseObserver);
    }

    /**
     */
    public void listCourseByUserId(com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCourseByUserIdMethod(), responseObserver);
    }

    /**
     */
    public void listCourseByListId(com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCourseByListIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.CourseInfo,
                com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse>(
                  this, METHODID_CREATE_COURSE)))
          .addMethod(
            getDeleteCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest,
                com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse>(
                  this, METHODID_DELETE_COURSE)))
          .addMethod(
            getUpdateCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest,
                com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse>(
                  this, METHODID_UPDATE_COURSE)))
          .addMethod(
            getCreateCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.CourseList,
                com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse>(
                  this, METHODID_CREATE_COURSE_LIST)))
          .addMethod(
            getDeleteCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest,
                com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse>(
                  this, METHODID_DELETE_COURSE_LIST)))
          .addMethod(
            getUpdateCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest,
                com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse>(
                  this, METHODID_UPDATE_COURSE_LIST)))
          .addMethod(
            getUpdateCourseAccessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest,
                com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse>(
                  this, METHODID_UPDATE_COURSE_ACCESS)))
          .addMethod(
            getGetCourseInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest,
                com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse>(
                  this, METHODID_GET_COURSE_INFO)))
          .addMethod(
            getRankCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest,
                com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse>(
                  this, METHODID_RANK_COURSE)))
          .addMethod(
            getUpdateCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest,
                com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse>(
                  this, METHODID_UPDATE_COMMENT)))
          .addMethod(
            getCreateCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest,
                com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse>(
                  this, METHODID_CREATE_COMMENT)))
          .addMethod(
            getLikeCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest,
                com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse>(
                  this, METHODID_LIKE_COURSE)))
          .addMethod(
            getFavCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest,
                com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse>(
                  this, METHODID_FAV_COURSE)))
          .addMethod(
            getJoinCourseByShareTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest,
                com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse>(
                  this, METHODID_JOIN_COURSE_BY_SHARE_TOKEN)))
          .addMethod(
            getGenerateShareTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest,
                com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse>(
                  this, METHODID_GENERATE_SHARE_TOKEN)))
          .addMethod(
            getGetShareInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest,
                com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse>(
                  this, METHODID_GET_SHARE_INFO)))
          .addMethod(
            getDeleteShareTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest,
                com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse>(
                  this, METHODID_DELETE_SHARE_TOKEN)))
          .addMethod(
            getHasJoinedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest,
                com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse>(
                  this, METHODID_HAS_JOINED)))
          .addMethod(
            getListShareInfoByUserIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest,
                com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse>(
                  this, METHODID_LIST_SHARE_INFO_BY_USER_ID)))
          .addMethod(
            getCancelShareTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest,
                com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse>(
                  this, METHODID_CANCEL_SHARE_TOKEN)))
          .addMethod(
            getSearchCoursesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest,
                com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse>(
                  this, METHODID_SEARCH_COURSES)))
          .addMethod(
            getListAllCoursesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest,
                com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse>(
                  this, METHODID_LIST_ALL_COURSES)))
          .addMethod(
            getListCourseByUserIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest,
                com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse>(
                  this, METHODID_LIST_COURSE_BY_USER_ID)))
          .addMethod(
            getListCourseByListIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest,
                com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse>(
                  this, METHODID_LIST_COURSE_BY_LIST_ID)))
          .build();
    }
  }

  /**
   */
  public static final class CourseServiceStub extends io.grpc.stub.AbstractAsyncStub<CourseServiceStub> {
    private CourseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCourse(com.amur.home.course.rpc.CourseServiceProto.CourseInfo request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourse(com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourse(com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createCourseList(com.amur.home.course.rpc.CourseServiceProto.CourseList request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourseList(com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourseList(com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourseAccess(com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseAccessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourseInfo(com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCourseInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rankCourse(com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRankCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateComment(com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createComment(com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void likeCourse(com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLikeCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void favCourse(com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFavCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void joinCourseByShareToken(com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinCourseByShareTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateShareToken(com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateShareTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getShareInfo(com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetShareInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteShareToken(com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteShareTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void hasJoined(com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHasJoinedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listShareInfoByUserId(com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListShareInfoByUserIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelShareToken(com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelShareTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchCourses(com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAllCourses(com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAllCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listCourseByUserId(com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCourseByUserIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listCourseByListId(com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCourseByListIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CourseServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CourseServiceBlockingStub> {
    private CourseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse createCourse(com.amur.home.course.rpc.CourseServiceProto.CourseInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse deleteCourse(com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse updateCourse(com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse createCourseList(com.amur.home.course.rpc.CourseServiceProto.CourseList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse deleteCourseList(com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse updateCourseList(com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse updateCourseAccess(com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseAccessMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse getCourseInfo(com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCourseInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse rankCourse(com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRankCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse updateComment(com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse createComment(com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse likeCourse(com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLikeCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse favCourse(com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFavCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse joinCourseByShareToken(com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinCourseByShareTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse generateShareToken(com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateShareTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse getShareInfo(com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetShareInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse deleteShareToken(com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteShareTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse hasJoined(com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHasJoinedMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse listShareInfoByUserId(com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListShareInfoByUserIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse cancelShareToken(com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelShareTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse searchCourses(com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse listAllCourses(com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse listCourseByUserId(com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCourseByUserIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse listCourseByListId(com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCourseByListIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CourseServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CourseServiceFutureStub> {
    private CourseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse> createCourse(
        com.amur.home.course.rpc.CourseServiceProto.CourseInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse> deleteCourse(
        com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse> updateCourse(
        com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse> createCourseList(
        com.amur.home.course.rpc.CourseServiceProto.CourseList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse> deleteCourseList(
        com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse> updateCourseList(
        com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse> updateCourseAccess(
        com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseAccessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse> getCourseInfo(
        com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCourseInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse> rankCourse(
        com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRankCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse> updateComment(
        com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse> createComment(
        com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse> likeCourse(
        com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLikeCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse> favCourse(
        com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFavCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse> joinCourseByShareToken(
        com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinCourseByShareTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse> generateShareToken(
        com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateShareTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse> getShareInfo(
        com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetShareInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse> deleteShareToken(
        com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteShareTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse> hasJoined(
        com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHasJoinedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse> listShareInfoByUserId(
        com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListShareInfoByUserIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse> cancelShareToken(
        com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelShareTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse> searchCourses(
        com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchCoursesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse> listAllCourses(
        com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAllCoursesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse> listCourseByUserId(
        com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCourseByUserIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse> listCourseByListId(
        com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCourseByListIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COURSE = 0;
  private static final int METHODID_DELETE_COURSE = 1;
  private static final int METHODID_UPDATE_COURSE = 2;
  private static final int METHODID_CREATE_COURSE_LIST = 3;
  private static final int METHODID_DELETE_COURSE_LIST = 4;
  private static final int METHODID_UPDATE_COURSE_LIST = 5;
  private static final int METHODID_UPDATE_COURSE_ACCESS = 6;
  private static final int METHODID_GET_COURSE_INFO = 7;
  private static final int METHODID_RANK_COURSE = 8;
  private static final int METHODID_UPDATE_COMMENT = 9;
  private static final int METHODID_CREATE_COMMENT = 10;
  private static final int METHODID_LIKE_COURSE = 11;
  private static final int METHODID_FAV_COURSE = 12;
  private static final int METHODID_JOIN_COURSE_BY_SHARE_TOKEN = 13;
  private static final int METHODID_GENERATE_SHARE_TOKEN = 14;
  private static final int METHODID_GET_SHARE_INFO = 15;
  private static final int METHODID_DELETE_SHARE_TOKEN = 16;
  private static final int METHODID_HAS_JOINED = 17;
  private static final int METHODID_LIST_SHARE_INFO_BY_USER_ID = 18;
  private static final int METHODID_CANCEL_SHARE_TOKEN = 19;
  private static final int METHODID_SEARCH_COURSES = 20;
  private static final int METHODID_LIST_ALL_COURSES = 21;
  private static final int METHODID_LIST_COURSE_BY_USER_ID = 22;
  private static final int METHODID_LIST_COURSE_BY_LIST_ID = 23;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CourseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CourseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_COURSE:
          serviceImpl.createCourse((com.amur.home.course.rpc.CourseServiceProto.CourseInfo) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CreateCourseResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE:
          serviceImpl.deleteCourse((com.amur.home.course.rpc.CourseServiceProto.DeleteCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE:
          serviceImpl.updateCourse((com.amur.home.course.rpc.CourseServiceProto.UpdateCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseResponse>) responseObserver);
          break;
        case METHODID_CREATE_COURSE_LIST:
          serviceImpl.createCourseList((com.amur.home.course.rpc.CourseServiceProto.CourseList) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CreateCourseListResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE_LIST:
          serviceImpl.deleteCourseList((com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.DeleteCourseListResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE_LIST:
          serviceImpl.updateCourseList((com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseListResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE_ACCESS:
          serviceImpl.updateCourseAccess((com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCourseAccessResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE_INFO:
          serviceImpl.getCourseInfo((com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.GetCourseInfoResponse>) responseObserver);
          break;
        case METHODID_RANK_COURSE:
          serviceImpl.rankCourse((com.amur.home.course.rpc.CourseServiceProto.RankCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.RankCourseResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COMMENT:
          serviceImpl.updateComment((com.amur.home.course.rpc.CourseServiceProto.UpdateCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.UpdateCommentResponse>) responseObserver);
          break;
        case METHODID_CREATE_COMMENT:
          serviceImpl.createComment((com.amur.home.course.rpc.CourseServiceProto.CreateCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CreateCommentResponse>) responseObserver);
          break;
        case METHODID_LIKE_COURSE:
          serviceImpl.likeCourse((com.amur.home.course.rpc.CourseServiceProto.LikeCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.LikeCourseResponse>) responseObserver);
          break;
        case METHODID_FAV_COURSE:
          serviceImpl.favCourse((com.amur.home.course.rpc.CourseServiceProto.FavCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.FavCourseResponse>) responseObserver);
          break;
        case METHODID_JOIN_COURSE_BY_SHARE_TOKEN:
          serviceImpl.joinCourseByShareToken((com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.JoinCourseByShareTokenResponse>) responseObserver);
          break;
        case METHODID_GENERATE_SHARE_TOKEN:
          serviceImpl.generateShareToken((com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.GenerateShareTokenResponse>) responseObserver);
          break;
        case METHODID_GET_SHARE_INFO:
          serviceImpl.getShareInfo((com.amur.home.course.rpc.CourseServiceProto.GetShareInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.GetShareInfoResponse>) responseObserver);
          break;
        case METHODID_DELETE_SHARE_TOKEN:
          serviceImpl.deleteShareToken((com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.DeleteShareTokenResponse>) responseObserver);
          break;
        case METHODID_HAS_JOINED:
          serviceImpl.hasJoined((com.amur.home.course.rpc.CourseServiceProto.HasJoinedRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.HasJoinedResponse>) responseObserver);
          break;
        case METHODID_LIST_SHARE_INFO_BY_USER_ID:
          serviceImpl.listShareInfoByUserId((com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListShareInfoByUserIdResponse>) responseObserver);
          break;
        case METHODID_CANCEL_SHARE_TOKEN:
          serviceImpl.cancelShareToken((com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.CancelShareTokenResponse>) responseObserver);
          break;
        case METHODID_SEARCH_COURSES:
          serviceImpl.searchCourses((com.amur.home.course.rpc.CourseServiceProto.SearchCoursesRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.SearchCoursesResponse>) responseObserver);
          break;
        case METHODID_LIST_ALL_COURSES:
          serviceImpl.listAllCourses((com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListAllCoursesResponse>) responseObserver);
          break;
        case METHODID_LIST_COURSE_BY_USER_ID:
          serviceImpl.listCourseByUserId((com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListCourseByUserIdResponse>) responseObserver);
          break;
        case METHODID_LIST_COURSE_BY_LIST_ID:
          serviceImpl.listCourseByListId((com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.CourseServiceProto.ListCourseByListIdResponse>) responseObserver);
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

  private static abstract class CourseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CourseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.amur.home.course.rpc.CourseServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CourseService");
    }
  }

  private static final class CourseServiceFileDescriptorSupplier
      extends CourseServiceBaseDescriptorSupplier {
    CourseServiceFileDescriptorSupplier() {}
  }

  private static final class CourseServiceMethodDescriptorSupplier
      extends CourseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CourseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CourseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CourseServiceFileDescriptorSupplier())
              .addMethod(getCreateCourseMethod())
              .addMethod(getDeleteCourseMethod())
              .addMethod(getUpdateCourseMethod())
              .addMethod(getCreateCourseListMethod())
              .addMethod(getDeleteCourseListMethod())
              .addMethod(getUpdateCourseListMethod())
              .addMethod(getUpdateCourseAccessMethod())
              .addMethod(getGetCourseInfoMethod())
              .addMethod(getRankCourseMethod())
              .addMethod(getUpdateCommentMethod())
              .addMethod(getCreateCommentMethod())
              .addMethod(getLikeCourseMethod())
              .addMethod(getFavCourseMethod())
              .addMethod(getJoinCourseByShareTokenMethod())
              .addMethod(getGenerateShareTokenMethod())
              .addMethod(getGetShareInfoMethod())
              .addMethod(getDeleteShareTokenMethod())
              .addMethod(getHasJoinedMethod())
              .addMethod(getListShareInfoByUserIdMethod())
              .addMethod(getCancelShareTokenMethod())
              .addMethod(getSearchCoursesMethod())
              .addMethod(getListAllCoursesMethod())
              .addMethod(getListCourseByUserIdMethod())
              .addMethod(getListCourseByListIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
