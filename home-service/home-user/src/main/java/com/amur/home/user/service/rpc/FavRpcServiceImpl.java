package com.amur.home.user.service.rpc;

import com.amur.home.user.entity.UserFavorite;
import com.amur.home.user.mapper.UserFavMapper;
import com.amur.home.user.rpc.FavServiceGrpc;
import com.amur.home.user.rpc.FavServiceProto;
import com.amur.home.user.rpc.ServiceResultProto;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

@GrpcService
@Slf4j
public class FavRpcServiceImpl extends FavServiceGrpc.FavServiceImplBase {
    @Resource
    private UserFavMapper userFavMapper;


    @Override
    public void getFavCourses(FavServiceProto.GetFavCoursesRequest request, StreamObserver<FavServiceProto.GetFavCoursesResponse> responseObserver) {
        UserFavorite userFavorite = userFavMapper.selectById(request.getUserId());
        ServiceResultProto.ServiceResult resProto;
        FavServiceProto.GetFavCoursesResponse response;
        if (userFavorite == null) {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("用户不存在").build();
            response = FavServiceProto.GetFavCoursesResponse.newBuilder().setResult(resProto).build();
        } else {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
            response = FavServiceProto.GetFavCoursesResponse.newBuilder().addAllCourseIds(userFavorite.getCourseIds()).setResult(resProto).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void addFavCourse(FavServiceProto.AddFavCourseRequest request, StreamObserver<FavServiceProto.AddFavCourseResponse> responseObserver) {
        UserFavorite userFavorite = userFavMapper.selectById(request.getUserId());
        ServiceResultProto.ServiceResult resProto;
        FavServiceProto.AddFavCourseResponse response;
        if (userFavorite == null) {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("用户不存在").build();
        } else {
            if (userFavorite.getCourseIds().contains(request.getCourseId())) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("已经收藏").build();
                response = FavServiceProto.AddFavCourseResponse.newBuilder().setResult(resProto).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            userFavorite.getCourseIds().add(request.getCourseId());
            if (userFavMapper.updateById(userFavorite) > 0) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
            } else {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("添加失败").build();
            }
        }
        response = FavServiceProto.AddFavCourseResponse.newBuilder().setResult(resProto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delFavCourse(FavServiceProto.DelFavCourseRequest request, StreamObserver<FavServiceProto.DelFavCourseResponse> responseObserver) {
        UserFavorite userFavorite = userFavMapper.selectById(request.getUserId());
        ServiceResultProto.ServiceResult resProto;
        FavServiceProto.DelFavCourseResponse response;
        if (userFavorite == null) {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("用户不存在").build();
        } else {
            if (!userFavorite.getCourseIds().contains(request.getCourseId())) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("未收藏").build();
                response = FavServiceProto.DelFavCourseResponse.newBuilder().setResult(resProto).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            userFavorite.getCourseIds().remove(request.getCourseId());
            if (userFavMapper.updateById(userFavorite) > 0) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
            } else {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("删除失败").build();
            }
        }
        response = FavServiceProto.DelFavCourseResponse.newBuilder().setResult(resProto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getFavCourseLists(FavServiceProto.GetFavCourseListsRequest request, StreamObserver<FavServiceProto.GetFavCourseListsResponse> responseObserver) {
        UserFavorite userFavorite = userFavMapper.selectById(request.getUserId());
        ServiceResultProto.ServiceResult resProto;
        FavServiceProto.GetFavCourseListsResponse response;
        if (userFavorite == null) {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("用户不存在").build();
            response = FavServiceProto.GetFavCourseListsResponse.newBuilder().setResult(resProto).build();
        } else {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
            response = FavServiceProto.GetFavCourseListsResponse.newBuilder().addAllCourseListIds(userFavorite.getCourseListIds()).setResult(resProto).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void addFavCourseList(FavServiceProto.AddFavCourseListRequest request, StreamObserver<FavServiceProto.AddFavCourseListResponse> responseObserver) {
        UserFavorite userFavorite = userFavMapper.selectById(request.getUserId());
        ServiceResultProto.ServiceResult resProto;
        FavServiceProto.AddFavCourseListResponse response;
        if (userFavorite == null) {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("用户不存在").build();
        } else {
            if (userFavorite.getCourseListIds().contains(request.getCourseListId())) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("已经收藏").build();
                response = FavServiceProto.AddFavCourseListResponse.newBuilder().setResult(resProto).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            userFavorite.getCourseListIds().add(request.getCourseListId());
            if (userFavMapper.updateById(userFavorite) > 0) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
            } else {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("添加失败").build();
            }
        }
        response = FavServiceProto.AddFavCourseListResponse.newBuilder().setResult(resProto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delFavCourseList(FavServiceProto.DelFavCourseListRequest request, StreamObserver<FavServiceProto.DelFavCourseListResponse> responseObserver) {
        UserFavorite userFavorite = userFavMapper.selectById(request.getUserId());
        ServiceResultProto.ServiceResult resProto;
        FavServiceProto.DelFavCourseListResponse response;
        if (userFavorite == null) {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("用户不存在").build();
        } else {
            if (!userFavorite.getCourseListIds().contains(request.getCourseListId())) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("未收藏").build();
                response = FavServiceProto.DelFavCourseListResponse.newBuilder().setResult(resProto).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            userFavorite.getCourseListIds().remove(request.getCourseListId());
            if (userFavMapper.updateById(userFavorite) > 0) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
            } else {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("删除失败").build();
            }
        }
        response = FavServiceProto.DelFavCourseListResponse.newBuilder().setResult(resProto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getFavCourseWares(FavServiceProto.GetFavCourseWaresRequest request, StreamObserver<FavServiceProto.GetFavCourseWaresResponse> responseObserver) {
        UserFavorite userFavorite = userFavMapper.selectById(request.getUserId());
        ServiceResultProto.ServiceResult resProto;
        FavServiceProto.GetFavCourseWaresResponse response;
        if (userFavorite == null) {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("用户不存在").build();
            response = FavServiceProto.GetFavCourseWaresResponse.newBuilder().setResult(resProto).build();
        } else {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
            response = FavServiceProto.GetFavCourseWaresResponse.newBuilder().addAllCourseWareIds(userFavorite.getCourseWareIds()).setResult(resProto).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void addFavCourseWare(FavServiceProto.AddFavCourseWareRequest request, StreamObserver<FavServiceProto.AddFavCourseWareResponse> responseObserver) {
        UserFavorite userFavorite = userFavMapper.selectById(request.getUserId());
        ServiceResultProto.ServiceResult resProto;
        FavServiceProto.AddFavCourseWareResponse response;
        if (userFavorite == null) {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("用户不存在").build();
        } else {
            if (userFavorite.getCourseWareIds().contains(request.getCourseWareId())) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("已经收藏").build();
                response = FavServiceProto.AddFavCourseWareResponse.newBuilder().setResult(resProto).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            userFavorite.getCourseWareIds().add(request.getCourseWareId());
            if (userFavMapper.updateById(userFavorite) > 0) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
            } else {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("添加失败").build();
            }
        }
        response = FavServiceProto.AddFavCourseWareResponse.newBuilder().setResult(resProto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void delFavCourseWare(FavServiceProto.DelFavCourseWareRequest request, StreamObserver<FavServiceProto.DelFavCourseWareResponse> responseObserver) {
        UserFavorite userFavorite = userFavMapper.selectById(request.getUserId());
        ServiceResultProto.ServiceResult resProto;
        FavServiceProto.DelFavCourseWareResponse response;
        if (userFavorite == null) {
            resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("用户不存在").build();
        } else {
            if (!userFavorite.getCourseWareIds().contains(request.getCourseWareId())) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("未收藏").build();
                response = FavServiceProto.DelFavCourseWareResponse.newBuilder().setResult(resProto).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            userFavorite.getCourseWareIds().remove(request.getCourseWareId());
            if (userFavMapper.updateById(userFavorite) > 0) {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build();
            } else {
                resProto = ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage("删除失败").build();
            }
        }
        response = FavServiceProto.DelFavCourseWareResponse.newBuilder().setResult(resProto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
