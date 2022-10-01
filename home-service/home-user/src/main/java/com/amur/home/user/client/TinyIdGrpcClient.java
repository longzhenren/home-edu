package com.amur.home.user.client;

import com.amur.home.tinyid.rpc.IdServiceGrpc;
import com.amur.home.tinyid.rpc.TinyId;
import com.amur.home.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TinyIdGrpcClient {
    @GrpcClient("home-tinyid")
    private IdServiceGrpc.IdServiceBlockingStub idServiceBlockingStub;

    private String token = "0f673adf80504e2eaa552f5d791b644c";

    public ServiceResult<Long> getNextId(String bizType) {
        TinyId.GenIdReq req = TinyId.GenIdReq.newBuilder().setBizType(bizType).setToken(token).setBatchSize(1).build();
        try {
            TinyId.Resp resp = idServiceBlockingStub.genId(req);
            if (resp.getCode() == 0) {
                return ServiceResult.success(resp.getData().getId(0));
            } else {
                return ServiceResult.ex(resp.getMessage());
            }
        } catch (Exception e) {
            return ServiceResult.ex(e.getMessage());
        }
    }
}
