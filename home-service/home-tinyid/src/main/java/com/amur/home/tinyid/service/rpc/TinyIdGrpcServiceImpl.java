package com.amur.home.tinyid.service.rpc;

import com.amur.home.common.constant.Constants.ResultCode;
import com.amur.home.tinyid.factory.impl.IdGeneratorFactoryServer;
import com.amur.home.tinyid.generator.IdGenerator;
import com.amur.home.tinyid.rpc.IdServiceGrpc;
import com.amur.home.tinyid.rpc.TinyId.GenIdReq;
import com.amur.home.tinyid.rpc.TinyId.GenIdResp;
import com.amur.home.tinyid.rpc.TinyId.Resp;
import com.amur.home.tinyid.service.TinyIdTokenService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Slf4j
@GrpcService
public class TinyIdGrpcServiceImpl extends IdServiceGrpc.IdServiceImplBase {
    @Autowired
    private IdGeneratorFactoryServer idGeneratorFactoryServer;

    @Autowired
    private TinyIdTokenService tinyIdTokenService;

    @Value("${batch.size.max}")
    private Integer batchSizeMax;

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void genId(GenIdReq request, StreamObserver<Resp> responseObserver) {
        Resp resp = Resp.newBuilder().build();
        String bizType = request.getBizType();
        Integer batchSize = request.getBatchSize();
        String token = request.getToken();
        Integer newBatchSize = checkBatchSize(batchSize);
        if (tinyIdTokenService.canVisit(bizType, token)) {
            resp = resp.toBuilder().setCode(ResultCode.TOKEN_ERR.getCode()).setMessage(ResultCode.TOKEN_ERR.getMessage()).build();
        }
        try {
            IdGenerator idGenerator = idGeneratorFactoryServer.getIdGenerator(bizType);
            List<Long> ids = idGenerator.nextId(newBatchSize);
            GenIdResp data = GenIdResp.newBuilder().addAllId(ids).build();
            resp = resp.toBuilder().setData(data).build();
        } catch (Exception e) {
            resp = resp.toBuilder().setCode(ResultCode.SYS_ERR.getCode()).setMessage(e.getMessage()).build();
            log.error("nextId error", e);
        }
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    private Integer checkBatchSize(Integer batchSize) {
        if (batchSize == null) {
            batchSize = 1;
        }
        if (batchSize > batchSizeMax) {
            batchSize = batchSizeMax;
        }
        return batchSize;
    }
}
