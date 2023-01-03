package com.amur.home.tinyid.controller;

import com.amur.home.common.Constants.ResultCode;
import com.amur.home.tinyid.entity.SegmentId;
import com.amur.home.tinyid.factory.impl.IdGeneratorFactoryServer;
import com.amur.home.tinyid.generator.IdGenerator;
import com.amur.home.tinyid.service.SegmentIdService;
import com.amur.home.tinyid.service.TinyIdTokenService;
import com.amur.home.tinyid.vo.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author du_imba
 */
@Slf4j
@Tag(name = "tinyid")
@RestController
@RequestMapping("/id/")
public class IdContronller {
    @Autowired
    private IdGeneratorFactoryServer idGeneratorFactoryServer;
    @Autowired
    private SegmentIdService segmentIdService;
    @Autowired
    private TinyIdTokenService tinyIdTokenService;
    @Value("${batch.size.max}")
    private Integer batchSizeMax;

    @Operation(summary = "获取id")
    @Parameters({
            @Parameter(name = "bizType", description = "业务类型", required = true),
            @Parameter(name = "batchSize", description = "批量大小", required = true),
            @Parameter(name = "token", description = "token", required = true)
    })
    @RequestMapping(value = "nextId", method = {RequestMethod.GET, RequestMethod.POST})
    public Response<List<Long>> nextId(String bizType, Integer batchSize, String token) {
        Response<List<Long>> response = new Response<>();
        Integer newBatchSize = checkBatchSize(batchSize);
        if (tinyIdTokenService.canVisit(bizType, token)) {
            response.setCode(ResultCode.TOKEN_ERR.getCode());
            response.setMessage(ResultCode.TOKEN_ERR.getMessage());
            return response;
        }
        try {
            IdGenerator idGenerator = idGeneratorFactoryServer.getIdGenerator(bizType);
            List<Long> ids = idGenerator.nextId(newBatchSize);
            response.setData(ids);
        } catch (Exception e) {
            response.setCode(ResultCode.SYS_ERR.getCode());
            response.setMessage(e.getMessage());
            log.error("nextId error", e);
        }
        return response;
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

    @Operation(summary = "简易获取id")
    @Parameters({
            @Parameter(name = "bizType", description = "业务类型", required = true),
            @Parameter(name = "batchSize", description = "批量大小", required = true),
            @Parameter(name = "token", description = "token", required = true)
    })
    @RequestMapping(value = "nextIdSimple", method = {RequestMethod.GET, RequestMethod.POST})
    public String nextIdSimple(String bizType, Integer batchSize, String token) {
        Integer newBatchSize = checkBatchSize(batchSize);
        if (tinyIdTokenService.canVisit(bizType, token)) {
            return "";
        }
        String response = "";
        try {
            IdGenerator idGenerator = idGeneratorFactoryServer.getIdGenerator(bizType);
            if (newBatchSize == 1) {
                Long id = idGenerator.nextId();
                response = id + "";
            } else {
                List<Long> idList = idGenerator.nextId(newBatchSize);
                StringBuilder sb = new StringBuilder();
                for (Long id : idList) {
                    sb.append(id).append(",");
                }
                response = sb.deleteCharAt(sb.length() - 1).toString();
            }
        } catch (Exception e) {
            log.error("nextIdSimple error", e);
        }
        return response;
    }

    @Operation(summary = "获取段id")
    @Parameters({
            @Parameter(name = "bizType", description = "业务类型", required = true),
            @Parameter(name = "token", description = "token", required = true)
    })
    @RequestMapping(value = "nextSegmentId", method = {RequestMethod.GET, RequestMethod.POST})
    public Response<SegmentId> nextSegmentId(String bizType, String token) {
        Response<SegmentId> response = new Response<>();
        if (tinyIdTokenService.canVisit(bizType, token)) {
            response.setCode(ResultCode.TOKEN_ERR.getCode());
            response.setMessage(ResultCode.TOKEN_ERR.getMessage());
            return response;
        }
        try {
            SegmentId segmentId = segmentIdService.getNextSegmentId(bizType);
            response.setData(segmentId);
        } catch (Exception e) {
            response.setCode(ResultCode.SYS_ERR.getCode());
            response.setMessage(e.getMessage());
            log.error("nextSegmentId error", e);
        }
        return response;
    }

    @Operation(summary = "简易获取段id")
    @Parameters({
            @Parameter(name = "bizType", description = "业务类型", required = true),
            @Parameter(name = "token", description = "token", required = true)
    })
    @RequestMapping(value = "nextSegmentIdSimple", method = {RequestMethod.GET, RequestMethod.POST})
    public String nextSegmentIdSimple(String bizType, String token) {
        if (tinyIdTokenService.canVisit(bizType, token)) {
            return "";
        }
        String response = "";
        try {
            SegmentId segmentId = segmentIdService.getNextSegmentId(bizType);
            response = segmentId.getCurrentId() + "," + segmentId.getLoadingId() + "," + segmentId.getMaxId()
                    + "," + segmentId.getDelta() + "," + segmentId.getRemainder();
        } catch (Exception e) {
            log.error("nextSegmentIdSimple error", e);
        }
        return response;
    }

}
