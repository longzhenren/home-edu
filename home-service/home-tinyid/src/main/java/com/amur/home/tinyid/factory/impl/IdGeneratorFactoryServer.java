package com.amur.home.tinyid.factory.impl;

import com.amur.home.tinyid.factory.AbstractIdGeneratorFactory;
import com.amur.home.tinyid.generator.IdGenerator;
import com.amur.home.tinyid.generator.impl.CachedIdGenerator;
import com.amur.home.tinyid.service.SegmentIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author du_imba
 */
@Slf4j
@Component
public class IdGeneratorFactoryServer extends AbstractIdGeneratorFactory {
    @Autowired
    private SegmentIdService tinyIdService;

    @Override
    public IdGenerator createIdGenerator(String bizType) {
        log.info("createIdGenerator :{}", bizType);
        return new CachedIdGenerator(bizType, tinyIdService);
    }
}
