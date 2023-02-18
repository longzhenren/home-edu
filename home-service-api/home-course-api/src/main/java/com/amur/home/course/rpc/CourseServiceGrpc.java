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
  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CourseInfo,
      com.amur.home.course.rpc.Course.CreateCourseResponse> getCreateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCourse",
      requestType = com.amur.home.course.rpc.Course.CourseInfo.class,
      responseType = com.amur.home.course.rpc.Course.CreateCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CourseInfo,
      com.amur.home.course.rpc.Course.CreateCourseResponse> getCreateCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CourseInfo, com.amur.home.course.rpc.Course.CreateCourseResponse> getCreateCourseMethod;
    if ((getCreateCourseMethod = CourseServiceGrpc.getCreateCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getCreateCourseMethod = CourseServiceGrpc.getCreateCourseMethod) == null) {
          CourseServiceGrpc.getCreateCourseMethod = getCreateCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.CourseInfo, com.amur.home.course.rpc.Course.CreateCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.CourseInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.CreateCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("CreateCourse"))
              .build();
        }
      }
    }
    return getCreateCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.DeleteCourseRequest,
      com.amur.home.course.rpc.Course.DeleteCourseResponse> getDeleteCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCourse",
      requestType = com.amur.home.course.rpc.Course.DeleteCourseRequest.class,
      responseType = com.amur.home.course.rpc.Course.DeleteCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.DeleteCourseRequest,
      com.amur.home.course.rpc.Course.DeleteCourseResponse> getDeleteCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.DeleteCourseRequest, com.amur.home.course.rpc.Course.DeleteCourseResponse> getDeleteCourseMethod;
    if ((getDeleteCourseMethod = CourseServiceGrpc.getDeleteCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getDeleteCourseMethod = CourseServiceGrpc.getDeleteCourseMethod) == null) {
          CourseServiceGrpc.getDeleteCourseMethod = getDeleteCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.DeleteCourseRequest, com.amur.home.course.rpc.Course.DeleteCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.DeleteCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.DeleteCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("DeleteCourse"))
              .build();
        }
      }
    }
    return getDeleteCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCourseRequest,
      com.amur.home.course.rpc.Course.UpdateCourseResponse> getUpdateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCourse",
      requestType = com.amur.home.course.rpc.Course.UpdateCourseRequest.class,
      responseType = com.amur.home.course.rpc.Course.UpdateCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCourseRequest,
      com.amur.home.course.rpc.Course.UpdateCourseResponse> getUpdateCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCourseRequest, com.amur.home.course.rpc.Course.UpdateCourseResponse> getUpdateCourseMethod;
    if ((getUpdateCourseMethod = CourseServiceGrpc.getUpdateCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUpdateCourseMethod = CourseServiceGrpc.getUpdateCourseMethod) == null) {
          CourseServiceGrpc.getUpdateCourseMethod = getUpdateCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.UpdateCourseRequest, com.amur.home.course.rpc.Course.UpdateCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.UpdateCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.UpdateCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UpdateCourse"))
              .build();
        }
      }
    }
    return getUpdateCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CourseList,
      com.amur.home.course.rpc.Course.CreateCourseListResponse> getCreateCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCourseList",
      requestType = com.amur.home.course.rpc.Course.CourseList.class,
      responseType = com.amur.home.course.rpc.Course.CreateCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CourseList,
      com.amur.home.course.rpc.Course.CreateCourseListResponse> getCreateCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CourseList, com.amur.home.course.rpc.Course.CreateCourseListResponse> getCreateCourseListMethod;
    if ((getCreateCourseListMethod = CourseServiceGrpc.getCreateCourseListMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getCreateCourseListMethod = CourseServiceGrpc.getCreateCourseListMethod) == null) {
          CourseServiceGrpc.getCreateCourseListMethod = getCreateCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.CourseList, com.amur.home.course.rpc.Course.CreateCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.CourseList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.CreateCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("CreateCourseList"))
              .build();
        }
      }
    }
    return getCreateCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.DeleteCourseListRequest,
      com.amur.home.course.rpc.Course.DeleteCourseListResponse> getDeleteCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCourseList",
      requestType = com.amur.home.course.rpc.Course.DeleteCourseListRequest.class,
      responseType = com.amur.home.course.rpc.Course.DeleteCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.DeleteCourseListRequest,
      com.amur.home.course.rpc.Course.DeleteCourseListResponse> getDeleteCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.DeleteCourseListRequest, com.amur.home.course.rpc.Course.DeleteCourseListResponse> getDeleteCourseListMethod;
    if ((getDeleteCourseListMethod = CourseServiceGrpc.getDeleteCourseListMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getDeleteCourseListMethod = CourseServiceGrpc.getDeleteCourseListMethod) == null) {
          CourseServiceGrpc.getDeleteCourseListMethod = getDeleteCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.DeleteCourseListRequest, com.amur.home.course.rpc.Course.DeleteCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.DeleteCourseListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.DeleteCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("DeleteCourseList"))
              .build();
        }
      }
    }
    return getDeleteCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCourseListRequest,
      com.amur.home.course.rpc.Course.UpdateCourseListResponse> getUpdateCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCourseList",
      requestType = com.amur.home.course.rpc.Course.UpdateCourseListRequest.class,
      responseType = com.amur.home.course.rpc.Course.UpdateCourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCourseListRequest,
      com.amur.home.course.rpc.Course.UpdateCourseListResponse> getUpdateCourseListMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCourseListRequest, com.amur.home.course.rpc.Course.UpdateCourseListResponse> getUpdateCourseListMethod;
    if ((getUpdateCourseListMethod = CourseServiceGrpc.getUpdateCourseListMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUpdateCourseListMethod = CourseServiceGrpc.getUpdateCourseListMethod) == null) {
          CourseServiceGrpc.getUpdateCourseListMethod = getUpdateCourseListMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.UpdateCourseListRequest, com.amur.home.course.rpc.Course.UpdateCourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.UpdateCourseListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.UpdateCourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UpdateCourseList"))
              .build();
        }
      }
    }
    return getUpdateCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCourseAccessRequest,
      com.amur.home.course.rpc.Course.UpdateCourseAccessResponse> getUpdateCourseAccessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCourseAccess",
      requestType = com.amur.home.course.rpc.Course.UpdateCourseAccessRequest.class,
      responseType = com.amur.home.course.rpc.Course.UpdateCourseAccessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCourseAccessRequest,
      com.amur.home.course.rpc.Course.UpdateCourseAccessResponse> getUpdateCourseAccessMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCourseAccessRequest, com.amur.home.course.rpc.Course.UpdateCourseAccessResponse> getUpdateCourseAccessMethod;
    if ((getUpdateCourseAccessMethod = CourseServiceGrpc.getUpdateCourseAccessMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUpdateCourseAccessMethod = CourseServiceGrpc.getUpdateCourseAccessMethod) == null) {
          CourseServiceGrpc.getUpdateCourseAccessMethod = getUpdateCourseAccessMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.UpdateCourseAccessRequest, com.amur.home.course.rpc.Course.UpdateCourseAccessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCourseAccess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.UpdateCourseAccessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.UpdateCourseAccessResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UpdateCourseAccess"))
              .build();
        }
      }
    }
    return getUpdateCourseAccessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.GetCourseInfoRequest,
      com.amur.home.course.rpc.Course.GetCourseInfoResponse> getGetCourseInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCourseInfo",
      requestType = com.amur.home.course.rpc.Course.GetCourseInfoRequest.class,
      responseType = com.amur.home.course.rpc.Course.GetCourseInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.GetCourseInfoRequest,
      com.amur.home.course.rpc.Course.GetCourseInfoResponse> getGetCourseInfoMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.GetCourseInfoRequest, com.amur.home.course.rpc.Course.GetCourseInfoResponse> getGetCourseInfoMethod;
    if ((getGetCourseInfoMethod = CourseServiceGrpc.getGetCourseInfoMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetCourseInfoMethod = CourseServiceGrpc.getGetCourseInfoMethod) == null) {
          CourseServiceGrpc.getGetCourseInfoMethod = getGetCourseInfoMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.GetCourseInfoRequest, com.amur.home.course.rpc.Course.GetCourseInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCourseInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.GetCourseInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.GetCourseInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetCourseInfo"))
              .build();
        }
      }
    }
    return getGetCourseInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.RankCourseRequest,
      com.amur.home.course.rpc.Course.RankCourseResponse> getRankCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RankCourse",
      requestType = com.amur.home.course.rpc.Course.RankCourseRequest.class,
      responseType = com.amur.home.course.rpc.Course.RankCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.RankCourseRequest,
      com.amur.home.course.rpc.Course.RankCourseResponse> getRankCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.RankCourseRequest, com.amur.home.course.rpc.Course.RankCourseResponse> getRankCourseMethod;
    if ((getRankCourseMethod = CourseServiceGrpc.getRankCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getRankCourseMethod = CourseServiceGrpc.getRankCourseMethod) == null) {
          CourseServiceGrpc.getRankCourseMethod = getRankCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.RankCourseRequest, com.amur.home.course.rpc.Course.RankCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RankCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.RankCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.RankCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("RankCourse"))
              .build();
        }
      }
    }
    return getRankCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCommentRequest,
      com.amur.home.course.rpc.Course.UpdateCommentResponse> getUpdateCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateComment",
      requestType = com.amur.home.course.rpc.Course.UpdateCommentRequest.class,
      responseType = com.amur.home.course.rpc.Course.UpdateCommentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCommentRequest,
      com.amur.home.course.rpc.Course.UpdateCommentResponse> getUpdateCommentMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.UpdateCommentRequest, com.amur.home.course.rpc.Course.UpdateCommentResponse> getUpdateCommentMethod;
    if ((getUpdateCommentMethod = CourseServiceGrpc.getUpdateCommentMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUpdateCommentMethod = CourseServiceGrpc.getUpdateCommentMethod) == null) {
          CourseServiceGrpc.getUpdateCommentMethod = getUpdateCommentMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.UpdateCommentRequest, com.amur.home.course.rpc.Course.UpdateCommentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.UpdateCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.UpdateCommentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UpdateComment"))
              .build();
        }
      }
    }
    return getUpdateCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CreateCommentRequest,
      com.amur.home.course.rpc.Course.CreateCommentResponse> getCreateCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateComment",
      requestType = com.amur.home.course.rpc.Course.CreateCommentRequest.class,
      responseType = com.amur.home.course.rpc.Course.CreateCommentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CreateCommentRequest,
      com.amur.home.course.rpc.Course.CreateCommentResponse> getCreateCommentMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CreateCommentRequest, com.amur.home.course.rpc.Course.CreateCommentResponse> getCreateCommentMethod;
    if ((getCreateCommentMethod = CourseServiceGrpc.getCreateCommentMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getCreateCommentMethod = CourseServiceGrpc.getCreateCommentMethod) == null) {
          CourseServiceGrpc.getCreateCommentMethod = getCreateCommentMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.CreateCommentRequest, com.amur.home.course.rpc.Course.CreateCommentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.CreateCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.CreateCommentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("CreateComment"))
              .build();
        }
      }
    }
    return getCreateCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.LikeCourseRequest,
      com.amur.home.course.rpc.Course.LikeCourseResponse> getLikeCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LikeCourse",
      requestType = com.amur.home.course.rpc.Course.LikeCourseRequest.class,
      responseType = com.amur.home.course.rpc.Course.LikeCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.LikeCourseRequest,
      com.amur.home.course.rpc.Course.LikeCourseResponse> getLikeCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.LikeCourseRequest, com.amur.home.course.rpc.Course.LikeCourseResponse> getLikeCourseMethod;
    if ((getLikeCourseMethod = CourseServiceGrpc.getLikeCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getLikeCourseMethod = CourseServiceGrpc.getLikeCourseMethod) == null) {
          CourseServiceGrpc.getLikeCourseMethod = getLikeCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.LikeCourseRequest, com.amur.home.course.rpc.Course.LikeCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LikeCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.LikeCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.LikeCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("LikeCourse"))
              .build();
        }
      }
    }
    return getLikeCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.FavCourseRequest,
      com.amur.home.course.rpc.Course.FavCourseResponse> getFavCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FavCourse",
      requestType = com.amur.home.course.rpc.Course.FavCourseRequest.class,
      responseType = com.amur.home.course.rpc.Course.FavCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.FavCourseRequest,
      com.amur.home.course.rpc.Course.FavCourseResponse> getFavCourseMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.FavCourseRequest, com.amur.home.course.rpc.Course.FavCourseResponse> getFavCourseMethod;
    if ((getFavCourseMethod = CourseServiceGrpc.getFavCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getFavCourseMethod = CourseServiceGrpc.getFavCourseMethod) == null) {
          CourseServiceGrpc.getFavCourseMethod = getFavCourseMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.FavCourseRequest, com.amur.home.course.rpc.Course.FavCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FavCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.FavCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.FavCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("FavCourse"))
              .build();
        }
      }
    }
    return getFavCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest,
      com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse> getJoinCourseByShareTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinCourseByShareToken",
      requestType = com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest.class,
      responseType = com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest,
      com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse> getJoinCourseByShareTokenMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest, com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse> getJoinCourseByShareTokenMethod;
    if ((getJoinCourseByShareTokenMethod = CourseServiceGrpc.getJoinCourseByShareTokenMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getJoinCourseByShareTokenMethod = CourseServiceGrpc.getJoinCourseByShareTokenMethod) == null) {
          CourseServiceGrpc.getJoinCourseByShareTokenMethod = getJoinCourseByShareTokenMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest, com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinCourseByShareToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("JoinCourseByShareToken"))
              .build();
        }
      }
    }
    return getJoinCourseByShareTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.GenerateShareTokenRequest,
      com.amur.home.course.rpc.Course.GenerateShareTokenResponse> getGenerateShareTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateShareToken",
      requestType = com.amur.home.course.rpc.Course.GenerateShareTokenRequest.class,
      responseType = com.amur.home.course.rpc.Course.GenerateShareTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.GenerateShareTokenRequest,
      com.amur.home.course.rpc.Course.GenerateShareTokenResponse> getGenerateShareTokenMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.GenerateShareTokenRequest, com.amur.home.course.rpc.Course.GenerateShareTokenResponse> getGenerateShareTokenMethod;
    if ((getGenerateShareTokenMethod = CourseServiceGrpc.getGenerateShareTokenMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGenerateShareTokenMethod = CourseServiceGrpc.getGenerateShareTokenMethod) == null) {
          CourseServiceGrpc.getGenerateShareTokenMethod = getGenerateShareTokenMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.GenerateShareTokenRequest, com.amur.home.course.rpc.Course.GenerateShareTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateShareToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.GenerateShareTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.GenerateShareTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GenerateShareToken"))
              .build();
        }
      }
    }
    return getGenerateShareTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.GetShareInfoRequest,
      com.amur.home.course.rpc.Course.GetShareInfoResponse> getGetShareInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetShareInfo",
      requestType = com.amur.home.course.rpc.Course.GetShareInfoRequest.class,
      responseType = com.amur.home.course.rpc.Course.GetShareInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.GetShareInfoRequest,
      com.amur.home.course.rpc.Course.GetShareInfoResponse> getGetShareInfoMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.GetShareInfoRequest, com.amur.home.course.rpc.Course.GetShareInfoResponse> getGetShareInfoMethod;
    if ((getGetShareInfoMethod = CourseServiceGrpc.getGetShareInfoMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetShareInfoMethod = CourseServiceGrpc.getGetShareInfoMethod) == null) {
          CourseServiceGrpc.getGetShareInfoMethod = getGetShareInfoMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.GetShareInfoRequest, com.amur.home.course.rpc.Course.GetShareInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetShareInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.GetShareInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.GetShareInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetShareInfo"))
              .build();
        }
      }
    }
    return getGetShareInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.DeleteShareTokenRequest,
      com.amur.home.course.rpc.Course.DeleteShareTokenResponse> getDeleteShareTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteShareToken",
      requestType = com.amur.home.course.rpc.Course.DeleteShareTokenRequest.class,
      responseType = com.amur.home.course.rpc.Course.DeleteShareTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.DeleteShareTokenRequest,
      com.amur.home.course.rpc.Course.DeleteShareTokenResponse> getDeleteShareTokenMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.DeleteShareTokenRequest, com.amur.home.course.rpc.Course.DeleteShareTokenResponse> getDeleteShareTokenMethod;
    if ((getDeleteShareTokenMethod = CourseServiceGrpc.getDeleteShareTokenMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getDeleteShareTokenMethod = CourseServiceGrpc.getDeleteShareTokenMethod) == null) {
          CourseServiceGrpc.getDeleteShareTokenMethod = getDeleteShareTokenMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.DeleteShareTokenRequest, com.amur.home.course.rpc.Course.DeleteShareTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteShareToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.DeleteShareTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.DeleteShareTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("DeleteShareToken"))
              .build();
        }
      }
    }
    return getDeleteShareTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.HasJoinedRequest,
      com.amur.home.course.rpc.Course.HasJoinedResponse> getHasJoinedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HasJoined",
      requestType = com.amur.home.course.rpc.Course.HasJoinedRequest.class,
      responseType = com.amur.home.course.rpc.Course.HasJoinedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.HasJoinedRequest,
      com.amur.home.course.rpc.Course.HasJoinedResponse> getHasJoinedMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.HasJoinedRequest, com.amur.home.course.rpc.Course.HasJoinedResponse> getHasJoinedMethod;
    if ((getHasJoinedMethod = CourseServiceGrpc.getHasJoinedMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getHasJoinedMethod = CourseServiceGrpc.getHasJoinedMethod) == null) {
          CourseServiceGrpc.getHasJoinedMethod = getHasJoinedMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.HasJoinedRequest, com.amur.home.course.rpc.Course.HasJoinedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HasJoined"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.HasJoinedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.HasJoinedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("HasJoined"))
              .build();
        }
      }
    }
    return getHasJoinedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest,
      com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse> getListShareInfoByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListShareInfoByUserId",
      requestType = com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest.class,
      responseType = com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest,
      com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse> getListShareInfoByUserIdMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest, com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse> getListShareInfoByUserIdMethod;
    if ((getListShareInfoByUserIdMethod = CourseServiceGrpc.getListShareInfoByUserIdMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getListShareInfoByUserIdMethod = CourseServiceGrpc.getListShareInfoByUserIdMethod) == null) {
          CourseServiceGrpc.getListShareInfoByUserIdMethod = getListShareInfoByUserIdMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest, com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListShareInfoByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("ListShareInfoByUserId"))
              .build();
        }
      }
    }
    return getListShareInfoByUserIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CancelShareTokenRequest,
      com.amur.home.course.rpc.Course.CancelShareTokenResponse> getCancelShareTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelShareToken",
      requestType = com.amur.home.course.rpc.Course.CancelShareTokenRequest.class,
      responseType = com.amur.home.course.rpc.Course.CancelShareTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CancelShareTokenRequest,
      com.amur.home.course.rpc.Course.CancelShareTokenResponse> getCancelShareTokenMethod() {
    io.grpc.MethodDescriptor<com.amur.home.course.rpc.Course.CancelShareTokenRequest, com.amur.home.course.rpc.Course.CancelShareTokenResponse> getCancelShareTokenMethod;
    if ((getCancelShareTokenMethod = CourseServiceGrpc.getCancelShareTokenMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getCancelShareTokenMethod = CourseServiceGrpc.getCancelShareTokenMethod) == null) {
          CourseServiceGrpc.getCancelShareTokenMethod = getCancelShareTokenMethod =
              io.grpc.MethodDescriptor.<com.amur.home.course.rpc.Course.CancelShareTokenRequest, com.amur.home.course.rpc.Course.CancelShareTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelShareToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.CancelShareTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.amur.home.course.rpc.Course.CancelShareTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("CancelShareToken"))
              .build();
        }
      }
    }
    return getCancelShareTokenMethod;
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
    public void createCourse(com.amur.home.course.rpc.Course.CourseInfo request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CreateCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCourseMethod(), responseObserver);
    }

    /**
     */
    public void deleteCourse(com.amur.home.course.rpc.Course.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.DeleteCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCourseMethod(), responseObserver);
    }

    /**
     */
    public void updateCourse(com.amur.home.course.rpc.Course.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseMethod(), responseObserver);
    }

    /**
     */
    public void createCourseList(com.amur.home.course.rpc.Course.CourseList request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CreateCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCourseListMethod(), responseObserver);
    }

    /**
     */
    public void deleteCourseList(com.amur.home.course.rpc.Course.DeleteCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.DeleteCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCourseListMethod(), responseObserver);
    }

    /**
     */
    public void updateCourseList(com.amur.home.course.rpc.Course.UpdateCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseListMethod(), responseObserver);
    }

    /**
     */
    public void updateCourseAccess(com.amur.home.course.rpc.Course.UpdateCourseAccessRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCourseAccessResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseAccessMethod(), responseObserver);
    }

    /**
     */
    public void getCourseInfo(com.amur.home.course.rpc.Course.GetCourseInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.GetCourseInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCourseInfoMethod(), responseObserver);
    }

    /**
     */
    public void rankCourse(com.amur.home.course.rpc.Course.RankCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.RankCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRankCourseMethod(), responseObserver);
    }

    /**
     */
    public void updateComment(com.amur.home.course.rpc.Course.UpdateCommentRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCommentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCommentMethod(), responseObserver);
    }

    /**
     */
    public void createComment(com.amur.home.course.rpc.Course.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CreateCommentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCommentMethod(), responseObserver);
    }

    /**
     */
    public void likeCourse(com.amur.home.course.rpc.Course.LikeCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.LikeCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLikeCourseMethod(), responseObserver);
    }

    /**
     */
    public void favCourse(com.amur.home.course.rpc.Course.FavCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.FavCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFavCourseMethod(), responseObserver);
    }

    /**
     */
    public void joinCourseByShareToken(com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinCourseByShareTokenMethod(), responseObserver);
    }

    /**
     */
    public void generateShareToken(com.amur.home.course.rpc.Course.GenerateShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.GenerateShareTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateShareTokenMethod(), responseObserver);
    }

    /**
     */
    public void getShareInfo(com.amur.home.course.rpc.Course.GetShareInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.GetShareInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetShareInfoMethod(), responseObserver);
    }

    /**
     */
    public void deleteShareToken(com.amur.home.course.rpc.Course.DeleteShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.DeleteShareTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteShareTokenMethod(), responseObserver);
    }

    /**
     */
    public void hasJoined(com.amur.home.course.rpc.Course.HasJoinedRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.HasJoinedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHasJoinedMethod(), responseObserver);
    }

    /**
     */
    public void listShareInfoByUserId(com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListShareInfoByUserIdMethod(), responseObserver);
    }

    /**
     */
    public void cancelShareToken(com.amur.home.course.rpc.Course.CancelShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CancelShareTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelShareTokenMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.CourseInfo,
                com.amur.home.course.rpc.Course.CreateCourseResponse>(
                  this, METHODID_CREATE_COURSE)))
          .addMethod(
            getDeleteCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.DeleteCourseRequest,
                com.amur.home.course.rpc.Course.DeleteCourseResponse>(
                  this, METHODID_DELETE_COURSE)))
          .addMethod(
            getUpdateCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.UpdateCourseRequest,
                com.amur.home.course.rpc.Course.UpdateCourseResponse>(
                  this, METHODID_UPDATE_COURSE)))
          .addMethod(
            getCreateCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.CourseList,
                com.amur.home.course.rpc.Course.CreateCourseListResponse>(
                  this, METHODID_CREATE_COURSE_LIST)))
          .addMethod(
            getDeleteCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.DeleteCourseListRequest,
                com.amur.home.course.rpc.Course.DeleteCourseListResponse>(
                  this, METHODID_DELETE_COURSE_LIST)))
          .addMethod(
            getUpdateCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.UpdateCourseListRequest,
                com.amur.home.course.rpc.Course.UpdateCourseListResponse>(
                  this, METHODID_UPDATE_COURSE_LIST)))
          .addMethod(
            getUpdateCourseAccessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.UpdateCourseAccessRequest,
                com.amur.home.course.rpc.Course.UpdateCourseAccessResponse>(
                  this, METHODID_UPDATE_COURSE_ACCESS)))
          .addMethod(
            getGetCourseInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.GetCourseInfoRequest,
                com.amur.home.course.rpc.Course.GetCourseInfoResponse>(
                  this, METHODID_GET_COURSE_INFO)))
          .addMethod(
            getRankCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.RankCourseRequest,
                com.amur.home.course.rpc.Course.RankCourseResponse>(
                  this, METHODID_RANK_COURSE)))
          .addMethod(
            getUpdateCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.UpdateCommentRequest,
                com.amur.home.course.rpc.Course.UpdateCommentResponse>(
                  this, METHODID_UPDATE_COMMENT)))
          .addMethod(
            getCreateCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.CreateCommentRequest,
                com.amur.home.course.rpc.Course.CreateCommentResponse>(
                  this, METHODID_CREATE_COMMENT)))
          .addMethod(
            getLikeCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.LikeCourseRequest,
                com.amur.home.course.rpc.Course.LikeCourseResponse>(
                  this, METHODID_LIKE_COURSE)))
          .addMethod(
            getFavCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.FavCourseRequest,
                com.amur.home.course.rpc.Course.FavCourseResponse>(
                  this, METHODID_FAV_COURSE)))
          .addMethod(
            getJoinCourseByShareTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest,
                com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse>(
                  this, METHODID_JOIN_COURSE_BY_SHARE_TOKEN)))
          .addMethod(
            getGenerateShareTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.GenerateShareTokenRequest,
                com.amur.home.course.rpc.Course.GenerateShareTokenResponse>(
                  this, METHODID_GENERATE_SHARE_TOKEN)))
          .addMethod(
            getGetShareInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.GetShareInfoRequest,
                com.amur.home.course.rpc.Course.GetShareInfoResponse>(
                  this, METHODID_GET_SHARE_INFO)))
          .addMethod(
            getDeleteShareTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.DeleteShareTokenRequest,
                com.amur.home.course.rpc.Course.DeleteShareTokenResponse>(
                  this, METHODID_DELETE_SHARE_TOKEN)))
          .addMethod(
            getHasJoinedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.HasJoinedRequest,
                com.amur.home.course.rpc.Course.HasJoinedResponse>(
                  this, METHODID_HAS_JOINED)))
          .addMethod(
            getListShareInfoByUserIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest,
                com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse>(
                  this, METHODID_LIST_SHARE_INFO_BY_USER_ID)))
          .addMethod(
            getCancelShareTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.amur.home.course.rpc.Course.CancelShareTokenRequest,
                com.amur.home.course.rpc.Course.CancelShareTokenResponse>(
                  this, METHODID_CANCEL_SHARE_TOKEN)))
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
    public void createCourse(com.amur.home.course.rpc.Course.CourseInfo request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CreateCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourse(com.amur.home.course.rpc.Course.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.DeleteCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourse(com.amur.home.course.rpc.Course.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createCourseList(com.amur.home.course.rpc.Course.CourseList request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CreateCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourseList(com.amur.home.course.rpc.Course.DeleteCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.DeleteCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourseList(com.amur.home.course.rpc.Course.UpdateCourseListRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourseAccess(com.amur.home.course.rpc.Course.UpdateCourseAccessRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCourseAccessResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseAccessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourseInfo(com.amur.home.course.rpc.Course.GetCourseInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.GetCourseInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCourseInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rankCourse(com.amur.home.course.rpc.Course.RankCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.RankCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRankCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateComment(com.amur.home.course.rpc.Course.UpdateCommentRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCommentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createComment(com.amur.home.course.rpc.Course.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CreateCommentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void likeCourse(com.amur.home.course.rpc.Course.LikeCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.LikeCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLikeCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void favCourse(com.amur.home.course.rpc.Course.FavCourseRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.FavCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFavCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void joinCourseByShareToken(com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinCourseByShareTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateShareToken(com.amur.home.course.rpc.Course.GenerateShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.GenerateShareTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateShareTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getShareInfo(com.amur.home.course.rpc.Course.GetShareInfoRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.GetShareInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetShareInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteShareToken(com.amur.home.course.rpc.Course.DeleteShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.DeleteShareTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteShareTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void hasJoined(com.amur.home.course.rpc.Course.HasJoinedRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.HasJoinedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHasJoinedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listShareInfoByUserId(com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListShareInfoByUserIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelShareToken(com.amur.home.course.rpc.Course.CancelShareTokenRequest request,
        io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CancelShareTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelShareTokenMethod(), getCallOptions()), request, responseObserver);
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
    public com.amur.home.course.rpc.Course.CreateCourseResponse createCourse(com.amur.home.course.rpc.Course.CourseInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.DeleteCourseResponse deleteCourse(com.amur.home.course.rpc.Course.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.UpdateCourseResponse updateCourse(com.amur.home.course.rpc.Course.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.CreateCourseListResponse createCourseList(com.amur.home.course.rpc.Course.CourseList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.DeleteCourseListResponse deleteCourseList(com.amur.home.course.rpc.Course.DeleteCourseListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.UpdateCourseListResponse updateCourseList(com.amur.home.course.rpc.Course.UpdateCourseListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.UpdateCourseAccessResponse updateCourseAccess(com.amur.home.course.rpc.Course.UpdateCourseAccessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseAccessMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.GetCourseInfoResponse getCourseInfo(com.amur.home.course.rpc.Course.GetCourseInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCourseInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.RankCourseResponse rankCourse(com.amur.home.course.rpc.Course.RankCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRankCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.UpdateCommentResponse updateComment(com.amur.home.course.rpc.Course.UpdateCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.CreateCommentResponse createComment(com.amur.home.course.rpc.Course.CreateCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.LikeCourseResponse likeCourse(com.amur.home.course.rpc.Course.LikeCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLikeCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.FavCourseResponse favCourse(com.amur.home.course.rpc.Course.FavCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFavCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse joinCourseByShareToken(com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinCourseByShareTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.GenerateShareTokenResponse generateShareToken(com.amur.home.course.rpc.Course.GenerateShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateShareTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.GetShareInfoResponse getShareInfo(com.amur.home.course.rpc.Course.GetShareInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetShareInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.DeleteShareTokenResponse deleteShareToken(com.amur.home.course.rpc.Course.DeleteShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteShareTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.HasJoinedResponse hasJoined(com.amur.home.course.rpc.Course.HasJoinedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHasJoinedMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse listShareInfoByUserId(com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListShareInfoByUserIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.amur.home.course.rpc.Course.CancelShareTokenResponse cancelShareToken(com.amur.home.course.rpc.Course.CancelShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelShareTokenMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.CreateCourseResponse> createCourse(
        com.amur.home.course.rpc.Course.CourseInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.DeleteCourseResponse> deleteCourse(
        com.amur.home.course.rpc.Course.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.UpdateCourseResponse> updateCourse(
        com.amur.home.course.rpc.Course.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.CreateCourseListResponse> createCourseList(
        com.amur.home.course.rpc.Course.CourseList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.DeleteCourseListResponse> deleteCourseList(
        com.amur.home.course.rpc.Course.DeleteCourseListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.UpdateCourseListResponse> updateCourseList(
        com.amur.home.course.rpc.Course.UpdateCourseListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.UpdateCourseAccessResponse> updateCourseAccess(
        com.amur.home.course.rpc.Course.UpdateCourseAccessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseAccessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.GetCourseInfoResponse> getCourseInfo(
        com.amur.home.course.rpc.Course.GetCourseInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCourseInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.RankCourseResponse> rankCourse(
        com.amur.home.course.rpc.Course.RankCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRankCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.UpdateCommentResponse> updateComment(
        com.amur.home.course.rpc.Course.UpdateCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.CreateCommentResponse> createComment(
        com.amur.home.course.rpc.Course.CreateCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.LikeCourseResponse> likeCourse(
        com.amur.home.course.rpc.Course.LikeCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLikeCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.FavCourseResponse> favCourse(
        com.amur.home.course.rpc.Course.FavCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFavCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse> joinCourseByShareToken(
        com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinCourseByShareTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.GenerateShareTokenResponse> generateShareToken(
        com.amur.home.course.rpc.Course.GenerateShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateShareTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.GetShareInfoResponse> getShareInfo(
        com.amur.home.course.rpc.Course.GetShareInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetShareInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.DeleteShareTokenResponse> deleteShareToken(
        com.amur.home.course.rpc.Course.DeleteShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteShareTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.HasJoinedResponse> hasJoined(
        com.amur.home.course.rpc.Course.HasJoinedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHasJoinedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse> listShareInfoByUserId(
        com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListShareInfoByUserIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.amur.home.course.rpc.Course.CancelShareTokenResponse> cancelShareToken(
        com.amur.home.course.rpc.Course.CancelShareTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelShareTokenMethod(), getCallOptions()), request);
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
          serviceImpl.createCourse((com.amur.home.course.rpc.Course.CourseInfo) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CreateCourseResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE:
          serviceImpl.deleteCourse((com.amur.home.course.rpc.Course.DeleteCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.DeleteCourseResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE:
          serviceImpl.updateCourse((com.amur.home.course.rpc.Course.UpdateCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCourseResponse>) responseObserver);
          break;
        case METHODID_CREATE_COURSE_LIST:
          serviceImpl.createCourseList((com.amur.home.course.rpc.Course.CourseList) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CreateCourseListResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE_LIST:
          serviceImpl.deleteCourseList((com.amur.home.course.rpc.Course.DeleteCourseListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.DeleteCourseListResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE_LIST:
          serviceImpl.updateCourseList((com.amur.home.course.rpc.Course.UpdateCourseListRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCourseListResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE_ACCESS:
          serviceImpl.updateCourseAccess((com.amur.home.course.rpc.Course.UpdateCourseAccessRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCourseAccessResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE_INFO:
          serviceImpl.getCourseInfo((com.amur.home.course.rpc.Course.GetCourseInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.GetCourseInfoResponse>) responseObserver);
          break;
        case METHODID_RANK_COURSE:
          serviceImpl.rankCourse((com.amur.home.course.rpc.Course.RankCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.RankCourseResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COMMENT:
          serviceImpl.updateComment((com.amur.home.course.rpc.Course.UpdateCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.UpdateCommentResponse>) responseObserver);
          break;
        case METHODID_CREATE_COMMENT:
          serviceImpl.createComment((com.amur.home.course.rpc.Course.CreateCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CreateCommentResponse>) responseObserver);
          break;
        case METHODID_LIKE_COURSE:
          serviceImpl.likeCourse((com.amur.home.course.rpc.Course.LikeCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.LikeCourseResponse>) responseObserver);
          break;
        case METHODID_FAV_COURSE:
          serviceImpl.favCourse((com.amur.home.course.rpc.Course.FavCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.FavCourseResponse>) responseObserver);
          break;
        case METHODID_JOIN_COURSE_BY_SHARE_TOKEN:
          serviceImpl.joinCourseByShareToken((com.amur.home.course.rpc.Course.JoinCourseByShareTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.JoinCourseByShareTokenResponse>) responseObserver);
          break;
        case METHODID_GENERATE_SHARE_TOKEN:
          serviceImpl.generateShareToken((com.amur.home.course.rpc.Course.GenerateShareTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.GenerateShareTokenResponse>) responseObserver);
          break;
        case METHODID_GET_SHARE_INFO:
          serviceImpl.getShareInfo((com.amur.home.course.rpc.Course.GetShareInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.GetShareInfoResponse>) responseObserver);
          break;
        case METHODID_DELETE_SHARE_TOKEN:
          serviceImpl.deleteShareToken((com.amur.home.course.rpc.Course.DeleteShareTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.DeleteShareTokenResponse>) responseObserver);
          break;
        case METHODID_HAS_JOINED:
          serviceImpl.hasJoined((com.amur.home.course.rpc.Course.HasJoinedRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.HasJoinedResponse>) responseObserver);
          break;
        case METHODID_LIST_SHARE_INFO_BY_USER_ID:
          serviceImpl.listShareInfoByUserId((com.amur.home.course.rpc.Course.ListShareInfoByUserIdRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.ListShareInfoByUserIdResponse>) responseObserver);
          break;
        case METHODID_CANCEL_SHARE_TOKEN:
          serviceImpl.cancelShareToken((com.amur.home.course.rpc.Course.CancelShareTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.amur.home.course.rpc.Course.CancelShareTokenResponse>) responseObserver);
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
      return com.amur.home.course.rpc.Course.getDescriptor();
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
              .build();
        }
      }
    }
    return result;
  }
}
