package com.amur.home.msg.service.rpc;

import com.amur.home.msg.rpc.AnnouncementServiceGrpc;
import com.amur.home.msg.rpc.AnnouncementServiceProto;
import io.grpc.stub.StreamObserver;

public class AnnouncementRpcServiceImpl extends AnnouncementServiceGrpc.AnnouncementServiceImplBase {

    @Override
    public void getAnnouncementList(AnnouncementServiceProto.GetAnnouncementListRequest request, StreamObserver<AnnouncementServiceProto.GetAnnouncementListResponse> responseObserver) {
        
    }


    @Override
    public void getAnnouncement(AnnouncementServiceProto.GetAnnouncementRequest request, StreamObserver<AnnouncementServiceProto.GetAnnouncementResponse> responseObserver) {
        super.getAnnouncement(request, responseObserver);
    }


    @Override
    public void createAnnouncement(AnnouncementServiceProto.CreateAnnouncementRequest request, StreamObserver<AnnouncementServiceProto.CreateAnnouncementResponse> responseObserver) {
        super.createAnnouncement(request, responseObserver);
    }


    @Override
    public void updateAnnouncement(AnnouncementServiceProto.UpdateAnnouncementRequest request, StreamObserver<AnnouncementServiceProto.UpdateAnnouncementResponse> responseObserver) {
        super.updateAnnouncement(request, responseObserver);
    }


    @Override
    public void deleteAnnouncement(AnnouncementServiceProto.DeleteAnnouncementRequest request, StreamObserver<AnnouncementServiceProto.DeleteAnnouncementResponse> responseObserver) {
        super.deleteAnnouncement(request, responseObserver);
    }
}
