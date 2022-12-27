package com.amur.home.user.config;

import com.amur.home.tinyid.rpc.IdServiceGrpc;
import com.amur.home.tinyid.rpc.TinyId;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyBatisTinyIdGenerator implements IdentifierGenerator {
    @GrpcClient("home-tinyid")
    private IdServiceGrpc.IdServiceBlockingStub idServiceBlockingStub;

    @Value("${tinyid.bizType}")
    private String bizType = "home";

    @Value("${tinyid.token}")
    private String token = "0f673adf80504e2eaa552f5d791b644c";

    @Override
    public Long nextId(Object entity) {
        TinyId.GenIdReq req = TinyId.GenIdReq.newBuilder()
                .setBizType(bizType)
                .setToken(token)
                .setBatchSize(1)
                .build();
        try {
            TinyId.Resp resp = idServiceBlockingStub.genId(req);
            if (resp.getCode() == 0) {
                return resp.getData().getId(0);
            }
        } catch (Exception e) {
            log.error("从Tiny-ID获取id异常", e);
        }
        return -1L;
    }
}